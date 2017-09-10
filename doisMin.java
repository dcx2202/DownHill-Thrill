import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class doisMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class doisMin extends TempoLimite
{
    private GreenfootImage img1 = new GreenfootImage("2m.png"); //cria e inicializa imagens usadas por esta classe
    private GreenfootImage img2 = new GreenfootImage("2msel.png");
    private int override; //cria variavel usada para controlar a execucao de metodos
    private int imagematual; //cria variavel para guardar uma indicacao da imagem atual
    public static int reset; //cria variavel estatica para guardar uma indicacao de reset
    /**
     * Act - do whatever the doisMin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        verificaClique(); //verifica constantemente se o objeto foi clicado
        resetImagem();    //e chamada em todos os acts para que possa "resetar" a imagem deste objeto a "pedido" das outras subclasses
    }
    public doisMin()
    {
        imagematual = 1; //inicializa imagematual como guardando a indicacao de a imagem atual ser a img1
        override = 1;    //inicializa override a 1 para que este objeto possa ter a sua imagem "resetada"
    }
    public void verificaClique()
    {
        if(Greenfoot.mouseClicked(this)) //se for clicado
        {
            MundoJogo.tempo = 120; //define o tempo de jogo como sendo 2 minutos
            if(imagematual == 1) //se a imagem atual for a a img1
            {
                override = 0; //define o override como 0 para impedir a execucao do metodo resetImagem() nesta classe
                umMin.reset = 1; //atualiza a variavel reset das outras subclasses de TempoLimite para 1
                tresMin.reset = 1;
                quatroMin.reset = 1;
                cincoMin.reset = 1;
                setImage(img2); //altera para a imagem img2
            }
            else //se a imagem atual for a img2
            {
                setImage(img1); //altera para a imagem img1
                imagematual = 1; //define a imageatual como sendo a img1
            }
        }
    }
    public void resetImagem()
    {
        if(override == 1) //se o override desta classe estiver a 1
        {
            if(reset == 1) //e o reset tambem (caso em que pretende-se que a classe desta imagem seja definida como img1)
            {
                setImage(img1); //define a imagem como sendo a img1
                reset = 0; //define o reset como 0 para impedir nova execucao deste bloco
            }
        }
        else //se override estiver a 0 entao neste act este objeto esta a ser clicado, de forma a que a imagem atual deve ser alterada para a img2
            override = 1; // e pretende-se que todos os outros objetos das subclasses de TempoLimite tenham a sua imagem definida como img1 
    }                     // Para que este objeto esteja disponivel a "levar reset" pelas outras subclasses nas iteracoes seguintes override e definido como 1
}

