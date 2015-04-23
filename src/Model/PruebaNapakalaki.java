package Model;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public class PruebaNapakalaki {

    
    public static void main(String[] args) {
        
    // Prueba de las clases de la segunda práctica    
        
    Dice dado = Dice.getInstance();            
    System.out.println(dado.nextNumber());    
    
    //Prueba clase dado
    CardDealer cartas = CardDealer.getInstance();   
    
    
    //Prueba clase BadConsequence
    BadConsequence bc = new BadConsequence("uno",false);
    if(bc.isEmpty()){
        System.out.println("bc vacío");
    }
    else{
        System.out.println("bc lleno");
    }
    
    
    if(bc.kills()){
        System.out.println("mata");
    }
    else{
        System.out.println("no mata");
    }
    bc.toString();
    
    //Prueba clase Treasure
    String text = "tesoro";
    int goldCoins = 1000;
    int min = 1;
    int max = 2;
    TreasureKind tesoro = TreasureKind.HELMET;
    Treasure t = new Treasure(text, goldCoins, min, max, tesoro);
    System.out.println("Datos del tesoro:");
    System.out.println(t.getGoldCoins());
    System.out.println(t.getMaxBonus());
    System.out.println(t.getMinBonus());
    System.out.println(t.getName());
    System.out.println(t.getType());
   
    //Prueba de clase jugador
    
    Player jugador = new Player("Maria");
    System.out.println(jugador.getCombatLevel());
    System.out.println(jugador.validState());
    System.out.println(jugador.hasVisibleTreasures());
    System.out.println(jugador.isDead());
    System.out.println(jugador.canMakeTreasureVisible(t));
    //Prueba de clase CardDealer
    CardDealer crupier = CardDealer.getInstance();
    BadConsequence badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
    Prize prize = new Prize(1,1);
    Monster monster = new Monster("La que redacta en las tinieblas", 2, badConsequence, prize);
    
    crupier.giveMonsterBack(monster);
    crupier.giveTreasureBack(t);
    
        //-----------------------------Prueba Sesión 1--------------------------
     /*  
        Prize price = new Prize(1,1);
        System.out.println("Premio creado:");
        System.out.println(price.toString());
        
        String text = "Sientes bichos bajo la ropa. Descarta la armadura visible.";
        BadConsequence bc1 = new BadConsequence(text,0,1,0);
        BadConsequence bc2 = new BadConsequence(text,false);
        BadConsequence bc3 = new BadConsequence(text,8,
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)),
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)));
        
        System.out.println("Malos rollos creados:");
        System.out.println(bc1.toString());
        System.out.println(bc2.toString());
        
        Monster myMonster = new Monster("Bichgooth", 2, bc1,price);
        System.out.println("El monstruo creado es:");
        System.out.println(myMonster.toString());
        
        //----------------------Declaración de los monstruos------------------------
        
        ArrayList<Monster> monstruos = new ArrayList();
        BadConsequence badConsequence;
        Prize prize;
                
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te "
                + "descartas de tu casco visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso." + 
                " Pierdes el calzado visible.",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
                     
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta " +
                "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));     
        
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                                        0, Integer.MAX_VALUE,Integer.MAX_VALUE );
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
       
        
        badConsequence = new BadConsequence("Pierdes la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
                 
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("El   rey   de   rosa",   13,   badConsequence, prize));
        
                
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        
        badConsequence = new BadConsequence("Estos monstruos resultan bastantes superficiales y "
                + "te aburren mortalmente. Estas muerto." , true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros ocultos" ,2,
               0,2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te intentas escaquear."
                + "Pierdes una mano visible" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles" ,3,
                0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre."
                + "Estas muerto" ,true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto" ,true);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder"
                + " dos niveles y un tesoro dos manos visible" ,2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te asusta en la noche. "
                + "Pierdes un casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes "
                + "dos niveles y cinco tesoros visibles" ,2,5,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza." + 
                "Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
                Integer.MAX_VALUE,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        
        //----------------------------------Consultas----------------------------------------------
        
        System.out.println("\nLos monstruos cuyo nivel de combate es mayor a 10 son: ");
        for(Monster monster: monstruos){
            if(monster.getCombatLevel() > 10){
                System.out.println(monster.toString());
            }
        }
        
        System.out.println("\nLos monstruos cuyo mal rollo solo implica la perdida de niveles son: ");
        for(Monster monster: monstruos){
            BadConsequence bc = monster.getBadConsequence();
            if((bc.getNHiddenTreasures() == 0) && (bc.getNVisibleTreasures() == 0) && (bc.getLevel()!=0)
                    && bc.getSpecificHiddenTreasures().isEmpty() && 
                    bc.getSpecificVisibleTreasures().isEmpty()){
                System.out.println(monster.toString());
            }
        }
        System.out.println("\nLos monstruos cuyo buen rollo implica una ganancia de más de un "+
                            "nivel son: ");
        for(Monster monster: monstruos){
            if(monster.getPrize().getLevels() > 1){
                System.out.println(monster.toString());
            }
        }
        
        System.out.println("\nLos monstruos cuyo  mal rollo supone la pérdida de al menos un " +
                            "tesoro ONEHAND son: ");
        for(Monster monster: monstruos){
            boolean encontrado = false;
            BadConsequence bc =  monster.getBadConsequence();
            ArrayList<TreasureKind>  visibleTreasures = bc.getSpecificVisibleTreasures();
            ArrayList<TreasureKind>  hiddenTreasures = bc.getSpecificHiddenTreasures();
            
            for(TreasureKind visibles: visibleTreasures ){
                if(visibles.name() == "ONEHAND"){
                    System.out.println(monster.toString());
                    encontrado = true;
                }
            }    
            if(!encontrado){
                for(TreasureKind invisibles: hiddenTreasures ){
                    if(invisibles.name() == "ONEHAND"){
                        System.out.println(monster.toString());
                    }
                }    
            }
        }*/
    }    
}