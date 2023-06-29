
package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_BookedCab extends JFrame {
   
    Font f;
    JTable t1;
    String x[]={"BookID","username","drivername","car","sorce","destination","price"};
    String y[][]=new String[20][7];
    int i=0,j=0;
        
    View_BookedCab() {
               super("All Intracity Booked Cab Records");
               setSize(1300,400);
               setLocation(0,10);
               f=new Font("MS UI Gothic",Font.BOLD,17);
               
               try 
               {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from intracityCab";
                ResultSet rest=obj.stm.executeQuery(q);
                while(rest.next()){
                    y[i][j++]=rest.getString("BookID");
                    y[i][j++]=rest.getString("username");
                    y[i][j++]=rest.getString("drivername");
                    y[i][j++]=rest.getString("car");
                    y[i][j++]=rest.getString("sorce");
                    y[i][j++]=rest.getString("destination");
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
        new View_BookedCab().setVisible(true);
    }
}
