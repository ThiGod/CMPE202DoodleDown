import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrickGround extends SpecialGround
{
    private int timer = 0;  
    private static int CHECKPOINT = Greenfoot.getRandomNumber(25) + 60;
    
    public void checkRemove() {
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
