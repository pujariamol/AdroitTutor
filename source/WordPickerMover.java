import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WordPickerMover extends Actor
{
    int movementValue = 4;
    public WordPickerMover(){
        GreenfootImage image = getImage() ;
        image.scale(90, 100 );
    }

    public void act() 
    {
        if(Greenfoot.isKeyDown("down")){
            System.out.println("down key pressed");
        }else{
            if(getX() > 900){
                movementValue = -4;
            }else if(getX() < 100) {
                movementValue = 4;
            }
            move(movementValue);
        }
    }

}
