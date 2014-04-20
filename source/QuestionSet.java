import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public abstract class QuestionSet
{
    protected List<Question> questions;
    
    public List<Question> getQuestions() 
    {
        return questions;
    }
    
    public abstract void  setQuestionSet();
}
