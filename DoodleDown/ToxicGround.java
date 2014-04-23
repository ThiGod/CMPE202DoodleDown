import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToxicGround here.
 * this ground will let doodler stucked for a while
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToxicGround extends SpecialGround
{  
   private boolean stuckbegin;
   private int stuckcount=0;
   private Doodler doodler;
   private int STUCKTIME=80;
   
   ToxicGround(){
       super();
       stuckbegin=false;
       stuckcount=0;
    }
   public void act(){
      super.act();
      if(stuckbegin) stuckcount++;
      if(stuckcount>STUCKTIME) stopGroundEffect(doodler);
      
   }
    
   public void startGroundEffect(Doodler d){ 
    if(d.currentMovingStateName!=EMovingStates.STUCK){ //use if to avoid resetting all the time 
      Alert alert = new Alert("Toxic! stucked!");
       ((DoodleWorld) getWorld()).addObject(alert, d.getX(),d.getY()-20);
       stuckbegin=true;
       d.stucked=true;
       d.setMovingState(EMovingStates.STUCK);
       doodler=d;
    
    }
   }
    
   public void stopGroundEffect(Doodler d){
       //set the stuckedState in doodler to stucked==false
       d.stucked=false;
       stuckbegin=false;
       stuckcount=0;
    }
}
