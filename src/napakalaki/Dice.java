/*
 * Clase que representa un dado
 * Invariante de representación:
 *  -Tan solo puede haber una instancia de la clase
 */
package napakalaki;
import java.util.Random;

/**
 *
 * @authorMiguel Morales Castillo y María del Mar Ruiz Martín
 */

public class Dice {

    private static final Dice instance = new Dice();
    
//---------------------------------Constructor----------------------------------    
    
    /*
     * @brief Constructor de la clase
    */
    private Dice(){
        
    }

//---------------------------------Getter---------------------------------------   
    /*
     * @brief Método para obtener la instancia de la clase
    */
    public static Dice getInstance(){
        return instance;
    }

//-------------------------------Other methods----------------------------------    
    
    /*
     * @brief Método para obtener un número
     * @return int: número obtenido
    */
    public int nextNumber(){
        Random rand = new Random();
        int number = rand.nextInt(5) + 1;
        return number;
    }
}
