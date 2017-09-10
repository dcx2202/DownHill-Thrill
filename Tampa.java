import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tampa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tampa extends Objetos
{
    private GreenfootImage TAMPA, tampa;
    /**
     * Act - do whatever the Tampa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        diminuir(TAMPA, tampa);
        if(!apagaObjetos())
            colisao(this);
    }   
    public Tampa()
    {
        TAMPA = new GreenfootImage("esgoto.png");
        tampa = TAMPA;
        setImage(tampa);
    } 
}