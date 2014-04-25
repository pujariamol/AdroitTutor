import greenfoot.*;
import java.util.List;

public class AdroitTutorWorld extends World implements OnOptionSelectedListener,Observer
{
    private static Player player = Player.getInstance();
    private WordPicker wordPicker = WordPicker.getInstance();

    private Level currentLevel = null;
    private GameEngine gameEngine = null;
    private QuestionActor questionActor = null;
    
    private static final int WELCOME_SCREEN_TIMEOUT = 2000;

    private IScreenHandler levelScreen = new LevelScreen(this);
    private IScreenHandler gamePlayScreen = new GamePlayScreen(this);
    private IScreenHandler levelCompleteScreen = new LevelCompleteScreen(this);
    private IScreenHandler gameOverScreen = new GameOverScreen(this);
    
    /**
     * Constructor for objects of class AdroitTutorWorld.
     */
    public AdroitTutorWorld()
    {    
        super(990, 610, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        final WelcomeScreen screen1 = new WelcomeScreen();
        GreenfootImage welcomeBackground = new GreenfootImage("./images/WelcomeScreen.png");
        welcomeBackground.scale(1020, 640);
        screen1.setImage(welcomeBackground);
        
        levelScreen.setNextScreen(gamePlayScreen);
        gamePlayScreen.setNextScreen(levelCompleteScreen);
        levelCompleteScreen.setNextScreen(gameOverScreen);
        
        addObject(screen1, 484, 318);
        
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
        System.out.println("Inside world option selected --> " + option.getOptionText());
        List<Option> optionList = getObjects(Option.class);
        removeObjects(optionList);
        
        currentLevel = LevelFactory.createLevel(option.getOptionText());
        
        gameEngine = GameEngine.getInstance(this);
        gameEngine.initialize();
        levelScreen.showScreen(ScreenType.GAMEPLAY);
        attachObserversToWordPicker();

    }

    public static Player getPlayer()
    {
        return player;
    }
    
    public void update()
    {
        // remove user selected word from World
        this.removeObject(wordPicker.getPickedAnswerOption());
        System.out.println("Picked word removed from world");
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
    
    public void changeScreen(ScreenType screenType){
        levelScreen.showScreen(screenType);
    }
    
    public void reset(){
        player.reset();
        player = Player.getInstance();
        wordPicker = WordPicker.getInstance();
        currentLevel = null;
        gameEngine = null;
        questionActor = null;
    }
}