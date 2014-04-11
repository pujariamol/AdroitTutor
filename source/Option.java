import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
import java.awt.Font;  
import java.util.List;

/**
 * Write a description of class Option here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Option extends Actor
{
    private String optionText;
    private OnOptionSelectedListener optionSelectedListener;
    
    public Option(){
    }

    public Option(String optionText)
    {
        this.optionText = optionText;
        GreenfootImage img = new GreenfootImage(optionText, 48, Color.BLACK, new Color(0,0,0,0));
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && optionSelectedListener != null)
        {
            System.out.println(optionText + " clicked");
            optionSelectedListener.onOptionSelected(this);
        }
    }
    
    public String getOptionText()
    {
        return optionText;
    }
    
    public void setOptionSelectedListener(OnOptionSelectedListener optionSelectedListener)
    {
        this.optionSelectedListener = optionSelectedListener;
    }

}
