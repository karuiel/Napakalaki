
package Model;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;

public class EjemploMain {

    public static void main(String[] args) {
      
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView= new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        
        ArrayList<String> names =  new ArrayList<>();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        
        napakalakiView.setNapakalaki(napakalakiModel);
        
        napakalakiView.showView();
      
        
      /*Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      test.play(game, 2); */
              
    }
}
