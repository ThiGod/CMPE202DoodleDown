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
    
    /**
     * Constructor for objects of class DoodleWorld.
     * 
     */
    public DoodleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
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
        addObject(ground2, 376, 238);
        Ground ground3 = new Ground();
        addObject(ground3, 183, 338);
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
            Message m = new Message("Game Over");
            addObject(m,300,200);
            removeObjects(getObjects(Doodler.class));
            removeObjects(getObjects(Ground.class));
        }
    
    }
    
  
    
    public void addGround()
    {
      
        addObject(new Ground(), Greenfoot.getRandomNumber(600), 400);
       
    }
    
    public void gameOver()
    {
        gameOver=true;
    }
}

