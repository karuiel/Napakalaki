/*
 * Clase que representa un jugador
 * Invariante de representación:
 *  -El atributo level debe ser un entero comprendido entre 1 y 10
 *  -El atributo hiddenTreasures debe ser tener un tamaño igual o menor a 4
 *  -El atributo visibleTreasures estará constituido por:
        uno o ningún tesoro de tipo armor 
        uno o ningún tesoro de tipo helmet
        uno o ningún tesoro de tipo shoe
        uno o ningún tesoro de tipo necklace
        uno o ningún tesoro de tipo bothhands
        uno, dos o ningún tesoro de tipo onehand en caso de no tener ninguno de tipo
            bothhands, y ninguno en caso contrario
       
 */
package Model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

public class Player {
    private boolean dead = true;
    private String name;
    private int level;
    private int MAXHIDDENTREASURES = 4;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

//---------------------------------Constructor----------------------------------

/*
 * @brief Constuctor de la clase
 * @param String name: nombre del jugador   
 */
    public Player(String name){

        this.name = name;
        this.level = 1;
        this.dead = false;
        this.hiddenTreasures = new ArrayList<>();
        this.visibleTreasures = new ArrayList<>();
        this.pendingBadConsequence = new BadConsequence("vacio",false);

    }
    
//----------------------------------Getters-------------------------------------
    
    /*
     * @brief Método para obtener el nivel de combate del jugador
     * @return int: nivel de combate
    */
    public int getCombatLevel(){
        int nivel = this.level;
        boolean collar = false;
        
        // Bucle de búsqueda del collar
        for(Treasure vElement : visibleTreasures){
            if(vElement.getType().name() == "NECKLACE" ){
                collar = true;
            }
        }
        
        // Bucle de recuento de niveles
        for(Treasure vElement : visibleTreasures){
          if(!collar){  
            nivel += vElement.getMinBonus();
          }
          else{
              nivel += vElement.getMaxBonus();
          }
      }
        return nivel;
    }
    
//---------------------------------Other methods--------------------------------
    
    //Nota: he cambiado el nombre de este método porque estaba mal
    //hay que ver si se ha utilizado en algun lado...
    private void bringToLife(){
        this.dead = false;
    }
    
    /*
     * @brief Método para subir niveles al jugador
     * @param int l: número de niveles a subir
    */
    private void incrementLevels(int l){
        this.level += l;
        if(level > 10){
            level = 10;
        }
    }
    
    /*
     * @brief Método para bajar niveles al jugador
     * @param int l: número de niveles a decrementar
    */
    private void decrementLevels(int l){
        this.level -= l;
        if(this.level < 1){
            level = 1;
        }
    }
    
