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
            showRewardScreen();
        }else if(this.nextScreen != null){
            System.out.println("Reward Screen to next Screen ");
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen(IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    public void showRewardScreen()
    {
       this.adroitTutorWorld.removeObjects(this.adroitTutorWorld.getObjects(null));
       GreenfootImage greenfootImage = new GreenfootImage("./images/RewardScreen.png");
       greenfootImage.scale(1100,600);
       this.adroitTutorWorld.setBackground(greenfootImage);
       Greenfoot.delay(125);
       this.adroitTutorWorld.setBackground("./images/largeTransparent.gif");
       this.adroitTutorWorld.reset();
       this.adroitTutorWorld.changeScreen(ScreenType.LEVEL);
    }
    
}
