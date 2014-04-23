import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuddyGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuddyGround extends SpecialGround
{
    public void startGroundEffect(Doodler d){ 
    if(d.currentMovingStateName!=EMovingStates.SLOW){ //use if to avoid resetting all the time 
      Alert alert = new Alert("Muddy! very Slow!");
       ((DoodleWorld) getWorld()).addObject(alert, d.getX(),d.getY()-20);
       d.setMovingState(EMovingStates.SLOW); 
    
    }
  }     
}
