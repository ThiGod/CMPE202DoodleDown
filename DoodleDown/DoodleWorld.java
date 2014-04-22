import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*; //file manipulation (for score recording)
import java.util.*;

/**
 * Write a description of class DoodleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class DoodleWorld extends World
{
    private int timer = 0;  
    private static int GROUNDCHECKPOINT = 120; 
    private static int SPEEDCHECKPOINT = 500;
    private static int ITEMCHECKPOINT = 300;
    private boolean gameOver=false;
    private boolean soundPlayed=false;
    private boolean endScreenShowed=false;
    private static int finalScore=0;
    protected Doodler doodler;
    protected ScoreKeeper scoreKeeper;
      
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
        
        super(400, 600, 1); 
        prepare();
        readScores();
    }

    public abstract Ground getRegularGround();
    public abstract ArrayList<Ground> getSpecialGrounds();
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage image = getBackground();  
        image.scale(400, 600);  
        setBackground(image); 
        doodler = new Doodler();
        addObject(doodler, 175, 34);
        Ground ground = getRegularGround();
        addObject(ground, 162, 129);
        Ground ground2 = getRegularGround();
        addObject(ground2, 306, 238);
        Ground ground3 = getRegularGround();
        addObject(ground3, 183, 338);
        ScoreKeeper score=new ScoreKeeper();
        scoreKeeper = score;
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
            if (timer % (GROUNDCHECKPOINT/worldMoveUpSpeed)==0) {         
                addGround();
            }
           //dynamically add item
            if (timer % (ITEMCHECKPOINT/worldMoveUpSpeed)==0) {
                addItem();
            }     
            timer++;            
            
            
            
            //speed up the whole world  
            if (timer % SPEEDCHECKPOINT==0)
                worldMoveUpSpeed ++;   
        } 
        else if (!endScreenShowed) {
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
            
            PlayGame play1 = new PlayBlueSky();
            addObject(play1, (doodleWorldWide/2),(doodleWorldHeight/2-100));
            PlayGame play2 = new PlayDeepOcean();
            addObject(play2, (doodleWorldWide/2-80),(doodleWorldHeight/2-170));
            PlayGame play3 = new PlayOuterSpace();
            addObject(play3, (doodleWorldWide/2+80),(doodleWorldHeight/2-170));
            
            endScreenShowed=true;
        }
    }
    
    public ScoreKeeper getScoreKeeper(){
        return scoreKeeper;
    }
    
    public Doodler getDoodler(){
        return doodler;
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
        ArrayList<Ground> specialgrounds= getSpecialGrounds();
        int i=specialgrounds.size()-1;
        switch(randomNumber) {
            case 0:
                addObject(specialgrounds.get(0), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 1:
                addObject(specialgrounds.get(1), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 2:
                addObject(specialgrounds.get(i), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 3:
                addObject(getRegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 4:
                addObject(getRegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            case 5:
                addObject(getRegularGround(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
                break;
            }
    }
    
    public void addItem()
    {
        int randomNumber = Greenfoot.getRandomNumber(100);
        
        if(randomNumber < 10) {
            addObject(new Shield(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
        }else if(randomNumber < 20) {
            addObject(new PoisonousMushroom(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
        }else if(randomNumber < 30) {
            addObject(new BonusMushroom(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
        }else if(randomNumber < 45) {
            addObject(new BonusStrawberry(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
        }else if(randomNumber < 65) {
            addObject(new BonusGrape(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
        }else if(randomNumber < 70) {
            addObject(new BonusBanana(), Greenfoot.getRandomNumber(doodleWorldWide), doodleWorldHeight);
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
