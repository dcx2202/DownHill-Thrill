import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class voltaratras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class voltaratras extends Actor
{
    /**
     * Act - do whatever the voltaratras wants to do. This method is called whenever
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
            if(getWorld() instanceof Regras) //se tiver no mundo Regras
            {
                Greenfoot.setWorld(new MenuPrincipal()); //passa para o mundo MenuPrincipal
                MenuPrincipal.som2 = Regras.som1;        //a música ficar com a mesma opção do mundo Regras (a tocar ou sem som)
            }
            if(getWorld() instanceof MundoJogo) //se tiver no mundo MundoJogo
            {
                Regras.som1 = MundoJogo.som3;   //a música ficar com a mesma opção do mundo MundoJogo (a tocar ou sem som)
                Som.musicajogo.stop();          //a música do MundoJogo para de tocar
                Greenfoot.setWorld(new Regras()); //passa para o mundo Regras
            }
        }
    }
}
