/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Model.Napakalaki;
import Model.Player;
import Model.Monster;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel;
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
        
        fillPlayerPanel(playerView,napakalakiModel.getCurrentPlayer());
        fillMonsterPanel(monsterView, napakalakiModel.getCurrentMonster());
        
        //Nota: ver esto porqué
        repaint();
        revalidate();
    }
    
    public void fillPlayerPanel (JPanel aPanel, Player player) {
        // Se elimina la información antigua
        aPanel.removeAll();

        //Se construye y añade la vista del jugador
        PlayerView aPlayerView = new PlayerView();
        aPlayerView.setPlayer(player);
        aPlayerView.setVisible (true);
        aPanel.add (aPlayerView);
    
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }    

    public void fillMonsterPanel (JPanel aPanel, Monster monster) {
        // Se elimina la información antigua
        aPanel.removeAll();

        //Se construye y añade la vista del jugador
        MonsterView aMonsterView = new MonsterView();
        aMonsterView.setMonster(monster);
        aMonsterView.setVisible (true);
        aPanel.add (aMonsterView);
    
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerView = new GUI.PlayerView();
        monsterView = new GUI.MonsterView();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Meet the Monster");

        jButton2.setText("Combat");

        jButton3.setText("Next Turn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public void showView(){
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private GUI.MonsterView monsterView;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables

}