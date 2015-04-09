/*
 * Clase que representa un monstruo
 * Invariante de representación:
 *  -El atributo combatLevel debe ser un natural
 */

package Model;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    
    //------------------------------Constructor---------------------------------
    
    /*
     * @brief Constructor con parámetros
     * @param String name: nombre del monstruo
     * @param int level: nivel de combate del monstruo
     * @param BadConsequence bc: mal rollo del monstrup
     * @param Prize price: buen rollo del monstruo
     */ 
    public Monster(String name, int level,
                    BadConsequence bc,Prize price){
        this.name = name;
        if(level >= 0){
            this.combatLevel = level;
        }
        else{
            this.combatLevel = 0;
        }
        this.bc = bc;
        this.price = price;
    }
    
    //-------------------------------Getters------------------------------------
    
    
    /*
     *@brief Método para obtener el atributo name
     * @return String: nombre del monstruo
     */  
    public String getName(){
        return name;     
    }    
       
    /*
     * @brief Método para obtener el atributo combatLevel
     * @return int: nivel de combate del monstruo
     */ 
    public int getCombatLevel(){
        return combatLevel;     
    }
    
    /*
     * @brief Método para obtener el atributo bc
     * @return BadConsequence: mal rollo del monstruo
     */   
    public BadConsequence getBadConsequence(){
        return this.bc;
    }
    
    /*
     *@brief Método para obtener el atributo price
     * @return Prize: buen rollo del monstruo
     */   
    public Prize getPrize(){
        return this.price;
    }
       
//------------------------------------Other methods-----------------------------  
    
  /*
   * @brief Método para convertir en cadena de texto los atributos del objeto
   * @return String: cadena de texto con el valor de los atributos del monstruo
   */
    public String toString(){
        return "Name = " + name + 
                "\n\tCombat level = " + Integer.toString(combatLevel) +
                "\n\n\tPrize = ("+ price.toString()+" ) " +
                "\n\n\tBad consequence = ( " + bc.toString()+ " ) ";
    }       
}
