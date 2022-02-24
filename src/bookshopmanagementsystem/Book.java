
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class Book extends javax.swing.JFrame {

    public Book() throws SQLException {
        initComponents();
        booktable.getTableHeader().setFont(new Font("Times new roman", Font.BOLD,18));
        show_user();
        Statement st = null;
        com.mysql.jdbc.Connection con = null;
        ResultSet rs = null;
        try{
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management","root","");
            st=con.createStatement();
            String query = "select * from books";
            rs=st.executeQuery(query);
            while(rs.next()){
                tcombo.addItem(rs.getString(2));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error");
    }finally{
            try{
                st.close();
                rs.close();
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        this.setVisible(true);
        AutoCompleteDecorator.decorate(tcombo);
        tcombo.setSelectedItem(null);
    }
     
     public void show_user() throws SQLException{
         int c;
         try{
         Class.forName("java.sql.Driver");
         
         java.sql.Connection con = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select * from books";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)booktable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("id"));
                 v2.add(rs.getString("book_name"));
                 v2.add(rs.getString("writer"));
                 v2.add(rs.getString("stock"));
                 v2.add(rs.getString("price"));
                 v2.add(rs.getString("category"));
             }
             d.addRow(v2);
         }
         
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error!!" +ex);
         }
     }
     public void Book_Load() throws SQLException{
         int c;
         try{
         Class.forName("java.sql.Driver");
         
         java.sql.Connection con = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop_management", "root", "");
         String query = "select * from books where book_name = '"+tcombo.getSelectedItem()+"' order by id asc";
         Statement pst=(Statement)con.prepareStatement(query);
         ResultSet rs=pst.executeQuery(query);
         
         ResultSetMetaData rsd = rs.getMetaData();
         c=rsd.getColumnCount();
         
         DefaultTableModel d=(DefaultTableModel)booktable.getModel();
         d.setRowCount(0);
         
         while(rs.next()){
             Vector v2 = new Vector();
             
             for(int i=1;i<=c;i++){
                 v2.add(rs.getString("id"));
                 v2.add(rs.getString("book_name"));
                 v2.add(rs.getString("writer"));
                 v2.add(rs.getString("stock"));
                 v2.add(rs.getString("price"));
                 v2.add(rs.getString("category"));
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
        baddnewbook = new javax.swing.JButton();
        bremove = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bremove1 = new javax.swing.JButton();
        bsearch = new javax.swing.JButton();
        tcombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booktable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(532, 532, 532)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));

        baddnewbook.setBackground(new java.awt.Color(102, 102, 0));
        baddnewbook.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        baddnewbook.setForeground(new java.awt.Color(255, 255, 255));
        baddnewbook.setText("Add New Book");
        baddnewbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baddnewbookActionPerformed(evt);
            }
        });

        bremove.setBackground(new java.awt.Color(102, 102, 0));
        bremove.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bremove.setForeground(new java.awt.Color(255, 255, 255));
        bremove.setText("Remove Book");
        bremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bremoveActionPerformed(evt);
            }
        });

        bupdate.setBackground(new java.awt.Color(102, 102, 0));
        bupdate.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bupdate.setForeground(new java.awt.Color(255, 255, 255));
        bupdate.setText("Update Book");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        bremove1.setBackground(new java.awt.Color(102, 102, 0));
        bremove1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bremove1.setForeground(new java.awt.Color(255, 255, 255));
        bremove1.setText("Back");
        bremove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bremove1ActionPerformed(evt);
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

        tcombo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tcombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tcomboMouseClicked(evt);
            }
        });
        tcombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tcomboKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcomboKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Book Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(baddnewbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bremove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(bremove1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(bsearch))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsearch)
                .addGap(18, 18, 18)
                .addComponent(baddnewbook)
                .addGap(18, 18, 18)
                .addComponent(bupdate)
                .addGap(18, 18, 18)
                .addComponent(bremove)
                .addGap(38, 38, 38)
                .addComponent(bremove1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 0), 3));

        booktable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        booktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Writer", "Stock", "Price", "Category"
            }
        ));
        jScrollPane1.setViewportView(booktable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bremoveActionPerformed
        RemoveBook rbook = new RemoveBook();
        this.hide();
        rbook.setVisible(true);
    }//GEN-LAST:event_bremoveActionPerformed

    private void baddnewbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baddnewbookActionPerformed
        AddNewBook newbook = new AddNewBook();
        this.hide();
        newbook.setVisible(true);
    }//GEN-LAST:event_baddnewbookActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        UpdateBook ubook = new UpdateBook();
        this.hide();
        ubook.setVisible(true);
    }//GEN-LAST:event_bupdateActionPerformed

    private void bremove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bremove1ActionPerformed
        MainMenu menu = new MainMenu();
        this.hide();
        menu.setVisible(true);
    }//GEN-LAST:event_bremove1ActionPerformed

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        try {
            Book_Load();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bsearchActionPerformed

    private void tcomboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcomboKeyPressed
        try {
            Book_Load();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tcomboKeyPressed

    private void tcomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tcomboMouseClicked
        try {
            Book_Load();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tcomboMouseClicked

    private void tcomboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcomboKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tcomboKeyTyped

    
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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Book().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baddnewbook;
    private javax.swing.JTable booktable;
    private javax.swing.JButton bremove;
    private javax.swing.JButton bremove1;
    private javax.swing.JButton bsearch;
    private javax.swing.JButton bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tcombo;
    // End of variables declaration//GEN-END:variables
}
