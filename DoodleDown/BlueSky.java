import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class BlueSky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueSky extends DoodleWorld
{

    /**
     * Constructor for objects of class BlueSky.
     * 
     */
    public BlueSky() 
    {    
        super(); 
     
    }
    
    public Ground getRegularGround(){
        return new GrassGround();
    }
    
    public ArrayList<Ground> getSpecialGrounds(){
         ArrayList<Ground> result =new ArrayList<Ground>();
         result.add(new DeadGround());
         result.add(new BrickGround());
         return result;
    }
}
