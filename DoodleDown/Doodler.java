import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doodler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doodler extends Actor
{
    private int moveHorizontalSpeed = 8; //Doodler honrizontal speed
    private int fallingSpeed = 0; //Doodler falling speed
    private int worldMoveUpSpeed = 1; //World go up speed
    private int worldMoveUpAcceleration = 1;
    private int fallingAcceleration = 1; //Doodler falling speed acceleration
    public boolean game = false; //Check the game is done or not
    public boolean soundPlayed = false; //Check whether the sound has played or not.
    private int doodleWorldWide = 400;
    private int doodleWorldHeight = 600;
    private int doodleWide = 40;
    private int doodleHeight = 40;
    private int timer = 0;
    private static int CHECKPOINT = 100;
    
    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkDeath()) {
            worldMoveUp();
            checkKeys();
            checkFall();
        }
        else 
        { 
           ((DoodleWorld)getWorld()).gameOver();
        }
    }    
    
    private void checkKeys() {
        if(Greenfoot.isKeyDown("left")) {
            //setImage("doodler.png");
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) {
            //setImage("doodler.png");
            moveRight();
        }
    }
    
    public void accelerationWorldSpeed() {
        if(timer != CHECKPOINT) {
            timer++;
        } else {
            worldMoveUpSpeed ++;
            timer = 0;
        }
    }
    
    public boolean checkDeath() {
        if(getY() == 0) {
            //getWorld().removeObject(this);
            return false;
        }
        if(getY() == (doodleWorldHeight-1)) {
            //getWorld().removeObject(this);
            return false;
        }
        else {
            return true;
        }
    }
    
    public int returnHeight() {
        int h = getY();
        return h;
    }
    
    public void worldMoveUp() {
        setLocation(getX(), getY() - worldMoveUpSpeed);
        accelerationWorldSpeed();
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, (doodleHeight/2), Ground.class);
        if(under != null){
            soundPlayed = false;
        }
        return under != null;
    }
    
    public void checkFall() {
        if(onGround()) {
            fallingSpeed = 0;
        }
        else {
            fall();
        }
    }
    
    public void fall() {
        if(!soundPlayed) {
            Greenfoot.playSound("Jump.mp3");
            soundPlayed = true;
        }
        setLocation(getX(), getY() + fallingSpeed);
        fallingSpeed = fallingSpeed + fallingAcceleration;
    }
    
    public void moveLeft() {
        setLocation(getX() - moveHorizontalSpeed, getY());
    }
    
    public void moveRight() {
        setLocation(getX() + moveHorizontalSpeed, getY());
    }
    
}
