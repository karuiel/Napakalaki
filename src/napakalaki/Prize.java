/*
 * Clase que representa un buen rollo
 *Invariante de representación:
 *  -El atributo treasures debe ser un entero no negativo
 *  -El atributo levels debe ser un entero no negativo
 */
package napakalaki;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public class Prize {
    
    private int treasures;
    private int levels;
    
    //--------------------------------------Constructor--------------------------------------------
    
    
    /*
    *@brief Constructor de la clase
    *@param int treasures: número de tesoros
    *@param inr levels: número de niveles
    */
    public Prize(int treasures, int levels){
        if(treasures > 0){
            this.treasures = treasures;
        }
        else{
            this.treasures = 0;
        }
        
        if(levels > 0){
            this.levels= levels;
        }
        else{
            this.levels = 0;
        }
    }
    
    //--------------------------------------Getters-----------------------------------------------
    
    
    /*
    *@brief Método que devuelve el valor del atributo treasures
    *@return int número de tesoros
    */
    
    public int getTreasures(){
        return treasures;
    }
    
    
    /*
    *@brief Método que devuelve el valor del atributo levels
    *@return int número de niveles
    */
    
    public int getLevels(){
        return levels;
    }
   
    /*
    *@brief Método convierte en cadena de texto los atributos del objeto 
    *@retun String cadena con los valores de los atributos
    */
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + 
                "\nLevels = " + Integer.toString(levels);
    }    
}
