import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenWorld extends World
{
    int scoreAreaHeight = 60;
    Scoreboard sb;
    Player bug;
    int startBugX = 340;
    int startBugY = 220;
    /**
     * Constructor for objects of class GreenWorld.
     * 
     */
    public GreenWorld()
    {  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        GreenfootImage bg = new GreenfootImage(getWidth(),getHeight());
        bg.setColor(Color.GREEN);
        bg.fillRect(0,0,getWidth(),getHeight()-scoreAreaHeight);
        setBackground(bg);
        String[] map = {};
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        bug = new Player();
        addObject(bug,340,220);
        sb = new Scoreboard();
        addObject(sb, getWidth()/2, getAdjustedHeight() + scoreAreaHeight/2);
    }
    
    public int getAdjustedHeight(){
        return getHeight()-scoreAreaHeight;
    }
    
    protected void drawMap(String[] map){
    for(int i=0;i<map.length;i++){
            String row = map[i];
            for(int j=0;j<row.length();j++){
                char position = row.charAt(j);
                Actor newActor;
                if(position == '*'){
                    newActor = new Rock();
                } else {
                    newActor = new Aphid();
                }
                if(newActor!=null){
                    addObject(newActor,j*40+20, i*40+20);
                }
            }
        }
    }
    
    public int getScoreAreaHeight(){
        return scoreAreaHeight;
    }
    
    public void changeScore(int amount){
        sb.changeScore(amount);
    }
    
    protected boolean levelIsComplete(){
        return getObjects(Collectable.class).isEmpty();
    }
    
    public GreenfootImage getPlayerImage(){
        Player p = new Player();
        return p.getImage();
    }
    
    public void loseLife(){
        removeObject(bug);
        if(sb.getLives()>0){
            addObject(bug, startBugX, startBugY);
            sb.loseLife();
        }
    }
}
