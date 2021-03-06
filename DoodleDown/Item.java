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
                effectTimeCountDown(this);
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
    
    public void effectTimeCountDown(Item i){
       effectiveTimeLeft --;
        if(effectiveTimeLeft == 0)
        {
            if(i.getClass().getSimpleName().equals("Turtle")||i.getClass().getSimpleName().equals("Rocket"))
                i.stopEffect();
            else
                stopEffect();
        }
    }    
    
    public void startEffect(Doodler d){
        isInEffect = true;
        isActivated = true;
        getImage().setTransparency(0); //what this mean?
        setLocation(400,0);
        doodler = d;
        //getWorld().removeObject(this);
    }
    
    public void stopEffect()
    {
        isInEffect = false;
    }
}
