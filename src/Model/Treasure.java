/*
 * Clase que representa los tesoros
 * Invariante de representación:
 *  -El atributo goldCoins debe ser un entero no negativo
 *  -El atributo minBonus debe ser un entero no negativo
 *  -El atributo maxBonus debe ser un entero no negativo
 */
package Model;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */
public class Treasure {
    
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
 
//---------------------------------Constructor----------------------------------    
   
    /*
     * @brief constructor de la clase
     * @param String n: nombre del tesoro
     * @param int g: número de monedas de oro
     * @param int min: número mínimo de niveles
     * @param int max: número máximo de niveles
     * @param TreasureKind t: tipo de tesoro
    */
    public Treasure(String n, int g, int min, int max, TreasureKind t){
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
 
//-----------------------------------Getters------------------------------------    
    
    
    /*
     * @brief Método para obtener el nombre del tesoro
     * @param String: nombre del tesoro
    */
    public String getName(){
        return this.name;
    }
    
    /*
     * @brief Método para obtener el número de monedas de oro asociado
     * @param int: número de monedas
    */
    public int getGoldCoins(){
        return this.goldCoins;
    }
    
    /*
     * @brief Método para obtener el número mínimo de niveles
     * @param int: número mínimo de niveles
    */
    public int getMinBonus(){
        return this.minBonus;
    }
    
    /*
     * @brief Método para obtener el número máximo de niveles
     * @param int: número máximo de niveles
    */
    public int getMaxBonus(){
        return this.maxBonus;
    }
    
    /*
     * @brief Método para obtener el tipo al que pertenece el tesoro
     * @param TreasureKind: tipo del tesoro
    */
    public TreasureKind getType(){
        return this.type;
    }
    
    public String toString(){
        String output ="Nombre = " + this.name + 
              "\n\tTipo = "+ this.type +
              "\n\tValor = " +Integer.toString(goldCoins) +
              "\n\tMin Bonus" + Integer.toString(minBonus)+
              "\n\tMax Bonus= " + Integer.toString(maxBonus);
        
        return output;
            
    }
    
}
