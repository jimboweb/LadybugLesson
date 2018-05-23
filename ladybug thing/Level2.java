import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends GreenWorld
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        super();
        String[] map = {
                "***** *********",
                "* * * *       *",
                "  *   *   * *  ",
                "* *** * *     *",
                "* **    **   ***",
                "*    **       *",
                "***  *   ** ** *",
                "* *  *    * *  *",
                "     * * * ***  ",
                "* *           *",
                "***** *********"            
            };
        drawMap(map);

    }
    
    public Level2(int score){
        super();
        sb.setScore(score);
    }
}
