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
/*
En los constructores he cambiado los parámetros también, pero hay que inicializar todas las variables, 
no solo las que se pasan como parámetro, que lastra dijo en clase el viernes que si hay cosas en 
estado no válido quita puntos. Para el método toString pongo el mío comentado al final de la clase para
que le heches un ojo y ya cuando eso lo vemos.

He puesto lo que getters y constructors porque queda to fucker jajajaj
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
      String part1,part2,part3;
      Iterator<TreasureKind> vTreasuresIterator= specificVisibleTreasures.iterator();
      Iterator<TreasureKind> hTreasuresIterator= specificHiddenTreasures.iterator();
      part1="Text= "+ text + "Levels= "+ Integer.toString(levels)+
              "Visible treasures= " + Integer.toString(nVisibleTreasures)+
              "Invisible treasures= "+ Integer.toString(nHiddenTreasures)+
              "Death= "+ Boolean.toString(death) + "Specific visible treasures=";
              part2= " ";
               while(vTreasuresIterator.hasNext()){
                 TreasureKind vElemento = vTreasuresIterator.next();
                 part2+=vElemento.toString()+" ";
              }
              part1 = part1+part2+"Specific hidden treasures =";
              part3= " ";
              while(hTreasuresIterator.hasNext()){
                  TreasureKind hElemento= hTreasuresIterator.next();
                  part3+=hElemento.toString() + " ";
              }
              return part1+part3;
  }
  /*    public String toString(){
        
        String output;
        
        output = "Text = " + text + 
                "\nLevels = " + Integer.toString(levels) +
                "\nnVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
                "\nnHiddenTreasures = " + Integer.toString(nHiddenTreasures) +
                "\nDeath = " + Boolean.toString(death) +
                "\n SpecificHiddenTreasures = ";
        
        for(int i = 0; i < specificHiddenTreasures.size(); ++i){
            output += specificHiddenTreasures.get(i) + "\n";
        }
  
        //Caso en que specificHiddenTreasures está vacío
        if(specificHiddenTreasures.size() == 0){
            output += "nil\n";
        }
  
  
        output += "SpecificVisibleTreasures = ";
  
        for(int i = 0; i < specificVisibleTreasures.size(); ++i){
            output += specificVisibleTreasures.get(i) + "\n";
        }
  
        //Caso en que sprcificVisibleTreasures está vacío
        if(specificVisibleTreasures.size() == 0){
            output += "nil\n";
        }
  
        return output;
    }*/
}
