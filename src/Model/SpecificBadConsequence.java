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
public class SpecificBadConsequence extends BadConsequence{
    
  private String text;
  private int levels;
  private ArrayList<TreasureKind> specificHiddenTreasures;
  private ArrayList<TreasureKind> specificVisibleTreasures;
    
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
                        ArrayList<TreasureKind> tHidden){
      super(text, levels);
      this.specificHiddenTreasures = tHidden;
      this.specificVisibleTreasures = tVisible;
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
    
    
    public boolean kills(){
        return false;
    }
    
    public String toString(){
        String output;
        output = super.toString();
        
        output += "\n\tSpecific visible treasures = ";
              
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
    
    public boolean isEmpty(){
      boolean vacio = false;
      if(levels == 0 && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
          vacio = true;      
      }
      return vacio;
    }
    
    public void substractVisibleTreasure(Treasure t){
        
        boolean found = false;
        int indice=0;
        
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
        }    
      }
    }
    
    public void substractHiddenTreasure(Treasure t){
        
        boolean found = false;
        int indice=0;
        
        if(specificHiddenTreasures.size()!=0){
        for(int i = 0; i < specificHiddenTreasures.size()&& !found;++i){
                TreasureKind type = specificHiddenTreasures.get(i);
                if(type == t.getType()){
                    found = true;
                    indice = i;
                }
        }
        if(found){
            specificHiddenTreasures.remove(indice);
        }    
      }
    }
    
    
    public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
      
        SpecificBadConsequence bad; 
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
        bad  = new SpecificBadConsequence(text ,0, vT, hT);
        return bad;
    }
    
}
