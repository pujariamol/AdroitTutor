
public class Level  
{
    /** Difficulty must be either of these, so using enum **/
    public static enum Difficulty{EASY, MEDIUM, DIFFICULT};
    private QuestionSet questionSet;

    private Difficulty difficulty;
    
    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
        switch(difficulty) {
        case DIFFICULT:
            questionSet = new DifficultQuestionSet();
            break;
            
        case MEDIUM:
            questionSet = new MediumQuestionSet();
            break;
            
        case EASY:
            questionSet = new EasyQuestionSet();
            break;
        }
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
    }
    
    public QuestionSet getQuestionSet() {
        return questionSet;
    }
}
