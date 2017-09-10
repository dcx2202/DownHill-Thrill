import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class quatroVidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quatroVidas extends NumeroVidas
{
    private GreenfootImage img1 = new GreenfootImage("4vidas.png");
    private GreenfootImage img2 = new GreenfootImage("4vidassel.png");
    private int override;
    private int imagematual;
    public static int reset;
    /**
     * Act - do whatever the duasVidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //identica a duasVidas
    {
        verificaClique();
        resetImagem();
    }
    public quatroVidas()
    {
        imagematual = 1;
        override = 1;
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Vidas1.vidasj1 = 4;
            Vidas2.vidasj2 = 4;
            if(imagematual == 1)
            {
                override = 0;
                umaVida.reset = 1;
                duasVidas.reset = 1;
                tresVidas.reset = 1;
                cincoVidas.reset = 1;
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
