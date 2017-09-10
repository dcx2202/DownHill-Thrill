import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class duasVidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class duasVidas extends NumeroVidas
{
    private GreenfootImage img1 = new GreenfootImage("2vidas.png");
    private GreenfootImage img2 = new GreenfootImage("2vidassel.png");
    private int override;
    private int imagematual;
    public static int reset;
    /**
     * Act - do whatever the duasVidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        verificaClique();
        resetImagem();
    }
    public duasVidas()
    {
        imagematual = 1;
        override = 1;
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this)) //se o rato clicar nesta opção
        {
            Vidas1.vidasj1 = 2; //os 2 jogadores passam a ter 2 vidas cada
            Vidas2.vidasj2 = 2;
            if(imagematual == 1)
            {
                override = 0;
                umaVida.reset = 1;
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
