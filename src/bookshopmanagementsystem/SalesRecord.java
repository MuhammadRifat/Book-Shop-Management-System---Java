
package bookshopmanagementsystem;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SalesRecord extends javax.swing.JFrame {

   
    public SalesRecord() throws SQLException {
        initComponents();
        salesTable.getTableHeader().setFont(new Font("Times new roman", Font.BOLD,18));
        SalesRecord_Load();
        getSum();
    }

    public void SalesRecord_Load() throws SQLException{
         int c;
         
         try{
         Class.forName("java.sql.Driver");
         
         Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select * from sales";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)salesTable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("sell_id"));
                 v2.add(rs.getString("cust_name"));
                 v2.add(rs.getString("amount"));
                 v2.add(rs.getString("pay"));
                 v2.add(rs.getString("due"));
             }
             d.addRow(v2);
         }
         
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error!!" +ex);
         }
     }
    
    public void SalesRecord_Search() throws SQLException{
         int c;
         
         try{
         Class.forName("java.sql.Driver");
         
         Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select * from sales where sell_id = '"+tduecustomer.getText()+"' order by sell_id asc";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)salesTable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("sell_id"));
                 v2.add(rs.getString("cust_name"));
                 v2.add(rs.getString("amount"));
                 v2.add(rs.getString("pay"));
                 v2.add(rs.getString("due"));
             }
             d.addRow(v2);
         }
         
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error!!" +ex);
         }
         
     }
    
    public void getSum(){
        int sum=0;
        int paid=0;
        int due=0;
        for(int i=0;i<salesTable.getRowCount();i++){
            sum=sum+Integer.parseInt((String) salesTable.getValueAt(i, 2).toString());
            tamount.setText(Integer.toString(sum));

        }
        for(int i=0;i<salesTable.getRowCount();i++){
            paid=paid+Integer.parseInt((String) salesTable.getValueAt(i, 3).toString());
            tpaid.setText(Integer.toString(paid));
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bsearch = new javax.swing.JButton();
        bback = new javax.swing.JButton();
        tduecustomer = new javax.swing.JTextField();
        bdue = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bdue1 = new javax.swing.JButton();
        bdue2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tamount = new javax.swing.JTextField();
        tpaid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel11.setBackground(new java.awt.Color(0, 51, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sales Record");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(476, 476, 476))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        bsearch.setBackground(new java.awt.Color(102, 102, 0));
        bsearch.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bsearch.setForeground(new java.awt.Color(255, 255, 255));
        bsearch.setText("Search");
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });

        bback.setBackground(new java.awt.Color(102, 102, 0));
        bback.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bback.setForeground(new java.awt.Color(255, 255, 255));
        bback.setText("Back");
        bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbackActionPerformed(evt);
            }
        });

        tduecustomer.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        bdue.setBackground(new java.awt.Color(102, 102, 0));
        bdue.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bdue.setForeground(new java.awt.Color(255, 255, 255));
        bdue.setText("Due Table");
        bdue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdueActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Sell ID");

        bdue1.setBackground(new java.awt.Color(102, 102, 0));
        bdue1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bdue1.setForeground(new java.awt.Color(255, 255, 255));
        bdue1.setText("Update");
        bdue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdue1ActionPerformed(evt);
            }
        });

        bdue2.setBackground(new java.awt.Color(102, 102, 0));
        bdue2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bdue2.setForeground(new java.awt.Color(255, 255, 255));
        bdue2.setText("Remove");
        bdue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdue2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tduecustomer))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bdue1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(bsearch))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(bdue)))
                            .addComponent(bdue2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(bback, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tduecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsearch)
                .addGap(18, 18, 18)
                .addComponent(bdue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bdue1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bdue2)
                .addGap(31, 31, 31)
                .addComponent(bback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 51, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 3));

        salesTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sell ID", "Customer Name", "Amount", "Paid", "Due"
            }
        ));
        jScrollPane2.setViewportView(salesTable);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Amount");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Paid");

        tamount.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N

        tpaid.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tamount, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(tpaid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        try {
            SalesRecord_Search();
        } catch (SQLException ex) {
            Logger.getLogger(SalesRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsearchActionPerformed

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed
        try {
            MainMenu menu = new MainMenu();
            this.hide();
            menu.setVisible(true);
        } catch(Exception ex){
            
        }
    }//GEN-LAST:event_bbackActionPerformed

    private void bdueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdueActionPerformed
        try {
            DueCustomer due = new DueCustomer();
            this.hide();
            due.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Custormer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bdueActionPerformed

    private void bdue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdue1ActionPerformed
        UpdateSales sale=new UpdateSales();
        this.hide();
        sale.setVisible(true);
    }//GEN-LAST:event_bdue1ActionPerformed

    private void bdue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdue2ActionPerformed
        RemoveSales sale=new RemoveSales();
        this.hide();
        sale.setVisible(true);
    }//GEN-LAST:event_bdue2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SalesRecord().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SalesRecord.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bback;
    private javax.swing.JButton bdue;
    private javax.swing.JButton bdue1;
    private javax.swing.JButton bdue2;
    private javax.swing.JButton bsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable salesTable;
    private javax.swing.JTextField tamount;
    private javax.swing.JTextField tduecustomer;
    private javax.swing.JTextField tpaid;
    // End of variables declaration//GEN-END:variables
}
