import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moeda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    public class Moeda extends Objetos
{
    private int contadorrodar, lane, contarscale;
    private GreenfootImage[] face, FACE;
    /**
     * Act - do whatever the Moeda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        rodar();
        mover(); //método herdado de Objetos que faz a moeda subir na rua
        diminuir(FACE, face); //método herdado de Objetos que irá fazer scale às imagens da moeda
        if(!apagaObjetos()) //se a moeda nao tiver desaparecido no topo da rua
            colisao(this);  //então verifica se houve colisão com o carro
    }
    public Moeda()
    {
        face = new GreenfootImage[4]; //imagens que irão sofrer scale
        FACE = new GreenfootImage[4]; //imagens com resolução original que não vai ser alterada
        FACE[0] = new GreenfootImage("coin1.png");
        FACE[1] = new GreenfootImage("coin2.png");
        FACE[2] = new GreenfootImage("coin3.png");
        FACE[3] = new GreenfootImage("coin4.png");
        
        for (int i=0; i<FACE.length; i++)
            face[i] = FACE[i];
            
        contarscale = 1;
        contadorrodar = 0;
        setImage(face[0]);
    }
    public void rodar()
    {
        if(contadorrodar == 5) //muda de imagem a cada 5 iterações
        {
            contadorrodar = 0; //reinicia o contador
            if (getImage()==face[0]) //verifica qual a imagem atua e faz setImage da próxima
                setImage(face[1]);
            else if (getImage()==face[1])
                setImage(face[2]);
            else if (getImage()==face[2])
                setImage(face[3]);
            else if (getImage()==face[3])
                setImage(face[0]);
        }
        else
            contadorrodar++;
    }
}