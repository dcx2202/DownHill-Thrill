import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oleo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oleo extends Objetos
{
    private GreenfootImage OLEO, oleo;
    /**
     * Act - do whatever the Oleo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        diminuir(OLEO, oleo);
        if(!apagaObjetos())
            colisao(this);
    }    
    public Oleo()
    {
        OLEO = new GreenfootImage("oleo.png");
        oleo = OLEO;
        setImage(oleo);
    }
}