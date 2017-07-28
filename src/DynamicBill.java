
public class DynamicBill extends javax.swing.JPanel
{    
    public DynamicBill(String name, int quantity, double price)
    {
        initComponents();
        setVisible(true);
        nameLb.setText(name);
        quantityLb.setText(quantity + "");
        priceLb.setText(price + "");
        double amount = price * quantity;
        amountLb.setText(amount + "");
        this.setSize(316, 25);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        nameLb = new javax.swing.JLabel();
        quantityLb = new javax.swing.JLabel();
        priceLb = new javax.swing.JLabel();
        amountLb = new javax.swing.JLabel();

        nameLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        nameLb.setText("jLabel6");

        quantityLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        quantityLb.setText("jLabel1");

        priceLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        priceLb.setText("jLabel2");

        amountLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        amountLb.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(quantityLb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(priceLb, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountLb, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(quantityLb)
                .addComponent(priceLb)
                .addComponent(amountLb)
                .addComponent(nameLb))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLb;
    private javax.swing.JLabel nameLb;
    private javax.swing.JLabel priceLb;
    private javax.swing.JLabel quantityLb;
    // End of variables declaration//GEN-END:variables
}
