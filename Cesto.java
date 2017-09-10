import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cesto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cesto extends Actor
{
    /**
     * Act - do whatever the Cesto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int contador;
    public void act() 
    {
        animaCesto();
    }
    public Cesto()
    {
        contador = 0;
    }
    public void animaCesto()
    {
        if (Greenfoot.getRandomNumber(1000)<30) //3% de chance de o cesto subir/descer
        {
            if(contador == 1) //para delay, senão troca de sítio muito rapidamente
            {
                contador = 0;
                if(getY() == 334)
                    setLocation(getX(), 289); //desce
                else
                    setLocation(getX(), 334); //sobe
            }
            else 
                contador++;
        }
    }
}
