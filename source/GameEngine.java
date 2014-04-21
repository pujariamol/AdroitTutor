public class GameEngine implements Observer
{
    protected WordPicker wordPicker;
    protected Level level;
    protected Player player;
    protected AdroitTutorWorld adroitTutorWorld;
    protected QuestionSetIterator questionSetIterator;
    
    public GameEngine(AdroitTutorWorld atw)
    {
        this.adroitTutorWorld = atw;
        wordPicker = atw.getWordPicker();
        level = atw.getCurrentLevel();
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
            if(player.getLives() == 1)
            {
                System.out.println("GAME OVER !!");
            }
            wrongAnswer();
        }
    }
    
    public void correctAnswer()
    {
        int currentScore = player.getScore();
        
        if(((currentScore+1) % 5)==0 || ((currentScore % 8)==0) || ((currentScore % 10)==0))
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
}
