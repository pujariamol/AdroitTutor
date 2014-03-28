import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pulley extends Actor
{
    private static final int MAX_X = 900;
    private static final int MIN_X = 100;
    private static final int DISTANCE = 4;
    private int distance = DISTANCE;
    
    public void act() 
    {
        if(getX() > MAX_X){
            distance = -DISTANCE;
        }else if(getX() < MIN_X) {
            distance = DISTANCE;
        }
        move(distance);
    }    
}
