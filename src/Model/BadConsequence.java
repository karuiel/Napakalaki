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

public class BadConsequence {
    
  private String text;
  private int levels;
  private int nVisibleTreasures;
  private int nHiddenTreasures;
  private boolean death;
  private ArrayList<TreasureKind> specificHiddenTreasures;
  private ArrayList<TreasureKind> specificVisibleTreasures;
  
  
  //-------------------------------------Constructors----------------------------------------------
  
  
  /*
   *@brief Constructor con parámetros
   *@param String text: cadena de texto
   *@param int levels: número de niveles a perder
   *@param int nVisible: número de tesoros visibles a perder
   *@param int nHidden: número de tesoros ocultos a perder
   */
  public BadConsequence(String text, int levels, int nVisible, int nHidden){
      this.text = text;
      this.levels = levels;
      if(nVisible >= 0){
        this.nVisibleTreasures = nVisible;
      }  
      else{
      this.nVisibleTreasures = 0;
      }
      if(nHidden >= 0){
        this.nHiddenTreasures = nHidden;
      }
      else{
          this.nHiddenTreasures = 0;
      }
      this.death = false;
      this.specificHiddenTreasures = new ArrayList<>();
      this.specificVisibleTreasures = new ArrayList<>();
      
  }
  
  /*
   *@brief Constructor con parámetros
   *@param String text: cadena de texto
   *@param boolean death: muerte
   */
  public BadConsequence(String text, boolean death){
      this.text = text;
      this.death = death;
      this.levels = 0;
      this.nHiddenTreasures = 0;
      this.nVisibleTreasures = 0;
      this.specificHiddenTreasures = new ArrayList<>();
      this.specificVisibleTreasures = new ArrayList<>();
  }
  
  /*
   * @brief Constructor con parámetros
   * @param String text: cadena de texto
   * @param int levels: número de niveles a perder
   * @paramArrayList<TreasureKind>tVisible: array con los tesoros visibles
   * @param ArrayList<TrasureKind> tHidden: array con los tesoros ocultos
   */
  public BadConsequence(String text, int levels,
                        ArrayList<TreasureKind> tVisible, 
                        ArrayList<TreasureKind> tHidden){
      this.text = text;
      this.levels = levels;
      this.nVisibleTreasures = 0;
      this.nHiddenTreasures = 0;
      this.specificHiddenTreasures = tHidden;
      this.specificVisibleTreasures = tVisible;
      this.death = false;
      
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
      return levels;
  }
  
  /*
   * @brief Metodo que devuelve el atributo nVisibleTreasures
   * @return int: número de tesoros visibles a perder 
   */
  public int getNVisibleTreasures(){
      return nVisibleTreasures;
  }
  
  /*
   * @brief Metodo que devuelve el atributo nHiddenTreasures
   * @return int: número de tesoros invisibles a perder
   */  
  public int getNHiddenTreasures(){
      return nHiddenTreasures;
  }
  
