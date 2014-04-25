import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turtle here.
 * 
 * Surbhi
 * @version (a version number or a date)
 */
public class Turtle extends Item
{
    public Turtle() 
    {
        super();
        effectiveTimeLeft=300;
    }    
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        int speed=((DoodleWorld)getWorld()).getSpeed();
        ((DoodleWorld)getWorld()).setSpeed(speed-2);
        Alert alert=new Alert("Speeding Down");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }
    
    public void stopEffect(){
        super.stopEffect();
        int speed=((DoodleWorld)getWorld()).getSpeed();
        ((DoodleWorld)getWorld()).setSpeed(speed+2);
        Alert alert=new Alert("Bored! Back to normal.");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }
}
