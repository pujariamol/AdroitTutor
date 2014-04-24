import greenfoot.*;
import java.awt.Color;  
import java.awt.Font;  

import java.util.List;

public class UIHandler extends Actor
{
    
    public UIHandler()
    {        
    }
    
    public void showOptions(){
        
            Question question = new Question();     // this should be provided by daemon Class.
            List<String> answerOptions = question.getAnswerOptions();
            
            for(int i=0; i < answerOptions.size();i++)
            {
                Option option1 = new Option(answerOptions.get(i));
                getWorld().addObject(option1,100+(i*200),450);
                option1.turn(i*100);                
            }
    }
    
    public void act()
    {
    }
    
}
