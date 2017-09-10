import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sair extends Actor
{
    /**
     * Act - do whatever the Sair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        verificaCliqueSair();
    } 
    public void verificaCliqueSair()
    {
       if(Greenfoot.mouseClicked(this)) //se clicar no objeto
       {
           System.exit(0); //fechar o jogo
       }
    }
}
