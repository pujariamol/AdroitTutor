import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pulley extends Actor
{
    private static final int MAX_RIGHT = 800;
    private static final int MAX_LEFT = 100;
    private static final int DISTANCE = 4;
    private int distance = DISTANCE;
    
    public void act() 
    {
        if(getX() > MAX_RIGHT){
            distance = -DISTANCE;
        }else if(getX() < MAX_LEFT) {
            distance = DISTANCE;
        }
        move(distance);
    }
}
