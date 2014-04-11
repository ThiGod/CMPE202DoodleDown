import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class DeepOcean here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DeepOcean extends DoodleWorld
{

    /**
     * Constructor for objects of class DeepOcean.
     * 
     */
    public DeepOcean()
    {    
        super();
       
    }
    
    public Ground getRegularGround(){
        return new CoralGround();
    }
    
    public ArrayList<Ground> getSpecialGrounds(){
         ArrayList<Ground> result =new ArrayList<Ground>();
         result.add(new ToxicGround());
         result.add(new IceGround());
         result.add(new MuddyGround());
         return result;
    }
}
