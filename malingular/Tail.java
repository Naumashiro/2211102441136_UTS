import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tail extends Actor
{
    private int age = 0;
    private int lifeSpan = 25;
    public Tail(int lifeSpan)
    {
        GreenfootImage img = new GreenfootImage(20,20);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
        
        this.lifeSpan = lifeSpan;
    }
    
    public void act()
    {
        if(age == lifeSpan) {
            getWorld().removeObject(this);
        }
        age++;
    }
}
