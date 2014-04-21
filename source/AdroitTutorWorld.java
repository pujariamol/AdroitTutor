import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class AdroitTutorWorld extends World implements OnOptionSelectedListener,Observer
{
    static Player player = new Player();
    WordPicker wordPicker = new WordPicker();
    WordPickerMover wordpickermover = new WordPickerMover();
    Level currentLevel = null;//new Level(Level.Difficulty.EASY);
    GameEngine gameEngine = null;
    QuestionActor questionActor = null;
    
    private static final int WELCOME_SCREEN_TIMEOUT = 2000;

    IScreenHandler levelScreen = new LevelScreen(this);
    IScreenHandler gamePlayScreen = new GamePlayScreen(this);
    IScreenHandler rewardScreen = new RewardScreen(this);
    IScreenHandler gameOverScreen = new GameOverScreen(this);
    
    
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
        
        //player=new Player();

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
        
        
        // attaching observers

    }
       
    public void onOptionSelected(Option option)
    {
        System.out.println("Inside world option selected --> " + option.getOptionText());
        List<Option> optionList = getObjects(Option.class);
        removeObjects(optionList);
        
        //currentLevel = new Level(option.getOptionText());
        String difficulty = option.getOptionText();
        if(difficulty.equalsIgnoreCase("Easy"))
        {
             currentLevel = new EasyLevel();
        }
        else if(difficulty.equalsIgnoreCase("Medium"))
        {
              currentLevel = new MediumLevel();
        }
        else
        {
             currentLevel = new DifficultLevel();
        }
        gameEngine = new GameEngine(this);
        levelScreen.showScreen(ScreenType.GAMEPLAY);
        attachObserversToWordPicker();
 /*       
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
*/
    }

    public static Player getPlayer()
    {
        return player;
    }
    
    public void update()
    {
        System.out.println("In update call of AdroitTutorWorld Observer..");
        // remove user selected word from World
        this.removeObject(wordPicker.getPickedWord());
        System.out.println("Picked word removed from world");
    }
    
   
    
    public void showGameOverScreen(){
        System.out.println("Game Over Screen");
    }
    
    
    
    public void showRewardScreen()
    {
        System.out.println("Reward Screen");
       
    }
    
    // Attaching observers to WordPicker
    public void attachObserversToWordPicker()
    {
        wordPicker.attach(gameEngine);
        wordPicker.attach(this);
    }
    
    public WordPicker getWordPicker()
    {
        return wordPicker;
    }
    
    public WordPickerMover getWordPickerMover()
    {
        return wordpickermover;
    }
    
    public Level getCurrentLevel()
    {
        return currentLevel;
    }
    
    public void setQuestionActor(QuestionActor questionActor)
    {
        this.questionActor = questionActor;
    }
    
    public QuestionActor getQuestionActor()
    {
        return this.questionActor;
    }
    
    public IScreenHandler getGamePlayScreen()
    {
        return this.gamePlayScreen;
    }
    
    public GameEngine getGameEngine()
    {
        return this.gameEngine;
    }
}