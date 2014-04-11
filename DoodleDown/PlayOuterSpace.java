import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayOuterSpace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayOuterSpace extends PlayGame
{
    /**
     * Act - do whatever the PlayOuterSpace wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            DoodleWorld dworld = new OuterSpace();
            Greenfoot.setWorld(dworld);
        }
    }   
}
