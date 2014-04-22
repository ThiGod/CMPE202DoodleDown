import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MushroomSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MushroomSymbol extends Symbol
{
    public MushroomSymbol (int t) {
        super(t);
        
        GreenfootImage image = getImage();  
        image.scale(25, 25);  
        setImage(image);
    }  
}
