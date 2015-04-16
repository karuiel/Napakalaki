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
    private int currentPlayerIndex;
    
    private Napakalaki(){}
    private void initPlayers(ArrayList<String> names){
        for(String n : names){ 
           players.add(new Player(n));
      }
    }
    //Modifico este metodo en el pdf pone que hay que actualizar currentPlayer
    private Player nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); 
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
               
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    //public CombatResult combat(){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    //public boolean makeTreasureVisible(Treasure t){}
    //public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}
    public void initGame(ArrayList<String> players){}
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    /*public boolean canMakeTreasureVisible(Treasure t){}
    public ArrayList<Treasure> getVisibleTreasures(){}
    public ArrayList<Treasure> getHiddenTreasures(){}
    public boolean nextTurn(){}*/
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
}
