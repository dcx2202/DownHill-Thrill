import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cliqueparacontinuar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliqueparacontinuar extends Actor
{
    private int contador;
    public void act() 
    {
        anima();
        verificaClique();
    }
    public Cliqueparacontinuar()
    {
        contador = 0;
    }
    public void anima() //faz o objeto 'clique para continuar' aparecer/desaparecer (parecer que está a piscar)
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
            Greenfoot.setWorld(new Regras()); //passa para o mundo Regras
            Regras.som1 = MenuPrincipal.som2; //a música ficar com a mesma opção do mundo Menu Principal (a tocar ou sem som)
        }
    }
}
