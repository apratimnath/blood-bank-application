import datacon.*;
import java.io.*;
import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class BloodBankTitle extends JFrame
{
JPanel p1,p2,p3;
JLabel l1,l2,l3,l4,l5;

public BloodBankTitle ()
{
setSize (600,400);
setUndecorated (true);
setExtendedState (MAXIMIZED_BOTH);
setBackground (Color.gray);

p1 = new JPanel ();
p1.setVisible (true);
p1.setLayout (new FlowLayout ());
p1.setBackground (new Color (123,145,124));
l1 = new JLabel ("Welcome to Blood Bank Management System.");p1.add (l1);
l1.setHorizontalAlignment(JTextField.CENTER);
l1.setFont (new Font ("Times New Roman",Font.BOLD,65));
add (p1,BorderLayout.NORTH);

p2 = new JPanel ();
p2.setVisible (true);
p2.setLayout (new FlowLayout ());
p2.setBackground (Color.cyan);
l2 = new JLabel ("Made With Love by - Apratim, Sagar, Souvik, Soumik,Abir and Pooja.");p2.add (l2);
l2.setHorizontalAlignment(JTextField.CENTER);
l2.setFont (new Font ("Times New Roman",Font.ITALIC,30));
add (p2,BorderLayout.SOUTH);

p3 = new JPanel ();
p3.setVisible (true);
p3.setLayout (new FlowLayout ());
p3.setBackground (Color.lightGray);
l3 = new JLabel ("A one stop solution for your Blood Bank management problems.");p3.add (l3);
l3.setHorizontalAlignment(JLabel.CENTER);
l3.setFont (new Font ("Times New Roman",Font.BOLD,40));
l5 = new JLabel (new ImageIcon ("E:\\Blood Bank Logo.jpg"));p3.add(l5);
l5.setHorizontalAlignment(JLabel.CENTER);
l4 = new JLabel ("© Techno India University, Entrepreneurship Skills Development Project - 2017,All Rights Reserved.");p3.add (l4);
l4.setHorizontalAlignment(JLabel.CENTER);
l4.setFont (new Font ("Times New Roman",Font.BOLD,30));
add (p3,BorderLayout.CENTER);
}
}