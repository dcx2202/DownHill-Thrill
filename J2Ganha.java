import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class J2Ganha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class J2Ganha extends Actor
{
    private int conta;
    /**
     * Act - do whatever the J2Ganha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //identica ao J1Ganha
    {
        anima();
    }
    public J2Ganha()
    {
        conta = 0;
        Som.musicafim.play();
    }
    public void anima()
    {
        if(conta == 150)
        {
            conta++;
            if(getImage().getTransparency() == 255)
                getImage().setTransparency(0);
        }
        else if(conta == 200)
        {
            conta = 0;
            if(getImage().getTransparency() == 0)
                getImage().setTransparency(255);
        }
        else
            conta++;
    }
}