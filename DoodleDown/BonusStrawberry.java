import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BonusStrawberry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusStrawberry extends Item
{
    public BonusStrawberry() {
        super();
        effectiveTimeLeft = 20;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        //((DoodleWorld) getWorld()).getScoreKeeper().addScore(5);
        DoodlerFoodUpdate foodUpdate = new DoodlerFoodUpdate(((DoodleWorld) getWorld()).getRealTimeScorer());
        foodUpdate.updateScore();
        Alert alert = new Alert("+10");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    }      
}
