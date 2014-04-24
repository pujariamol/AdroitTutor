import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class QuestionActor here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public class QuestionActor extends Actor
{
    private GreenfootImage background;

    public QuestionActor(Question question){
        this.background = getImage();   
        this.setImage("./images/largeTransparent.gif");
    }

    public void displayQuestion(Question question){

        GreenfootImage image = new GreenfootImage(this.background);
        GreenfootImage img = new GreenfootImage(1000,80);
        img.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 22));
        img.setColor(Color.BLACK);
        img.drawString(question.getQuestion(),0,20);
        image.drawImage(img,2,12);


        setImage(image);
    }
}
