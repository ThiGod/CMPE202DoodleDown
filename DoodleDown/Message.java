import greenfoot.*; 
import java.awt.Font;
import java.awt.Color; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    public Message(String t) {
        GreenfootImage gfi = new GreenfootImage(t, 30, java.awt.Color.blue, java.awt.Color.white);
        this.setImage(gfi);
    }
    
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
