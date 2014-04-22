import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShieldSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldSymbol extends Symbol
{
    public ShieldSymbol (int t) {
        super(t);
        
        GreenfootImage image = getImage();  
        image.scale(25, 25);  
        setImage(image);
    }
}
