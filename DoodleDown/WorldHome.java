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
        PlayGame play = new PlayGame();
        addObject(play, 200, 390);
    }
    
    public void act()
    {
        
    }
}
