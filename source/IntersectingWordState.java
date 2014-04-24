
public class IntersectingWordState implements WordPickerState {
    private WordPicker wordPicker;
    private static final int MAX_BOTTOM = 500;
    
    public IntersectingWordState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word) {

    }

    public void moveDown() {

    }

    public void intersectingWord() {
        Option answerOption = (Option)wordPicker.getIntersectingWord();
        if(answerOption != null)
        {
            wordPicker.setWordPickerState(wordPicker.getWordPickerMovingUpState());
            wordPicker.moveUp(answerOption);
        }
        else
        {
            wordPicker.setWordPickerState(wordPicker.getWordPickerMovingDownState());
            wordPicker.moveDown();
        }
    }

}
