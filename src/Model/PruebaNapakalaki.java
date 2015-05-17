package Model;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public class PruebaNapakalaki {

    
    public static void main(String[] args) {
        
        // Prueba de las clases de la segunda práctica    

        //Obtener enumerados    
        TreasureKind treasureKind = TreasureKind.BOTHHANDS;
        CombatResult resutl = CombatResult.LOSEANDESCAPE;
        

        //Prueba clase dado 
        System.out.println("\ndado");
        
        Dice dado = Dice.getInstance();            
        System.out.println(dado.nextNumber());    


        //Prueba clase Prize
        System.out.println("\nPrize");
        
        int t = 1;
        int l = 1;
        Prize premio = new Prize(t,l);
        System.out.println(premio.toString());
       
        //Prueba clase cultist
        System.out.println("\nCultist");
        
        String n = "un nombre";
        int gl = 1;
        Cultist cultist = new Cultist(n,gl);
        System.out.println(cultist.getBasicBalue());
        System.out.println(cultist.getSpecialValue());
        
        //Prueba clase treasure
        System.out.println("\nTreasure");
        
        String nombre = "un nombre";
        int g = 1;
        int min = 1;
        int max = 2;
        TreasureKind tesoro = TreasureKind.NECKLACE;
        Treasure treasure = new Treasure(nombre, g, min, max, tesoro);
        System.out.println(treasure.toString());
        System.out.println(treasure.getBasicBalue());
        System.out.println(treasure.getSpecialValue());
        
        
        //Prueba de BadConsequence
        System.out.println("\nBadConsequences");
        ArrayList<Treasure> visibles = new ArrayList<>();
        ArrayList<Treasure> hidden = new ArrayList<>();
        visibles.add(treasure);
        hidden.add(treasure);
        
        
        String text = "un texto";
        boolean mata = true;
        DeathBadConsequence death = new DeathBadConsequence(text, mata);
        System.out.println(death.toString());
        System.out.println(death.isEmpty());
        death.substractHiddenTreasure(treasure);
        death.substractVisibleTreasure(treasure);
        System.out.println(death.adjustToFitTreasureLists(visibles, hidden));
        System.out.println(death.toString());
        
        
        int levels = 1;
        int nV = 2;
        int nH = 4;
        NumberBadConsequence number = new NumberBadConsequence(text, levels, nV, nH);
        System.out.println(number.toString());
        System.out.println(number.isEmpty());
        number.substractHiddenTreasure(treasure);
        number.substractVisibleTreasure(treasure);
        System.out.println(number.adjustToFitTreasureLists(visibles, hidden));
        System.out.println(number.toString());
        
        
        ArrayList<TreasureKind> sV = new ArrayList<>();
        ArrayList<TreasureKind> sH = new ArrayList<>();
        sV.add(TreasureKind.ARMOR);
        sV.add(TreasureKind.SHOE);
        sV.add(TreasureKind.NECKLACE);
        sH.add(TreasureKind.SHOE);
        sH.add(TreasureKind.BOTHHANDS);
        sH.add(TreasureKind.NECKLACE);
        SpecificBadConsequence specific = new SpecificBadConsequence(text, levels,sV,sH);
        System.out.println(specific.toString());
        System.out.println(specific.isEmpty());
        System.out.println(specific.adjustToFitTreasureLists(visibles, hidden));
        specific.substractHiddenTreasure(treasure);
        specific.substractVisibleTreasure(treasure);
        System.out.println(specific.toString());
        
        
        //Prueba clase monster
        System.out.println("\nMonster");
        
        int lC = 2;
        Monster monster = new Monster(n,l,specific,premio,lC);
        System.out.println(monster.toString());
        System.out.println(monster.getBasicBalue());
        System.out.println(monster.getSpecialValue());
        
        //Prueba clase cardDealer
        System.out.println("\nCardDealer");
        
        CardDealer dealer = CardDealer.getInstance();  
        dealer.initCards();
        System.out.println(dealer.nextCultist());
        System.out.println(dealer.nextMonster());
        System.out.println(dealer.nextTreasure());
        dealer.giveMonsterBack(monster);
        
        //Prueba Player
        System.out.println("\n\n\nPlayer");
        
        Player player = new Player("nombre");
        System.out.println(player.toString());
        player.initTreasures();
        System.out.println(player.toString());
        System.out.println(player.validState());
        System.out.println(player.isDead());
        System.out.println(player.makeTreasureVisible(player.getHiddenTreasures().get(0)));
        System.out.println(player.hasVisibleTreasures());
        player.applyPrize(premio);
        System.out.println(player.toString());
        System.out.println(player.computeGoldCoinsValue(hidden));
        player.combat(monster);
        player.applyBadConsequence(death);
        player.isDead();
        
        //Prueba cultist        
        System.out.println("Prueba cultist Player");
        CultistPlayer cultistPlayer = new CultistPlayer(player, cultist);
        System.out.println(CultistPlayer.getTotalCultistPlayer());
        System.out.println(cultistPlayer.getOponentLevel(monster));
        

       /* //Prueba clase BadConsequence
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
        bc.toString();*/



        //Prueba de clase jugador

        /*Player jugador = new Player("Maria");
        System.out.println(jugador.getCombatLevel());
        System.out.println(jugador.validState());
        System.out.println(jugador.hasVisibleTreasures());
        System.out.println(jugador.isDead());
        System.out.println(jugador.canMakeTreasureVisible(t));
        //Prueba de clase CardDealer
        CardDealer crupier = CardDealer.getInstance();
        BadConsequence badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        Prize prize = new Prize(1,1);
        Monster monster1 = new Monster("La que redacta en las tinieblas", 2, badConsequence, prize);

        crupier.giveMonsterBack(monster);
        crupier.giveTreasureBack(t);*/
    }  
}    
    
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
//    }    
//}