import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RegularGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegularGround extends Ground
{
    /**
     * Act - do whatever the RegularGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RegularGround(){
        GreenfootImage image = getImage();  
        image.scale(150, 30);  
        setImage(image); 
    }
     

}
