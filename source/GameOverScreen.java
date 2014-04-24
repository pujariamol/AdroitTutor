import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author Amol Pujari
 * @version (a version number or a date)
 */
public class GameOverScreen extends Screen
{
    IScreenHandler nextScreen = null;
    
    public GameOverScreen(AdroitTutorWorld world){
        super(world);
    }
    
    public void showScreen(ScreenType screenType){
        if(screenType == ScreenType.GAMEOVER){
            showGameOverScreen();
        }else if(this.nextScreen != null){
            System.out.println("Game over Screen to next Screen ");
            this.nextScreen.showScreen(screenType);
        }
    }
    
    public void setNextScreen(IScreenHandler nextScreen){
        this.nextScreen = nextScreen;
    }
    
    private void showGameOverScreen(){
       this.adroitTutorWorld.removeObjects(this.adroitTutorWorld.getObjects(null));
       GreenfootImage greenfootImage = new GreenfootImage("./images/GameOver.png");
       greenfootImage.scale(990,610);
       this.adroitTutorWorld.setBackground(greenfootImage);
       Greenfoot.delay(125);
       this.adroitTutorWorld.setBackground("./images/largeTransparent.gif");
       this.adroitTutorWorld.reset();
       this.adroitTutorWorld.changeScreen(ScreenType.LEVEL);
    }
}
