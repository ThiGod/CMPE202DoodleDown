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
    private int fallingAcceleration = 1; //Doodler falling speed acceleration
    public boolean game = false; //Check the game is done or not
    public boolean soundPlayed = false; //Check whether the sound has played or not.
    private int doodleWorldWide = 400;
    private int doodleWorldHeight = 600;
    private int doodleWide = 40;
    private int doodleHeight = 40;
    private String prevDirection="right"; //the last direction the doodler was facing to 


    
    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkDeath()) {
            doodlerMoveUp();
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
            turnAround("left");
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) {
            //setImage("doodler.png");
            turnAround("right");
            moveRight();
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
    
    public void doodlerMoveUp() {
        int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed();
        setLocation(getX(), getY() - worldMoveUpSpeed);
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, (doodleHeight/2), RegularGround.class);
        
        boolean onTop=under != null;
        
        if(onTop){
            soundPlayed = false;
            alignDoodler(under); //make sure the doodler is on the surface of the ground
        }
        
        
        
        return onTop;
    }
    
    private void alignDoodler(Actor ground){
        setLocation(getX(), ground.getY()-ground.getImage().getHeight()/2-10);
    }
    
    private void turnAround(String direction){
        if(prevDirection!=direction){
            prevDirection=direction;
            getImage().mirrorHorizontally();
        }
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
