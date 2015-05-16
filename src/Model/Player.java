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
    
    //Nota: cambiar el constructor
    public Player(String name){

        this.name = name;
        this.level = 1;
        this.dead = false;
        this.hiddenTreasures = new ArrayList<>();
        this.visibleTreasures = new ArrayList<>();
        //this.pendingBadConsequence = new BadConsequence("vacio",false);
        //initTreasures();

    }
    
    /*
     * @brief Constuctor de copia
     * @param Player player: jugador a copiar   
    */
    public Player(Player player){
        this.name = player.name;
        this.level = player.level;
        this.dead = player.dead;        
        this.hiddenTreasures = player.hiddenTreasures; 
        this.visibleTreasures = player.visibleTreasures;
        this.pendingBadConsequence = player.pendingBadConsequence;
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
    
    /*
     * @brief Consultor del atributo name
     * @return String: name
    */
    public String getName(){
        return this.name;
    }
    
    /*
     * @brief Consultor visibleTreasures
     * @return ArrayList<Treasures>: visibleTreasures
    */
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    
    /*
     * @brief Consultor hiddenTreasures
     * @return ArrayList<Treasures>: hiddenTreasures
    */
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getLevel();
    }
    
//---------------------------------Other methods--------------------------------
    
 
    /*
     * @brief Método que determina si el jugador se convierte a sectario
     * @return boolean: true en caso en que deba convertirse
                        false en caso contrario
    */
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        
        if(number==6){
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * @brief Método encargado de revivir al jugador
    */
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
            die();
        }
    }
    
    /*
     * @brief Método para determinar si se pueden comprar una cantidad de niveles
     * @param int l: número de niveles a comprar
     * @return boolean: true en caso de que el incremento no suponga ganar la partida
     *                  false en caso contrario
    */
    private boolean canIBuyLevels(int l){
        return (10 > (level + l));
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

    /*
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
    
    /*
     * @brief Método encargafdo de determinar si un tesoro que está 
              oculto puede pasar a estar visible
     * @return boolean: true en caso en que se pueda pasar a visible
     *                  false en caso contrario
    */
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
                if( ((onehand < 2) && (type == TreasureKind.ONEHAND)) ||
                         ((onehand == 0) && (TreasureKind.BOTHHANDS == type))){
                    canMake = true;
                }
            }
        }
        else{
            canMake = (contains(visibleTreasures,type) == 0);
        }
        return canMake;
    }

    
    /*
     * @brief Método encargado de recibir un premio
     * @param Prize p: premio a recibir
    */
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
    
    /*
     * @brief Método encargado de combatir contra un monstruo
     * @param Monster m: monstruo contra el que combatir
     * @return CombatResult: resultado del combate
    */
    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel();
        int levelMonster = this.getOponentLevel(m);
        CombatResult result;
        
        /*
        Algoritmo:
            Se calcula el nivel del jugador con sus tesoros visibles
            Si el nivel del jugador es mayor que el del monstruo se aplica el premio
                Si con el premio llega al nivel 10 ha ganado la partida
                Si no tan solo ha ganado el combate
            Si el nivel es menor o igual que el del monstruo se tira el dado
                Si se obtiene un número mayor que 4 se escapa
                En caso contrario:
                    Si el mal rollo implica muerte el jugador pierde y muere
                    Si no tan solo pierde y se aplica el mal rollo
                
        */
        
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
                    boolean convert = this.shouldConvert();
                    if(convert){
                        result = CombatResult.LOSEANDCONVERT;
                    }
                    else{
                        result = CombatResult.LOSE;
                    }
                }
            }
            else{
                result = CombatResult.LOSEANDESCAPE;
            }
            
        }
        discardNecklaceIfVisible();
        return result;
    }
    
    
    /*
     * @brief Método encargado de aplicar un mal rollo
     * @param BadConsequence bad: mal rollo recibido
    */
    public void applyBadConsequence(BadConsequence bad){
        int nLevels = bad.getLevel();
        decrementLevels(nLevels);
        BadConsequence pendingBad =bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    
    /*
     * @brief Método encargado de decidir si un tesoro oculto puede pasar a visible
     * @param Treasure t: tesoro a hacer visible
     * @return boolean: true en caso en que se pueda hacer visible
                        false en caso contrario
    */
    public boolean makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
            return true;
        }
        else{       
            return false;
        }
    }
    
    /*
     * @brief Método para descartarse de un tesoro visible
     * @param Treasure t: tesoro a descartar
    */
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if( (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    /*
     * @brief Método para descartarse de un tesoro oculto
     * @param Treasure t: tesoro a descartar
    */
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if( (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    
    
    /*
     * @brief Método encargado de gestionar la compra de niveles
     * @param ArrayList<Treasure> visible: lista de tesoros visibles a vender
     * @param ArrayList<Treasure> hidden: lista de tesoros ocultos a vender
     * @return boolean: true en caso de que se realice la compra
     *                  false en caso contrario
    */
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
    
    /*
     * @brief Método encargado inicializar los tesoros ocultos 
     * @return boolean: true en caso de éxito
     *                  false en caso contrario
    */
    public boolean initTreasures(){
        bringToLife();
        Treasure treasure;
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        
        /*
         Si se obtiene un 1 se adquiere un tesoro
         Si se obtiene un 6 se adquieren 3
         En caso contrario se adquieren 2
        */
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
    
    
    /*
     * @brief Método encargado de gestionar la muerte del jugador
    */
    private void die(){
        this.dead=true;
        CardDealer dealer = CardDealer.getInstance();
        
        //Bucle de borrado de los tesoros visibles
        for(Treasure v: visibleTreasures){
            dealer.giveTreasureBack(v);
        }
        visibleTreasures.clear();
        
        //Bucle de borrado de los tesoros invisibles
        for(Treasure v: hiddenTreasures){
            dealer.giveTreasureBack(v);
        }
        hiddenTreasures.clear();
    }
    
    /*
     * @brief Método encargado de descartar el collar si está visible
    */
    private void discardNecklaceIfVisible(){
        CardDealer dealer = CardDealer.getInstance();
        boolean found = false;
        
        //Bucle de búsqueda del collar
        for(int i = 0; i < visibleTreasures.size() && !found; ++i){
            Treasure actual = visibleTreasures.get(i);
            if(actual.getType()==TreasureKind.NECKLACE){
                dealer.giveTreasureBack(actual);
                visibleTreasures.remove(i);
            }
        }        
    } 

    /*
     * @brief Método encargado de calcular los niveles que proporcionan una lista 
               de tesoros
     * @param ArrayList<Treasure> t: tesoros 
     * @return float: niveles que se pueden comprar
    */
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        int coins = 0;
        float levels;
        for(Treasure treasure: t){
            coins += treasure.getGoldCoins();
        }
        levels = coins / 1000;
        return levels;
    }
    
    /*
     * @brief Método encargado de convertir en String un objeto Player
     * @return String: cadena de texto obtenida
    */
    public String toString(){
        String output =" " + name + 
              "\tNivel = "+ Integer.toString(level)+
              "\tNivel de Combate = "+ Integer.toString(this.getCombatLevel())+
              "\n\tMuerto = " + dead + 
              "\n\tTesoros visibles = " + this.visibleTreasures.toString() +
              "\n\tTesoros ocultos = " + this.hiddenTreasures.toString() + 
              "\n\tPendingBadConsequence = " + this.pendingBadConsequence.toString();
        return output;
    }
    
}    
