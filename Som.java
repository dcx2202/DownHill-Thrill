import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Som here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Som extends Actor
{
    /**
     * Act - do whatever the Som wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage [] som = new GreenfootImage[2]; //cria um array que vai guardar as imagens da coluna
    public static GreenfootSound musicamenu = new GreenfootSound("musicamenu.mp3"); //musica usada no MenuPrincipal e Regras
    public static GreenfootSound musicajogo = new GreenfootSound("musicajogo.mp3"); //musica usada no MundoJogo
    public static GreenfootSound musicafim = new GreenfootSound("musicafim.mp3"); //efeito sonoro usado no fim do jogo em caso de vitoria
    public static GreenfootSound musicaempate = new GreenfootSound("musicaempate.mp3"); //efeito sonoro usado no fim do jogo em case de empate
    public void act() 
    {
        verificaCliqueSomMenuPrincipal();
        verificaCliqueSomRegras();
        verificaCliqueSomMundoJogo();
        tocaSom();
    }
    public Som()
    {
        som[0] = new GreenfootImage("som1.png"); //inicializacao de cada posicao do array com as imagens da coluna
        som[1] = new GreenfootImage("som2.png");
        if(MenuPrincipal.mundo == 1) //verifica em que mundo esta e define a imagem da coluna para a que estava previamente (noutro mundo)
        {                            // as variaveis imgsom1/2/3 guardam a posicao do vetor som que contem a imagem atual nesses respectivos mundo
            setImage(som[MenuPrincipal.imgsom1]); //estas variaveis sao atualizadas nos construtores destes mundos
        }
        else if(MenuPrincipal.mundo == 2)
        {
            setImage(som[Regras.imgsom2]);
        }
        else if(MenuPrincipal.mundo == 3)
        {
            setImage(som[MundoJogo.imgsom3]);
        }
    }
    public void verificaCliqueSomMenuPrincipal()
    {
        if(getWorld() instanceof MenuPrincipal) //se estiver no MenuPrincipal
        {
            if(Greenfoot.mouseClicked(this)) //se a coluna for clicada
            {
                if(MenuPrincipal.som2) //se o som no MenuPrincipal estiver ativo
                {
                    MenuPrincipal.som2 = false; //desativa
                    setImage(som[1]);           //troca imagem da coluna
                    MenuPrincipal.imgsom1 = 1;  //define a posicao do vetor em que esta a imagem a ser usada
                }
                else if(MenuPrincipal.som2 == false) //se estiver desativo
                {
                    MenuPrincipal.som2 = true; //ativa
                    setImage(som[0]);          //troca imagem
                    MenuPrincipal.imgsom1 = 0;
                }
            }
        }
    }
    public void verificaCliqueSomRegras() //tem o mesmo proposito que o metodo acima com a unica diferenca sendo o mundo em questao
    {
        if(getWorld() instanceof Regras)
        {
            if(Greenfoot.mouseClicked(this))
            {
                if(Regras.som1)
                {
                    Regras.som1 = false;
                    setImage(som[1]);
                    Regras.imgsom2 = 1;
                }
                else if(Regras.som1 == false)
                {
                    Regras.som1 = true;
                    setImage(som[0]);
                    Regras.imgsom2 = 0;
                }
            }
        }
    }
    public void verificaCliqueSomMundoJogo() //tem o mesmo proposito que o metodo acima com a unica diferenca sendo o mundo em questao
    {
        if(getWorld() instanceof MundoJogo)
        {
            if(Greenfoot.mouseClicked(this))
            {
                if(MundoJogo.som3)
                {
                    MundoJogo.som3 = false;
                    setImage(som[1]);
                    MundoJogo.imgsom3 = 1;
                }
                else if(MundoJogo.som3 == false)
                {
                    MundoJogo.som3 = true;
                    setImage(som[0]);
                    MundoJogo.imgsom3 = 0;
                }
            }
        }
    }
    public void tocaSom() //garante que o som esta ativo/inativo em cada mundo (ativo) consoante o valor da variavel som1/2/3 desse mesmo mundo
    {                     //MenuPrincipal -> som2  |  Regras -> som1  |  MundoJogo -> som3
        if(getWorld() instanceof MenuPrincipal) //se estiver no MenuPrincipal
        {
            if(MenuPrincipal.som2) //se a variavel som2 do menu principal estiver true
            {
                if(!musicamenu.isPlaying()) //e se a musica nao estiver ja a tocar
                    musicamenu.play();      //entao poe a musica a tocar
            }
            else //se som2 nao estiver true entao esta false e
            {
                if(musicamenu.isPlaying()) //se a musica ainda estiver ativa
                {
                    musicamenu.pause(); //entao pausa a musica
                }
            }
        }
        else if(getWorld() instanceof Regras) //identico a condicao anterior com a unica diferenca sendo o mundo em questao
        {
            if(Regras.som1)
            {
                if(!musicamenu.isPlaying())
                    musicamenu.play();
            }
            else
            {
                if(musicamenu.isPlaying())
                {
                    musicamenu.pause();
                }
            }
        }
        else if(getWorld() instanceof MundoJogo) //identico a condicao anterior com a unica diferenca sendo o mundo em questao
        {
            if(MundoJogo.som3)
            {
                if(!musicajogo.isPlaying())
                    musicajogo.play();
            }
            else
            {
                if(musicajogo.isPlaying())
                    musicajogo.pause();
            }
        }
    }
}
