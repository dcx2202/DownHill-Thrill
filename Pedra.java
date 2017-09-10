import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pedra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedra extends Objetos
{
    private GreenfootImage PEDRA, pedra;
    /**
     * Act - do whatever the Pedra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        diminuir(PEDRA, pedra);
        if(!apagaObjetos())
            colisao(this);
    }    
    public Pedra()
    {
        PEDRA = new GreenfootImage("pedra.png");
        pedra = PEDRA;
        setImage(pedra);
    }
}