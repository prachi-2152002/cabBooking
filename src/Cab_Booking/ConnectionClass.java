
package Cab_Booking;
import java.sql.*;
public class ConnectionClass {
    Connection conn;
    Statement stm;
    public ConnectionClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CabBooking","root","MyNewPass");
            stm=conn.createStatement();
            
//            if(conn.isClosed()) System.out.println("Yes");
//            else System.out.println("No");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
