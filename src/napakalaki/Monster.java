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
    
    public Monster(String newName, int newLevel,
            BadConsequence newBc,Prize newPrice){
        name = newName;
        combatLevel=newLevel;
        bc=newBc;
        price=newPrice;
    }
    
    public String getName(){
        return name;
        
    }    
    public int getCombatLevel(){
        return combatLevel;
        
    }
    public String toString(){
        return "Name = " + name + "Combat level= " + 
                Integer.toString(combatLevel) + "Prize=("+ price.toString()+" ) " +
                "Bad consequence= ( " + bc.toString()+ " ) ";
    }
    
}
