/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author maria
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonster;
    private ArrayList<Monster> usedMonster;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    
    private CardDealer(){}
    private void initTreasureCardDeck(){}
    private void initMonsterCardDeck(){}
    private void shuffleTreasures(){}
    private void shuffleMonsters(){}
    public static CardDealer getInstante(){
        return instance;
    }
    //public Treasure nextTreasure(){}
    //public Monster nextMonster(){}
    public void giveTreasureBack(Treasure t){}
    public void giveMonsterBack(Monster m){}
    public void initCards(){}
}
