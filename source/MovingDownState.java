import greenfoot.Greenfoot;

public class MovingDownState implements WordPickerState {
    private WordPicker wordPicker;
    
    
    public MovingDownState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word)
    {
        System.out.println("Cannot move word picker up in MovingDownState");
    }

    public void moveDown()
    {
        if(Greenfoot.isKeyDown("down"))
        {
            Greenfoot.delay(1);
            wordPicker.movePickerDown();
            wordPicker.setWordPickerState(wordPicker.getWordPickerIntersectingWordState());
            wordPicker.intersectingWord();
        }
        else
        {
            wordPicker.setWordPickerState(wordPicker.getWordPickerMovingUpState());
            wordPicker.moveUp(null);
        }
    }

    public void intersectingWord()
    {
        System.out.println("Cannot intersect word in MovingDownState");
    }

}
