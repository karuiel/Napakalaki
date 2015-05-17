/*
 * Clase que representa el mal rollo
 * Invariante de representación:
 *  -El atributo levels debe ser un entero no negativo
 *  -El atributo nVisibleTreasures debe ser un entero no negativo
 *  -El atributo nHiddenTreasures debe ser un entero no negativo
 */
package Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public abstract class BadConsequence {
    
  private String text; 
  
  //-------------------------------------Constructors----------------------------------------------
  
  
  /*
   *@brief Constructor con parámetros
   *@param String text: cadena de texto
   *@param int levels: número de niveles a perder
   *@param int nVisible: número de tesoros visibles a perder
   *@param int nHidden: número de tesoros ocultos a perder
   */
  public BadConsequence(String text){
      this.text = text;     
  }
  
  //--------------------------------------Getters-----------------------------------------------
  
  /*
   * @brief Metodo que devuelve el atributo texto
   * @return String: cadena de texto 
   */ 
  public String getText(){
      return text;
  }
  
   /*
   * @brief Metodo que devuelve el atributo levels
   * @return int: número de niveles a perder 
   */ 
  public int getLevel(){
      return 0;
  }
  
  //-----------------------------------Other methods---------------------------------------
  
  /*
   * @brief Método para convertir en cadena de texto los atributos del objeto
   * @return String: cadena de texto con el valor de los atributos
   */ 
  public String toString(){
      String output;
      output = "\nEsto es un mal rollo con el siguiente contenido:\n";
      output +="Text = " + text;
                
      return output;
  }
  
  
  /*
   * @brief Método abstracto para comprobar si el mal rollo está vacío
   * @return boolean: true en caso de que esté vacío
   *                  false en caso contrario
   */
  public abstract boolean isEmpty();
  
  
  /*
   * @brief Método para determinar si el mal rollo implica la muerte
   * @return boolean: truen en caso de que implique la muerte
                      false en caso contrario
  */
  public abstract boolean kills();

  /*
   * @brief Método para eliminar un tesoro t de la lista de tesoros
   *        visibles, ya sea específico o un número determinado
   * @param Treasure t: tesoro entregado para cumplir el mal rollo
  */
  public void substractVisibleTreasure(Treasure t){}
  /*
   * @brief Método para eliminar un tesoro t de la lista de tesoros
   *        ocultos, ya sea específico o un número determinado
   * @param Treasure t: tesoro entregado para cumplir el mal rollo
  */
  public void substractHiddenTreasure(Treasure t){}
  
  
  /*
   * @brief Método para crear un mal rollo de forma que el jugador lo pueda cumplir
   * @param ArrayList<Treasure> v: lista de tesoros visibles que posee el jugador
   * @param ArrayList<Treasure> h: lista de tesoros ocultos que posee el jugador
   * @return BadConsequence: mal rollo creado
  */
  public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
  
}