import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BonosMushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusMushroom extends Item
{
    public BonusMushroom() {
        super();
        effectiveTimeLeft = 20;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        //((DoodleWorld) getWorld()).getScoreKeeper().addScore(20);
        DoodlerFoodUpdate foodUpdate = new DoodlerFoodUpdate(((DoodleWorld) getWorld()).getRealTimeScorer());
        foodUpdate.updateScore();
        Alert alert = new Alert("+10");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }     
}
