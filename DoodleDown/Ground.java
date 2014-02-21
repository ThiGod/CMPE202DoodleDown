import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private int mSpeed = 1;
    
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveUp();
        checkGround();
    }    
    
    public void moveUp() {
        setLocation(getX(), getY() - mSpeed);
    }
    
    public void checkGround() {
        if(getY() == 0) {
            getWorld().removeObject(this);
        }
    }
}
