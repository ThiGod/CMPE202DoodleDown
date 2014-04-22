import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DoodlerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class DoodlerState implements IDoodlerState 
{
    protected Doodler doodler;
    public DoodlerState(Doodler d) {
        doodler = d;
    }
    public void checkGround(Actor under) {
    }
    public void fall() {
    }
}
