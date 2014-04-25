import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedUp here.
 * 
 * Surbhi
 * @version (a version number or a date)
 */
public class Rocket extends Item
{
    public Rocket() 
    {
        super();
        effectiveTimeLeft=300;
    }    
    
    public void startEffect(Doodler d){
        super.startEffect(d);  
        int speed=((DoodleWorld)getWorld()).getSpeed();
        ((DoodleWorld)getWorld()).setSpeed(speed+3);
        Alert alert=new Alert("Speeding Up");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }
    
    public void stopEffect(){
        super.stopEffect();
        int speed=((DoodleWorld)getWorld()).getSpeed();
        ((DoodleWorld)getWorld()).setSpeed(speed-3);
        Alert alert=new Alert("Tired! Back to normal.");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }
}
