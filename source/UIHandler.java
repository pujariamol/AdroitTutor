import greenfoot.*;
import java.awt.Color;  
import java.awt.Font;  

import java.util.List;

/**
 * Write a description of class UIHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIHandler extends Actor
{
    // instance variables - replace the example below with your own
    private int flag;
    /**
     * Constructor for objects of class UIHandler
     */
    public UIHandler()
    {
        // initScreen();
        // selectDifficultyScreen();
    }

    private void initScreen(){
        GreenfootImage img = new GreenfootImage("WelcomeScreen.png");
        setImage(img);
        img.scale(900,570);
        Greenfoot.delay(200);
    }
    
    private void selectDifficultyScreen(){
        GreenfootImage img = new GreenfootImage("bathroom-tile.jpg");
        setImage(img);
        img.scale(900,570);
       
        for(int i=0;i < level.getDifficulty().values().length;i++)
        {
            System.out.println(Level.Difficulty.values()[i]);
            Option option = new Option(Level.Difficulty.values()[i].toString());
            getWorld().addObject(option,200,100+(i*200));
           
        }
    }
    
    private void showOptions(){
        
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
            flag=0;
            
            for(int i=0; i < answerOptions.size();i++)
            {
                Option option = new Option(answerOptions.get(i));
                getWorld().addObject(option,100+(i*200),450);
                option.turn(i*100);                
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
        showOptions();
    }
    
}
