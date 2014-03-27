import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WordPicker extends Actor implements Pulley
{
    private static final int Y = 15;
    private static final int MAX_TOP = 90;
    private static final int MAX_BOTTOM = 500;
    private MouseInfo mouse; 
    
    public WordPicker() {
        setRotation(90);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("down") && getY() < MAX_BOTTOM)
        {
             //System.out.println("Down Y --> " + getY());
             move(Y);
        }
        else if(Greenfoot.isKeyDown("up") && getY() > MAX_TOP)
        {
             //System.out.println("UP Y --> " + getY());
             move(-Y);
        }
    }
    
    public void move()
    {
    }
    
    public void pickWord()
    {
        
    }
    
    /*public void move(int x, int y)
    {
       int mouseX, mouseY, actorX, actorY ;
       MouseInfo mouse = Greenfoot.getMouseInfo(); 
       mouseX = mouse.getX();  
       mouseY = mouse.getY();  
       actorX = getX();
       actorY = getY();
       
       for(int i = 0 ; i < 30 ; i++)
       {
           actorX = actorX + x;
           actorY = actorY + y;
           setLocation(actorX ,actorY);
           Greenfoot.delay(1);
       }
    }*/
}
