import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    public boolean isActivated = false;
    public boolean isInEffect = false;
    protected int effectiveTimeLeft;
    protected Doodler doodler;
    
    public void act(){
        if(!getWorld().getObjects(Doodler.class).isEmpty() && !((DoodleWorld)getWorld()).isPaused) {
            moveUp();
            checkBoundary();
            
            if (isInEffect == true){
                effectTimeCountDown();
            }            
        }
    }    
    
    public void moveUp() {
        if(isInEffect == false){
            int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed();
            setLocation(getX(), getY() - worldMoveUpSpeed);
        }
    }
    
    public void checkBoundary() {
        if(getY() == 0 && !isInEffect) {
            getWorld().removeObject(this);
        }
    }    
    
    public void effectTimeCountDown(){
        effectiveTimeLeft --;
        if(effectiveTimeLeft == 0)
        {
            stopEffect();
        }
    }    
    
    public void startEffect(Doodler d){
        isInEffect = true;
        isActivated = true;
        getImage().setTransparency(0);
        setLocation(400,0);
        doodler = d;
        doodler.currentItem = this;
        //getWorld().removeObject(this);
    }
    
    public void stopEffect()
    {
        isInEffect = false;
    }
}
