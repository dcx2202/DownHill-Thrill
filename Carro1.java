import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carro1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro1 extends Actor
{
    private int contador, antigoY;
    public static int lane;
    private GreenfootImage carrinho, esquerda, direita;
    /**
     * Act - do whatever the Carro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
    }
    public Carro1()
    {
        lane = 2; //carro faz spawn na lane do meio
        
        contador = 0;
        carrinho = new GreenfootImage("carro.png");
        esquerda = new GreenfootImage("esq.png");
        direita = new GreenfootImage("dir.png");
    }
    protected void addedToWorld(World MundoJogo) //chama o método na 1ª iteração depois do objeto ser adicionado ao mundo
    {
        antigoY = getY(); //obter o Y do spawn
        
        if (getX()== 195) //identificar em que lane se encontra o carro através do X do spawn
            lane = 1;
        else if (getX()==246)
            lane = 2;
        else if (getX()==301)
            lane = 3;
    }
    public void mover()
    {
        if(contador >= 10) //delay para não ser possível mudar de lane muito rapidamente
        {
            if(MundoJogo.acoes) //poder mover só após o semáforo
            {
                if(getX() == 195) //se estiver na lane da esquerda
                {
                    if ( Greenfoot.isKeyDown("D") )
                    {   
                        setLocation(246,getY()); //coloca o carro na lane do meio
                        setImage(carrinho);      //muda para a imagem correta
                        lane = 2;                //indica que está na lane 2
                        contador = 0;            //reinicia o contador para o delay
                    }
                }
                else if(getX() == 246) //se estiver na lane do meio
                {
                    if ( Greenfoot.isKeyDown("A") )
                    {
                        setLocation(195,getY());
                        setImage(esquerda);
                        lane = 1;
                        contador = 0;
                    }
                    else if ( Greenfoot.isKeyDown("D") )
                    {   
                        setLocation(301,getY());
                        setImage(direita); 
                        lane = 3;
                        contador = 0;
                    }
                }
                else if(getX() == 301) //se estiver na lane da direita
                {
                    if ( Greenfoot.isKeyDown("A") )
                    {
                        setLocation(246,getY());
                        setImage(carrinho);
                        lane = 2;
                        contador = 0;
                    }
                }
            }
        }
        else
            contador++;
    }
}