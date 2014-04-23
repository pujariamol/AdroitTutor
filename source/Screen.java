/**
 * Write a description of class Screen here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public abstract class Screen implements IScreenHandler
{
    AdroitTutorWorld adroitTutorWorld = null;
    public Screen(AdroitTutorWorld world)
    {
        this.adroitTutorWorld = world;
    }
}
