import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class DoodlerGroundState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoodlerGroundState extends DoodlerState 
{
    public DoodlerGroundState(Doodler d) {
        super(d);  //will set the private attribuete doodler
    }
    public void fall() {
    }
    public void checkGround(Actor groundUnder) {
        doodler.setLocation(doodler.getX(), groundUnder.getY() - groundUnder.getImage().getHeight()/2-10);
        if (groundUnder!=null){
            //according to different ground under the dooder, the doodler MovingState will be set different
            Ground Under=(Ground) groundUnder;
            Under.startGroundEffect(doodler);
            
        }
    }
}
