/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;         

/**
 *
 * @author maria
 */

//NOTA: initTreasureCardDeck; shuffleMonsters; shuffleTreasure;
//giveback...¿simplemente añade o tiene que barajarse?
//shuffle array list
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    
    private CardDealer(){}
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
        
    }
    private void initMonsterCardDeck(){
        BadConsequence badConsequence;
        Prize prize;
                
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te "
                + "descartas de tu casco visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso." + 
                " Pierdes el calzado visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
                     
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta " +
                "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonster.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));     
        
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",0, Integer.MAX_VALUE,Integer.MAX_VALUE );
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
       
        
        badConsequence = new BadConsequence("Pierdes la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
                 
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonster.add(new   Monster("El   rey   de   rosa",   13,   badConsequence, prize));
        
                
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new   Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        
        badConsequence = new BadConsequence("Estos monstruos resultan bastantes superficiales y "
                + "te aburren mortalmente. Estas muerto." , true);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros ocultos" ,2,
               0,2);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te intentas escaquear."
                + "Pierdes una mano visible" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles" ,3,
                0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre."
                + "Estas muerto" ,true);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto" ,true);
        prize = new Prize(4,1);
        unusedMonster.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder"
                + " dos niveles y un tesoro dos manos visible" ,2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El espia", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "dos niveles y cinco tesoros visibles" ,2,5,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza." + 
                "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
                Integer.MAX_VALUE,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        Collections.shuffle(unusedMonster);
    }
    private void shuffleTreasures(){}
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonster);
    }
    public static CardDealer getInstante(){
        return instance;
    }
    //public Treasure nextTreasure(){}
    //public Monster nextMonster(){}
    public void giveTreasureBack(Treasure t){}
    public void giveMonsterBack(Monster m){}
    public void initCards(){}
}
