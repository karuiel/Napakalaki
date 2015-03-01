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

/*He cambiado el nombre de los parámetros para que sea como se dice en el guión,
 y comprobado que sean válidos los valores.
En el toString se va a imprimir seguido sin ningún espacio levels, tendríamos que poner
alguna como o un retorno de carro o lo que sea que te guste y hacelo igual para 
todos los métodos toString.
*/

public class Prize {
    
    private int treasures;
    private int levels;
    
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
        return "Treasures= " + Integer.toString(treasures)+"levels= "+ 
                Integer.toString(levels);
    }    
}
