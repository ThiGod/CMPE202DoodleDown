import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BonusBanana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusBanana extends Item
{
    public BonusBanana() {
        super();
        effectiveTimeLeft = 20;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        ((DoodleWorld) getWorld()).getScoreKeeper().addScore(10);
        Alert alert = new Alert("+10");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }   
}
