package wasterecycling;
import static java.awt.SystemColor.text;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Nomepurchase extends javax.swing.JFrame {
   static PreparedStatement ps,ps2;
  static  ResultSet rs,rs2;
    public Nomepurchase() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        m1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        m2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Money.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 90, -1));
        getContentPane().add(m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 73, -1));

        jLabel2.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Amount");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 320, -1));
        getContentPane().add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 73, -1));

        jButton1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 81, -1));

        jButton2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jButton2.setText("返回");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 81, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Metalpurchase.jpg"))); // NOI18N
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Surepurchase2 s=new Surepurchase2();
        s.setVisible(true);
        String drivername="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/Project?characterEncoding=utf8&serverTimezone=UTC";
    String username="root";
    String password="niit1234";
    java.sql.Connection con = null;     
  try{
                Class.forName(drivername);
              //  System.out.println("数据库驱动加载成功");
                
}       catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
     try{
        con =  DriverManager.getConnection(url, username, password);
      //   System.out.println("数据库连接成功");   
     }  catch (SQLException ex) {
         ex.printStackTrace();
     }
String str=m1.getText();
    int i=Integer.parseInt(str);
    String str2=m2.getText();
    int i2=Integer.parseInt(str2);
        try {
            
            PreparedStatement ps1=con.prepareStatement("select GarbageName from metal where Id=i");
           ResultSet rs1=ps1.executeQuery();
           String str3=rs1.getString("GarbageName");
            PreparedStatement ps2=con.prepareStatement("select Quantity_kilogram metal where Id=i");
            ResultSet rs2=ps2.executeQuery();
            String str4=rs2.getString("Quantity_kilogram");
            
            PreparedStatement ps3=con.prepareStatement("select Unitprice_gram from metal where Id=i");
           ResultSet rs3=ps3.executeQuery();
            String str5=rs3.getString("Unitprice_gram");
            
             int i3=Integer.parseInt(str4);
             int i4=Integer.parseInt(str5);
             int sum;
             sum=i2*i4;
             
             int cha=i3-i2;
            PreparedStatement ps4=con.prepareStatement("Update Metal set Quantity_kilogram=cha where Id=i");
           ResultSet rs4=ps4.executeQuery();
           if(cha==0)
           {
           PreparedStatement ps5=con.prepareStatement("delete from metal where id=i");
           ResultSet rs5=ps5.executeQuery();
           }    
        } catch (SQLException ex) {
            Logger.getLogger(Metalpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Nonmetal2 N2=new Nonmetal2();
        N2.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomepurchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField m1;
    private javax.swing.JTextField m2;
    // End of variables declaration//GEN-END:variables
}
