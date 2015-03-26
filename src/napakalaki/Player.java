/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author maria
 */
public class Player {
    private boolean dead = true;
    private String name;
    private int level;
    private int MAXHIDDENTREASURES = 4;
    private Treasure hiddenTreasures;
    private Treasure visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    private void bringToLive(){}
    private void incrementLevels(int l){
        this.level += l;}
    private void decrementLevels(int l){
        this.level -= l;
    }
    private void setPendingBadConsequence(BadConsequence b){}
    private void die(){}
    private void discardNecklaceIfVisible(){}
    private void dieIfNoTreasures(){}
   /* private boolean canIBuyLevlels(int I){}
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){}
    public void applyPrize(Prize p){}
    public CombatResult combat(Monster m){}
    public void applyBadConsequence(BadConsequence bad){}
    public boolean makeTreasureVisible(Treasure t){}
    public boolean canMakeTreasurevisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}*/
    public int getCombatLevel(){
        return this.level;
    }/*
    public boolean validState(){}
    public boolean initTreasures(){}
    public boolean isDead(){}
    public boolean hasVisibleTreasures(){}*/
    public Player(String name){
        this.name = name;
    }
   // public ArrayList<Treasure> getVisibleTreasures(){}
   // public ArrayList<Treasure> getHiddenTreasures(){}
}
