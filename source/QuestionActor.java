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
        displayQuestion(question);
    }

    public void displayQuestion(Question question){

        GreenfootImage image = new GreenfootImage(this.background);
        GreenfootImage img = new GreenfootImage(200,60);
        img.drawString(question.getQuestion(),0,10);
        GreenfootImage rect = new GreenfootImage(310,310);
        rect.drawRect(0, 0, 200, 150);

        GreenfootImage options[] = new GreenfootImage[4];
        List<String> answerOptions = question.getAnswerOptions();
        for(int i=0; i < answerOptions.size(); i++){
            options[i] = new GreenfootImage(200,60);
            options[i].drawString(answerOptions.get(i),10,10);
        }

        for(int i=0;i<options.length; i++){
            image.drawImage(options[i], 0, i*20+20);
        }

        image.drawImage(img,2,2);
        image.drawImage(rect,0,0);
        setImage(image);
    }

}
