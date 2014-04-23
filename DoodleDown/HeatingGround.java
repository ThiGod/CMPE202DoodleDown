import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeatingGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeatingGround extends SpecialGround
{
  public void startGroundEffect(Doodler d){ 
    if(d.currentMovingStateName!=EMovingStates.SLOW){ //use if to avoid resetting all the time 
      Alert alert = new Alert("Heat! so hurt!");
       ((DoodleWorld) getWorld()).addObject(alert, d.getX(),d.getY()-20);
       d.setMovingState(EMovingStates.SLOW); 
    
    }
  }
    
}
