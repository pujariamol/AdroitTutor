public class LevelSetFactory  
{
    public static Level createLevel(String difficulty)
    {            
        if(difficulty.equalsIgnoreCase("Easy"))
        {
             return new EasyLevel();
        }
        else if(difficulty.equalsIgnoreCase("Medium"))
        {
             return new MediumLevel();
        }
        else
        {
             return new DifficultLevel();
        }
    }
}
