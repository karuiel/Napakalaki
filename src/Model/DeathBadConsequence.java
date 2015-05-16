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


//NOTA: si mata ¿Bc está vacío o no?
public class DeathBadConsequence extends BadConsequence{
    
  private String text;
  private boolean death;
    
    public DeathBadConsequence(String text , boolean death){
      super(text);
      this.death = death;
    } 
    
    public boolean kills(){
        return true;
    }
    
    public String toString(){
        String output;
        output = super.toString();
        output += "\n\tDeath= " + Boolean.toString(death);
        return output;
              
    }
    
    public boolean isEmpty(){
      boolean vacio = false;
      if(!death){
          vacio = true;      
      }
      return vacio;
    }
    
    public void substractHiddenTreasure(Treasure t){
    }
    
    public void substractVisibleTreasure(Treasure t){ 
    }
    
    public DeathBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        DeathBadConsequence bad;
        bad = new DeathBadConsequence(text,death); 
        return bad;
    }
}
