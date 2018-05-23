import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MovingActor extends Actor
{
    boolean doesRotate = true;
    public enum Direction{
        UP, DOWN, LEFT,RIGHT
    }

    int speed = 2;
    int length;
    int width;
    GreenWorld myWorld;
    int worldWidth;
    int worldHeight;
    public MovingActor(){
        GreenfootImage img = getImage();
        length = img.getWidth();
        width = img.getHeight();
    }

    public void addedToWorld(World w){
        myWorld = (GreenWorld)w;
        worldWidth = myWorld.getWidth();
        worldHeight = myWorld.getAdjustedHeight();
    }
    

    /**
     * Act - do whatever the MovingActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    protected void move(Direction d){
        if(doesRotate){
            setRotation(getNewRotation(d));
        }
        int xOffset = getXOffset(d);
        int yOffset = getYOffset(d);
       if(!isBlocked(xOffset, yOffset)){
            setLocation(getNewX(xOffset), getNewY(yOffset));
        }
    }
    
    private int getNewX(int xOffset){
        return wrapSum(getX(), xOffset, worldWidth);
    }

    private int getNewY(int yOffset){
        return wrapSum(getY(), yOffset, worldHeight);
    }
    
    protected int getXOffset(Direction d){
        switch(d){
            case LEFT:
                return -speed;
            case RIGHT:
                return speed;
            default: 
                return 0;
        }
    }
    
    protected int getYOffset(Direction d){
        switch(d){
            case UP:
                return -speed;
            case DOWN:
                return speed;
            default: 
                return 0;
        }
    }
    
    private int getNewRotation(Direction d){
        switch(d){
            case LEFT:
                return 180;
            case UP:
                return -90;
            case DOWN:
                return 90;
            default:
                return 0;
            
        }
    }
    
    protected boolean isBlocked(int xOffset, int yOffset){
        int adjustedXOffset = adjustOffset(xOffset);
        int adjustedYOffset = adjustOffset(yOffset);
        Actor obstacle = getOneObjectAtOffset(adjustedXOffset, adjustedYOffset, Obstacle.class);
        if(obstacle!=null){
            return true;
        }
        return false;
    }
    
    protected int adjustOffset(int coordOffset){
        int distanceToFront = length/2;
        int sign = (int)Math.signum(coordOffset);
        int newOffset = coordOffset +sign * distanceToFront;
        return newOffset;
    }
    
    private int wrapSum(int term1, int term2, int max){
        int simpleSum = term1 + term2;
        return (simpleSum % max + max) % max;
    }
    
    protected Direction getOppositeDirection(Direction d){
        switch(d){
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            case UP: 
                return Direction.DOWN;
            default: 
                return Direction.RIGHT;
            
        }
    }
}
