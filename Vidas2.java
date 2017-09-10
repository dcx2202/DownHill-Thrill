import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vidas2 extends Actor
{
    public static int vidasj2;
    /**
     * Act - do whatever the Vidas1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //identica a Vidas1
    {
        defineImagem(vidasj2);
    }
    public static void tiraVidas()
    { 
        switch(vidasj2)
        {
            case 5: vidasj2--; break;
            case 4: vidasj2--; break;
            case 3: vidasj2--; break;
            case 2: vidasj2--; break;
            case 1: vidasj2--; MundoJogo.tempoacabou = false; MundoJogo.tempo=0; break;
            default: break;
        }
    }
    public static void adicionaVidas()
    { 
        switch(vidasj2)
        {
            case 4: vidasj2++; break;
            case 3: vidasj2++; break;
            case 2: vidasj2++; break;
            case 1: vidasj2++; break;
            default: break;
        }
    }
    public void defineImagem(int vidas)
    { 
        switch(vidas)
        {
            case 5: setImage("vidas5.png"); setLocation(1050, getY()); break;
            case 4: setImage("vidas4.png"); setLocation(1058, getY()); break;
            case 3: setImage("vidas3.png"); setLocation(1066, getY()); break;
            case 2: setImage("vidas2.png"); setLocation(1074, getY()); break;
            case 1: setImage("vidas1.png"); setLocation(1082, getY()); break;
            case 0: setImage("vidas0.png"); setLocation(1082, getY()); break;
            default: break;
        }
    }
}