/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Miguemc
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    public CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers += 1;                
    }
    public static int getTotalCultistPlayer(){
        return totalCultistPlayers;
    }
}
