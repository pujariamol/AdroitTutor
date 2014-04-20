import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class ScoreBoard extends Actor implements Observer
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private Player player;
    
    public ScoreBoard()
    {
        background= getImage();
        player = AdroitTutorWorld.getPlayer();
        player.attach(this);
        displayScore();
    }
    
    public void act() 
    {
        displayScore();
    }
   
    public void displayLives(GreenfootImage image)
    {
        GreenfootImage lives[]=new GreenfootImage[3];
        // todo at constructor
        for(int i=0;i<3;i++)
        {
            lives[i]= new GreenfootImage("life.png");
            lives[i].scale(50,50);
        }
        
        // lives => displaying lives on scoreboard
        int no_of_lives= player.getLives();
        
        for(int i=0;i<no_of_lives; i++)
        {
            image.drawImage(lives[i], 50+(i*80), 150);
        }    
        
    }
    
    public void displayRewards(GreenfootImage image)
    {
        GreenfootImage rewardIcons[]=new GreenfootImage[3];
        
        for(int i=0;i<3;i++)
        {
            rewardIcons[i]= new GreenfootImage("reward.png");
            rewardIcons[i].scale(50,50);
        }
        
        // rewards => displaying rewards on scoreboard
        int no_of_rewards= player.getRewards().size();
        
        for(int i=0;i<no_of_rewards; i++)
        {
            image.drawImage(rewardIcons[i], 50+(i*80), 80);
        }    
    }
    
    /**
     * Update the score on screen to show the current value.
     */
    private void displayScore()
    {
        // image => background scoreboard
        GreenfootImage image = new GreenfootImage(background);
        
        // text => displaying score in text format
        GreenfootImage text = new GreenfootImage("" + player.getScore(), 35, Color.WHITE, transparent);
        image.drawImage(text, 150,25);
        
        displayLives(image);
        displayRewards(image);
                        
        image.scale(150,150);               
        setImage(image);
    }
    
    public void update() {
        
        displayScore();
	}
}
