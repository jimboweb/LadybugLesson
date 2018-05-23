import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends GreenWorld
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        String[] map = {
                "******** ******",
                "* * * *       *",
                "  *   * * * *  ",
                "* *** * *     *",
                "* **    *******",
                "*    **       *",
                "********** ** *",
                "* *      * *  *",
                "* ******    * *",
                "*        **   *",
                "******** ******"            
            };
        drawMap(map);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Snake snake = new Snake();
        addObject(snake,65,100);
        Snake snake2 = new Snake();
        addObject(snake2,454,343);
        Snake snake3 = new Snake();
        addObject(snake3,66,380);
        snake.setLocation(53,98);
    }
    
    public void act(){
        if(levelIsComplete()){
            Greenfoot.setWorld(new Level2(sb.getScore()));
        }
    }
}
