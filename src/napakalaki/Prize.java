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

public class Prize {
    
    private int treasures;
    private int levels;
    
    //--------------------------------------Constructor--------------------------------------------
    
    public Prize(int treasures, int levels){
        if(treasures > 0){
            this.treasures = treasures;
        }
        else{
            this.treasures = 0;
        }
        
        if(levels > 0){
            this.levels= levels;
        }
        else{
            this.levels = 0;
        }
    }
    
    //--------------------------------------Getters-----------------------------------------------
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + 
                "\nLevels = " + Integer.toString(levels);
    }    
}
