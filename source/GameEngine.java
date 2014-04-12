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
        
    }
}
