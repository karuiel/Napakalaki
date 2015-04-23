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
    //Nota: si es el primer turno hay que calcular quien empieza
    //se me ocurre en el constructor inicializar index con -1 para poder determinar
    //que estamos en el primer turno. Por cierto, hay que hacer el constructor
    private Player nextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); 
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
               
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    
    //Nota: Preguntar por este diagrama
    public CombatResult combat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveMonsterBack(currentMonster);
        return result;
    }
    
    
    //Nota: ¿a que jugador se aplica?¿al actual?
    public void discardVisibleTreasure(Treasure t){
        currentPlayer.discardVisibleTreasure(t);       
    }
    
    public void discardHiddenTreasure(Treasure t){
        currentPlayer.discardHiddenTreasure(t);
    }
    //public boolean makeTreasureVisible(Treasure t){}
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden);
    }
    public void initGame(ArrayList<String> players){
        CardDealer dealer = CardDealer.getInstance();
        dealer.initCards();
        initPlayers(players);
        nextTurn();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    public boolean canMakeTreasureVisible(Treasure t){
        boolean canMake = currentPlayer.canMakeTreasureVisible(t);
        
        if(canMake){
            currentPlayer.makeTreasureVisible(t);
        }
        return canMake;
    }
    //public ArrayList<Treasure> getVisibleTreasures(){}
    //public ArrayList<Treasure> getHiddenTreasures(){}
    
    //Nota: preguntar al profesor
    public boolean nextTurn(){
        boolean allowed = nextTurnAllowed();
        if(allowed){
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer = nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();  
            }
        }
        return allowed;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
}
