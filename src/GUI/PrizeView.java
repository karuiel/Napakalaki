/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Model.Prize;

/**
 *
 * @author Miguel Morales Castillo y María del Mar Ruiz Martín
 */
public class PrizeView extends javax.swing.JPanel {

    private Prize prizeModel;
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }
    public void setPrize(Prize p){
        prizeModel = p;
        treasures.setText(Integer.toString(prizeModel.getTreasures()));
        levels.setText(Integer.toString(prizeModel.getLevels()));
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treauresD = new javax.swing.JLabel();
        levelsD = new javax.swing.JLabel();
        treasures = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();

        treauresD.setText("Treasures");

        levelsD.setText("Levels");

        treasures.setText("jLabel3");

        levels.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treauresD)
                    .addComponent(levelsD))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levels)
                    .addComponent(treasures))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treauresD)
                    .addComponent(treasures))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelsD)
                    .addComponent(levels))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levels;
    private javax.swing.JLabel levelsD;
    private javax.swing.JLabel treasures;
    private javax.swing.JLabel treauresD;
    // End of variables declaration//GEN-END:variables
}