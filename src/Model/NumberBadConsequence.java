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
  private boolean death;
  private ArrayList<TreasureKind> specificHiddenTreasures;
  private ArrayList<TreasureKind> specificVisibleTreasures;
    
    
    public NumberBadConsequence(String text, int levels, int nVisible, int nHidden){
      super(text, levels);
      this.nVisibleTreasures = nVisible;
      this.nHiddenTreasures = nHidden;      
    } 
    
    public boolean kills(){
        return false;
    }
      
    public String toString(){
        
        String output;
        output = super.toString();
        output +="Text = " + text + 
              "\n\tLevels = "+ Integer.toString(levels) +
              "\n\tVisible treasures = " + Integer.toString(nVisibleTreasures)+
              "\n\tHidden treasures = " + Integer.toString(nHiddenTreasures);
              
        return output;
    }    
    
    public boolean isEmpty(){
      boolean vacio = false;
      if(levels == 0  && nVisibleTreasures == 0  && nHiddenTreasures == 0){
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
    
    public NumberBadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
          NumberBadConsequence bad;
     
          int nV = Math.min(nVisibleTreasures,v.size());
          int nH = Math.min(nHiddenTreasures,h.size());
          bad = new NumberBadConsequence(text, 0, nV, nH);
      
          return bad;
    }
}
