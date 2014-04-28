import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EatScoreMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EatScoreMonster extends Item
{
    public EatScoreMonster() {
        super();
        GreenfootImage image = getImage();  
        image.scale(60, 60);  
        setImage(image); 
        effectiveTimeLeft = 20;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        //((DoodleWorld) getWorld()).getScoreKeeper().addScore(3);
        DoodlerFoodUpdate foodUpdate = new DoodlerFoodUpdate(((DoodleWorld) getWorld()).getRealTimeScorer());
        foodUpdate.updateScore();
        Alert alert = new Alert("-30");
        ((DoodleWorld) getWorld()).addObject(alert, doodler.getX(),doodler.getY()-20);
    } 
}
