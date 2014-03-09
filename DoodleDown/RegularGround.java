import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RegularGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegularGround extends Ground
{
    /**
     * Act - do whatever the RegularGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!getWorld().getObjects(Doodler.class).isEmpty() && !((DoodleWorld)getWorld()).isPaused) {
            groundMoveUp();
            checkGround();
        }
    }    
}
