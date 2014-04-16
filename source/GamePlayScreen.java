import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameScreen here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public class GamePlayScreen extends Screen
{    
    IScreenHandler nextScreen = null;
    
    public GamePlayScreen(AdroitTutorWorld world){
        super(world);
    }
    
    public void showScreen(ScreenType screenType){
        if(screenType == ScreenType.GAMEPLAY){
            this.world.showGamePlayScreen();
        }else if(this.nextScreen != null){
            System.out.println("Game Play Screen to next Screen ");
            this.nextScreen.showScreen(screenType);
            
        }
    }
    
    public void setNextScreen(IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
}
