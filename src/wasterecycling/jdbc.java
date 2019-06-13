
package wasterecycling;


import java.sql.*;

public class jdbc {
    String drivername="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/Project?characterEncoding=utf8&serverTimezone=UTC";
    String username="root";
    String password="niit1234";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
 public  Connection getConnection() {
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
     return con;
    
     
}


}









