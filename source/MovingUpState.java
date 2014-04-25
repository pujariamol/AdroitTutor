import greenfoot.*; 

public class MovingUpState implements WordPickerState {
    private WordPicker wordPicker;
    
    public MovingUpState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word)
    {
        while(wordPicker.getY() > WordPicker.MAX_TOP)
        {
            wordPicker.movePickerUp();
            if(word != null)
            {
                word.setLocation(wordPicker.getX(), (wordPicker.getYAxis() + WORD_MOVE_INTERVAL));
            }
            Greenfoot.delay(1);
        }
        if(word != null)
        {
            wordPicker.setPickedAnswerOption(word);
        }
        wordPicker.setWordPickerState(wordPicker.getWordPickerMovingDownState());
    }

    public void moveDown()
    {
        System.out.println("Cannot move down in MovingUpState");
    }

    public void intersectingWord()
    {
        System.out.println("Cannot intersect word in MovingUpState");
    }

}
