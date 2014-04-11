import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Main Game engine of Adroid tutor
 * 
 * @version (a version number or a date)
 */
public class AdroitTutorWorld extends World implements OnOptionSelectedListener
{
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
                    showLevels();
                }
                
            }
        }).start();
    }
    
    private void showLevels()
    {
        for(int i=0;i < Level.Difficulty.values().length;i++)
        {
            Option option = new Option(Level.Difficulty.values()[i].toString());
            addObject(option, 500, 100 + (i * 200));
            option.setOptionSelectedListener(this);
        }
    }
    
    public void onOptionSelected(Option option)
    {
        System.out.println("Inside world option selected --> " + option.getOptionText());
        List<Option> optionList = getObjects(Option.class);
        removeObjects(optionList);
        
        addObject(wordpickermover, 530, 80);
        //wordpickermover.setLocation(513, 102);
        addObject(wordPicker, 530, 100);
    }

}