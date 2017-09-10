import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cliqueparajogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliqueparajogar extends Actor
{
    /**
     * Act - do whatever the Cliqueparajogar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int contador;
    public void act() 
    {
        anima();
        verificaClique();
    }
    public Cliqueparajogar()
    {
        contador = 0;
    }
    public void anima() //faz o objeto 'clique para jogar' aparecer/desaparecer (parecer que está a piscar)
    {
        if(contador == 100) //neste 'if' vamos pôr a imagem invisível
        {
            contador++;
            if(getImage().getTransparency() == 255)
                getImage().setTransparency(0);
        }
        else if(contador == 150) //neste 'if' vamos pôr a imagem visível
        {
            contador = 0;
            if(getImage().getTransparency() == 0)
                getImage().setTransparency(255);
        }
        else
            contador++;
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this)) //se clicar no objeto
        {
            Som.musicamenu.stop(); //parar a música (dos mundos MenuPrincipal e Regras)
            Greenfoot.setWorld(new MundoJogo()); //passa para o mundo MundoJogo
            Som.musicajogo.play(); //iniciar a música do MundoJogo
        }
    }
}