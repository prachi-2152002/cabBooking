package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Book_Intracity_cab extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    Font f,f1;
    Choice ch1,ch2,ch3;
    
    Book_Intracity_cab() {
        
        super("Book Intracity Cab");
        setLocation(50,10);
        setSize(1100, 700);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select sorce from intracity_driver";
          
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("sorce"));
            }
            rest.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select username from customer";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch3.add(rest.getString("username"));
            }
            rest.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        l1=new JLabel("Book Intracity Cab");
        l2=new JLabel("Book ID");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Username");
        l6=new JLabel("Name");
        l7=new JLabel("Driver Name");
        l8=new JLabel("Car");
        l9=new JLabel("Destination From");
        l10=new JLabel("Destination To");
        l11=new JLabel("Price");
        l12=new JLabel();
        
        tf1=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
       
        tf1.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        
        bt1=new JButton("Book Cab");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        bt1.setBackground(Color.YELLOW);
        bt2.setBackground(Color.RED);
        
        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        
        Random rm=new Random();
        tf1.setText(""+Math.abs(rm.nextInt()%100000));
        tf1.setForeground(Color.RED);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        
        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        tf1.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/booktaxi.jpeg"));
        Image img=ic.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l12.setIcon(ic1);
        
        p1=new JPanel();  
        p1.setLayout(new GridLayout(1,1,10,10));  // 1 1 means 1 frame panel 1 row 1 column for heading
        p1.add(l1);
        
        p2=new JPanel();  
        p2.setLayout(new GridLayout(11,2,10,10));  // for all data 11 row 2 column
        
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch2);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(tf3);
        p2.add(l7);
        p2.add(tf4);
        p2.add(l8);
        p2.add(tf5);
        p2.add(l9);
        p2.add(tf6);
        p2.add(l10);
        p2.add(tf7);
        p2.add(l11);
        p2.add(tf8);
        p2.add(bt1);
        p2.add(bt2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l12);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        ch3.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent arg0){
               try {
                   ConnectionClass obj=new ConnectionClass();
                   String username=ch3.getSelectedItem();
                   String q1="select name from customer where username='"+username+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       tf3.setText(rest1.getString("name"));
                   }
                   rest1.close();
               } catch (Exception e) {
                    System.out.println("188");
                   e.printStackTrace();
               }
           }
        });
        
             ch1.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent arg0){
               ch2.removeAll();  //remove item which come from selecting previous username
               try {
                   ConnectionClass obj=new ConnectionClass();
                   String source=ch1.getSelectedItem();
                   System.out.println(source);
                   String q1="select destination from intracity_driver where sorce='"+source+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   
                   while(rest1.next()){
                       ch2.add(rest1.getString("destination"));
                   }
                   rest1.close();  
               } catch (Exception e) {
                    System.out.println("207");
                   e.printStackTrace();
               }
           }
        });
        
        ch2.addMouseListener(new MouseAdapter() {
           @Override
          
           public void mouseClicked(MouseEvent arg0){
            
               try {
                   ConnectionClass obj=new ConnectionClass();
                   String source=ch1.getSelectedItem();
                   String destination=ch2.getSelectedItem();
                   String q1="select *from intracity_driver where sorce='"+source+"' and destination ='"+destination+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       tf4.setText(rest1.getString("driver"));
                       tf5.setText(rest1.getString("car"));
                       tf6.setText(rest1.getString("sorce"));
                       tf7.setText(rest1.getString("destination"));
                       tf8.setText(rest1.getString("price"));
                   }
                   rest1.close();
               } catch (Exception e) {
                   System.out.println("231");
                   e.printStackTrace();
               }
           }
        });    
    } 
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==bt1){
            String bid=tf1.getText();
            String username=ch3.getSelectedItem();
            String dname=tf4.getText();
            String car=tf5.getText();
            String sorce=tf6.getText();
            String destination=tf7.getText();
            String price=tf8.getText();
            
            try {
               ConnectionClass obj3=new ConnectionClass();
              String q1="insert into intracitycab values('"+bid+"','"+username+"','"+dname+"','"+car+"','"+sorce+"','"+destination+"','"+price+"')";
              int aa=obj3.stm.executeUpdate(q1);
              if(aa==1){
                  JOptionPane.showMessageDialog(null, "Cab Booked Succesfully");
                  this.setVisible(false);   
              }
              else{
                  JOptionPane.showMessageDialog(null, "Please!,Fill all details Carefully");
              }
               } catch (Exception eee) {
                   System.out.println("262");
                   eee.printStackTrace();
               }
           }
           if(e.getSource()==bt2){
                this.setVisible(false);
           }
    }
   
    public static void main(String[] args) {
        new Book_Intracity_cab().setVisible(true);
    }
}
