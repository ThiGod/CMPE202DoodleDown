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
        super(d);
    }
    public void fall() {
    }
    public void checkGround(Actor under) {
        doodler.setLocation(doodler.getX(), under.getY() - under.getImage().getHeight()/2-10);
        if (under!=null){
            
            if( under.getClass() == BlackHoleGround.class){
                doodler.setLocation(Greenfoot.getRandomNumber(doodler.doodleWorldWide-10), Greenfoot.getRandomNumber(doodler.doodleWorldHeight-10));
            }
            
            if (under.getClass() == HeatingGround.class || under.getClass()== MuddyGround.class){
                //set the horizontalState to slowHorizontalState
                //in this state, we can also add some effect pic around doodler
            }
            
            if (under.getClass() == IceGround.class ){
               //set the horizontalState to fastHorizontalState
               //in this state, we can also add some effect pic around doodler
            }

            if (under.getClass() == ToxicGround.class){
                //set the horizontalState to stalkedHorizontalState
                //in this state, we can also add some effect pic around doodler
            }
        }
    }
}
