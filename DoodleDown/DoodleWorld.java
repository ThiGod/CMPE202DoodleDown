import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.util.*;

/**
 * Write a description of class DoodleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoodleWorld extends World
{

    private int timer = 0;  
    private static int CHECKPOINT = 80; 
    private boolean gameOver=false;
    private boolean soundPlayed=false;
    private int finalScore=0;
    
    /**
     * Constructor for objects of class DoodleWorld.
     * 
     */
    public DoodleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Doodler doodler = new Doodler();
        addObject(doodler, 175, 34);
        Ground ground = new Ground();
        addObject(ground, 162, 129);
        Ground ground2 = new Ground();
        addObject(ground2, 306, 238);
        Ground ground3 = new Ground();
        addObject(ground3, 183, 338);
        ScoreKeeper score=new ScoreKeeper();
        addObject(score, 345,12);
    }
    
 
    public void act()
    {   
        if(gameOver==false)
        {
             if (timer != CHECKPOINT) 
                timer++;
             else {
                 timer=0;
                 addGround();
                }
         }
        else{
            if (!getObjects(ScoreKeeper.class).isEmpty())  
            {  
                ScoreKeeper keeper = (ScoreKeeper)getObjects(ScoreKeeper.class).get(0);  
                finalScore=keeper.getScore(); //Final score at the end of the game. 
            }
            Message m = new Message("Game Over");
            addObject(m,200,300);
            Message m1 = new Message("Your Score: "+finalScore);
            addObject(m1,200,330);
            removeObjects(getObjects(Doodler.class));
            removeObjects(getObjects(Ground.class));
            removeObjects(getObjects(ScoreKeeper.class));
            if(!soundPlayed) {
                Greenfoot.playSound("Gameover.mp3");
                soundPlayed = true;
            }
        }
    
    }
    
    public void addGround()
    {
        addObject(new Ground(), Greenfoot.getRandomNumber(400), 600);  
    }
    
    public void gameOver()
    {
        gameOver=true;
    }
}

