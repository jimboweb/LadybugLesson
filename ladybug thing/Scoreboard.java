import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
   int score = 0;
   int maxLives = 3;
   int lives;
   GreenfootImage boardImage;
   int width;
   int height;
   TextScore textScore;
   GreenfootImage playerImage;
   LifeCounter lifeCounter;
   public Scoreboard(){
   }
    
    public void addedToWorld(World w){
        GreenWorld thisWorld = (GreenWorld)w;
        width = thisWorld.getWidth();
        height = thisWorld.getScoreAreaHeight();
        boardImage = new GreenfootImage(width,height);
        boardImage.setColor(Color.BLACK);
        setImage(boardImage);
        textScore = new TextScore();
        playerImage = thisWorld.getPlayerImage();
        lives = maxLives;
        LifeCounterFactory lcf = new LifeCounterFactory();
        lifeCounter = lcf.getLifeCounter(this, playerImage, maxLives);
        lifeCounter.drawLives(lives);
     }
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        boardImage.clear();
        textScore.drawScore(score);
        boardImage.fillRect(0,0,width,height);
        boardImage.drawImage(textScore, 0, height/2);
        boardImage.drawImage(lifeCounter, boardImage.getWidth()-lifeCounter.getWidth(),0);
        
    }    
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public void changeScore(int amount){
        score+=amount;
    }
    
    public int getLives(){
        return lives;
    }
    
    public void loseLife(){
        lives--;
        lifeCounter.drawLives(lives);
    }
    
    class TextScore extends GreenfootImage{
        
        public TextScore(){
            super(200,100);
            score = 0;
            
        }
        
        public void drawScore(int score){
            this.clear();
            Font f = new Font("SansSerif",20);
            Color c = Color.WHITE;
            setFont(f);
            setColor(c);
            drawString("Score: " + score, 10, 20);
        }
    }
    
    class LifeCounter extends GreenfootImage{
        GreenfootImage playerImage;
        int playerImageWidth;
        Scoreboard parent;
        /**
         * don't use this constructor, use the factor
         */
        public LifeCounter(Scoreboard parent, GreenfootImage playerImage, int width, int height, int maxLives){
            super(width,height);
            lives = maxLives;
            this.playerImage = playerImage;
            this.playerImageWidth = playerImage.getWidth();
        }
        
        public void drawLives(int lives){
            clear();
            for(int i=0;i<lives;i++){
                drawImage(playerImage, (playerImageWidth+ 10) * i + 20, 10);
            }
        }
        
        
    }
    
    class LifeCounterFactory{
        public LifeCounter getLifeCounter(Scoreboard parent, GreenfootImage playerImage, int maxLives){
            return new LifeCounter(
                parent, 
                playerImage, 
                (playerImage.getWidth()+20)*maxLives+20, 
                playerImage.getHeight()+20, maxLives);
        }
        
    }
}
