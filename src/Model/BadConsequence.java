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
  public BadConsequence(String text, int levels){
      this.text = text;
      this.levels = levels;     
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
      output = "\nEsto es un mal rollo con el siguiente contenido:\n";
      
      /*output +="Text = " + text + 
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
      }  */
      
      return output;
  }
  
  
  /*
   * @brief Método para comprobar si el mal rollo está vacío
   * @return boolean: true en caso de que esté vacío
   *                  false en caso contrario
   */
  public abstract boolean isEmpty();
      /*boolean vacio = false;
      if(levels == 0  && nVisibleTreasures == 0  && nHiddenTreasures == 0 && !death
                && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
          vacio = true;      
      }
      return vacio;*/
  
  
  /*
   * @brief Método para determinar si el mal rollo implica la muerte
   * @return boolean: truen en caso de que implique la muerte
                      false en caso contrario
  */
  public abstract boolean kills();
      //return this.death;

  /*
   * @brief Método para eliminar un tesoro t de la lista de tesoros
   *        visibles, ya sea específico o un número determinado
   * @param Treasure t: tesoro entregado para cumplir el mal rollo
  */
  public void substractVisibleTreasure(Treasure t){
      boolean eliminado = false;
      boolean found = false;
      int indice=0;
      
      /*
       Algoritmo: 
            Si el mal rollo tiene tesoros específicos visibles:
                Se busca un tesoros del mismo tipo que t y se elimina del mal rollo
            Si no, se disminuye en uno el número de tesoros que implica    
      */
     /* 
      if(specificVisibleTreasures.size()!=0){
        for(int i = 0; i < specificVisibleTreasures.size()&& !found;++i){
                TreasureKind type = specificVisibleTreasures.get(i);
                if(type == t.getType()){
                    found = true;
                    indice = i;
                }
        }
        if(found){
            specificVisibleTreasures.remove(indice);
            eliminado = true;
        }    
      } 
       if(!eliminado){
           nVisibleTreasures = Math.max(0,nVisibleTreasures-1); 
       }*/
  }
  /*
   * @brief Método para eliminar un tesoro t de la lista de tesoros
   *        ocultos, ya sea específico o un número determinado
   * @param Treasure t: tesoro entregado para cumplir el mal rollo
  */
  public void substractHiddenTreasure(Treasure t){
      boolean eliminado = false;
      boolean found = false;
      int indice = 0;
      
      /*
       Algoritmo: 
            Si el mal rollo tiene tesoros específicos ocultos:
                Se busca un tesoros del mismo tipo que t y se elimina del mal rollo
            Si no, se disminuye en uno el número de tesoros que implica    
      */
     /*if(specificHiddenTreasures.size()!=0){
        for(int i = 0; i < specificHiddenTreasures.size()&& !found;++i){
            TreasureKind type = specificHiddenTreasures.get(i);
            if(type == t.getType()){
                found = true;
                indice = i;
            }
        }
        if(found){
            specificHiddenTreasures.remove(indice);
            eliminado = true;
        }    
      }  
      if(!eliminado){
        nHiddenTreasures = Math.max(0,nHiddenTreasures-1); 
      }  */
  }
  
  
  /*
   * @brief Método para crear un mal rollo de forma que el jugador lo pueda cumplir
   * @param ArrayList<Treasure> v: lista de tesoros visibles que posee el jugador
   * @param ArrayList<Treasure> h: lista de tesoros ocultos que posee el jugador
   * @return BadConsequence: mal rollo creado
  */
  public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
      BadConsequence bad;

      /*
      Algoritmo:
        Si el mal rollo presente implica muerte se crea un nuevo mal rollo que la implique
      
        Si implica pérdida de un número determinado de tesoros se crea un nuevo mal rollo 
        con el mínimo entre lo que implica el mal rollo y los tesoros que tiene el jugador,
        tanto ocultos como visibles.
      
        Si implica pérdida de tesoros específicos:
            *Se crean nuevos vectores con los tesoros del jugador
            *Para cada elemento del mal rollo se busca si existe uno de igual tipo en la 
            copia creada (cada uno en la correspondiente)
                Si hay coincidencia: 
                    Se añade al vector en el cual se almacena el nuevo mal rollo
                    Se elimina dicha coincidencia del vector copia de los tesoros
                Si no hay coincidencia:
                    No pertenecerá al ajuste del mal rollo
            *Se crea un mal rollo con los tipos específicos de tesoros seleccionados        
      */
      
      /*if(death){
         bad = new BadConsequence(text,death); 
      }
      else if(nVisibleTreasures != 0 || nHiddenTreasures != 0){
          int nV = Math.min(nVisibleTreasures,v.size());
          int nH = Math.min(nHiddenTreasures,h.size());
          bad = new BadConsequence(text, 0, nV, nH);
      }
      else{
        ArrayList<TreasureKind> vT = new ArrayList<>();
        ArrayList<TreasureKind> hT = new ArrayList<>();
        ArrayList<Treasure> vCopy = new ArrayList<>();//Copia de los tesoros visibles
        ArrayList<Treasure> hCopy = new ArrayList<>();//Copia de los tesoros ocultos
        
        //Bucles de copia
        for(Treasure t: v){
            vCopy.add(t);
        }
        for(Treasure t: h){
            hCopy.add(t);
        }
        
        //Ajuste de los tesoros visibles
        for(TreasureKind t1: specificVisibleTreasures){
            boolean found = false;
            //Búsqueda de t1 entre los tesoros del jugador
            for(int i = 0; i < vCopy.size()&& !found;++i){
                TreasureKind type = vCopy.get(i).getType();
                if(type == t1){
                    found = true;
                    vT.add(t1);
                    vCopy.remove(i);
                }
            }
        }
       
        //Ajuste de los tesoros ocultos
        for(TreasureKind t1: specificHiddenTreasures){            
            boolean found = false;
            //Búsqueda del tesoro t2 entre los tesoros del jugador
            for(int i = 0; i < hCopy.size()&& !found;++i){
                TreasureKind type = hCopy.get(i).getType();
                if(type == t1){
                    found = true;
                    hT.add(t1);
                    hCopy.remove(i);
                }
            }
        }
        bad  = new BadConsequence(text ,0, vT, hT);
      }
      return bad;*/
      return this;
  }
}  
