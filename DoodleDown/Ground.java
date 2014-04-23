import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
 

    public void act(){
        if(!getWorld().getObjects(Doodler.class).isEmpty() && !((DoodleWorld)getWorld()).isPaused) {
            groundMoveUp();
            checkRemove();
        }
    }    
    
    public void groundMoveUp() {
        int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed();
        setLocation(getX(), getY() - worldMoveUpSpeed);
    }
    
    public void checkRemove() {
        if(getY() == 0) {
            getWorld().removeObject(this);
        }
    }
    
    public void startGroundEffect(Doodler d){
    }
    
}
