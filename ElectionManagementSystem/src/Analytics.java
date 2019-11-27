
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Analytics extends javax.swing.JFrame {

  Connection con;
    Statement stmt;
    ArrayList<Integer> userAge;
    ArrayList<String> userGn;
    ArrayList<Integer> count;
    ArrayList<Integer> countgn;
    ArrayList<Integer> dist;
    ArrayList<String> distgn;
    ArrayList<Integer> cdNbv;
    SimpleUser su;
    int nbvoters;
    public Analytics() {
        nbvoters=0;
    
      try {
          initComponents();
          Connect();
          
          String s = "SELECT * FROM USERS ";
          ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
              
              int id= rs.getInt("ID");
              String fn = rs.getString("FirstName");
              String ln = rs.getString("LastName");
              int ag = rs.getInt("Age");
              String gn = rs.getString("Gender");
              int voted = rs.getInt("Voted");
              
              
              
              if (voted==1)
                  nbvoters++;
                  }
          
          
      } catch (SQLException ex) {
          Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
      }}

    public void Connect(){
       try {
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/ElectionDB","Election","pass");
           stmt = con.createStatement();
           
       } catch (SQLException ex) {
           Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
       }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Show voters' age bar graph");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        pnl.setForeground(new java.awt.Color(255, 255, 255));
        pnl.setPreferredSize(new java.awt.Dimension(650, 370));
        pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 360));

        jButton2.setText("Show voters' gender pie chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 220, -1));

        jButton3.setText("Show results' pie chart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     
      try {
          DefaultCategoryDataset set = new DefaultCategoryDataset();
          userAge = new ArrayList<>();
          count= new ArrayList<>();
          dist =new ArrayList<>();
          
          int k=0;
          String s = "SELECT * FROM USERS ";
          ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
              
              int id= rs.getInt("ID");
              String fn = rs.getString("FirstName");
              String ln = rs.getString("LastName");
              int ag = rs.getInt("Age");
              String gn = rs.getString("Gender");
              int voted = rs.getInt("Voted");
              
              
              
              if (voted==1)
                  userAge.add(ag);
              
              
              k++;
          }
          Set<Integer> distinct = new HashSet<>(userAge);
          for(int i:distinct){
              count.add(Collections.frequency(userAge, i));
              dist.add(i);
          // JOptionPane.showMessageDialog(null,count.toString(), "TITLE", JOptionPane.WARNING_MESSAGE);

          }
              for (int index=0;index<count.size();index++){
              set.setValue(count.get(index), "Age",dist.get(index) );
               //JOptionPane.showMessageDialog(null, count.size(), "TITLE", JOptionPane.WARNING_MESSAGE);
              }
          
          JFreeChart barChart = ChartFactory.createBarChart3D("Voters' age bar chart", "Voter Age","Frequency",set, PlotOrientation.VERTICAL, true,true,false);
          CategoryPlot plot = barChart.getCategoryPlot();
          plot.setRangeGridlinePaint(Color.DARK_GRAY);
          ChartFrame chartFrm = new ChartFrame("Vote",barChart,true);
          //chartFrm.setVisible(true);
          // chartFrm.setSize(600,400);
          ChartPanel chartPanel = new ChartPanel(barChart);
          pnl.removeAll();
          pnl.add(chartPanel);
          pnl.updateUI();
          /* for(int i=0;i<user.size();i++){
          if(user.get(i).getAge()==ag)
          user.set(i,user.get(i)++);
          }
          
          set.setValue(ag, "Age", fn+" "+ln);*/
      } catch (SQLException ex) {
          Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
      }
              
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      try {
          DefaultPieDataset set = new DefaultPieDataset();
          userGn = new ArrayList<>();
          count= new ArrayList<>();
          distgn =new ArrayList<>();
          
          int k=0;
          String s = "SELECT * FROM USERS ";
          ResultSet rs = stmt.executeQuery(s);
          while(rs.next()){
              
              int id= rs.getInt("ID");
              String fn = rs.getString("FirstName");
              String ln = rs.getString("LastName");
              int ag = rs.getInt("Age");
              String gn = rs.getString("Gender");
              int voted = rs.getInt("Voted");
              
              
              
              if (voted==1)
                  userGn.add(gn);
              
              
              k++;
          }
          Set<String> distinct = new HashSet<>(userGn);
          for(String i:distinct){
              count.add(Collections.frequency(userGn, i));
              distgn.add(i);
          //JOptionPane.showMessageDialog(null,count.toString()+" " + i, "TITLE", JOptionPane.WARNING_MESSAGE);

          }
              for (int index=0;index<count.size();index++){
              set.setValue(distgn.get(index),count.get(index));
              //JOptionPane.showMessageDialog(null, count.size()+" "+distgn.get(index), "TITLE", JOptionPane.WARNING_MESSAGE);
              }
          
          JFreeChart pieChart = ChartFactory.createPieChart3D("Gender Pie Chart", set, true, true, true);
          PiePlot3D plot = (PiePlot3D)pieChart.getPlot();
         plot.setBackgroundPaint(Color.WHITE);
          
          ChartFrame chartFrm = new ChartFrame("Pie Chart",pieChart);
          //chartFrm.setVisible(true);
          // chartFrm.setSize(600,400);
          ChartPanel chartPanel = new ChartPanel(pieChart);
          pnl.removeAll();
          pnl.add(chartPanel);
          pnl.updateUI();
          /* for(int i=0;i<user.size();i++){
          if(user.get(i).getAge()==ag)
          user.set(i,user.get(i)++);
          }
          
          set.setValue(ag, "Age", fn+" "+ln);*/
      } catch (SQLException ex) {
          Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
      }       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        try {
          DefaultPieDataset set = new DefaultPieDataset();
          
          count= new ArrayList<>();
          cdNbv =new ArrayList<>();
          
          int k=0;
          String sql = "SELECT * FROM Candidates";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                int id =rs.getInt("id");
                String fname = rs.getString("FirstName");
                String lname = rs.getString("LastName");
                int ag = rs.getInt("Age");
                String gn= rs.getString("Gender");
                int nbv=rs.getInt("NBVotes");
              
              
              
             
              cdNbv.add(nbv);
              set.setValue(fname+" "+lname+": "+nbv/nbvoters*100+"%",cdNbv.get(k));
              
              k++;
          }
            
          
          
          JFreeChart pieChart = ChartFactory.createPieChart3D("Results Pie Chart", set, true, true, true);
          PiePlot3D plot = (PiePlot3D)pieChart.getPlot();
          plot.setBackgroundPaint(Color.WHITE);
         
          
          ChartFrame chartFrm = new ChartFrame("Pie Chart",pieChart);
          //chartFrm.setVisible(true);
          // chartFrm.setSize(600,400);
          ChartPanel chartPanel = new ChartPanel(pieChart);
          pnl.removeAll();
          pnl.add(chartPanel);
          pnl.updateUI();
          /* for(int i=0;i<user.size();i++){
          if(user.get(i).getAge()==ag)
          user.set(i,user.get(i)++);
          }
          
          set.setValue(ag, "Age", fn+" "+ln);*/
      } catch (SQLException ex) {
          Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
      }       
                     
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analytics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables
}
