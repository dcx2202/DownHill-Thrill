import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class J1Ganha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class J1Ganha extends Actor
{
    private int contador;
    /**
     * Act - do whatever the J1Ganha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        anima();
    }
    public J1Ganha()
    {
        contador = 0;
        Som.musicafim.play(); //começa a tocar a música de vitória
    }
    public void anima() //faz o objeto 'Jogador 1 ganha' aparecer/desaparecer (parecer que está a piscar)
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