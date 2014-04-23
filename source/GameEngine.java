public class GameEngine implements Observer
{
    private static GameEngine instance=null;
    private boolean isGameOver = false;
    protected WordPicker wordPicker;
    protected Level level;
    protected Player player;
    protected AdroitTutorWorld adroitTutorWorld;
    protected QuestionSetIterator questionSetIterator;
    
    private GameEngine(AdroitTutorWorld atw)
    {
        this.adroitTutorWorld = atw;
    }
    
    public static GameEngine getInstance(AdroitTutorWorld atw)
    {
        
        if(instance == null){
           instance = new GameEngine(atw);
        }
        return instance;
    }
    
    
    public void initialize()
    {
        isGameOver = false;
        wordPicker = this.adroitTutorWorld.getWordPicker();
        level = this.adroitTutorWorld.getCurrentLevel();
        questionSetIterator = new QuestionSetIterator(this.level.getQuestionSet());
        player = AdroitTutorWorld.getPlayer();
    }
    
    public void update()
    {
        
        System.out.println("In update method of GameEngine");
        
        // call to evaluate answer function
        String selectedAnswerOption = wordPicker.getPickedWord().getOptionText();
        System.out.println("User Picked Word::" + selectedAnswerOption);
        evaluateAnswer(selectedAnswerOption);
        
        // display next question
        if(!isGameOver)
        {
            if(questionSetIterator.isDone())
            {
                System.out.println("Congrats..You have completed Level");
                adroitTutorWorld.changeScreen(ScreenType.REWARD);
            }
            else
            {
                Question nextQuestion= questionSetIterator.getNextQuestion();
                ((GamePlayScreen)adroitTutorWorld.getGamePlayScreen()).updateQuestion(nextQuestion);
            }
        }    
    }
    
    public void evaluateAnswer(String selectedAnswerOption)
    {
        boolean answer = questionSetIterator.currentQuestion().getCorrectAnswer().equalsIgnoreCase(selectedAnswerOption);
        System.out.println("Answer is ::"+answer);
        
        if(answer)  // correct answer
        {
            correctAnswer();
        }
        else       // wrong answer 
        {
            wrongAnswer();
            if(player.getLives() == 0)
            {
                System.out.println("GAME OVER !!");
                adroitTutorWorld.changeScreen(ScreenType.GAMEOVER);
                isGameOver= true;
            }
            
        }
    }
    
    public void correctAnswer()
    {
        int currentScore = player.getScore();
        
        if(((currentScore+1) % 5)==0 || (((currentScore+1) % 8)==0) || (((currentScore+1) % 10)==0))
        {
            player.addReward(new Reward());
            player.setScore(currentScore + 1);
        }
        else
        {
            player.setScore(currentScore + 1);
        }
    }
    
    public void wrongAnswer()
    {
        int currentScore = player.getScore();
        
        player.decretementLife();
        player.setScore(currentScore);
    }
    
    public QuestionSetIterator getQuestionSetIterator()
    {
        return this.questionSetIterator;
    }
    
}
