import greenfoot.Greenfoot;

public class MovingDownState implements WordPickerState {
    private WordPicker wordPicker;
    
    
    public MovingDownState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word)
    {
        System.out.println("Cannot move word picker up in down state");
    }

    public void moveDown()
    {
        if(Greenfoot.isKeyDown("down"))
        {
            wordPicker.setYAxis(wordPicker.getYAxis() + MOVE_INTERVAL);
            Greenfoot.delay(1);
            wordPicker.setLocation(wordPicker.getX(), wordPicker.getYAxis());
            wordPicker.setWordPickerState(wordPicker.getWordPickerIntersectingWordState());
            wordPicker.isIntersectingWord();
        }
        else
        {
            //System.out.println("Down key released");
            wordPicker.setWordPickerState(wordPicker.getWordPickerMovingUpState());
            wordPicker.moveUp(null);
        }
    }

    public void isIntersectingWord()
    {
        System.out.println("Cannot intersect word while moving in down state");
    }

}
