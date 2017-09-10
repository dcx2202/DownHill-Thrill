import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Objetos
{
    private GreenfootImage VIDA, vida;
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        diminuir(VIDA, vida);
        if(!apagaObjetos())
            colisao(this);
    }    
    public Vida()
    {
        VIDA = new GreenfootImage("vidaobj.png");
        vida = VIDA;
        setImage(vida);
    }
    public void mover() //como é um objeto que adiciona mais uma vida decidimos que devia ser mais difícil de apanhar
    {
        if(lane == 1)
            setLocation( getX()+5, getY()-5 );
        else if(lane == 2)
            setLocation( getX(), getY()-5 );
        else if(lane == 3)
            setLocation( getX()-5, getY()-5 );
    }
    public void diminuir(GreenfootImage original, GreenfootImage modificado)
    {
        if(getY() == antigoY-25) //diminui a imagem cada vez que o objeto anda 24 unidades em Y
        {
            modificado = original;
            modificado.scale( (int)(modificado.getWidth()*Math.pow(0.95,contarscale)), (int)(modificado.getHeight()*Math.pow(0.95,contarscale)) );
            
            antigoY = getY();
            contarscale++; //a imagem vai diminuir 95% (0.95) cada vez que entra no 'if' (1ª vez 0.95, 2ª vez 0.95*0.95, etc)
                           // foi feito assim porque fazer rescale à mesma imagem várias vezes perde imensa qualidade
        }
    }
}