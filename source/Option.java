import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
import java.awt.Font;  
import java.util.List;

public class Option extends Actor
{
    private String optionText;
    private OnOptionSelectedListener optionSelectedListener;
    
    public Option(){
    }

    public Option(String optionText)
    {
        this.optionText = optionText;
        GreenfootImage img = new GreenfootImage(optionText, 40, Color.BLACK, new Color(0,0,0,0));
        img.drawString(optionText, 200, 300);
        setImage(img);
    }
    
    public Option(String optionText, String imgPath)
    {
        this.optionText = optionText;
        GreenfootImage img = new GreenfootImage(imgPath);
        setImage(img);
    }
   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && optionSelectedListener != null)
        {
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
