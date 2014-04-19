public class GameEngine implements Observer
{
    protected WordPicker wordPicker;
    
    public GameEngine(WordPicker wp)
    {
        this.wordPicker=wp;
    }
    
    public void update()
    {
        System.out.println("In update method of GameEngine");
        
        // call to evaluate answer function
        String selectedAnswerOption = wordPicker.getPickedWord().getOptionText();
        System.out.println("User Picked Word::" + selectedAnswerOption);
        evaluateAnswer(selectedAnswerOption);
    }
    
    public boolean evaluateAnswer(String selectedAnswerOption)
    {
        return true;
    }
}
