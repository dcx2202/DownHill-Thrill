import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Semaforo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Semaforo extends Actor
{
    public static boolean carroMover;
    private int conta, con;
    private GreenfootImage [] count;
    private boolean posicao, aux;
    private GreenfootSound beep, go;
    /**
     * Act - do whatever the Semaforo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        count();
    }
    public Semaforo()
    {
        conta = 0;
        con = 0;
        posicao = false;
        aux = true;
        carroMover = false;
        count = new GreenfootImage[3];
        count[0] = new GreenfootImage("vermelho.png");
        count[1] = new GreenfootImage("amarelo.png");
        count[2] = new GreenfootImage("verde.png");
        
        beep = new GreenfootSound("beep.mp3");
        go = new GreenfootSound("go.mp3");
        
        setImage(count[0]); //pôr a imagem da luz vermelha
    }
    public void mover()
    {
        if(conta>=5) //o semáforo mover-se de 5 em 5 iterações
        {
            if(getY()< 236) //enquanto não tiver chegado a Y=235
                setLocation(getX(), getY()+4); //descer
            else if(aux) //se já tiver chegado a Y=235 e aux=true
            {
                posicao = true; //indica que chegou à posição
                beep.play();    //toca o som da luz vermelha
                aux = false;    //aux=false para garantir que o método não será chamado novamente
            }    
        }
        else if(conta != 5 && posicao == false)
            conta++;
    }
    public void count() //esta classe usa um contador assim como o MundoJogo para que possam ser desencadeados eventos especificos com uma ordem especifica
    {
        if(posicao) //se o semáforo já tiver descido até à posição final (Y=235)
        {
            if(con==70) //fazer o 'if' 70 iterações após o método mover()
            {
                setImage(count[1]); //imagem da luz amarela
                beep.play();        //tocar o som da luz amarela
                con++;
            }
            else if(con == 140) //fazer o 'if' 70 iterações após o 'if' anterior
            {
                setImage(count[2]); //imagem da luz verde
                go.play();          //tocar o som da luz verde e início do jogo
                MundoJogo.acoes = true; //permitir ações no mundo (mover os carros e fazer spawn de objetos)
                con++;
            }
            else if(con > 180 && con <= 240) //fazer o 'if' 40 iterações após o 'if' anterior e até 240
                setLocation(getX(), getY()-8);//subir
            else if(con > 240)
                getWorld().removeObject(this); //remove o semáforo quando o contador chega a 241
            con++;
        }
    }
}
