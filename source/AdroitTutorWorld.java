import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Main Game engine of Adroid tutor
 * 
 * @version (a version number or a date)
 */
public class AdroitTutorWorld extends World implements OnOptionSelectedListener,Observer
{
    static Player player=null;
    WordPicker wordPicker = new WordPicker();
    WordPickerMover wordpickermover = new WordPickerMover();
    private static final int WELCOME_SCREEN_TIMEOUT = 2000;

    /**
     * Constructor for objects of class AdroitTutorWorld.
     */
    public AdroitTutorWorld()
    {    
        // Create a new world with 600x400  cells with a cell size of 1x1 pixels.
        super(1100, 600, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        final WelcomeScreen screen1 = new WelcomeScreen();
        
        final IScreenHandler levelScreen = new LevelScreen(this);
        final IScreenHandler gamePlayScreen = new GamePlayScreen(this);
        final IScreenHandler rewardScreen = new RewardScreen(this);
        final IScreenHandler gameOverScreen = new GameOverScreen(this);
        
        levelScreen.setNextScreen(gamePlayScreen);
        gamePlayScreen.setNextScreen(rewardScreen);
        rewardScreen.setNextScreen(gameOverScreen);
        
        //---------For Reference Start--------
        //levelScreen.showScreen(ScreenType.GAMEPLAY);
        //levelScreen.showScreen(ScreenType.GAMEOVER);
        //levelScreen.showScreen(ScreenType.LEVEL);
        //levelScreen.showScreen(ScreenType.REWARD);
        //---------For Reference ends--------
        
        addObject(screen1, 484, 318);
        
        player=new Player();

        final UIHandler uihandler = new UIHandler();
        new Thread(new Runnable() 
        {
            
            @Override
            public void run() 
            {
                try
                {
                    Thread.sleep(WELCOME_SCREEN_TIMEOUT);  
                }
                catch(Exception e) 
                {}
                finally{
                    removeObject(screen1);
                    levelScreen.showScreen(ScreenType.LEVEL);       
                }
            }
        }).start();
        
    }
       
    public void onOptionSelected(Option option)
    {
        //System.out.println("Inside world option selected --> " + option.getOptionText());
        List<Option> optionList = getObjects(Option.class);
        removeObjects(optionList);
        
        //addObject(wordpickermover, 530, 80);
        addObject(wordPicker, 530, 100);
        ScoreBoard scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 980, 500);
        
        GreenfootImage greenfootImage = new GreenfootImage("./images/game_screen_bg.png");
        setBackground(greenfootImage);
        
        for(int i=0; i < 4; i++)
        {
            Option answerOption = new Option("" + (i + 1));
            addObject(answerOption, 100 + (i * 200), 550);
            option.turn(i * 100);
        }
    }

    public static Player getPlayer()
    {
        return player;
    }
    
    public void update()
    {
        System.out.println("In update call of AdroitTutorWorld Observer..");
        // remove user selected word from Worl 
    }
    
    public void showGamePlayScreen()
    {
        System.out.println("Game Play Screen");
        
    }
    
    public void showGameOverScreen(){
        System.out.println("Game Over Screen");
    }
    
    public void showLevelScreen()
    {
        for(int i=0;i < Level.Difficulty.values().length;i++)
        {
            Option option = new Option(Level.Difficulty.values()[i].toString());
            addObject(option, 500, 100 + (i * 200));
            option.setOptionSelectedListener(this);
        }
    }
    
    public void showRewardScreen()
    {
        System.out.println("Reward Screen");
       
    }
    
}