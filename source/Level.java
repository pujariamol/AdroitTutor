
public abstract class Level  
{
    /** Difficulty must be either of these, so using enum **/
    public static enum Difficulty{EASY, MEDIUM, DIFFICULT};
    //private Difficulty difficulty;
    protected QuestionSet questionSet;
    
    public Level()
    {}
        
     /*public Level(final String difficultyText)
     {
         if(difficultyText.equalsIgnoreCase(Difficulty.EASY.toString()))
         {
             questionSet = new EasyQuestionSet();
         }
         else if(difficultyText.equalsIgnoreCase(Difficulty.MEDIUM.toString()))
         {
              questionSet = new MediumQuestionSet();
         }
         else
         {
             questionSet = new DifficultQuestionSet();
         }
     }
    

     public Level(final Difficulty difficulty)
    {

        this.difficulty = difficulty;
        QuestionSetFactory questionFactory = new QuestionSetFactory();
        questionSet = questionFactory.createQuestionSet(difficulty);
    }
    
    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
        QuestionSetFactory questionFactory = new QuestionSetFactory();
        questionSet = questionFactory.createQuestionSet(difficulty);
       
    } 
    
    public Difficulty getDifficulty() {
        return difficulty;
    }
    
    public int getDifficultyLevel() {
        switch(difficulty) {
        case DIFFICULT:
            return 3;
            
        case MEDIUM:
            return 2;
            
        case EASY:
            return 1;
        }
        return 1;
    }*/
    
    public QuestionSet getQuestionSet() {
        return questionSet;
    }
}