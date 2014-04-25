
public class IntersectingWordState implements WordPickerState {
    private WordPicker wordPicker;
    
    public IntersectingWordState(WordPicker wordPicker)
    {
        this.wordPicker = wordPicker;
    }

    public void moveUp(Option word)
    {
        System.out.println("Cannot move word picker up in IntersectingWordState");
    }

    public void moveDown()
    {
        System.out.println("Cannot move word picker down in IntersectingWordState");
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
