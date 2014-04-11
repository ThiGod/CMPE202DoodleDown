import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class OuterSpace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OuterSpace extends DoodleWorld
{

    /**
     * Constructor for objects of class OuterSpace.
     * 
     */
    public OuterSpace()
    {    
        super();
    
    }
    
    public Ground getRegularGround(){
        return new RockGround();
    }
    
    public ArrayList<Ground> getSpecialGrounds(){
         ArrayList<Ground> result =new ArrayList<Ground>();
         result.add(new HeatingGround());
         result.add(new BlackHoleGround());
         return result;
    }
}
