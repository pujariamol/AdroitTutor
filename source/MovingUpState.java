import greenfoot.*; 

public class MovingUpState implements WordPickerState {
    private WordPicker wordPicker;
    
    public MovingUpState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word)
    {
        while(wordPicker.getY() > MAX_TOP)
        {
            wordPicker.setYAxis(wordPicker.getYAxis() - MOVE_INTERVAL);
            wordPicker.setLocation(wordPicker.getX(), wordPicker.getYAxis());
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
        System.out.println("Can't move down while picking up word");
    }

    public void isIntersectingWord()
    {
        System.out.println("Can't intersect while picking up word");
    }

}
