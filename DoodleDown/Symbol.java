import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Symbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Symbol extends Actor
{
    protected int timeLeft;
    protected int timeToLast;
    
    public Symbol(int t){
        timeLeft = t;
        timeToLast = t;
    }
    public void act() 
    {
        timeLeft--;
        
        getImage().setTransparency((255*timeLeft)/timeToLast);
        
        if(timeLeft == 0){
            World world = (DoodleWorld) getWorld();
            world.removeObject(this) ;
        }
    }    
}
