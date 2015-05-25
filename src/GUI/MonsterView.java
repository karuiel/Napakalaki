/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Model.*;
import javax.swing.JPanel;
import java.util.ArrayList;
/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */
public class MonsterView extends javax.swing.JPanel {

    private Monster monsterModel; 
    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }
    
    public void setMonster(Monster m){
        monsterModel = m;
        name.setText(monsterModel.getName());
        level.setText(Integer.toString(monsterModel.getBasicBalue()));
        fillPrizePanel(prizeView1,monsterModel.getPrize());
                
    }
    public void fillPrizePanel(JPanel aPanel,Prize p ){
        aPanel.removeAll();
        PrizeView aPrizeView = new PrizeView();
        aPrizeView.setPrize(p);
        aPrizeView.setVisible(true);
        aPanel.add(aPrizeView);
        aPanel.repaint();
        aPanel.revalidate();
    }
    public void fillBadConsequencePanel(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prizeView1 = new GUI.PrizeView();
        badConsequenceView1 = new GUI.BadConsequenceView();
        nameD = new javax.swing.JLabel();
        textD = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        levelD = new javax.swing.JLabel();
        level = new javax.swing.JLabel();

        javax.swing.GroupLayout prizeView1Layout = new javax.swing.GroupLayout(prizeView1);
        prizeView1.setLayout(prizeView1Layout);
        prizeView1Layout.setHorizontalGroup(
            prizeView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        prizeView1Layout.setVerticalGroup(
            prizeView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout badConsequenceView1Layout = new javax.swing.GroupLayout(badConsequenceView1);
        badConsequenceView1.setLayout(badConsequenceView1Layout);
        badConsequenceView1Layout.setHorizontalGroup(
            badConsequenceView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        badConsequenceView1Layout.setVerticalGroup(
            badConsequenceView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        nameD.setText("Name");

        textD.setText("Text");

        name.setText("jLabel3");

        text.setText("jLabel4");

        levelD.setText("Level");

        level.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameD)
                        .addGap(18, 18, 18)
                        .addComponent(name))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textD)
                            .addComponent(levelD))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level)
                            .addComponent(text))))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prizeView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(badConsequenceView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameD)
                            .addComponent(name))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textD)
                            .addComponent(text))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(level)
                            .addComponent(levelD)))
                    .addComponent(badConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(prizeView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView badConsequenceView1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel levelD;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameD;
    private GUI.PrizeView prizeView1;
    private javax.swing.JLabel text;
    private javax.swing.JLabel textD;
    // End of variables declaration//GEN-END:variables
}
