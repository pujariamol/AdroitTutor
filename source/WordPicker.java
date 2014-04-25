import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class WordPicker extends Pulley implements Subject
{
    public static final int MAX_TOP = 100;
    private static final int MAX_BOTTOM = 500;
    public static final int MOVE_INTERVAL = 10;
    
    private int y = 100;
    private static boolean wordPickerDown = false;
    
    private WordPickerState wordPickerState;
    private WordPickerState wordPickerMovingUpState;
    private WordPickerState wordPickerMovingDownState;
    private WordPickerState wordPickerIntersectingWordState;
    
    private Option selectedAnswerOption;
    
    private Set<Observer> observers = new HashSet<Observer>();
    private static WordPicker instance = null;
    
    public static WordPicker getInstance(){
        if(instance == null){
            instance = new WordPicker();
        }
        return instance;
    }
    
    private WordPicker()
    {
        wordPickerMovingUpState = new MovingUpState(this);
        wordPickerMovingDownState = new MovingDownState(this);
        wordPickerIntersectingWordState = new IntersectingWordState(this);
        setWordPickerState(wordPickerMovingDownState);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("down"))
        {
            wordPickerState.moveDown();
        }
        else
        {
            super.act();
        }
    }
    
    public void setWordPickerState(WordPickerState newWordPickerState)
    {
        wordPickerState = newWordPickerState;
    }
    
    public WordPickerState getWordPickerMovingDownState()
    {
        return wordPickerMovingDownState;
    }
    
    public WordPickerState getWordPickerMovingUpState()
    {
        return wordPickerMovingUpState;
    }
    
    public WordPickerState getWordPickerIntersectingWordState()
    {
        return wordPickerIntersectingWordState;
    }
    
    public void moveUp(Option word)
    {
        wordPickerState.moveUp(word);
    }
    
    public void moveDown()
    {
        wordPickerState.moveDown();
    }
    
    public void intersectingWord()
    {
        wordPickerState.intersectingWord();
    }
    
    public Actor getIntersectingWord()
    {
        return getOneIntersectingObject(Option.class);
    }
    
    public void setPickedAnswerOption(Option answerOption)
    {
        selectedAnswerOption = answerOption;
        notifyObservers();
    }
    
    public Option getPickedAnswerOption()
    {
        return selectedAnswerOption;
    }

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
    
    public int getYAxis()
    {
        return y;
    }
    
    public void setYAxis(int y)
    {
        this.y = y;
    }
    
    public void movePickerDown()
    {
        y += MOVE_INTERVAL;
        setLocation(getX(), getYAxis());
    }
    
    public void movePickerUp()
    {
        y -= MOVE_INTERVAL;
        setLocation(getX(), getYAxis());
    }
}
