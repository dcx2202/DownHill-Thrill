import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoJogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoJogo extends World
{
    private int contadorSpawn=0, contador, conta, conta1, tempoaux, scorej1, scorej2, vencedor, l1j1, l2j1, l1j2, l2j2, l3j1, l3j2, lspawn1, lspawn2;
    private GreenfootImage [] fundo, count;
    public final int LANE1J1=40, LANE2J1=246, LANE3J1=454, LANE1J2=642, LANE2J2=847, LANE3J2=1058;
    private boolean mostraScores, unicaChamada, unicaChamada1, unicaChamada2;
    public static boolean prontoMostrarVencedor, acoes, som3, execfim, tempoacabou;
    public static int tempo, imgsom3;
    /**
     * Constructor for objects of class MundoJogo.
     * 
     */
    public MundoJogo()
    {    
        super(1100, 457, 1);
        prepare();
        imgsom3 = Regras.imgsom2; //imgsom3 e inicializada como sendo igual a variavel que guarda a posicao da imagem da coluna a ser exibida no mundo anterior no vetor som
        MenuPrincipal.mundo = 3; //define mundo como sendo o atual (3)
        contador = 0; //inicia contadores a 0
        conta = 0;
        conta1 = 0;
        scorej1 = 0; //inicia scores a 0
        scorej2 = 0;
        mostraScores = true; //inicia booleans como true para que possam desencadear o fim
        unicaChamada = true;
        unicaChamada1 = true;
        unicaChamada2 = true;
        execfim = false;     //iniciadas como false pois apenas estam true quando se pretende desencadear o fim do jogo
        prontoMostrarVencedor = false;
        acoes = false;       //iniciada como false para impedir o movimento dos carros e spawn de objetos/obstaculos durante a parte do semaforo
        tempoacabou = true;  //e definida como false apenas quando acabam as vidas de um dos jogadores antes do tempo acabar
        l1j1 = 1; //variaveis responsaveis por indicar as faixas em que e permitido fazer spawn de objetos/obstaculos
        l2j1 = 1; //sao usadas com o proposito de impedir o spawn na mesma faixa 2 ou mais vezes seguidas
        l3j1 = 1;
        l1j2 = 1;
        l2j2 = 1;
        l3j2 = 1;
        som3 = Regras.som1; //define o estado atual da musica neste mundo como sendo igual ao mundo anterior
        fundo = new GreenfootImage[5]; //define o "comprimento" do array que guarda as imagens de fundo do mundo
        fundo[0] = new GreenfootImage("world1.jpg"); //atribuicao das imagens as posicoes correspondentes do vetor
        fundo[1] = new GreenfootImage("world2.jpg");
        fundo[2] = new GreenfootImage("world3.jpg");
        fundo[3] = new GreenfootImage("world4.jpg");
        fundo[4] = new GreenfootImage("world5.jpg");
        setBackground(fundo[0]); //define o fundo inicial como a imagem guardada na posicao 0 do vetor fundo
    }
    public void act()
    {
        Semaforo();
        if(conta1 >= 510) //510 e o numero de iteracoes/acts reservadas para ocorrer o definido por Semaforo()
        {
            fazerSpawn(); //permite fazer spawn dos objetos/obstaculos
            animaRua(); //alterna entre imagens de fundo para dar efeito de movimento
            tempo(); //mantem registo do tempo e controla o que acontece a determinada altura
            mostrarScore(); //dependendo da variavel mostrarScores mostra (ou nao) os scores dos jogadores
            fimdojogo(); //se a variavel execfim for definida como true pelo metodo execfimdojogo() o fim e desencadeado
            if(unicaChamada1 && prontoMostrarVencedor) //unicachamada1 garante que so este bloco so e chamado uma vez e prontoMostrarVencedor indica que ja foi
            {                                          //adicionado um objeto FimJogo e que este encontra-se com a transparencia pretendida, permitindo entao que seja
                mostraVencedor(checkScores());         //calculado e mostrado o vencedor. Para isso mostraVencedor() recebe como parametro checkScores() que dita o vencedor
                unicaChamada1 = false;                 //impede nova chamada
            }
        }
        else
            conta1++; //incrementa o contador ate terem passado 510 iteracoes
    }
    public void prepare()
    {
        Carro1 carro1 = new Carro1(); //adiciona ao mundo os carros do jogador 1 e jogador 2, nas posicoes pretendidas
        addObject(carro1, 246, 240);
        Carro2 carro2 = new Carro2();
        addObject(carro2, 847, 240);
        
        Vidas1 vidasjog1 = new Vidas1(); //adiciona ao mundo as vidas do jogador 1 e jogador 2, nas posicoes pretendidas
        addObject(vidasjog1, 47, 87);
        Vidas2 vidasjog2 = new Vidas2();
        addObject(vidasjog2, 1052, 87);
        
        addObject(new Som(), getWidth()/2, 350); //adiciona ao mundo uma coluna que permite controlar a musica
        addObject(new voltaratras(), getWidth()/2, 384); //adiciona ao mundo uma opcao para voltar a um ecra anterior estabelecido
        
        
        tempoaux = 0; //inicializa o contador do metodo tempo() a 0
    }
    public void animaRua()
    {
        if(conta == 16) //mudar de background a cada 16 iterações
        {
            conta = 0;
            if (getBackground()==fundo[0]) //vê se o background é a primeira imagem
                setBackground(fundo[1]); //se for, passa para a segunda
            else if (getBackground()==fundo[1])
                setBackground(fundo[2]);
            else if (getBackground()==fundo[2])
                setBackground(fundo[3]);
            else if (getBackground()==fundo[3])
                setBackground(fundo[4]);
            else if (getBackground()==fundo[4])
                setBackground(fundo[0]);
        }
        else
            conta++;
    }
    public void fazerSpawn()
    {
        if(acoes) //se acoes=true (após o semáforo)
        {
            if(contadorSpawn==30)
            {
                int rand1 = Greenfoot.getRandomNumber(170);  //  2.9% -> Vida  |  11.8% -> Oleo  |  11.8% -> Pedra
                int rand2 = Greenfoot.getRandomNumber(170);  // 11.8% -> Tampa |  11.8% -> Bola  |  50% -> Moeda     (aproximadamente)
                contadorSpawn = 0;
                lspawn1 = laneSpawn(1); //retorna a lane em que o objeto faz spawn para o jogador 1
                lspawn2 = laneSpawn(2); //retorna a lane em que o objeto faz spawn para o jogador 1
                if(lspawn1 != -1)
                {
                    if(rand1 < 5) //casos em que faz spawn do objeto Vida
                        addObject(new Vida(), lspawn1, 400);
                    else if(rand1 < 25)
                        addObject(new Oleo(), lspawn1, 400);
                    else if(rand1 < 45)
                        addObject(new Pedra(), lspawn1, 400);
                    else if(rand1 < 65)
                        addObject(new Tampa(), lspawn1, 400);
                    else if(rand1 < 85)
                        addObject(new Bola(), lspawn1, 400);
                    else if(rand1 < 170)
                        addObject(new Moeda(), lspawn1, 400);
                }
                if(lspawn2 != -1)
                {
                    if(rand2 < 5)
                        addObject(new Vida(), lspawn2, 400);
                    else if(rand2 < 25)
                        addObject(new Oleo(), lspawn2, 400);
                    else if(rand2 < 45)
                        addObject(new Pedra(), lspawn2, 400);
                    else if(rand2 < 65)
                        addObject(new Tampa(), lspawn2, 400);
                    else if(rand2 < 85)
                        addObject(new Bola(), lspawn2, 400);
                    else if(rand2 < 160)
                        addObject(new Moeda(), lspawn2, 400); 
                }
            }
            else
                contadorSpawn++;
        }
    }
    private int laneSpawn(int jogador)
    {
        int rand = Greenfoot.getRandomNumber(3)+1;
        // 1 -> lane1  |  2 -> lane2  |  3 -> lane3
        if(jogador==1)
        {
            if (rand==1 && l1j1 == 1)
            {
                l1j1 = 0;
                l2j1 = 1;
                l3j1 = 1;
                return LANE1J1;
            }
            else if (rand==2 && l2j1 == 1)
            {
                l1j1 = 1;
                l2j1 = 0;
                l3j1 = 1;
                return LANE2J1;
            }
            else if (rand==3 && l3j1 == 1)
            {
                l1j1 = 1;
                l2j1 = 1;
                l3j1 = 0;
                return LANE3J1;
            }
        }
        else if(jogador==2)
        {
             if (rand==1 && l1j2 == 1)
            {
                l1j2 = 0;
                l2j2 = 1;
                l3j2 = 1;
                return LANE1J2;
            }
            else if (rand==2 && l2j2 == 1)
            {
                l1j2 = 1;
                l2j2 = 0;
                l3j2 = 1;
                return LANE2J2;
            }
            else if (rand==3 && l3j2 == 1)
            {
                l1j2 = 1;
                l2j2 = 1;
                l3j2 = 0;
                return LANE3J2;
            }
        }
        return -1; //retorna -1 se algo estiver mal
    }
    public void Semaforo()
    {
        if(conta1==100) //numero de iteracoes apos inicializar o MundoJogo e antes de adicionar um objeto semaforo
        {
            addObject(new Semaforo(), getWidth()/2, 0);
            conta1++;
        }
        else
            conta1++;
    }
    public void tempo()
    {
        if(tempoaux == 60) //numero de iteracoes/acts entre cada decremento da variavel tempo (aproximadamente um segundo) 
        {
            tempoaux = 0; //faz reset ao contador
            tempo--; //decrementa a variavel tempo
        }
        else
            tempoaux++; //se for diferente de 60 entao continua a incrementar
        if(tempo > 0) //enquanto o tempo nao acaba mostra o tempo restante, atualizado em tempo real
        {
            showText("Tempo", getWidth()/2, 410);
            showText("" + tempo, getWidth()/2, 435);
        }     
        else if(unicaChamada) //unicachamada garante que este bloco e chamada apenas uma vez pois so pode ocorrer um fim do jogo
        {
            mostraScores = false; //variavel que determina se os scores estao a ser exibidos (usada no metodo mostrarScore())
            showText("", getWidth()/2, 410); //retira os scores que estavam anteriormente a ser exibidos
            showText("", getWidth()/2, 435);
            execfimdojogo(); //desencadeia uma sequencia de chamadas que leva ao fim do jogo
            acoes = false; //variavel que permite/bloqueia a jogabilidade no MundoJogo (impede movimento dos carros e spawn de objetos/obstaculos)
            unicaChamada = false; //unicachamada definida como false para obter o efeito pretendido com este bloco
        }
    }
    public void modificaScore(int jogador, int pontos) //método para adicionar/retirar pontos aos jogadores
    {
        if(jogador==1)
        {
            if( scorej1+pontos>=0 ) //se o score do jogador1 + pontos nao der negativo entao executa scorej1+=pontos
                scorej1+=pontos;
        }
        else if(jogador==2)
            if( scorej2+pontos>=0)
                scorej2+=pontos;
    }
    protected void mostrarScore() //método para mostrar no mundo o score dos 2 jogadores
    {
        if(mostraScores)
        {
            showText("Score: "+scorej1, 441, 87);
            showText("Score: "+scorej2, 657, 87);
        }
        else if(!mostraScores)
        {
            showText("", 441, 87);
            showText("", 657, 87);
        }    
    }
    public int checkScores()
    {
        if(tempoacabou) //se tempoacabou=true então significa que o jogo acabou por tempo e não por algum jogador ficar sem vidas
        {
            if(scorej1 > scorej2)
                return 1;
            else if(scorej2 > scorej1)
                return 0;
            else //empate
                return 2;
        }
        else if(!tempoacabou)
        {
            if(Vidas1.vidasj1 > Vidas2.vidasj2)
                return 1;
            else if(Vidas2.vidasj2 > Vidas1.vidasj1)
                return 0;
        }
        return 3; //retorna 3 se algo estiver mal
    }
    public void fimdojogo() //e chamada em todos os acts mas apenas desencadeia o fim do jogo caso a variavel execfim seja true
    {
        if(execfim) //se execfim for true entao adiciona um objeto FimJogo que por sua vez desencadeia a determinacao e exibicao do vencedor
        {
            addObject(new FimJogo(), getWidth()/2, getHeight()/2);
            execfim = false; //execfim e definida como false pois so pode haver um fim
        }
    }
    public static void execfimdojogo() //metodo estatico que permite definir execfim como true desencadeando o fim do jogo atraves do metodo fimdojogo()
    {
        execfim = true;
    }
    public void mostraVencedor(int vencedor1) //método para mostrar corretamente o vencedor, adicionar os botões de 'novo jogo' ou 'sair' e mostrar os scores finais
    {
        if(vencedor1 == 0) //se o vencedor for o jogador 2
        {
            addObject(new J2Ganha(), getWidth()/2, getHeight()/2);
            addObject(new NovoJogo(), 408, 416);
            addObject(new Sairfimjogo(), 697, 416);
            showText("Score Jogador 1: "+scorej1, getWidth()/2, 347);
            showText("Score Jogador 2: "+scorej2, getWidth()/2, 367);
        }
        else if(vencedor1 == 1) //se o vencedor for o jogador 1)
        {
            addObject(new J1Ganha(), getWidth()/2, getHeight()/2);
            addObject(new NovoJogo(), 408, 416);
            addObject(new Sairfimjogo(), 697, 416);
            showText("Score Jogador 1: "+scorej1, getWidth()/2, 347);
            showText("Score Jogador 2: "+scorej2, getWidth()/2, 367);
        }
        else if(vencedor1 == 2) //se houver empate
        {
            addObject(new Empate(), getWidth()/2, getHeight()/2);
            addObject(new NovoJogo(), 408, 416);
            addObject(new Sairfimjogo(), 697, 416);
            showText("Score Jogador 1: "+scorej1, getWidth()/2, 347);
            showText("Score Jogador 2: "+scorej2, getWidth()/2, 367);
        }
    }
}