import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Regras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Regras extends World
{
    public static boolean som1;
    public static int imgsom2;
    /**
     * Constructor for objects of class Regras.
     * 
     */
    public Regras()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 457, 1); 
        prepare();
        if(MenuPrincipal.mundo == 1) //se o mundo anterior tiver sido MenuPrincipal
            som1 = MenuPrincipal.som2; //a música ficar com a mesma opção do mundo Menu Principal (a tocar ou sem som)}
        else if(MenuPrincipal.mundo == 3) //se o mundo anterior tiver sido MundoJogo
            som1 = MundoJogo.som3; //a música ficar com a mesma opção do mundo MundoJogo (a tocar ou sem som)
        imgsom2 = MenuPrincipal.imgsom1; //atualiza a imagem da coluna para ser igual à do mundo MenuPrincipal (mute/unmute)
        MenuPrincipal.mundo = 2; //atualizar 'mundo' para indicar que o mundo atual é o mundo Regras
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new TempoLimite(), 432, 207);
        addObject(new NumeroVidas(), 395, 278);

        Cliqueparajogar clique = new Cliqueparajogar();
        addObject(clique, getWidth()/2, getHeight()/2);

        Som som = new Som();
        addObject(som, getWidth() - 37, getHeight()-57);
        
        umMin ummin = new umMin();
        addObject(ummin,630,206);

        doisMin doismin = new doisMin();
        addObject(doismin,670,206);
        
        tresMin tresmin = new tresMin();
        addObject(tresmin,710,206);
        
        quatroMin quatromin = new quatroMin();
        addObject(quatromin,750,206);
        
        cincoMin cincomin = new cincoMin();
        addObject(cincomin,790,206);
        
        umaVida umavida = new umaVida();
        addObject(umavida,630,280);
        
        duasVidas duasvidas = new duasVidas();
        addObject(duasvidas,670,280);
        
        tresVidas tresvidas = new tresVidas();
        addObject(tresvidas,710,280);
        
        quatroVidas quatrovidas = new quatroVidas();
        addObject(quatrovidas,750,280);
        
        cincoVidas cincovidas = new cincoVidas();
        addObject(cincovidas,790,280);
        
        voltaratras voltar = new voltaratras();
        addObject(voltar, getWidth() -37, 428);
    }
}