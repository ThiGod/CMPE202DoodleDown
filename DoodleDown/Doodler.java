import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doodler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doodler extends Actor
{
    private int speed = 8;
    private int vSpeed = 0;
    private int mSpeed = 1;
    private int acceleration = 1;
    
    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moveUp();
       checkKeys();
       checkFall();
    }    
    
    private void checkKeys() {
        if(Greenfoot.isKeyDown("left")) {
            setImage("doodler.png");
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) {
            setImage("doodler.png");
            moveRight();
        }
    }
    
    public void moveUp() {
        setLocation(getX(), getY() - mSpeed);
    }
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, 20, Ground.class);
        return under != null;
    }
    
    public void checkFall() {
        if(onGround()) {
            vSpeed = 0;
        }
        else {
            fall();
        }
    }
    
    public void fall() {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    public void moveLeft() {
        setLocation(getX() - speed, getY());
    }
    
    public void moveRight() {
        setLocation(getX() + speed, getY());
    }
}
