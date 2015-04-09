/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki(){}
    private void initPlayers(ArrayList<String> names){}
    //private Player nextPlayer(){}
    public static Napakalaki getInstance(){
        return instance;
    }
    //public CombatResult combat(){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    //public boolean makeTreasureVisible(Treasure t){}
    //public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}
    public void initGame(ArrayList<String> players){}
    /*public Player getCurrentPlayer(){}
    public Monster getCurrentMonster(){}
    public boolean canMakeTreasureVisible(Treasure t){}
    public ArrayList<Treasure> getVisibleTreasures(){}
    public ArrayList<Treasure> getHiddenTreasures(){}
    public boolean nextTurn(){}
    public boolean nextTurnAllowed(){}
    public boolean endOfGame(CombatResult result){}*/
    
}
