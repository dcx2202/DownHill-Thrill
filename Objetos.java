import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objetos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objetos extends Actor
{
    protected int lane;
    protected int antigoY, contarscale;
    private GreenfootSound atingetampa = new GreenfootSound("tampa.mp3");
    private GreenfootSound atingevida = new GreenfootSound("vidaextra.mp3");
    private GreenfootSound atingeoleo = new GreenfootSound("oleo.mp3");
    private GreenfootSound atingepedra = new GreenfootSound("pedra.mp3");
    private GreenfootSound atingebola = new GreenfootSound("bola.mp3");
    /**
     * Act - do whatever the Objetos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //
    }
    public Objetos()
    {
        lane = 2;   //os objetos fazem spawn na lane do meio
        contarscale=1;
    }
    protected void addedToWorld(World MundoJogo)
    {
        antigoY = getY();
        if (getX()== 40 || getX()==642) //valores em que fazem spawn os objetos na lane 1 para jogador1 e jogador2
            lane = 1;
        else if (getX()==246 || getX()==847)
            lane = 2;
        else if (getX()==454 || getX()==1058)
            lane = 3;
    }
    public boolean apagaObjetos()
    {
        if( getY()<230 ) //apagar objetos se nao colidirem com o carro
        {
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    public void mover()
    {
        if(lane == 1)
            setLocation( getX()+4, getY()-4 );
        else if(lane == 2)
            setLocation( getX(), getY()-4 );
        else if(lane == 3)
            setLocation( getX()-4, getY()-4 );
    }
    public void diminuir(GreenfootImage[] original, GreenfootImage[] modificado)
    {
        if(getY() == antigoY-24)
        {
            modificado[0] = original[0];
            modificado[0].scale( (int)(modificado[0].getWidth()*Math.pow(0.95,contarscale)), (int)(modificado[0].getHeight()*Math.pow(0.95,contarscale)) );
            modificado[1] = original[1];
            modificado[1].scale( (int)(modificado[1].getWidth()*Math.pow(0.95,contarscale)), (int)(modificado[1].getHeight()*Math.pow(0.95,contarscale)) );
            modificado[2] = original[2];
            modificado[2].scale( (int)(modificado[2].getWidth()*Math.pow(0.95,contarscale)), (int)(modificado[2].getHeight()*Math.pow(0.95,contarscale)) );
            modificado[3] = original[3];
            modificado[3].scale( (int)(modificado[3].getWidth()*Math.pow(0.95,contarscale)), (int)(modificado[3].getHeight()*Math.pow(0.95,contarscale)) );
            
            antigoY = getY();
            contarscale++;
        }
    }
    public void diminuir(GreenfootImage original, GreenfootImage modificado)
    {
        if(getY() == antigoY-24) //diminui a imagem cada vez que o objeto anda 24 unidades em Y
        {
            modificado = original;
            modificado.scale( (int)(modificado.getWidth()*Math.pow(0.95,contarscale)), (int)(modificado.getHeight()*Math.pow(0.95,contarscale)) );
            
            antigoY = getY();
            contarscale++; //a imagem vai diminuir 95% (0.95) cada vez que entra no 'if' (1ª vez 0.95, 2ª vez 0.95*0.95, etc)
                           // foi feito assim porque fazer rescale à mesma imagem várias vezes perde imensa qualidade
        }
    }
     public void colisao(Actor obj/*, boolean tampa, boolean vida, boolean oleo, boolean pedra, boolean bola*/)
    {
        if ( isTouching(Carro1.class) && Carro1.lane == lane) //getIntersectingObject
        {
            if(obj instanceof Vida)
            {
                if(Vidas1.vidasj1 != 5)
                    atingevida.play();
                Vidas1.adicionaVidas();
            }
             else if(obj instanceof Oleo)
            {
                getWorldOfType(MundoJogo.class).modificaScore(1, -4);
                Vidas1.tiraVidas();
                atingeoleo.play();
            }
             else if(obj instanceof Pedra)
            {
                getWorldOfType(MundoJogo.class).modificaScore(1, -8);
                Vidas1.tiraVidas();
                atingepedra.play();
            }
            else if(obj instanceof Tampa)
            {
                getWorldOfType(MundoJogo.class).modificaScore(1, -6);
                Vidas1.tiraVidas();
                atingetampa.play();
            }
            else if(obj instanceof Bola)
            {
                getWorldOfType(MundoJogo.class).modificaScore(1, -2);
                Vidas1.tiraVidas();
                atingebola.play();
            }
            else //Moeda
            {
                getWorldOfType(MundoJogo.class).modificaScore(1, 10);
                Greenfoot.playSound("ring.mp3");
            }
            getWorld().removeObject(obj);
        }
        else if ( isTouching(Carro2.class) && Carro2.lane == lane)
        {
            if(obj instanceof Vida)
            {
                if(Vidas2.vidasj2 != 5)
                    atingevida.play();
                Vidas2.adicionaVidas();
            }
            else if(obj instanceof Oleo)
            {
                getWorldOfType(MundoJogo.class).modificaScore(2, -4);
                Vidas2.tiraVidas();
                atingeoleo.play();
            }
            else if(obj instanceof Pedra)
            {
                getWorldOfType(MundoJogo.class).modificaScore(2, -8);
                Vidas2.tiraVidas();
                atingepedra.play();
            }
            else if(obj instanceof Tampa)
            {
                getWorldOfType(MundoJogo.class).modificaScore(2, -6);
                Vidas2.tiraVidas();
                atingetampa.play();
            }
            else if(obj instanceof Bola)
            {
                getWorldOfType(MundoJogo.class).modificaScore(2, -2);
                Vidas2.tiraVidas();
                atingebola.play();
            }
            else //Moeda
            {
                getWorldOfType(MundoJogo.class).modificaScore(2, 10);
                Greenfoot.playSound("ring.mp3");
            }
            getWorld().removeObject(obj);
        }
    }
}