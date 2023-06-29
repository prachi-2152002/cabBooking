
package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Intercity_Booked_Cab extends JFrame{
 
    Font f;
    JTable t1;
    String x[]={"Book ID","Username","Name","Driver Name","Source","Destination","Type","Car","Price"};
    String y[][]=new String[20][9];
    int i=0,j=0;
    
    View_Intercity_Booked_Cab() {
        
         super("All Intercity Booked Cab Records");
               setSize(1300,400);
               setLocation(0,10);
               f=new Font("MS UI Gothic",Font.BOLD,17);
               
               try 
               {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from intercityCab";
                ResultSet rest=obj.stm.executeQuery(q);
                while(rest.next()){
                    y[i][j++]=rest.getString("BookID");
                    y[i][j++]=rest.getString("username");
                    y[i][j++]=rest.getString("nam_e");
                    y[i][j++]=rest.getString("drivername");
                    y[i][j++]=rest.getString("sorce");                   //there may be a lower or upper case issue
                    y[i][j++]=rest.getString("destination");
                    y[i][j++]=rest.getString("typ_e");
                    y[i][j++]=rest.getString("car");
                    y[i][j++]=rest.getString("price");
                    i++;
                    j=0;  //new row thats y starts from 0
                }
                t1=new JTable(y,x);
               } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            t1.setFont(f);
            t1.setBackground(Color.BLACK);
            t1.setForeground(Color.WHITE);
            
            JScrollPane js=new JScrollPane(t1);
            add(js);
    }
    
    public static void main(String[] args) {
        new View_Intercity_Booked_Cab().setVisible(true);
    }
    
}
