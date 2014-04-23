import greenfoot.*;

public class WordPickerMover extends Pulley
{
    private static WordPickerMover instance = null;
    
    public static WordPickerMover getInstance(){
        if(instance == null){
            instance = new WordPickerMover();
        }
        return instance;
    }
    
    public WordPickerMover(){
        GreenfootImage image = getImage() ;
        image.scale(250, 150 );
    }

    public void act() 
    {
        if(!Greenfoot.isKeyDown("down")){
            super.act();
        }
    }
}
