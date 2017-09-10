import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FimJogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FimJogo extends Objetos
{
    private int conta, t;
    /**
     * Act - do whatever the FimJogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        aparece();
    }
    public FimJogo()
    {
        conta = 0; //inicializa a contagem a 0
        t = 0; //inicializa a variavel que define a transparencia a 0 (completamente transparente)
        MundoJogo.som3 = false; //desativa a musica que poderia estar previamente a tocar
        Som.musicajogo.stop(); 
        getImage().setTransparency(t); //inicializa a imagem completamente transparente
    }
    public void aparece() //responsavel por fazer "aparecer" um ecra preto atraves da diminuicao da transparencia (ate um certo valor)
    {
        if(conta == 5) //a cada 5 interacoes executa o seguinte
        {
            if(getImage().getTransparency() < 150) //se a transparencia estiver abaixo de 150 (de 0 a 255)
            {
                conta = 0; //reinicia a contagem
                getImage().setTransparency(t); //define a transparencia de acordo com a variavel t
                t = t + 15; //incrementa a variavel t para que a transparencia diminua na proxima chamada
            }
            else if(getImage().getTransparency() == 150) //se a transparencia estiver como pretendido
                MundoJogo.prontoMostrarVencedor = true;  //a variavel prontoMostrarVencedor e definida como true, permitindo que seja determinado e mostrado o vencedor 
        }
        else
            conta++; //se ainda nao tiverem passado 5 iteracoes continua a incrementar
    }
}
