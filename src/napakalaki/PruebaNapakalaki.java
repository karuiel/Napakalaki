/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miguemc
 */

/*
    Faltan por poner los monstruos de la segunda página. Para hacer las dos consultas he implementado
dos getters de la clase monsters.
    Hay dos monstruos que no tenía muy claro como ponerles el mal rollo. Y he borrado los comentarios
que te puse la otra vez. Ejecútalo y mira la salida, funciona, pero queda feo todo pegado, hay que 
inventarse una forma que sea menos fea, confío en tu instinto de principeso.

¡FELIZ NAVIDAD! <3 
*/
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Prize premio = new Prize(3,2);
        ArrayList<TreasureKind> vTreasures = new ArrayList();
        ArrayList<TreasureKind> hTreasures = new ArrayList();
        
        TreasureKind tesoro = TreasureKind.ARMOR;
        TreasureKind cosa = TreasureKind.HELMET;
        vTreasures.add(tesoro);
        hTreasures.add(cosa);
        BadConsequence malRollo= new BadConsequence("eres feo",4,vTreasures,hTreasures);
        Monster monstruo= new Monster("monstruo",10,malRollo,premio);
        
        System.out.println(premio.toString());
        System.out.println(malRollo.toString());
        System.out.println(monstruo.toString());
        
        ArrayList<Monster> monstruos = new ArrayList();
        BadConsequence badConsequence;
        Prize prize;
        
        
        //Declaración de los mosntruos
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta " +
                "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" ,0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        
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
        
        
        //cambiar arrayList
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Pierdes la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Chibithulhu", 6, badConsequence, prize));
        
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
                 
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new   Monster("El   rey   de   rosa",   13,   badConsequence, prize));
        
                
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new   Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        
        //cambiar arrayList
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza." + 
                "Pierdes 3 niveles y tus tesoros visibles de las manos.",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        //Consultas
        
        System.out.println("\nLos monstruos cuyo buen rollo implica una ganancia de más de dos "+
                            "niveles son: ");
        for(int i = 0; i < monstruos.size(); ++i){
            if(monstruos.get(i).getPrize().getLevels() > 1){
                System.out.println(monstruos.get(i).toString());
            }
        }
        
        System.out.println("\nLos monstruos cuyo  mal rollo supone la pérdida de un tesoro ONEHAND son: ");
        for(int i = 0; i < monstruos.size(); ++i){
            BadConsequence bc =  monstruos.get(i).getBadConsequence();
            if(bc.getNVisibleTreasures()>=1){
                System.out.println(monstruos.get(i).toString());
            }
        }
    }
    
}
