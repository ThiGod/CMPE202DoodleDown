import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoisonousMushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonousMushroom extends Item
{

    public PoisonousMushroom() {
        super();
        effectiveTimeLeft = 200;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        doodler.setMovingState(EMovingStates.OPPOSITE);
        doodler.currentMovingItem = this;
        
        Alert alert = new Alert("I am feeling dizzy~");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
        
        MushroomSymbol mushroomSymbol = new MushroomSymbol(200);
        ((DoodleWorld) getWorld()).addObject(mushroomSymbol,350,40);
    }
    
    public void stopEffect()
    {
        super.stopEffect();
        if(doodler.currentMovingItem == this){
            Alert alert = new Alert("Feel much better now!");
            ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);            
            doodler.setMovingState(EMovingStates.NORMAL);
        }
    }
    
}
