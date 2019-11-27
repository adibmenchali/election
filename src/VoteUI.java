//NEW
import java.awt.Color;
import java.awt.ScrollPane;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class VoteUI extends javax.swing.JFrame {

   int user_id,x, y;
   String table_click;
   Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    Candidate c;
    ArrayList<Candidate> List;
    SimpleUser su ;
    ArrayList<SimpleUser> sList;
    public VoteUI() throws IOException {
     initComponents();
    }
    
    public VoteUI(int user_id){
        this.user_id=user_id;
       try {
           Connect();
           
           List = new ArrayList<>()  ;
           sList = new ArrayList<>()  ;
           String sql ="SELECT * FROM CANDIDATES";
           stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               int id= rs.getInt("id");
               String fn=rs.getString("firstname");
               String ln=rs.getString("lastname");
             int ag=rs.getInt("Age");
             int nbv=rs.getInt("NBVotes");
             String gn=rs.getString("Gender");
             c = new Candidate(id,fn,ln,ag,gn,nbv);
           }
           initComponents();
           this.pack();
           this.setLocationRelativeTo(null);
           this.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(VoteUI.class.getName()).log(Level.SEVERE, null, ex);
       }filltable();
        
         //JOptionPane.showMessageDialog(null, user_id, "Candidate Added", JOptionPane.INFORMATION_MESSAGE);
    }

   public void Connect(){
       try {
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/ElectionDB","Election","pass");
           stmt = con.createStatement();
           
       } catch (SQLException ex) {
           Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vote");
        setMinimumSize(new java.awt.Dimension(750, 550));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 40, 40));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECT A CANDIDATE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 250, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/65299.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setDoubleBuffered(true);

        tab.setBackground(new java.awt.Color(51, 51, 51));
        tab.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        tab.setForeground(new java.awt.Color(255, 255, 255));
        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tab.setToolTipText("Select a candidate");
        tab.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tab.setAutoscrolls(false);
        tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab.setFocusable(false);
        tab.setGridColor(new java.awt.Color(204, 51, 0));
        tab.setName("tab"); // NOI18N
        tab.setRowHeight(35);
        tab.setRowMargin(0);
        tab.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tab.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tab.setShowHorizontalLines(false);
        tab.setShowVerticalLines(false);
        tab.setTableHeader(null);
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab);
        tab.getAccessibleContext().setAccessibleParent(jPanel1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 770, 460));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VOTE");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 80));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 770, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 770, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(evt.getXOnScreen()-x,evt.getYOnScreen()-y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        this.dispose();
    }//GEN-LAST:event_jLabel1MousePressed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
      int row=tab.getSelectedRow();
      table_click=tab.getModel().getValueAt(row,0).toString();//get value of selected row, 0 for first column
      // JOptionPane.showMessageDialog(null, table_click, "Candidate details", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_tabMouseClicked

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
       jPanel4.setBackground(Color.darkGray);
        
            int voted=0; int index=-1;
        try {
            int k=0;
           String s = "SELECT * FROM USERS ";
           ResultSet rs = stmt.executeQuery(s);
           while(rs.next()){
               
               int id= rs.getInt("ID");
               String fn = rs.getString("FirstName");
               String ln = rs.getString("LastName");
               int ag = rs.getInt("Age");
               String gn = rs.getString("Gender");
               voted = rs.getInt("Voted");
               
               su = new SimpleUser(id,fn,ln,ag,gn);
               sList.add(su);
               if (voted==1) sList.get(k).markVoted();
                       k++;
           }
       } catch (SQLException ex) {
           Logger.getLogger(VoteUI.class.getName()).log(Level.SEVERE, null, ex);
       }
         for(int i=0;i<sList.size();i++){
        if(sList.get(i).getId()==user_id)
            index=i; //index of user in sList
        
                }
         
        //JOptionPane.showMessageDialog(null,index +" "+sList.get(index).voted()+ sList.size()+sList.get(index).toString()+sList.toString(), "Vote Submitted", JOptionPane.INFORMATION_MESSAGE);

        if(sList.get(index).voted()==false){ //verify that user never voted before
        try {
           
           String sql = "UPDATE USERS SET VOTED=1 WHERE ID=?";
           pstmt= con.prepareStatement(sql);
           pstmt.setInt(1, user_id);
           int c = pstmt.executeUpdate();
           if(c>0){
           JOptionPane.showMessageDialog(null, "Thank you for voting, your vote has been submitted successfully", "Vote Submitted", JOptionPane.INFORMATION_MESSAGE);
           sList.get(index).markVoted(); //mark as voted
           

           for(int i=0;i<List.size();i++){
               if(List.get(i).getId()==Integer.parseInt(table_click)){
               List.get(i).add_Vote();
               int newnbv = List.get(i).getnbVotes();
               
               String query ="UPDATE CANDIDATES SET NBVOTES =? WHERE ID=?";
               pstmt = con.prepareStatement(query);
               pstmt.setInt(1, newnbv);
               pstmt.setInt(2, List.get(i).getId());
               int count = pstmt.executeUpdate();
              this.dispose();
               
               }
           }
           
           }}
        catch (SQLException ex) {
           Logger.getLogger(VoteUI.class.getName()).log(Level.SEVERE, null, ex);
       } }
           else{
                JOptionPane.showMessageDialog(null, "Your vote is already submitted, you cannot vote more than once!", "Already Voted", JOptionPane.ERROR_MESSAGE);
                }
           
        
       
      
        
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
       
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
    Login obj= new Login();
                          this.setVisible(false);
                          obj.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed
 public void filltable(){
        try {
            DefaultTableModel model = new DefaultTableModel();
                        Object ColNames[]=new Object[2];
            
            ColNames[0]="Candidates";
            
            
            model.setColumnIdentifiers(ColNames);
            String sql = "SELECT * FROM Candidates";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                int id =rs.getInt("id");
                String fname = rs.getString("FirstName");
                String lname = rs.getString("LastName");
                int ag = rs.getInt("Age");
                String gn= rs.getString("Gender");
                int nbv=rs.getInt("NBVotes");
                String name=fname.concat(" "+lname);
                Object[] row = {id,name};
                model.addRow(row);
                c= new Candidate(id,fname,lname,ag,gn,nbv);
                List.add(c);
                
            }
            
            tab.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(VoteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
   
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
            java.util.logging.Logger.getLogger(VoteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VoteUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VoteUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
