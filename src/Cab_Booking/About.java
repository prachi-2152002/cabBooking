/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;

/**
 *
 * @author india
 */
public class About extends JFrame{
  JPanel p1,p2;
  JLabel l1,l2;
    
  Font f,f1;
   About() {
        super("About Cab Booking Project");
        setLocation(450, 50);
        setSize(450,400);
        
        f=new Font("Arial",Font.BOLD,30);
        f1=new Font("Arial",Font.BOLD,8);
        
        l1=new JLabel("About Cab Booking Project");
        l1.setFont(f);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l2=new JLabel();
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/intro.jpg"));
        Image img=ic.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l2.setIcon(ic1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l2);
        
        setLayout(new BorderLayout(20,20));
        add(p1,"North");
        add(p2,"Center");
    }
    public static void main(String[] args) {
        new About().setVisible(true);
    }

    
}
