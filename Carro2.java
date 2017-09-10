import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro2 extends Actor
{
    private int conta, antigoY;
    public static int lane;
    private GreenfootImage carrinho, esquerda, direita;
    /**
     * Act - do whatever the Carro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //identica a Carro1
    {
        mover();
    }
    public Carro2()
    {
        conta = 0;
        lane = 2;
        
        carrinho = new GreenfootImage("carro.png");
        esquerda = new GreenfootImage("esq.png");
        direita = new GreenfootImage("dir.png");
    }
    public void mover()
    {
        if(conta>=10)
        {
            if(MundoJogo.acoes)
            {
                if(getX() == 796)
                {
                    if ( Greenfoot.isKeyDown("right") )
                    {   
                        setLocation(847,getY());
                        setImage(carrinho); 
                        lane = 2;
                        conta = 0;
                    }
                }
                else if(getX() == 847)
                {
                    if ( Greenfoot.isKeyDown("left") )
                    {
                        setLocation(796,getY());
                        setImage(esquerda);
                        lane = 1;
                        conta = 0;
                    }
                    else if ( Greenfoot.isKeyDown("right") )
                    {   
                        setLocation(902,getY());
                        setImage(direita); 
                        lane = 3;
                        conta = 0;
                    }
                }
                else if(getX() == 902)
                {
                    if ( Greenfoot.isKeyDown("left") )
                    {
                        setLocation(847,getY());
                        setImage(carrinho);
                        lane = 2;
                        conta = 0;
                    }
                }
            }
        }
        else
            conta++;
    }
     protected void addedToWorld(World MundoJogo)
    {
        antigoY = getY();
        if (getX()== 195)
            lane = 1;
        else if (getX()==246)
            lane = 2;
        else if (getX()==301)
            lane = 3;
    }
}