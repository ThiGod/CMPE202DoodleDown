import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayBlueSky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayBlueSky extends PlayGame
{
    /**
     * Act - do whatever the PlayBlueSky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            DoodleWorld dworld = new BlueSky();
            Greenfoot.setWorld(dworld);
        }
    }   
}
