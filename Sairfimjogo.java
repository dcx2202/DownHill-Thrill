import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sairfimjogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sairfimjogo extends Actor
{
    /**
     * Act - do whatever the Sairfimjogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        verificaClique();
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this)) //se clicar no objeto
        {
            Som.musicafim.stop(); //parar a música de vitória se estiver a tocar
            Som.musicaempate.stop(); //parar o som de empate se estiver a tocar
            Greenfoot.setWorld(new MenuPrincipal()); //passar ao mundo MenuPrincipal
        }
    }
}