import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeField extends World
{
    Score score = new Score();
    public YouLose youLose = new YouLose();
    public SnakeField()
    {    
        super(30, 20, 20); 
        
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new PalaSnake(), 15, 10);
        addObject(new Bear(), x, y);
        
        addFood();
    }
    
    public Score getScore()
    {
        return score;
    }
    
    public void addFood()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new Food(), x, y);
        
        addObject(score, 3, 2);
    }
    
    public void displayYouLose()
    {
        addObject(youLose, 20, 20);
        youLose.setLocation(getWidth()/2,getHeight()/2);
        Greenfoot.stop();
    }
}
