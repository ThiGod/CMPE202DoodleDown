import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrickGround extends Ground
{
    /**
     * Act - do whatever the BrickGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(!getWorld().getObjects(Doodler.class).isEmpty() && !((DoodleWorld)getWorld()).isPaused) {
                groundMoveUp();
                checkTimerGround();
       }
    }    
}
