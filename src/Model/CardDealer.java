/*
 * Clase que representa el encargado de gestionar las cartas del juego
 * Invariante de representación:
 *  -Tan solo puede haber una instancia de la clase
 */

package Model;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;         

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */


public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultist;
    
//------------------------------Constructors------------------------------------    
 
    /*
     * @brief Constructor 
    */
    private CardDealer(){
        unusedMonster = new ArrayList<>();
        usedMonster = new ArrayList<>();
        unusedTreasures = new ArrayList<>();
        usedTreasures = new ArrayList<>();
        unusedCultist = new ArrayList<>();
        shuffleTreasures();
        shuffleMonsters();
        shuffleCultists();
    }
    
//------------------------------Other methods-----------------------------------
           
    /*
     * @brief Método para obtener la instancia de la clase CardDeales
     * @return CardDeales instancia
    */
    public static CardDealer getInstance(){
        return instance;
    }
    
    /*
     * @brief Método para inicializar el mazo de cartas de tesoros
    */
    private void initTreasureCardDeck(){
        String name;
        int goldCoins;
        int minBonus;
        int maxBonus;
        TreasureKind type;
        
        name = "¡Sí mi amo!";
        goldCoins = 0;
        minBonus = 4;
        maxBonus = 7;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Botas de investigación";
        goldCoins = 600;
        minBonus = 3;
        maxBonus = 4;
        type = TreasureKind.SHOE;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Capucha de Cthulhu";
        goldCoins = 500;
        minBonus = 3;
        maxBonus = 5;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "A prueba de babas";
        goldCoins = 400;
        minBonus = 2;
        maxBonus = 5;
        type = TreasureKind.ARMOR;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Botas de lluvia ácida";
        goldCoins = 800;
        minBonus = 1;
        maxBonus = 1;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Casco minero";
        goldCoins = 400;
        minBonus = 2;
        maxBonus = 4;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Ametralladora Thompson";
        goldCoins = 600;
        minBonus = 4;
        maxBonus = 8;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Camiseta de la UGR";
        goldCoins = 100;
        minBonus = 1;
        maxBonus = 7;
        type = TreasureKind.ARMOR;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Clavo de rail ferroviario";
        goldCoins = 400;
        minBonus = 3;
        maxBonus = 6;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Cuchillo de sushi arcano";
        goldCoins = 300;
        minBonus = 2;
        maxBonus = 3;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Fez alópodo";
        goldCoins = 700;
        minBonus = 3;
        maxBonus = 5;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Hacha prehistórica";
        goldCoins = 500;
        minBonus = 2;
        maxBonus = 5;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "El aparato del Pr. Tesla";
        goldCoins = 900;
        minBonus = 4;
        maxBonus = 8;
        type = TreasureKind.ARMOR;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Gaita";
        goldCoins = 500;
        minBonus = 4;
        maxBonus = 5;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Insecticida";
        goldCoins = 300;
        minBonus = 2;
        maxBonus = 3;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Escopeta de 3 cañones";
        goldCoins = 700;
        minBonus = 4;
        maxBonus = 6;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Garabato místico";
        goldCoins = 300;
        minBonus = 2;
        maxBonus = 2;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        //NOTA::¿QUE ES BONUS MAYOR? Ponemos 0
        name = "La fuerza de Mr T";
        goldCoins = 1000;
        minBonus = 0;
        maxBonus = 0;
        type = TreasureKind.NECKLACE;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "La rebeca metálica";
        goldCoins = 400;
        minBonus = 2;
        maxBonus = 3;
        type = TreasureKind.ARMOR;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Mazo de los antiguos";
        goldCoins = 200;
        minBonus = 3;
        maxBonus = 4;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Necro-playboycón";
        goldCoins = 300;
        minBonus = 3;
        maxBonus = 5;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Lanzallamas";
        goldCoins = 800;
        minBonus = 4;
        maxBonus = 8;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Necro-comicón";
        goldCoins = 100;
        minBonus = 1;
        maxBonus = 1;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Necronomicón";
        goldCoins = 800;
        minBonus = 5;
        maxBonus = 7;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Linterna a 2 manos";
        goldCoins = 400;
        minBonus = 3;
        maxBonus = 6;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Necro-gnomicón";
        goldCoins = 200;
        minBonus = 2;
        maxBonus = 4;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Necrotelecom";
        goldCoins = 300;
        minBonus = 2;
        maxBonus = 3;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Porra preternatural";
        goldCoins = 200;
        minBonus = 2;
        maxBonus = 3;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Tentáculo de pega";
        goldCoins = 200;
        minBonus = 0;
        maxBonus = 1;
        type = TreasureKind.HELMET;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Zapato deja-amigos";
        goldCoins = 500;
        minBonus = 0;
        maxBonus = 1;
        type = TreasureKind.SHOE;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Shogulador";
        goldCoins = 600;
        minBonus = 1;
        maxBonus = 1;
        type = TreasureKind.BOTHHANDS;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
        name = "Varita de atizamiento";
        goldCoins = 400;
        minBonus = 3;
        maxBonus = 4;
        type = TreasureKind.ONEHAND;
        unusedTreasures.add(new Treasure(name, goldCoins, minBonus, maxBonus,type));
        
    }
    
    /*
     * @brief Método para inicializar el mazo de cartas de monstruos
    */
    private void initMonsterCardDeck(){
        BadConsequence badConsequence;
        Prize prize;
                
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize,0));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te "
                + "descartas de tu casco visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Chibithulhu", 2, badConsequence, prize,0));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso." + 
                " Pierdes el calzado visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize,0));
                     
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta " +
                "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonster.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize,0));     
        
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",0, Integer.MAX_VALUE,0);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize,0));
       
        
        badConsequence = new BadConsequence("Pierdes la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bichgooth", 2, badConsequence, prize,0));
        
                 
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonster.add(new   Monster("El   rey   de   rosa",   13,   badConsequence, prize,0));
        
                
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new   Monster("La que redacta en las tinieblas", 2, badConsequence, prize,0));

        
        badConsequence = new BadConsequence("Estos monstruos resultan bastantes superficiales y "
                + "te aburren mortalmente. Estas muerto." , true);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Los hondos", 8, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros ocultos" ,2,
               0,2);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("Te intentas escaquear."
                + "Pierdes una mano visible" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo", 1, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles" ,3,
                0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Pollipólipo volante", 3, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre."
                + "Estas muerto" ,true);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto" ,true);
        prize = new Prize(4,1);
        unusedMonster.add(new Monster("Familia feliz", 1, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder"
                + " dos niveles y un tesoro dos manos visible" ,2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth", 8, badConsequence, prize,0));
        
        
        badConsequence = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El espia", 5, badConsequence, prize,0));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "dos niveles y cinco tesoros visibles" ,2,5,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El Lenguas", 20, badConsequence, prize,0));
        
        
        ArrayList<TreasureKind> m = new ArrayList<>();
        m.add(TreasureKind.ONEHAND);
        m.add(TreasureKind.ONEHAND);
        m.add(TreasureKind.BOTHHANDS);
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza." + 
                "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
                m,new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicéfalo", 20, badConsequence, prize,0));
        
        badConsequence = new BadConsequence("Pierdes una mano visible" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize,-2));
        
        badConsequence = new BadConsequence("Pierdes tus tesoros visibles. Jajaja",0, Integer.MAX_VALUE,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Testigos oculares", 6, badConsequence, prize,2));
        
        badConsequence = new BadConsequence("Hoy no es tu día de suerte. Mueres", true);
        prize = new Prize(2,5);
        unusedMonster.add(new Monster("El gran cthulhu", 20, badConsequence, prize,4));
    
        badConsequence = new BadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Serpiente Político", 8, badConsequence, prize,2));
        
        ArrayList<TreasureKind> n = new ArrayList<>();
        n.add(TreasureKind.HELMET);
        n.add(TreasureKind.ARMOR);
        badConsequence = new BadConsequence("Pierdes tu casco y tu armadura visible." +
                               "Pierdes tus manos ocultas",0,n, m);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Felpuggoth", 2, badConsequence, prize,5));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles",2,0,0);
        prize = new Prize(4,2);
        unusedMonster.add(new Monster("Shoggoth", 16, badConsequence, prize,-4));
        
        badConsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Lolitagoth", 2, badConsequence, prize,3));
        
    }
    
    /*
     * @brief Método para inicializar el mazo de cartas de Sectarios
    */
    private void initCultistCardDesk(){
        String name = "Sectario";
        int level = 1;
        Cultist c = new Cultist(name,level);
        unusedCultist.add(c);
        
        level = 2;
        c = new Cultist(name,level);
        unusedCultist.add(c);
        
        level = 1;
        c = new Cultist(name,level);
        unusedCultist.add(c);
        
        level = 2;
        c = new Cultist(name,level);
        unusedCultist.add(c);
        
        level = 1;
        c = new Cultist(name,level);
        unusedCultist.add(c);
        
        level = 1;
        c = new Cultist(name,level);
        unusedCultist.add(c);
        
    
    }
    
    
    /*
     * @brief Método para barajar el mazo de cartar unusedTreasures
    */
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    /*
     * @brief Método para barajar el mazo de cartar unusedMonsters
    */
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonster);
    }

    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultist);
    }
    
    /*
     * @brief Método para incluir una carta de tesoro en el mazo de usadas
    */
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    /*
     * @brief Método para incluir una carta de monstruo en el mazo de usadas
     * @param Monster m: monstruo a devolver
    */
    public void giveMonsterBack(Monster m){
        usedMonster.add(m);
    }
    
    /*
     * @brief Método para inicializar los mazos de cartas
    */
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDesk();
    }
    
    /*
     * @brief Método que devuelve la siguiente carta de tesoro
     * @return Treasure: siguiente tesoro
    */
    public Treasure nextTreasure(){
        Treasure next;
        if(unusedTreasures.size()!=0){
            next = unusedTreasures.get(0);
            unusedTreasures.remove(0);
        }
        else{
            for(Treasure t: usedTreasures){
                unusedTreasures.add(t);
            }    
            usedTreasures.clear();
            shuffleTreasures();
            next = unusedTreasures.get(0);
            unusedTreasures.remove(0);
            
        }
        return next;        
    }
    
    /*
     * @brief Método que devuelve la siguiente carta de monstuo
     * @return Treasure: siguiente monstruo
    */
    public Monster nextMonster(){
        Monster next;
        if(unusedMonster.size()!=0){           
            next = unusedMonster.get(0);
            unusedMonster.remove(0);
        }else{
            for(Monster t: usedMonster){
                unusedMonster.add(t);
            }    
            usedMonster.clear();
            shuffleMonsters();
            next = unusedMonster.get(0);
            unusedMonster.remove(0);
            
        }
        return next;
    }
    
    //Nota:
    //No pongo comprobación porque hay 6 y nunca hay tantos jugadores
    //De todas formas preguntar al profesor
    public Cultist nextCultist(){
        Cultist next ;
        next = unusedCultist.get(0);
        unusedCultist.remove(0);
        return next;
    }
}
