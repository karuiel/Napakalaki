/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.Random;

/**
 *
 * @author maria
 */
public class Dice {

    private static final Dice instance = new Dice();
    private Dice(){
        
    }
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random rand = new Random();
        int number = rand.nextInt(5) + 1;
        return number;
    }
}
