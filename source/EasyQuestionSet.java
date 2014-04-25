import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;

public class EasyQuestionSet extends QuestionSet
{
    public EasyQuestionSet()
    {
        questions=new ArrayList<Question>();
        
        try
        {
            setQuestionSet();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
    
    public void setQuestionSet()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("./questionset/EasySet.txt"));
            String line = null,QueStr[];
            int i=0;
            java.util.List<String> answerOptionsList = new java.util.ArrayList<String>();
            Question q = null;
            while ((line = reader.readLine()) != null) 
            {
                i=i%6;
                
                switch(i)
                {
                    case 0:
                            q=new Question();
                            answerOptionsList=new java.util.ArrayList<String>();
                            q.setQuestion(line);
                            //q.getQuestion();
                            break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                            answerOptionsList.add(line);
                            break;

                    case 5:
                            q.setCorrectAnswerIndex(line);
                            q.setAnswerOptions(answerOptionsList);
                            questions.add(q);
                            //displayQuestion(q);
                            break;                            
                   
                }
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void displayQuestion(Question q)
    {
        System.out.println("Question :: "+q.getQuestion()+"\n"+q.getAnswerOptions()+"\n"+q.getCorrectAnswer());
    }
}
