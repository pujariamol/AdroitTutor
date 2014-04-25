
public abstract class Level  
{
    /** Difficulty must be either of these, so using enum **/
    public static enum Difficulty{EASY, MEDIUM, DIFFICULT};
    protected QuestionSet questionSet;

    public QuestionSet getQuestionSet() {
        return questionSet;
    }
}