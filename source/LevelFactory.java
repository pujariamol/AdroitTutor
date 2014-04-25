public class LevelFactory  
{
    public static Level createLevel(String difficulty)
    {            
        if(difficulty.equalsIgnoreCase(Level.Difficulty.EASY.toString()))
        {
             return new EasyLevel();
        }
        else if(difficulty.equalsIgnoreCase(Level.Difficulty.MEDIUM.toString()))
        {
             return new MediumLevel();
        }
        else
        {
             return new DifficultLevel();
        }
    }
}