  /*
   * @brief Metodo que devuelve el atributo specificHiddenTreasures 
   * @return ArrayList<TreasureKind>: Array con el tipo de tesoros invisibles 
                                      concretos que se pierden
                                      Será un array vacío en caso de que no se especifiquen      
   */ 
  public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
      return this.specificHiddenTreasures;
  }
   
  /*
   * @brief Metodo que devuelve el atributo specificHiddenTreasures 
   * @return ArrayList<TreasureKind>: Array con el tipo de tesoros visibles 
                                      concretos que se pierden
                                      Será un array vacío en caso de que no se especifiquen      
   */ 
  public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
      return this.specificVisibleTreasures;
  }
  
  
  //-----------------------------------Other methods---------------------------------------
  
  /*
   * @brief Método para convertir en cadena de texto los atributos del objeto
   * @return String: cadena de texto con el valor de los atributos
   */ 
  public String toString(){
      String output;
      
      output ="Text = " + text + 
              "\n\tLevels = "+ Integer.toString(levels) +
              "\n\tVisible treasures = " + Integer.toString(nVisibleTreasures)+
              "\n\tHidden treasures = " + Integer.toString(nHiddenTreasures)+
              "\n\tDeath= " + Boolean.toString(death) +
              "\n\tSpecific visible treasures = ";
              
      for(TreasureKind vElement : specificVisibleTreasures){
          output += vElement.toString() + " ";
      }
      
      //Caso en que specificVisibleTreasures está vacío
      if(specificVisibleTreasures.isEmpty()){
            output += "nil";
      }
      
      output += "\n\tSpecific hidden treasures = ";
              
      for(TreasureKind hElement : specificHiddenTreasures){
         output += hElement.toString() + " ";
      }
      
      //Caso en que specificHiddenTreasures está vacío
      if(specificHiddenTreasures.isEmpty()){
         output += "nil";
      }  
      
      return output;
  }
  
  
  /*
   * @brief Método para comprobar si el mal rollo está vacío
   * @return boolean: true en caso de que esté vacío
   *                  false en caso contrario
   */
  public boolean isEmpty(){
      boolean vacio = false;
      if(levels == 0  && nVisibleTreasures == 0  && nHiddenTreasures == 0 && !death
                && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
          vacio = true;      
      }
      return vacio;
  }
  
  /*
   * @brief Método para determinar si el mal rollo implica la muerte
   * @return boolean: truen en caso de que implique la muerte
                      false en caso contrario
  */
  public boolean kills(){
      return this.death;
  }

  public void substractVisibleTreasure(Treasure t){
      boolean eliminado = false;
      if(specificVisibleTreasures.size()!=0){
        for(TreasureKind tesoro: specificVisibleTreasures){
          if(!eliminado && tesoro == t.getType()){
              specificVisibleTreasures.remove(tesoro);
              eliminado = true;
          }
        }
        if(!eliminado){
           nVisibleTreasures = Math.max(0,nVisibleTreasures-1); 
        }
      }
  }
  
  public void substractHiddenTreasure(Treasure t){
      boolean eliminado = false;

      for(TreasureKind tesoro: specificHiddenTreasures){
        if(!eliminado && tesoro == t.getType()){
            specificHiddenTreasures.remove(tesoro);
            eliminado = true;
        }
      }
      if(!eliminado){
         nHiddenTreasures = Math.max(0,nHiddenTreasures-1); 
      }
  }
  
  //Nota: esto hay que arreglarlo, pero es que no me apetece nada la verdad
  //Quitar death
  public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
      BadConsequence bad;
      if(death){
         bad = new BadConsequence(text,death); 
      }
      else if(nVisibleTreasures != 0 || nHiddenTreasures != 0){
          int nV = Math.min(nVisibleTreasures,v.size());
          int nH = Math.min(nHiddenTreasures,h.size());
          bad = new BadConsequence(text, 0, nV, nH);
      }
      else{
        ArrayList<TreasureKind> vT = new ArrayList();
        ArrayList<TreasureKind> hT = new ArrayList();
        ArrayList<Treasure> vCopy = v;
        ArrayList<Treasure> hCopy = h;
        
        for(TreasureKind t1: specificVisibleTreasures){
            boolean found = false;
            for(Treasure t2: vCopy){
                TreasureKind type = t2.getType();
                if(type == t1 && !found){
                    vT.add(t1);
                    vCopy.remove(t2);
                    found = true;
                }
            }
        }
       
        for(TreasureKind t1: specificHiddenTreasures){            
            boolean found = false;
            for(Treasure t2: hCopy){
                TreasureKind type = t2.getType();
                if(type == t1 && !found){
                    hT.add(t1);
                    hCopy.remove(t2);
                    found = true;
                }
            }
        }
        bad  = new BadConsequence(text ,0, vT, hT);
      }
      return bad;
  }
}
