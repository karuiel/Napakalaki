/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author miguemc
 */

public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    
    //--------------------------------------Constructor--------------------------------------------
    
    public Monster(String name, int level,
                    BadConsequence bc,Prize price){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.price = price;
    }
    
    //-------------------------------------Getters----------------------------------------------
    
    public String getName(){
        return name;     
    }    
    
    public int getCombatLevel(){
        return combatLevel;     
    }
    
    public BadConsequence getBadConsequence(){
        return this.bc;
    }
    
    public Prize getPrize(){
        return this.price;
    }
    
    public String toString(){
        return "Name = " + name + 
                "\nCombat level = " + Integer.toString(combatLevel) +
                "\nPrize = ("+ price.toString()+" ) " +
                "\nBad consequence = ( " + bc.toString()+ " ) ";
    }
    
}
