import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*; //file manipulation (for score recording)
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
    private static int SPEEDCHECKPOINT = 600;
    private boolean gameOver=false;
    private boolean soundPlayed=false;
    private static int finalScore=0;
      
    private int worldMoveUpSpeed = 1; //World go up speed
    private int worldMoveUpAcceleration = 1;
    
    //for loading the highscore
    private int highScore=0;
    public int doodleWorldWide = 400;
    public int doodleWorldHeight = 600;
    public boolean isPaused=false;
    
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
        if(gameOver==false) {   
            checkPalse();
            if(isPaused) {
                return;
            } //do nothing if the game is paused
            //dynamically add ground 
            if (timer % (CHECKPOINT/worldMoveUpSpeed)!=0) 
                timer++;
            else {         
                timer++;
                addGround();
            }
            //speed up the whole world  
            if (timer % SPEEDCHECKPOINT == 0)
                worldMoveUpSpeed++;   
        } else {
            if (!getObjects(ScoreKeeper.class).isEmpty()) {  
                ScoreKeeper keeper = (ScoreKeeper)getObjects(ScoreKeeper.class).get(0);  
                finalScore=keeper.getScore(); //Final score at the end of the game. 
            }
        
            //Set Game Over screen
            Message m = new Message("Game Over");
            addObject(m,(doodleWorldWide/2),(doodleWorldHeight/2-50));
            Message m1 = new Message("Your Score: "+finalScore);
            addObject(m1,(doodleWorldWide/2),(doodleWorldHeight/2));
            Message m2;
        
            if(finalScore > highScore) {
                m2 = new Message("High Score : "+finalScore);
            } else {
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
            
            PlayGame play = new PlayGame();
            addObject(play, (doodleWorldWide/2),(doodleWorldHeight/2-100));
        }
    }
    
    private void checkPalse()
    {
        if(Greenfoot.isKeyDown("space")) {
            if(isPaused){
                isPaused=false;
            } else{
                isPaused=true;
            }
        }
    }
    
    public void addGround()
    {
        int randomNumber = 0;
        randomNumber = Greenfoot.getRandomNumber(6);
        switch(randomNumber) {
            case 0:
                addObject(new DeadGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 1:
                addObject(new BrickGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 2:
                addObject(new BrickGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 3:
                addObject(new RegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 4:
                addObject(new RegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 5:
                addObject(new RegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            }
    }
    
    public void gameOver()
    {
        gameOver=true;
        ScoreKeeper keeper = (ScoreKeeper)getObjects(ScoreKeeper.class).get(0);  
        finalScore=keeper.getScore(); //Final score at the end of the game. 
        if(finalScore > 0) {
            try {
                if(finalScore > highScore) {
                    //save the high score to the log file
                    BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt"));
                    bw.write(String.valueOf(finalScore));
                    bw.newLine();
                    bw.close();
                }
            } catch(Exception e) {
                System.out.println("Exception in write: "+e);
            }
        } 
        timer=0;   //set global timer back to 0 
    }
    
    public void readScores()
    {
        try {
            BufferedReader in = new BufferedReader(new FileReader("scores.txt"));
            String str = in.readLine();
            while (str != null && !str.isEmpty() && str != "" && str != " ") {
                   highScore = Integer.parseInt(str);
                   str = in.readLine();
            }
            in.close();
        } catch(Exception e) {
            System.out.println("Exception in read" +e);
        }
    }
    
    public int getTimer()
    { 
        return timer;
    }
    
    public void setTimer(int i)
    {
        timer=i;
    }
    
    public int getSpeed()
    {
        return worldMoveUpSpeed;
    }
    
    public void setSpeed(int i)
    {
        worldMoveUpSpeed=i;
    }
}
