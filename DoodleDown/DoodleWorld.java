import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
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
    private static int finalScore=0;

    //for loading the highscore
    private int highScore=0;
    public int doodleWorldWide = 400;
    public int doodleWorldHeight = 600;
    
    /**
     * Constructor for objects of class DoodleWorld.
     * 
     */
    public DoodleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        prepare();
        readScores();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Doodler doodler = new Doodler();
        addObject(doodler, 175, 34);
        Ground ground = new RegularGround();
        addObject(ground, 162, 129);
        Ground ground2 = new RegularGround();
        addObject(ground2, 306, 238);
        Ground ground3 = new RegularGround();
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
        else
        {
            if (!getObjects(ScoreKeeper.class).isEmpty())  
            {  
                ScoreKeeper keeper = (ScoreKeeper)getObjects(ScoreKeeper.class).get(0);  
                finalScore=keeper.getScore(); //Final score at the end of the game. 
            }
            
            Message m = new Message("Game Over");
            addObject(m,(doodleWorldWide/2),(doodleWorldHeight/2-50));
            Message m1 = new Message("Your Score: "+finalScore);
            addObject(m1,(doodleWorldWide/2),(doodleWorldHeight/2));
            Message m2;
            if(finalScore > highScore)
            {
                m2 = new Message("High Score : "+finalScore);
            }
            else
            {
                 m2 = new Message("High Score : "+highScore);
            }
            addObject(m2,(doodleWorldWide/2),(doodleWorldHeight/2+50));
            removeObjects(getObjects(Doodler.class));
            removeObjects(getObjects(Ground.class));
            removeObjects(getObjects(ScoreKeeper.class));
            if(!soundPlayed) 
            {
                Greenfoot.playSound("Gameover.mp3");
                soundPlayed = true;
            }
        }
    
    }
    
    public void addGround()
    {
        addObject(new RegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);  
    }
    
    public void gameOver()
    {
        gameOver=true;
        ScoreKeeper keeper = (ScoreKeeper)getObjects(ScoreKeeper.class).get(0);  
        finalScore=keeper.getScore(); //Final score at the end of the game. 
        if(finalScore > 0)
            {
                try
                {
                    if(finalScore > highScore)
                    {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt"));
                        bw.write(String.valueOf(finalScore));
                        bw.newLine();
                        bw.close();
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Exception in write: "+e);
                }
            }
    }
    
    public void readScores()
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("scores.txt"));
            String str = in.readLine();
            while (str != null && !str.isEmpty() && str != "" && str != " ")
            {
                   highScore = Integer.parseInt(str);
                   str = in.readLine();
            }
            in.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in read" +e);
        }
    }
}

