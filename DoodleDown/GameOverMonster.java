import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverMonster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverMonster extends Item
{
     public GameOverMonster() {
        super();
        GreenfootImage image = getImage();  
        image.scale(60, 60);  
        setImage(image); 
        //effectiveTimeLeft = 20;
    }
    
    public void startEffect(Doodler d){
        super.startEffect(d);
        //Alert alert = new Alert("Monster!!");
        ((DoodleWorld)getWorld()).gameOver();
    }  
}
