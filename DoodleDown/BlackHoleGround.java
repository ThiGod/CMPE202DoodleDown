import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackHoleGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackHoleGround extends SpecialGround
{
 
   public void startGroundEffect(Doodler d){ 
       
      Alert alert = new Alert("Oh Shit! Black Hole!");
       ((DoodleWorld) getWorld()).addObject(alert, d.getX(),d.getY()-20);
      d.setLocation(Greenfoot.getRandomNumber(d.doodleWorldWide-10), Greenfoot.getRandomNumber(d.doodleWorldHeight-10));           
    }
    
}
