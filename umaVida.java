import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class umaVida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class umaVida extends NumeroVidas
{
    private GreenfootImage img1 = new GreenfootImage("1vida.png");
    private GreenfootImage img2 = new GreenfootImage("1vidasel.png");
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
    public umaVida()
    {
        imagematual = 1;
        override = 1;
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Vidas1.vidasj1 = 1;
            Vidas2.vidasj2 = 1;
            if(imagematual == 1)
            {
                override = 0;
                duasVidas.reset = 1;
                tresVidas.reset = 1;
                quatroVidas.reset = 1;
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
