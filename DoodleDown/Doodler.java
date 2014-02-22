import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doodler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doodler extends Actor
{
    private int speed = 8; //Doodler honrizontal speed
    private int fallSpeed = 0; //Doodler falling speed
    private int moveSpeed = 1; //World go up speed
    private int acceleration = 1; //Doodler falling speed acceleration
    public boolean game = false; //Check the game is done or not
    
    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkDeath()) {
            moveUp();
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
    
    public boolean checkDeath() {
        if(getY() == 0) {
            //getWorld().removeObject(this);
            return false;
        }
        if(getY() == 599) {
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
    
    public void moveUp() {
        setLocation(getX(), getY() - moveSpeed);
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, 20, Ground.class);
        return under != null;
    }
    
    public void checkFall() {
        if(onGround()) {
            fallSpeed = 0;
        }
        else {
            fall();
        }
    }
    
    public void fall() {
        setLocation(getX(), getY() + fallSpeed);
        fallSpeed = fallSpeed + acceleration;
    }
    
    public void moveLeft() {
        setLocation(getX() - speed, getY());
    }
    
    public void moveRight() {
        setLocation(getX() + speed, getY());
    }
}
