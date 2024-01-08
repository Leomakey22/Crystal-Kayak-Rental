package crystal.kayak.rental;

import java.io.File;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RentalMenu extends javax.swing.JFrame {

    File f = new File("");
    
    public RentalMenu() {
        initComponents();  
        connect();
        loadname1();
        loadname2();
        fetch1();
        fetch2();
    }
    Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        public void connect(){
          try {
              Class.forName("com.mysql.jdbc.Driver");
              con =DriverManager.getConnection("jdbc:mysql://localhost/kayak","root","");
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        public void  loadname1(){
          try {
              pst = con.prepareStatement("SELECT ID FROM kayakrent");
              rs = pst.executeQuery();
              
              PANEL.removeAllItems();
              while(rs.next()){
                  PANEL.addItem(rs.getString(1));
              }
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        public void  loadname2(){
          try {
              pst = con.prepareStatement("SELECT ID FROM queue");
              rs = pst.executeQuery();
              
              PANEL.removeAllItems();
              while(rs.next()){
                  ID.addItem(rs.getString(1));
              }
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        private void fetch1(){
          try {
              int q;
              pst = con.prepareStatement("SELECT * FROM kayakrent");
              rs = pst.executeQuery();
              ResultSetMetaData rss = rs.getMetaData();
              q = rss.getColumnCount();
              
              DefaultTableModel df = (DefaultTableModel)Table1.getModel();
              df.setRowCount(0);
              
              while(rs.next()){
                  Vector v2 = new Vector();
                  for(int a = 1; a <= q; a++){
                      v2.add(rs.getString("name"));
                      v2.add(rs.getString("hours"));
                      v2.add(rs.getString("kayak"));
                      v2.add(rs.getString("id"));
                  }df.addRow(v2);
              }
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        private void fetch2(){
          try {
              int q;
              pst = con.prepareStatement("SELECT * FROM queue");
              rs = pst.executeQuery();
              ResultSetMetaData rss = rs.getMetaData();
              q = rss.getColumnCount();
              
              DefaultTableModel df = (DefaultTableModel)Table2.getModel();
              df.setRowCount(0);
              
              while(rs.next()){
                  Vector v2 = new Vector();
                  for(int a = 1; a <= q; a++){
                      v2.add(rs.getString("Client"));
                      v2.add(rs.getString("ID"));
                  }df.addRow(v2);
              }
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        client = new javax.swing.JTextField();
        ID = new javax.swing.JComboBox<>();
        procced = new javax.swing.JToggleButton();
        PANEL = new javax.swing.JComboBox<>();
        queue = new javax.swing.JToggleButton();
        id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hours = new javax.swing.JComboBox<>();
        kayak = new javax.swing.JComboBox<>();
        confirmfinal = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        OK = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        Panel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 102));

        EditPanel.setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setInheritsPopupMenu(true);

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Todays Kayak Schedule");

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Hours ", "Kayak No.", "ID Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(1).setHeaderValue("Hours");
        }

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Person in Queue");

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client", "Priority Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table2);

        jLabel5.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Name");

        ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        procced.setBackground(new java.awt.Color(153, 255, 255));
        procced.setForeground(new java.awt.Color(0, 0, 0));
        procced.setText("Procced");
        procced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proccedActionPerformed(evt);
            }
        });

        queue.setBackground(new java.awt.Color(153, 255, 255));
        queue.setForeground(new java.awt.Color(0, 0, 0));
        queue.setText("Queue");
        queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queueActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Priority Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(238, 238, 238))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(122, 122, 122)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(queue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(procced, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(126, 126, 126)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(procced))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setInheritsPopupMenu(true);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Crystal Kayak Rental");

        jLabel2.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Name");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Hours (Maximum of 5 hours only)");

        hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 mins", "1 hour", "2 hours", "3 hours", "4 hours", "5 hours" }));

        kayak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kayak 1", "Kayak 2", "Kayak 3 ", "Kayak 4", "Kayak 5" }));

        confirmfinal.setBackground(new java.awt.Color(102, 204, 255));
        confirmfinal.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        confirmfinal.setForeground(new java.awt.Color(0, 0, 0));
        confirmfinal.setText("Confirm");
        confirmfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmfinalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Kayak No.");

        jLabel14.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("ID Number");

        OK.setBackground(new java.awt.Color(102, 204, 255));
        OK.setForeground(new java.awt.Color(0, 0, 0));
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(102, 204, 255));
        jToggleButton2.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton2.setText("Delete");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        Panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Search");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(71, 71, 71))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(confirmfinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kayak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name)
                            .addComponent(jLabel14)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kayak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(confirmfinal)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK)
                    .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton2)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EditPanelLayout = new javax.swing.GroupLayout(EditPanel);
        EditPanel.setLayout(EditPanelLayout);
        EditPanelLayout.setHorizontalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditPanelLayout.setVerticalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
              String name1 = name.getText();
              String pid =  Panel.getText().toString();
              pst = con.prepareStatement("DELETE FROM kayakrent WHERE id=?");
              pst.setString(1,pid);
                  
              
            if(name1.isEmpty()){
                JOptionPane.showMessageDialog(null, "No clients name");
            }else{
                int k = pst.executeUpdate();    
                
                if(k ==1){
                    JOptionPane.showMessageDialog(null, "Rental Deleted");
                        name.setText("");
                        hours.setSelectedIndex(0);
                        kayak.setSelectedIndex(0);
                        Panel.setText("");
                        fetch1();
                        
                        loadname1();
                        
                        name.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Error deleting");
                } 
            }
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        try {
            String pid = Panel.getText().toString();

            pst = con.prepareStatement("SELECT * FROM kayakrent WHERE id=?");
            pst.setString(1,pid);
            rs = pst.executeQuery();

            if(rs.next() == true){
                name.setText(rs.getString(1));
                String selectedTime = rs.getString("hours");
                hours.setSelectedItem(selectedTime);

                String selectedService = rs.getString("kayak");
                kayak.setSelectedItem(selectedService);

            }else{
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OKActionPerformed

    private void confirmfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmfinalActionPerformed
       try {
            String name1 = name.getText();
            String hours1 = (String) hours.getSelectedItem();
            String kayak1 = (String) kayak.getSelectedItem();

            // Check for overlapping rentals
            pst = con.prepareStatement("SELECT * FROM kayakrent WHERE kayak = ?");
            pst.setString(1, kayak1);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                // Overlapping rental found, inform the user
                JOptionPane.showMessageDialog(null, "This kayak is already rented. Please choose a different kayak.");
            } else {
                // No overlapping rental, proceed to insert the new rental
                pst = con.prepareStatement("INSERT INTO kayakrent (name, hours, kayak) VALUES (?, ?, ?)");
                pst.setString(1, name1);
                pst.setString(2, hours1);
                pst.setString(3, kayak1);

                if (name1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up client's name");
                } else {
                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Rental Booked");
                        // Clear fields and update UI
                        name.setText("");
                        hours.setSelectedIndex(0);
                        kayak.setSelectedIndex(0);
                        fetch1();
                        
                        loadname1();
                        
                        name.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error Saving");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmfinalActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void queueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queueActionPerformed
        try {
            String client1 = client.getText();

            // Check for overlapping rentals
            pst = con.prepareStatement("SELECT * FROM queue WHERE Client = ?");
            pst.setString(1, client1);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                // Overlapping rental found, inform the user
                JOptionPane.showMessageDialog(null, "This name is already in there");
            } else {
                // No overlapping rental, proceed to insert the new rental
                pst = con.prepareStatement("INSERT INTO queue (Client) VALUES (?)");
                pst.setString(1, client1);
                

                if (client1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up client's name");
                } else {
                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Added to queue");
                        // Clear fields and update UI
                        client.setText("");
                        fetch1();
                        fetch2();
                        loadname1();
                        loadname2();
                        client.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error Saving");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_queueActionPerformed

    private void proccedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proccedActionPerformed
        try {
            String pid = id.getText().toString();

            pst = con.prepareStatement("SELECT * FROM queue WHERE ID=?");
            pst.setString(1,pid);
            rs = pst.executeQuery();

            if(rs.next() == true){
                name.setText(rs.getString(1));

            }else{
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
              String name1 = name.getText();
              String pid = (String) id.getText().toString();
              pst = con.prepareStatement("DELETE FROM queue WHERE id=?");
              pst.setString(1,pid);
                  
              
            
                int k = pst.executeUpdate();    
                
                if(k ==1){
                    //JOptionPane.showMessageDialog(null, "Reservation Deleted");
                        client.setText("");
                        id.setText("");
                        fetch1();
                        fetch2();
                        loadname1();
                        loadname2();
                        
                }          
          } catch (SQLException ex) {
              Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }//GEN-LAST:event_proccedActionPerformed

    private void PanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        try {
            String pid = Panel.getText().toString();

            pst = con.prepareStatement("SELECT * FROM kayakrent WHERE id=?");
            pst.setString(1,pid);
            rs = pst.executeQuery();

            if(rs.next() == true){
                name.setText(rs.getString(1));
                String selectedTime = rs.getString("hours");
                hours.setSelectedItem(selectedTime);

                String selectedService = rs.getString("kayak");
                kayak.setSelectedItem(selectedService);

            }else{
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Table1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RentalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentalMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EditPanel;
    private javax.swing.JComboBox<String> ID;
    private javax.swing.JToggleButton OK;
    private javax.swing.JComboBox<String> PANEL;
    private javax.swing.JTextField Panel;
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JTextField client;
    private javax.swing.JToggleButton confirmfinal;
    private javax.swing.JComboBox<String> hours;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JComboBox<String> kayak;
    private javax.swing.JTextField name;
    private javax.swing.JToggleButton procced;
    private javax.swing.JToggleButton queue;
    // End of variables declaration//GEN-END:variables
}
