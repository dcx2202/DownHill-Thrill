import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bola extends Objetos
{
    private GreenfootImage BOLA, bola;
    /**
     * Act - do whatever the Bola wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        diminuir(BOLA, bola);
        if(!apagaObjetos())
            colisao(this);
    }
    public Bola()
    {
        BOLA = new GreenfootImage("bola.png");
        bola = BOLA;
        setImage(bola);
    }
}