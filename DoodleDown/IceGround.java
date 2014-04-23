import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceGround extends SpecialGround
{
  public void startGroundEffect(Doodler d){ 
    if(d.currentMovingStateName!=EMovingStates.FAST){ //use if to avoid resetting all the time 
      Alert alert = new Alert("Ice! very Slippy!");
       ((DoodleWorld) getWorld()).addObject(alert, d.getX(),d.getY()-20);
       d.setMovingState(EMovingStates.FAST); 
    
    }
  }
   
}
