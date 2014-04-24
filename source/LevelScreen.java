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
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen( IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    private void showLevelScreen()
    {
        GreenfootImage levelScreenBackground = new GreenfootImage("./images/GrassTexture.png");
        levelScreenBackground.scale(1020, 640);
        this.adroitTutorWorld.setBackground(levelScreenBackground);
        
        for(int i=0;i < Level.Difficulty.values().length;i++)
        {
            Option option = new Option(Level.Difficulty.values()[i].toString(),("./images/"+Level.Difficulty.values()[i].toString()+"Option.png"));
            this.adroitTutorWorld.addObject(option, 500, 250 + (i * 100));
            option.setOptionSelectedListener(this.adroitTutorWorld);
        }
    }
}
