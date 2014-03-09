import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private int timer = 0;  
    private static int CHECKPOINT = 0; 
    
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }    
    
    public void groundMoveUp() {
        int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed();
        setLocation(getX(), getY() - worldMoveUpSpeed);
    }
    
    public void checkGround() {
        if(getY() == 0) {
            getWorld().removeObject(this);
        }
    }

    public void checkTimerGround() {
        CHECKPOINT = Greenfoot.getRandomNumber(25) + 60;
        if(getY() == 0) {
            getWorld().removeObject(this);
        }
        if(timer != CHECKPOINT) {
            timer++;
        } else {
            getWorld().removeObject(this);
            timer = 0;
            CHECKPOINT = 0;
        }
    }
}
