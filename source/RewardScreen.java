import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RewardScreen here.
 * 
 * @author Amol Pujari 
 * @version (a version number or a date)
 */
public class RewardScreen extends Screen
{
    IScreenHandler nextScreen = null;
    
    public RewardScreen(AdroitTutorWorld world){
        super(world);
    }
    
    public void showScreen(ScreenType screenType){
        if(screenType == ScreenType.REWARD){
            this.world.showRewardScreen();
        }else if(this.nextScreen != null){
            System.out.println("Reward Screen to next Screen ");
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen(IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    
}
