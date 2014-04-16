import greenfoot.*;

public class WordPickerMover extends Pulley
{
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
