import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends MovingActor
{
    Direction[] possibleDirections = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
    Direction currentDirection = Direction.RIGHT;
    int chanceToChangeDirection = 1;
    
    public Snake(){
        doesRotate = false;
        speed = 1;
    }
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List<Direction> availableDirections = new ArrayList<>();
        for(Direction direction:possibleDirections){
            int xOffset = getXOffset(direction);
            int yOffset = getYOffset(direction);
            if(!isBlocked(xOffset, yOffset)){
                availableDirections.add(direction);
            }
        }

        if(!availableDirections.isEmpty()){
            boolean changeDirection = Greenfoot.getRandomNumber(100)<chanceToChangeDirection;
            if(!availableDirections.contains(currentDirection) || changeDirection){
                currentDirection = availableDirections.get(Greenfoot.getRandomNumber(availableDirections.size()));
            }
            move(currentDirection);
        }
        Actor player = getOneIntersectingObject(Player.class);
        if(player!=null){
            myWorld.loseLife();
        }
    }    
    
}
