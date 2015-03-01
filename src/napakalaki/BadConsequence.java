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
  public BadConsequence(String newText, int newLevels, int nVisible, int nHidden){
      text=newText;
      levels=newLevels;
      nVisibleTreasures=nVisible;
      nHiddenTreasures=nHidden;
      
  }
  public BadConsequence(String newText, boolean newDeath){
      text=newText;
      death=newDeath;
  }
  public BadConsequence(String newText, int newLevels,
            ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
      text = newText;
      levels=newLevels;
      nVisibleTreasures = tVisible.size();
      nHiddenTreasures = tHidden.size();
      specificHiddenTreasures=tHidden;
      specificVisibleTreasures=tVisible;
      
  }
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
}
