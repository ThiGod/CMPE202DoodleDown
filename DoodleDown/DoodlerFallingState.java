import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DoodlerFallingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoodlerFallingState extends DoodlerState 
{
    public DoodlerFallingState(Doodler d) {
        super(d);
    }
    public void fall() {
        /*
        if(!doodler.soundPlayed) {
            Greenfoot.playSound("jump.mp3");
            doodler.soundPlayed = true;
        }
        */
        doodler.setLocation(doodler.getX(), doodler.getY() + doodler.fallingSpeed);
        doodler.fallingSpeed = doodler.fallingSpeed + doodler.fallingAcceleration;
    }
    public void checkGround(Actor under) {
    }
}
