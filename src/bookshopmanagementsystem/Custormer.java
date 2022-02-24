
package bookshopmanagementsystem;

import com.mysql.jdbc.Connection;
import java.awt.Font;
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


public class Custormer extends javax.swing.JFrame {

   
    public Custormer() throws SQLException {
        initComponents();
        customerTable.getTableHeader().setFont(new Font("Times new roman", Font.BOLD,18));
        Customer_Load();
    }

    public void Customer_Load() throws SQLException{
         int c;
         try{
         Class.forName("java.sql.Driver");
         
         java.sql.Connection con = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select cust_id,sell_id,cust_name,book_name,quantity,price,discount,amount from customer natural join books order by cust_id asc";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)customerTable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("cust_id"));
                 v2.add(rs.getString("sell_id"));
                 v2.add(rs.getString("cust_name"));
                 v2.add(rs.getString("book_name"));
                 v2.add(rs.getString("quantity"));
                 v2.add(rs.getString("price"));
                 v2.add(rs.getString("discount"));
                 v2.add(rs.getString("amount"));
             }
             d.addRow(v2);
         }
         
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error!!" +ex);
         }
     }
    
    
    public void Customer_Search() throws SQLException{
         int c;
         try{
         Class.forName("java.sql.Driver");
         
         java.sql.Connection con = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select cust_id,sell_id,cust_name,book_name,quantity,price,discount,amount from customer natural join books where sell_id = '"+tcustomer.getText()+"'";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)customerTable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("cust_id"));
                 v2.add(rs.getString("sell_id"));
                 v2.add(rs.getString("cust_name"));
                 v2.add(rs.getString("book_name"));
                 v2.add(rs.getString("quantity"));
                 v2.add(rs.getString("price"));
                 v2.add(rs.getString("discount"));
                 v2.add(rs.getString("amount"));
             }
             d.addRow(v2);
         }
         
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error!!" +ex);
         }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bmainmenu = new javax.swing.JButton();
        bsearch = new javax.swing.JButton();
        brcustomer = new javax.swing.JButton();
        bucustomer = new javax.swing.JButton();
        tcustomer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(509, 509, 509))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        bmainmenu.setBackground(new java.awt.Color(102, 102, 0));
        bmainmenu.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bmainmenu.setForeground(new java.awt.Color(255, 255, 255));
        bmainmenu.setText("Back");
        bmainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmainmenuActionPerformed(evt);
            }
        });

        bsearch.setBackground(new java.awt.Color(102, 102, 0));
        bsearch.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bsearch.setForeground(new java.awt.Color(255, 255, 255));
        bsearch.setText("Search");
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });

        brcustomer.setBackground(new java.awt.Color(102, 102, 0));
        brcustomer.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        brcustomer.setForeground(new java.awt.Color(255, 255, 255));
        brcustomer.setText("Remove Customer");
        brcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brcustomerActionPerformed(evt);
            }
        });

        bucustomer.setBackground(new java.awt.Color(102, 102, 0));
        bucustomer.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bucustomer.setForeground(new java.awt.Color(255, 255, 255));
        bucustomer.setText("Update Customer");
        bucustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucustomerActionPerformed(evt);
            }
        });

        tcustomer.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Sell ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(bmainmenu))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(bsearch))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bucustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brcustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tcustomer)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsearch)
                .addGap(16, 16, 16)
                .addComponent(bucustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brcustomer)
                .addGap(54, 54, 54)
                .addComponent(bmainmenu)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 3));

        customerTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cust_id", "Sell_id", "Cust_name", "Book Name", "Quantity", "Price", "Discount (%)", "Amount"
            }
        ));
        jScrollPane1.setViewportView(customerTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brcustomerActionPerformed
        RemoveCustomer rcustomer = new RemoveCustomer();
        this.hide();
        rcustomer.setVisible(true);
    }//GEN-LAST:event_brcustomerActionPerformed

    private void bmainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmainmenuActionPerformed
        MainMenu menu = new MainMenu();
        this.hide();
        menu.setVisible(true);
    }//GEN-LAST:event_bmainmenuActionPerformed

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        try {
            Customer_Search();
        } catch (SQLException ex) {
            Logger.getLogger(Custormer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsearchActionPerformed

    private void bucustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucustomerActionPerformed
        UpdateCustomer customer = new UpdateCustomer();
        this.hide();
        customer.setVisible(true);
    }//GEN-LAST:event_bucustomerActionPerformed

   
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
            java.util.logging.Logger.getLogger(Custormer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Custormer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Custormer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Custormer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Custormer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Custormer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bmainmenu;
    private javax.swing.JButton brcustomer;
    private javax.swing.JButton bsearch;
    private javax.swing.JButton bucustomer;
    private javax.swing.JTable customerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tcustomer;
    // End of variables declaration//GEN-END:variables
}
