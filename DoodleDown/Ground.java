import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private int moveSpeed = 1; //World go up speed

    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!getWorld().getObjects(Doodler.class).isEmpty()) {
            moveUp();
            checkGround();
        }
    }    
    
    public void moveUp() {
        setLocation(getX(), getY() - moveSpeed);
    }
    
    public void checkGround() {
        if(getY() == 0) {
            getWorld().removeObject(this);
        }
    }
    public int getSpeed(){
        return moveSpeed;
    }
}
