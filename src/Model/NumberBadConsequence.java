/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class NumberBadConsequence extends BadConsequence{
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    
    public NumberBadConsequence(String text, int levels, int nVisible, int nHidden){
      super(text);
      this.levels = levels;
      this.nVisibleTreasures = nVisible;
      this.nHiddenTreasures = nHidden;      
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
    
    
    public boolean kills(){
        return false;
    }
      
    public String toString(){
        
        String output;
        output = super.toString();
        output += "\n\tLevels = "+ Integer.toString(levels);
        output += "\n\tVisible treasures = " + Integer.toString(nVisibleTreasures)+
              "\n\tHidden treasures = " + Integer.toString(nHiddenTreasures);
              
        return output;
    }    
    
    public boolean isEmpty(){
      boolean vacio = false;
      if(nVisibleTreasures == 0  && nHiddenTreasures == 0){
          vacio = true;      
      }
      return vacio;
    }
    
    public void substractHiddenTreasure(Treasure t){

        nHiddenTreasures = Math.max(0,nHiddenTreasures-1);  
    }
    
    public void substractVisibleTreasure(Treasure t){

        nVisibleTreasures = Math.max(0,nVisibleTreasures-1);  
    }
    
    public NumberBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
          NumberBadConsequence bad;
     
          int nV = Math.min(nVisibleTreasures,v.size());
          int nH = Math.min(nHiddenTreasures,h.size());
          bad = new NumberBadConsequence(text, 0, nV, nH);
      
          return bad;
    }
}