    /*
     * @brief Método para asignar un mal rollo al jugador
     * @param BadConsequence b: mal rollo a asignar
     */
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    /*
     * @brief Método para cambiar el estado del jugador a muerto 
     *          en caso de que no tenga tesoros
    */
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()){
            this.dead = true;
            //NOTA:llamada al método die cuando esté implementado
        }
    }
    
    /*
     * @brief Método para determinar si se pueden comprar una cantidad de niveles
     * @param int I: número de niveles a comprar
     * @return boolean: true en caso de que el incremento no suponga ganar la partida
     *                  false en caso contrario
    */
    private boolean canIBuyLevels(int I){
        return (10 > (level + I));
    }

    
    /*
     * @brief Método para determinar si un jugador está en estado válido; es decir:
     *      no tiene más de 4 tesoros ocultos y no tiene mal rollo pendiente
     * @return boolean: true en caso de que se encuentre en estado válido
     *                  false en caso contrario
     */
    public boolean validState(){
        boolean valid = true;
        if(hiddenTreasures.size() > 4 || !pendingBadConsequence.isEmpty()){
            valid = false;
        }
        return valid;
    }

    /*
     * @brief Método para determinar si el jugador está muerto
     * @return boolean true en caso de que esté muerto
     *                 false en caso contrario
    */
    public boolean isDead(){
        return this.dead;
    }
    
    /*
     * @brief Método para determinar si un jugador tiene tesoros visibles
     * @return boolean: true en caso de tener tesoros visibles
     *                  fasle en caso contrario
    */
    public boolean hasVisibleTreasures(){
        return !visibleTreasures.isEmpty();
    }

    /**
     * @brief Método auxiliar para contar las repeticiones de un tesoro en un array
     * @param ArrayList<Treasure> treasures: array con los tesoros
     * @param TreasureKind t: tesoro a buscar
     * @return int: número de repeticiones
     */
    private int contains(ArrayList<Treasure> treasures, TreasureKind t){
        int repetitions = 0;
        for(Treasure x: treasures){
            if(x.getType() == t){
                repetitions ++;
            }
        }
        return repetitions;
    }
    
    //Nota: creo que el tio nos va a decir que nada de métodos auxiliares
    //asi que copiamos el código. Preguntar de todas formas
    public boolean canMakeTreasureVisible(Treasure t){
        TreasureKind type = t.getType();
        boolean canMake = false;
        
        /*
        Algoritmo:
            Si el tipo de tesoro es ONEHAND o BOTHHANDS
                Si hay un tesoro BOTHHANDS no se puede realizar el cambio
                Si no lo hay, se puede realizar el cambio si
                    es de tipo BOTHHANDS y no hay ninguno tipo ONEHAND o
                    es de tipo ONEHAND y hay uno o ningún tesoro tipo ONEHAND
            En caso contrario
                Se podrá realizar el cambio si no hay ninguno del mismo tipo en 
                el vector de tesoros visibles       
        */
        if(type == TreasureKind.ONEHAND || type == TreasureKind.BOTHHANDS){
            if(contains(visibleTreasures,TreasureKind.BOTHHANDS)==0){
                int onehand = contains(visibleTreasures,TreasureKind.ONEHAND);
                if( (onehand < 2) && (type == TreasureKind.ONEHAND) ||
                         (onehand == 0) && (TreasureKind.BOTHHANDS == type)){
                    canMake = true;
                }
            }
        }
        else{
            canMake = (contains(visibleTreasures,type) == 0);
        }
        return canMake;
       /* boolean canMake=true;
        int contador = 0;
        
            for(Treasure x: visibleTreasures){
                TreasureKind tipo = x.getType();
                if(t.getType()!= TreasureKind.ONEHAND){
                    if(t.getType()==x.getType()){
                      canMake=false;  
                    }
                }else{
                    if(tipo==TreasureKind.BOTHHANDS){
                        canMake=false;
                    }
                    if(tipo==TreasureKind.ONEHAND){
                        contador++;
                    }
                    if(contador==2){
                        canMake = false;
                    }                   
                }
            } */               
    }
    
   // public ArrayList<Treasure> getVisibleTreasures(){}
   // public ArrayList<Treasure> getHiddenTreasures(){}
    //Nota: implementar
    public void applyPrize(Prize p){
        int nLevels = p.getLevels();
        incrementLevels(nLevels);
        CardDealer dealer = CardDealer.getInstance();
        int nPrize = p.getTreasures();
        
        for(int i = 0; i < nPrize; ++i){
            Treasure treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel();
        int levelMonster = m.getCombatLevel();
        CombatResult result;
        
        if(myLevel > levelMonster){
            Prize prize = m.getPrize();
            applyPrize(prize);
            if(level < 10){
                result = CombatResult.WIN;
            }
            else{
                result = CombatResult.WINANDWINGAME;
            }
        }
        else{
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber();
            if(escape < 5){
                BadConsequence bad = m.getBadConsequence();
                boolean amIDead = bad.kills();
                
                if(amIDead){
                    die();
                    result = CombatResult.LOSEANDDIE;
                }
                else{
                    applyBadConsequence(bad);
                    result = CombatResult.LOSE;
                }
            }
            else{
                result = CombatResult.LOSEANDESCAPE;
            }
        }
        discardNecklaceIfVisible();
        return result;
    }
    
    public void applyBadConsequence(BadConsequence bad){
        int nLevels = bad.getLevel();
        decrementLevels(nLevels);
        BadConsequence pendingBad =bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    //Nota: preguntar
    public boolean makeTreasureVisible(Treasure t){
        visibleTreasures.add(t);
        hiddenTreasures.remove(t);
        return true;
    }
    
    
    //Nota: preguntar al profesor si esto solo borra al primer tesor que se encuentre
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    //nota: ver levels
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        float levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        boolean canI = canIBuyLevels((int)levels);
        
        if(canI){
            incrementLevels((int)levels);
            for(Treasure v: visible){
                discardVisibleTreasure(v);
            }
            for(Treasure h: hidden){
                discardHiddenTreasure(h);
            }
        }
        return canI;
    }
    
    public boolean initTreasures(){
        bringToLife();
        Treasure treasure;
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        
        if(number == 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        else if(number < 6){
            for(int i = 0; i < 2; ++i){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }    
        else if(number == 6){
            for(int i = 0; i < 3; ++i){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }            
        }    
        return true;
    }
    
    private void die(){
        CardDealer dealer = CardDealer.getInstance();
        for(Treasure v: visibleTreasures){
            dealer.giveTreasureBack(v);
        }
        visibleTreasures.clear();
        
        for(Treasure v: hiddenTreasures){
            dealer.giveTreasureBack(v);
        }
        hiddenTreasures.clear();
    }
    
    private void discardNecklaceIfVisible(){
        CardDealer dealer = CardDealer.getInstance();
        for(Treasure x: visibleTreasures){
            if(x.getType()==TreasureKind.NECKLACE){
                dealer.giveTreasureBack(x);                
                visibleTreasures.remove(x);
            }
        }
        
    }      

    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        int coins = 0;
        float levels;
        for(Treasure treasure: t){
            coins += treasure.getGoldCoins();
        }
        levels = coins / 1000;
        return levels;
    }
}    
