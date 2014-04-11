public class QuestionSetFactory  
{
    public QuestionSet createQuestionSet(Level.Difficulty difficultyType)
    {
        switch(difficultyType)
        {
            case DIFFICULT:
                return new DifficultQuestionSet();
                
            case MEDIUM:
                return new MediumQuestionSet();
                
            case EASY:
                return new EasyQuestionSet();
        }
        return null;
    }
}
