import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WordPickerMover extends Pulley
{
    public WordPickerMover(){
        GreenfootImage image = getImage() ;
        image.scale(250, 150 );
    }

    public void act() 
    {
        if(!Greenfoot.isKeyDown("down") && !WordPicker.isWordPickerDown()){ // && !Greenfoot.isKeyDown("up")
            super.act();
        }else{
            //System.out.println("Key pressed stop");
        }
    }

}
