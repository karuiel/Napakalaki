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
    
    /*
      @brief Constructor de la Clase
    */
    private Napakalaki(){
        players = new ArrayList<>();
        currentPlayerIndex = -1;
    }
    
    /*
     * @brief Método encargado de inicializar la lista de jugadores
     * @param ArrayList<String> names: nombre de los jugadores
    */
    private void initPlayers(ArrayList<String> names){
        for(String n : names){ 
           players.add(new Player(n));
      }
    }

    /*
     * @brief Método encargado de determinar cuál es el siguiente jugador
     * @return Player: jugador siguiente
    */
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
    
    /*
     * @brief Método que devuelve la instancia de Napakalaki
     * @return Napakalaki: instancia
    */
    public static Napakalaki getInstance(){
        return instance;
    }
    
    /*
     * @brief Método para combatir contra un monstruo
     * @return CombatResult: resultado del combate
    */
    public CombatResult combat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        CardDealer dealer = CardDealer.getInstance();
        if(result == CombatResult.LOSEANDCONVERT){
            Cultist c = dealer.nextCultist();
            CultistPlayer cp = new CultistPlayer(this.currentPlayer,c);
            this.currentPlayer = cp;
            this.players.set(currentPlayerIndex, cp);
        }
        dealer.giveMonsterBack(currentMonster);
        return result;
    }
    
    /*
     * @brief Método encargado de descartar una carta de tesoro visible de un jugador
     * @param Treasure t: carta a descartar
    */
    public void discardVisibleTreasure(Treasure t){
        currentPlayer.discardVisibleTreasure(t);       
    }
    
    /*
     * @brief Método encargado de descartar una carta de tesoro oculto de un jugador
    */
    public void discardHiddenTreasure(Treasure t){
        currentPlayer.discardHiddenTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t){
        
            return currentPlayer.makeTreasureVisible(t);
        
    }
    
    /*
     * @brief Método que gestiona la compra de niveles
     * @param ArrayList<Treasure> visible: lista de tesoros visibles del jugador
     * @param ArrayList<Treasure> hidden: lista de tesoros ocultos del jugador
     * @return boolean: true en caso de que se lleve a cabo la compra
                        false en caso contrario
    */
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible, hidden);
    }
    
    /*
     * @brief Método encargado de iniciar el juego
     * @param ArrayList<String> players: nombre de los jugadores
    */
    public void initGame(ArrayList<String> players){
        CardDealer dealer = CardDealer.getInstance();
        dealer.initCards();
        initPlayers(players);
        nextTurn();
    }
    
    /*
     * @brief Consultor de CurrentPlayer
     * @return Player: currentPlayer
    */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    /*
     * @brief Consultor de CurrentMonsgter
     * @return Player: currentMonster
    */
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    /*
     * @brief Método que comprueba si se puede pasar de turno
     * @return boolean: true en caso en que se pueda pasar de turno
                        false en caso contrario
    */
    public boolean nextTurnAllowed(){
        if(currentPlayerIndex==-1){
            return true;
        }
        else{
            return currentPlayer.validState();
        }
    }
    
    /*
     * @brief Método que comprueba si un tesoro oculto puede pasar a ser visible
     * @param Treasure t: tesoro que se quiere hacer visible
     * @return boolean: true en caso en que se pueda hacer visible
                        false en caso contrario
    */
    public boolean canMakeTreasureVisible(Treasure t){
        boolean canMake = currentPlayer.canMakeTreasureVisible(t);
        return canMake;
    }
    //public ArrayList<Treasure> getVisibleTreasures(){}
    //public ArrayList<Treasure> getHiddenTreasures(){}
    
    /*
     * @brief Método para pasar de turno
     * @return boolean: true en caso en que se haya pasado de turno correctamente
     *                  false en caso contrario
    */
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
    
    /*
     * @brief Método que determina si el juego ha terminado
     * @return boolean: true en caso en que haya terminado el juego
     *                  false en caso contrario
    */
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
}
