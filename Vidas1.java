import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vidas1 extends Actor
{
    public static int vidasj1;
    /**
     * Act - do whatever the Vidas1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        defineImagem(vidasj1);
    }
    public static void tiraVidas() //retira uma vida quando colide com um obstáculo
    { 
        switch(vidasj1)
        {
            case 5: vidasj1--; break; //se tiver 5 vidas, retira uma
            case 4: vidasj1--; break;
            case 3: vidasj1--; break;
            case 2: vidasj1--; break;
            case 1: vidasj1--; MundoJogo.tempoacabou = false; MundoJogo.tempo = 0; break;
            default: break; //MundoJogo.tempoacabou=false serve para não comparar os scores no final mas sim o numero de vidas
                            //MundoJogo.tempo=0 irá fazer com que o jogo acabe e apresente o ecrã de fim de jogo
        }
    }
    public static void adicionaVidas() //adiciona uma vida quando colide com um objeto da classe Vida()
    { 
        switch(vidasj1)
        {
            case 4: vidasj1++; break; //se tiver 4 vidas, adiciona uma
            case 3: vidasj1++; break;
            case 2: vidasj1++; break;
            case 1: vidasj1++; break;
            default: break;
        }
    }
    public void defineImagem(int vidas) //define a imagem que será apresentada
    { 
        switch(vidas)
        {
            case 5: setImage("vidas5.png"); setLocation(49, getY()); break; //para 5 vidas apresenta a imagem "vidas5.png"
            case 4: setImage("vidas4.png"); setLocation(41, getY()); break;
            case 3: setImage("vidas3.png"); setLocation(33, getY()); break;
            case 2: setImage("vidas2.png"); setLocation(25, getY()); break;
            case 1: setImage("vidas1.png"); setLocation(17, getY()); break;
            case 0: setImage("vidas0.png"); setLocation(17, getY()); break;
            default: break;
        }
    }
}