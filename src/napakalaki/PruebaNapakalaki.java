/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author miguemc
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
    }
    
}
