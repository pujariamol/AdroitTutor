import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main Game engine of Adroid tutor
 * 
 * @version (a version number or a date)
 */
public class AdroitTutorWorld extends World
{
    WordPicker wordPicker = new WordPicker();
	WordPickerMover wordpickermover = new WordPickerMover();

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
        addObject(wordpickermover, 545, 295);
        wordpickermover.setLocation(513, 102);
		addObject(wordPicker, 530, 100);
    }
}