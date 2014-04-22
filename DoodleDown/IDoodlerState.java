import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class IDoodlerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IDoodlerState
{
    void checkGround(Actor under);
    void fall();
}
