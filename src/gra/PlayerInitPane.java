
package gra;

import javax.swing.*;

/**
 *
 * @author Komputer Domowy
 */
public class PlayerInitPane extends javax.swing.JPanel {
    
    private static int paneCounter = 0;
    private int whichPane;
    private boolean ifUser;
    
    /**
     * Creates new form PlayerInitPane
     */
    public PlayerInitPane(boolean forUser) {
	whichPane = paneCounter++;
	initComponents();
	myOptions(forUser);
    }

    /**
     * 
     * @param forUser - jeśli tak to znaczy, że trzeba napisać w polu 
     */
    public void myOptions(boolean forUser){
	ifUser = forUser;
	tfPlayerName.setText(getDefaultName());
	setComponents();
    }
    
    public String getDefaultName(){
	return (ifUser ? "Gracz" : "Bot") + (whichPane + 1);
    }
    
    public JComboBox getCBCounterColor(){
	return cbCounterColor;
    }
    
    public boolean getIfUser(){
	return ifUser;
    }
    
    public int getWhichPane(){
	return whichPane;
    }
    
    public String getPlayerName(){
	return tfPlayerName.getText().isEmpty() ? getDefaultName() : tfPlayerName.getText();
    }
    
    protected void setComponents(){
	tfPlayerName.setEnabled(ifUser);
	cbCounterColor.setEnabled(ifUser);
    }
    
    protected void changePanel(){
	myOptions(!ifUser);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lPlayerName = new javax.swing.JLabel();
        tfPlayerName = new javax.swing.JTextField();
        cbCounterColor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        lPlayerName.setText("Nazwa gracza:");

        tfPlayerName.setColumns(17);

        cbCounterColor.setModel(new javax.swing.DefaultComboBoxModel<>(InitValue.getKeysVector()));
        cbCounterColor.setSelectedIndex(0);

        jLabel1.setText("Kolor pionków");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPlayerName)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCounterColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPlayerName)
                    .addComponent(tfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCounterColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCounterColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lPlayerName;
    private javax.swing.JTextField tfPlayerName;
    // End of variables declaration//GEN-END:variables
}
