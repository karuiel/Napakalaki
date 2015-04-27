/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
    
    //Nota: no se que cojones hacer aqui <3
    //(igual para ruby)
    private Napakalaki(){
        players = new ArrayList<>();
        currentPlayerIndex = -1;
    }
    
    private void initPlayers(ArrayList<String> names){
        for(String n : names){ 
           players.add(new Player(n));
      }
    }

    private Player nextPlayer(){
        if(currentPlayerIndex ==-1){
            Random rand = new Random();
            currentPlayerIndex = rand.nextInt(players.size());
        }
        else{
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); 
        }   
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
               
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult combat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveMonsterBack(currentMonster);
        return result;
    }
    
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
        if(currentPlayerIndex==-1){
            return true;
        }
        else{
            return currentPlayer.validState();
        }
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
