import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
import java.awt.Font;  

/**
 * Write a description of class Option here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Option extends Actor
{
    //GreenfootImage img = new GreenfootImage(200,50);

    /**
     * Act - do whatever the Option wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Option(){
    }

    public Option(String optionText)
    {
        int random1 = Greenfoot.getRandomNumber(255);
        int random2 = Greenfoot.getRandomNumber(255);
        int random3 = Greenfoot.getRandomNumber(255);
        int random4 = Greenfoot.getRandomNumber(255);
        GreenfootImage img = new GreenfootImage(optionText,48,Color.BLACK,new Color(0,0,0,0));
        setImage(img);        
    }
    
    public void act() 
    {
        
    }    

}
