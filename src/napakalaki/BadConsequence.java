/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author miguemc
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
  
  public BadConsequence(String text, int levels, int nVisible, int nHidden){
      this.text = text;
      this.levels = levels;
      this.nVisibleTreasures = nVisible;
      this.nHiddenTreasures = nHidden;
      this.death = false;
      this.specificHiddenTreasures = new ArrayList<>();
      this.specificVisibleTreasures = new ArrayList<>();
      
  }
  
  public BadConsequence(String text, boolean death){
      this.text = text;
      this.death = death;
      this.levels = 0;
      this.nHiddenTreasures = 0;
      this.nVisibleTreasures = 0;
      this.specificHiddenTreasures = new ArrayList<>();
      this.specificVisibleTreasures = new ArrayList<>();
  }
  
  public BadConsequence(String text, int levels,
                        ArrayList<TreasureKind> tVisible, 
                        ArrayList<TreasureKind> tHidden){
      this.text = text;
      this.levels = levels;
      this.nVisibleTreasures = tVisible.size();
      this.nHiddenTreasures = tHidden.size();
      this.specificHiddenTreasures = tHidden;
      this.specificVisibleTreasures = tVisible;
      this.death = false;
      
  }
  
  //--------------------------------------Getters-----------------------------------------------
  
  public String getText(){
      return text;
  }
  
  public int getLevel(){
      return levels;
  }
  
  public int getNVisibleTreasures(){
      return nVisibleTreasures;
  }
  
  public int getNHiddenTreasures(){
      return nHiddenTreasures;
  }
  
  public boolean getDeath(){
      return death;
  }
  
  public String toString(){
      String output;
      
      output ="Text = " + text + 
              "\nLevels = "+ Integer.toString(levels) +
              "\nVisible treasures = " + Integer.toString(nVisibleTreasures)+
              "\nHidden treasures = " + Integer.toString(nHiddenTreasures)+
              "\nDeath= " + Boolean.toString(death) +
              "\nSpecific visible treasures = ";
              
      for(TreasureKind vElement : specificVisibleTreasures){
          output += vElement.toString() + " ";
      }
      
      //Caso en que specificVisibleTreasures está vacío
      if(specificVisibleTreasures.isEmpty()){
            output += "nil\n";
      }
      
      output += "Specific hidden treasures = ";
              
      for(TreasureKind hElement : specificHiddenTreasures){
         output += hElement.toString() + " ";
      }
      
      //Caso en que specificHiddenTreasures está vacío
      if(specificHiddenTreasures.isEmpty()){
         output += "nil\n";
      }  
      
      return output;
  }
}
