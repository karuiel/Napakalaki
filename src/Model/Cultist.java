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
public class Cultist implements Card{
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getBasicBalue(){
        return this.gainedLevels;
    }
    
    public int getSpecialValue(){
        return this.gainedLevels * CultistPlayer.getTotalCultistPlayer();
    }
    
    public String toString(){
        String output;
        output = "Nombre: " + name + "\t\tGainedLevels = " + gainedLevels;
        return output;
    }
}
