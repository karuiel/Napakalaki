/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    //---------------------------------Constructor----------------------------------
    
    
    /*
     * @brief Constructor de la clase
     * @param Player p: jugador que pasa a convertirse en sectario
     * @param Cultist c: sectario
    */
    public CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers += 1;  
        myCultistCard = c;
    }
    
    
    /*
     * @biref Consultor del número de jugadores sectarios en el juego
     * @return int: número de sectarios
    */
    public static int getTotalCultistPlayer(){
        return totalCultistPlayers;
    }
    
    
    /*
     * @brief Método sobreescrito para determinar si el jugador debe pasar a sectario.
     *        Un sectario nunca se convierte
     * @retrun bolean: false
    */
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    /*
     * @brief Método que determina el nivel del oponente
     * @param Monster m: monstruo oponente
     * @return int: nivel del mosntruo contra un sectario
    */
    @Override
    protected int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    /*
     * @brief Consultor del nivel de combate de un sectario
     * @returnn int: nivel de combate
    */
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    
    public int getCultistBasicValue(){
        return this.myCultistCard.getBasicValue();
    }
    
    public int getCultistSpecialValue(){
        return this.myCultistCard.getSpecialValue();
    }
    
    /*
     * @brief Método que calcula los niveles que proporcionaría vender una lista de tesoros
     * @param ArrayList<Treasure> t: lista de tesoros a tasar
     * @return float: valor en niveles 
    */
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        return super.computeGoldCoinsValue(t) * 2;
    }
    
    public String toString(){
        String output = super.toString();
        output += "\n\tmyCultistCard = " + myCultistCard.toString();
        return output;
    }
    
    @Override
    public boolean isCultist(){
        return true;
    }
    
}
