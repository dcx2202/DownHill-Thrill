import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal extends World
{
    private GreenfootImage carro, titulo, clique;
    private GreenfootImage [] menu;
    private int contador;
    public static boolean som2;
    public static int imgsom1, mundo;
    /**
     * Constructor for objects of class MenuPrincipal.
     * 
     */
    public void act()
    {
        animaFundo();
    }
    public MenuPrincipal()
    {    
        super(1100, 457, 1);
        contador = 0;
        menu = new GreenfootImage[2];
        menu[0] = new GreenfootImage("menuprincipal1.png");
        menu[1] = new GreenfootImage("menuprincipal2.png");
        titulo = new GreenfootImage("titulo.png");
        setBackground(menu[0]);
        if(mundo==2) //como esta condicao e verificada antes da variavel mundo ser atualizada para indicar que agora o mundo
        {            //atual e este entao mundo indica o mundo anterior
            som2 = Regras.som1; //se veio de Regras define o estado do som deste mundo como sendo igual ao que estava em Regras
        }
        else //caso contrario atualiza o estado do som neste mundo para o estado indicado pela imagem da coluna
        {
            if(imgsom1 == 0)
                som2 = true;
            else
                som2 = false;
        }
        imgsom1 = Regras.imgsom2; //define a imagem deste mundo como sendo a anterior
        mundo = 1;
        prepare();
    }
    public void prepare()
    {
        Cesto cesto = new Cesto();
        addObject(cesto, 627, 334);
        
        Titulo titulo = new Titulo();
        addObject(titulo, getWidth()/2, 240);
        
        Cliqueparacontinuar clique = new Cliqueparacontinuar();
        addObject(clique, getWidth()/2, getHeight()/2);
        
        Som som = new Som();
        addObject(som, getWidth() - 37, getHeight()-57);
        
        Sair sair = new Sair();
        addObject(sair, getWidth() -37, 428);
    }
    public void animaFundo() //metodo para alterar o fundo a cada 20 iteracoes
    {
        if(contador == 20)
        {
            contador = 0;
            if(getBackground() == menu[0])
                setBackground(menu[1]);
            else if(getBackground() == menu[1])
                setBackground(menu[0]); 
        }
        else
            contador++;
    }
}