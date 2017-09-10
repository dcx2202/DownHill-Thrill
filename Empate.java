import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Empate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empate extends Actor
{
    private int contador;
    /**
     * Act - do whatever the Empate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        anima();
    }
    public Empate()
    {
        contador = 0;
        Som.musicaempate.play(); //toca o som de empate
    }
    public void anima() //faz o objeto 'Empate' aparecer/desaparecer (parecer que está a piscar)
    {
        if(contador == 150) //neste 'if' vamos pôr a imagem invisível
        {
            contador++;
            if(getImage().getTransparency() == 255)
                getImage().setTransparency(0);
        }
        else if(contador == 200) //neste 'if' vamos pôr a imagem visível
        {
            contador = 0;
            if(getImage().getTransparency() == 0)
                getImage().setTransparency(255);
        }
        else
            contador++;
    }
}
