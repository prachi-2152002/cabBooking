
package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton bt1,bt2,bt3,bt4;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    Font f,f1;
    
    AdminSection() {
        super("Admin Section");
        setLocation(450, 250);
        setSize(400,270);
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1=new JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2=new JLabel();
         
        bt1=new JButton("Intercity Driver");
        bt2=new JButton("Intracity Driver");
        bt3=new JButton("Transport Driver");
        bt4=new JButton("SignUp");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
       l1.setFont(f);
       bt1.setFont(f1);
       bt2.setFont(f1);
       bt3.setFont(f1);
       bt4.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(5,1,10,10));
       p1.add(l1);
       p1.add(bt1);
       p1.add(bt2);
       p1.add(bt3);
       p1.add(bt4);
       
       ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/admin.png"));
       Image img = ic.getImage().getScaledInstance(120,160, Image.SCALE_DEFAULT);
       ImageIcon ic1 = new ImageIcon(img);
       l2.setIcon(ic1);
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));
       p3.add(l2);
       
        setLayout(new BorderLayout(10,10));
      
        add(p1,"Center");
        add(p3,"East");
        
    }
    
    
      public void actionPerformed(ActionEvent e) {
          if(e.getSource()==bt1){
             new Add_Intercity_Cab().setVisible(true);
             this.setVisible(false);
          }
          if(e.getSource()==bt2){
            new Add_IntraCity_Driver().setVisible(true);
             this.setVisible(false);
          }
          if(e.getSource()==bt3){
              new Add_Transport_Driver().setVisible(true);
             this.setVisible(false);
          }
          if(e.getSource()==bt4){
              new SignUp().setVisible(true);
              this.setVisible(false);
          }
      }
      public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}
