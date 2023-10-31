import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Actor
{
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 1) {
            int randomX = Greenfoot.getRandomNumber(getWorld().getWidth());
            int randomY = Greenfoot.getRandomNumber(getWorld().getHeight());
            setLocation(randomX, randomY);
        }
    }
}
