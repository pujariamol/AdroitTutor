import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class WordPicker extends Pulley implements Subject
{
    private static final int MAX_TOP = 100;
    private static final int MAX_BOTTOM = 500;
    private static final int MOVE_INTERVAL = 10;
    
    private int y = 100;
    private static boolean wordPickerDown = false;
    
    // Added by Mahesh
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("down") && getY() < MAX_BOTTOM) // || Greenfoot.isKeyDown("up")
        {
            wordPickerDown = true;
            y += MOVE_INTERVAL;
            setLocation(getX(), y);
            
            /*else if(Greenfoot.isKeyDown("up") && getY() > MAX_TOP)
            {
                 //System.out.println("UP Y --> " + getY());
                 y -= MOVE_INTERVAL;
                 setLocation(getX(), y);
            }*/
        }
        else if(wordPickerDown)
        {
            while(getY() > MAX_TOP)
            {
                if(Greenfoot.isKeyDown("down"))
                {
                    break;
                }
                y -= MOVE_INTERVAL;
                setLocation(getX(), y);
                Greenfoot.delay(1);
                wordPickerDown = false;
            }
        }
        else
        {
            super.act();
        }
        
        /*
           1.Check for WordPicker is in hasWord state and reached particular height Y
           2.If condition 1 satisfied then notifyObservers
        */
    }
    
    public void pickWord()
    {
        
    }
    
    public static boolean isWordPickerDown()
    {
        return wordPickerDown;
    }
    
    // Added by Mahesh
    public void attach(Observer obj) 
    {
        observers.add(obj) ;
    }

    public void detach(Observer obj) 
    {
        observers.remove(obj) ;
    }

    public void notifyObservers() 
    {
        for (Observer obj  : observers)
        {
            obj.update();
        }
    }
}
