import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class quatroMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quatroMin extends TempoLimite
{
    private GreenfootImage img1 = new GreenfootImage("4m.png"); 
    private GreenfootImage img2 = new GreenfootImage("4msel.png");
    private int override; 
    private int imagematual; 
    public static int reset; 
    /**
     * Act - do whatever the tresMin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //identica a classe doisMin com as unicas diferencas sendo as imagens usadas e os valores das variaveis tempo e reset
    {
        verificaClique(); 
        resetImagem();    
    }
    public quatroMin()
    {
        imagematual = 1; 
        override = 1;    
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this))
        {
            MundoJogo.tempo = 240;
            if(imagematual == 1)
            {
                override = 0;
                umMin.reset = 1;
                doisMin.reset = 1;
                tresMin.reset = 1;
                cincoMin.reset = 1;
                setImage(img2);
            }
            else
            {
                setImage(img1);
                imagematual = 1;
            }
        }
    }
    public void resetImagem()
    {
        if(override == 1)
        {
            if(reset == 1)
            {
                setImage(img1);
                reset = 0;
            }
        }
        else
            override = 1;
    }
}
