import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Titulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titulo extends Actor
{
    /**
     * Act - do whatever the Titulo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int contador, aux, pos;
    private GreenfootImage[] titulo;
    public void act() 
    {
        animaTitulo();
    }
    public Titulo()
    {
        titulo = new GreenfootImage[20];
        
        titulo[0] = new GreenfootImage("titulo1.png");
        titulo[1] = new GreenfootImage("titulo2.png");
        titulo[2] = new GreenfootImage("titulo3.png");
        titulo[3] = new GreenfootImage("titulo4.png");
        titulo[4] = new GreenfootImage("titulo5.png");
        titulo[5] = new GreenfootImage("titulo6.png");
        titulo[6] = new GreenfootImage("titulo7.png");
        titulo[7] = new GreenfootImage("titulo8.png");
        titulo[8] = new GreenfootImage("titulo9.png");
        titulo[9] = new GreenfootImage("titulo10.png");
        titulo[10] = new GreenfootImage("titulo11.png");
        titulo[11] = new GreenfootImage("titulo12.png");
        titulo[12] = new GreenfootImage("titulo13.png");
        titulo[13] = new GreenfootImage("titulo14.png");
        titulo[14] = new GreenfootImage("titulo15.png");
        titulo[15] = new GreenfootImage("titulo16.png");
        titulo[16] = new GreenfootImage("titulo17.png");
        titulo[17] = new GreenfootImage("titulo18.png");
        titulo[18] = new GreenfootImage("titulo19.png");
        titulo[19] = new GreenfootImage("titulo20.png");
        
        setImage(titulo[0]);
        contador = 0;
        aux = Greenfoot.getRandomNumber(20); //arranja uma posição auxiliar aleatória
    }
    public void animaTitulo()
    {
        pos = retornaPosicao(titulo);
        if(contador == 2) //só mudar a imagem de 2 em 2 iterações
        {
            contador = 0;
            if(pos != -1 && pos < aux) //se a posição atual for menor que a auxiliar
                setImage(titulo[pos+1]); //passar para a imagem seguinte
            else if(pos == aux) //se tiver chegado à posição auxiliar
                aux = Greenfoot.getRandomNumber(20); //arranja uma nova posição auxiliar aleatória
            else if(pos != -1 && pos > aux) //se a posição atual for maior que a auxiliar
                setImage(titulo[pos-1]); //passar para a imagem anterior
        }
        else
            contador++;
    }
    public int retornaPosicao(GreenfootImage vetor[])
    {
        int i = 0;
        while(i<20)
        {
            if(getImage() == vetor[i])
            {
                return i;
            }
            i++;
        }
        return -1; //se retornar -1 então não encontrou correspondência
    }
}
