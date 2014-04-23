public class QuestionSetIterator  
{
    private QuestionSet currentQuestionSet=null;
    private int cursor;
    private int max;
    
    public QuestionSetIterator(QuestionSet qs)
    {
        currentQuestionSet = qs;
        cursor = 0;
        max = qs.getQuestions().size();
    }
    
    public Question currentQuestion()
    {
        return currentQuestionSet.getQuestions().get(cursor);
    }
    
    public Question getNextQuestion()
    {
        
        if(! isDone())
        {
            cursor++;
            return currentQuestionSet.getQuestions().get(cursor);
        }
        else
        {
            System.out.println("End of question list");
            return null;
        }
    }
    
    public boolean isDone()
    {
        return ( (cursor+1) == max );
    }
}
