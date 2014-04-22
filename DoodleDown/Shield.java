import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Item
{

    public Shield() {
        super();
        
        GreenfootImage image = getImage();  
        image.scale(50, 50);  
        setImage(image); 
        
        effectiveTimeLeft = 500;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        doodler.setProtectionState(EProtectionStates.PROTECTED);
        doodler.currentProtectionItem = this;
        
        Alert alert = new Alert("Get shield!");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
        
        ShieldSymbol shieldSymbol = new ShieldSymbol(500);
        ((DoodleWorld) getWorld()).addObject(shieldSymbol,380,40);
    }
    
    public void stopEffect()
    {
        super.stopEffect();
        if (doodler.currentProtectionItem == this){
            Alert alert = new Alert("Lost shield!");
            ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);            
            doodler.setProtectionState(EProtectionStates.UNPROTECTED);
        }
    }
}
