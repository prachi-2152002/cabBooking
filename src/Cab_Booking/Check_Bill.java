

package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Check_Bill extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2,bt3,bt4;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4;
    Font f,f1;
    Choice ch1;
    public int price=0;
    
    Check_Bill() {
        super("Check Total Cab Bill");
        setLocation(50,10);
        setSize(1100, 500);
        
        l1=new JLabel("Check Total Cab Bill");
        l2=new JLabel("Username");
        l3=new JLabel("Name");
        l4=new JLabel("Email");
        l5=new JLabel("Address");
        l6=new JLabel("Price");
       
        ch1=new Choice();
        
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select *from customer";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("username"));
            }
            rest.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        
        bt1=new JButton("Intercity Cab");
        bt2=new JButton("Intracity Cab");
        bt3=new JButton("Transport");
        bt4=new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        
        ch1.setFont(f1);
        
        tf1.setFont(f1);        
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        bt3.setFont(f1);
        bt4.setFont(f1);
        
        bt1.setBackground(Color.YELLOW);
        bt2.setBackground(Color.YELLOW);
        bt3.setBackground(Color.YELLOW);
        bt4.setBackground(Color.BLACK);
        
        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.BLACK);
        bt3.setForeground(Color.BLACK);
        bt4.setForeground(Color.WHITE);
        
        p1=new JPanel();  
        p1.setLayout(new GridLayout(1,1,10,10));  // 1 1 means 1 frame panel 1 row 1 column for heading
        p1.add(l1);
        
        p2=new JPanel();  
        p2.setLayout(new GridLayout(7,2,10,10));  // for all data 11 row 2 column
        
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(bt1);
        p2.add(bt2);
        p2.add(bt3);
        p2.add(bt4);
        
        p3=new JPanel();  
        p3.setLayout(new GridLayout(1,1,10,10)); 
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/taxi.jpg"));
        Image img=ic.getImage().getScaledInstance(650, 390, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l7=new JLabel(ic1);
        
        p3.add(l7);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        ch1.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent arg0){
               try {
                   ConnectionClass obj=new ConnectionClass();
                   String username=ch1.getSelectedItem();
                   String q1="select *from customer where username='"+username+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       tf1.setText(rest1.getString("name"));
                       tf2.setText(rest1.getString("email"));
                       tf3.setText(rest1.getString("address"));
                   }
                 rest1.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
        });
    }
    
    
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==bt1){
             price=0;
             String username=ch1.getSelectedItem();
             try {
                 ConnectionClass obj=new ConnectionClass();
                 String q2="select price from intercitycab where username='"+username+"'";
                 ResultSet rest1=obj.stm.executeQuery(q2);
                 while(rest1.next()){
                     price=price+Integer.parseInt(rest1.getString("price"));
                 }
                 tf4.setText(price+"");  //"" use to convert in string
                 rest1.close();               
                 
             } catch (Exception ee) {
                 ee.printStackTrace();
             }
         }
         
         if(e.getSource()==bt2){
              price=0;
             String username=ch1.getSelectedItem();
             try {
                 ConnectionClass obj=new ConnectionClass();
                 String q3="select price from intracitycab where username='"+username+"'";
                 ResultSet rest1=obj.stm.executeQuery(q3);
                 while(rest1.next()){
                     price=price+Integer.parseInt(rest1.getString("price"));
                 }
                 tf4.setText(price+"");  //"" use to convert in string
                 rest1.close();               
                 
             } catch (Exception ee) {
                 ee.printStackTrace();
             }
         }
         
         if(e.getSource()==bt3){
              price=0;
             String username=ch1.getSelectedItem();
             try {
                 ConnectionClass obj=new ConnectionClass();
                 String q4="select price from intransport where username='"+username+"'";
                 ResultSet rest1=obj.stm.executeQuery(q4);
                 while(rest1.next()){
                     price=price+Integer.parseInt(rest1.getString("price"));
                 }
                 tf4.setText(price+"");  //"" use to convert in string
                 rest1.close();               
                 
             } catch (Exception ee) {
                 ee.printStackTrace();
             }
         }
         
         if(e.getSource()==bt4){
             this.setVisible(false);
         }
     }
    public static void main(String[] args) {
        new Check_Bill().setVisible(true);
    }
}
