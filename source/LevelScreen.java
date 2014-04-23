import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelScreen here.
 * 
 * @author Amol Pujari  
 * @version (a version number or a date)
 */
public class LevelScreen extends Screen
{
    IScreenHandler nextScreen = null;
    
    public LevelScreen(AdroitTutorWorld world){
        super(world);
    }
    
    public void showScreen(ScreenType screenType){
        if(screenType == ScreenType.LEVEL){
            showLevelScreen();
        }else if(this.nextScreen != null){
            System.out.println("Level Screen to next Screen ");            
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen( IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    private void showLevelScreen()
    {
        System.out.println("Display level screen");
        for(int i=0;i < Level.Difficulty.values().length;i++)
        {
            Option option = new Option(Level.Difficulty.values()[i].toString());
            this.adroitTutorWorld.addObject(option, 500, 100 + (i * 200));
            option.setOptionSelectedListener(this.adroitTutorWorld);
        }
    }
}
