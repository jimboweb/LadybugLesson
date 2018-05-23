import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends MovingActor
{
    
    
    
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up")){
            move(Direction.UP);
        } else if (Greenfoot.isKeyDown("down")) {
            move(Direction.DOWN);
        } else if (Greenfoot.isKeyDown("right")){
            move(Direction.RIGHT);
        } else if (Greenfoot.isKeyDown("left")){
            move(Direction.LEFT);
        }
    }   
    

}

