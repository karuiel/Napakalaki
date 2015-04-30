/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Miguel Morales Castilla y María del Mar Ruiz Martín
 */
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getBasicBalue(){
        return this.gainedLevels;
    }
    
    //Hay que cambiarlo
    public int getSpecialValue(){
        System.out.println("Hay que arreglar el método getSpecialValue");
        return this.gainedLevels;
    }
}
