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
            this.world.showLevelScreen();
        }else if(this.nextScreen != null){
            System.out.println("Level Screen to next Screen ");            
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen( IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
}
