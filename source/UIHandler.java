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
        
        /*      if(flag==1)
        {
            
            //Greenfoot.delay(300);
        }
        
        if(flag==2)
        {
            //Greenfoot.delay(500);
        }
                
        
        if(flag==4)
        {
           */
            Question question = new Question();     // this should be provided by daemon Class.
            List<String> answerOptions = question.getAnswerOptions();
            //flag=0;
            
            for(int i=0; i < answerOptions.size();i++)
            {
                Option option1 = new Option(answerOptions.get(i));
                getWorld().addObject(option1,100+(i*200),450);
                option1.turn(i*100);                
            }
            
            
            /*Option option = new Option("Amol");
            System.out.println("---- " + option);
            System.out.println("---- " + getWorld());
            getWorld().addObject(option,400,200); */
        //}
        
        /*GreenfootImage img = new GreenfootImage(220,180);  
        img.setColor(Color.RED);  
        img.setFont(img.getFont().deriveFont(Font.BOLD, 34));  
        img.drawString(answerOptions, 40, 60);  
        img.rotate(34);
        setImage(img);*/
        
        /*Option option = new Option("Amol");
        System.out.println("---- " + option);
        System.out.println("---- " + getWorld());
        getWorld().addObject(option,400,200);
        */
        /* for(int i=0; i < answerOptions.size();i++)
        {
            System.out.println("inside UIHandler"+ i);
            Option option = new Option(answerOptions.get(i));
            GreenfootImage img = option.getImage();
            //img.drawImage(img, 100 + (i*10),400);
            //setImage(img);
            setLocation(100 + (i*10),400);
            setImage(img);
            //addObject(img,100 + (i*10),400);
        } */
    }
    
    public void act()
    {
        
    }
    
}
