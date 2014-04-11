import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldHome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldHome extends World
{
    /**
     * Constructor for objects of class WorldHome.
     * 
     */
    public WorldHome()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        PlayGame play1 = new PlayBlueSky();
        addObject(play1, 200, 350);
         PlayGame play2 = new PlayDeepOcean();
        addObject(play2, 200, 420);
         PlayGame play3 = new PlayOuterSpace();
        addObject(play3, 200, 490);

       
    }
    
    public void act()
    {
        
    }
}
