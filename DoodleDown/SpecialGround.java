import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialGround extends Ground
{
    public SpecialGround(){
        GreenfootImage image = getImage();  
        image.scale(150, 30);  
        setImage(image); 
    }
    
   
}
