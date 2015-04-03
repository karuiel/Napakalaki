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
package napakalaki;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */

//NOTA:metodo bring to live??
//incrementLevels--> ¿Que pasa si el jugador ya consigue el nivel 10?
//Constructor--> que asignar en pendingBadConsequence
//dieifnotreasures--> ¿Solo modifica del atributo death o se encarga de matar al jugador?
public class Player {
    private boolean dead = true;
    private String name;
    private int level;
    private int MAXHIDDENTREASURES = 4;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;

//-------------------------------------Constructor--------------------------------------------

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
        //this.pendingBadConsequence = new BadConsequence();
    }
    
//---------------------------------------Getters---------------------------------------------
    
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
    
//--------------------------------------Other methods-----------------------------------------
    
    private void bringToLive(){
        this.dead = false;
    }
    
    /*
     * @brief Método para subir niveles al jugador
     * @param int l: número de niveles a subir
    */
    private void incrementLevels(int l){
        this.level += l;
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
     * @return boolean: true en caso de que dicho incremento no suponga ganar la partida
     *                  false en caso contrario
    */
    private boolean canIBuyLevlels(int I){
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

    
   // public ArrayList<Treasure> getVisibleTreasures(){}
   // public ArrayList<Treasure> getHiddenTreasures(){}
   /* public void applyPrize(Prize p){}
    public CombatResult combat(Monster m){}
    public void applyBadConsequence(BadConsequence bad){}
    public boolean makeTreasureVisible(Treasure t){}
    public boolean canMakeTreasurevisible(Treasure t){}
    public void discardVisibleTreasure(Treasure t){}
    public void discardHiddenTreasure(Treasure t){}
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){}*/
    //public boolean initTreasures(){}
    private void die(){}
    private void discardNecklaceIfVisible(){}      
    //NOTA: en el diagrama de clase viene implementado como float; no le veo sentido
   /* protected int computeGoldCoinsValue(ArrayList<Treasure> t){
        int coins = 0;
        for(Treasure treasure: t){
            coins += treasure.getGoldCoins();
        }
        return coins;
    }*/
}    
