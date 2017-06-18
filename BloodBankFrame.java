import datacon.*;
import java.io.*;
import java.util.Date;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class BloodBankFrame extends JFrame implements ActionListener,ItemListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
Choice ch1,ch2;
JMenuBar mb;
JMenu m1,m2,m3,m4,m5,m6,m7,m8;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15;
JPanel p1,p2,p3,p4,p5,p6,p7;
String k=null;
int x=0;
int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0,a7=0,a8=0,a9=0,a10=0,a11=0,a12=0,a13=0,a14=0,a15=0,a16=0;
String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s8=null;
FileDialog fd;

FileWriter fw = null;
SimpleDateFormat dateformat;
Date date;

ResultSet rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11,rs12,rs13;

BloodSql bs;

public BloodBankFrame ()
{
bs = new BloodSql ();
bs.setVisible (true);

try
{
Thread.sleep (10000);
}
catch (Exception e)
{
System.out.println (e);
}
bs.setVisible (false);

try
{
rs1 = bs.show ("select * from donordetails");
rs2 = bs.show ("select * from blooddetails");
}
catch (Exception e)
{
System.out.println (e);
}

setLayout (new GridLayout (7,1));
setBackground (new Color (222,184,135));
setSize (900,900);
setTitle ("Blood Bank Management System");

mb = new JMenuBar ();
setJMenuBar (mb);

m1 = new JMenu ("File");mb.add (m1);
m2 = new JMenu ("Search");mb.add (m2);
m3 = new JMenu ("Insert");mb.add (m3);
m4 = new JMenu ("Token");mb.add (m4);
m5 = new JMenu ("Database");mb.add (m5);
m6 = new JMenu ("Help");mb.add (m6);

mi1 = new JMenuItem ("Open");m1.add (mi1);mi1.addActionListener (this);
mi2 = new JMenuItem ("Save");m1.add (mi2);
mi3 = new JMenuItem ("Save As");m1.add (mi3);mi3.addActionListener (this);
mi4 = new JMenuItem ("Exit");m1.add (mi4);mi4.addActionListener (this);

m7 = new JMenu ("Donor");m2.add(m7);
mi5 = new JMenuItem ("By ID");m7.add (mi5);mi5.addActionListener (this);
mi6 = new JMenuItem ("By Name");m7.add (mi6);mi6.addActionListener (this);
m8 = new JMenu ("Blood");m2.add(m8);
mi7 = new JMenuItem ("By Blood Group");m8.add (mi7);mi7.addActionListener (this);

mi8 = new JMenuItem ("New Donor");m3.add (mi8);mi8.addActionListener (this);
mi9 = new JMenuItem ("New Blood Group");m3.add (mi9);

mi10 = new JMenuItem ("Create");m4.add (mi10);mi10.addActionListener (this);

mi11 = new JMenuItem ("Database Connectivity");m5.add (mi11);
mi12 = new JMenuItem ("Database Name");m5.add (mi12);
mi13 = new JMenuItem ("View Entire Database");m5.add (mi13);

mi14 = new JMenuItem ("Help Topics");m6.add (mi14);
mi15 = new JMenuItem ("About System");m6.add (mi15);

p1 = new JPanel ();
p1.setVisible (false);
p1.setLayout (new FlowLayout());
p1.setBackground (new Color (210,105,30));
l1 = new JLabel ("Enter Blood Group");p1.add(l1);
t1 = new JTextField (20); p1.add(t1);
l1.setHorizontalAlignment(JLabel.CENTER);
l1.setFont (new Font ("Times New Roman",Font.BOLD,25));
b1 = new JButton ("Search Blood Database");p1.add(b1);b1.addActionListener (this);
b2 = new JButton ("Clear");p1.add(b2);b2.addActionListener (this);
add (p1,BorderLayout.CENTER);

p2 = new JPanel ();
p2.setVisible (false);
p2.setLayout (new FlowLayout());
p2.setBackground (new Color (255,255,240));
l2 = new JLabel ("Blood ID");p2.add(l2);
l2.setHorizontalAlignment(JLabel.CENTER);
l2.setFont (new Font ("Times New Roman",Font.BOLD,25));
t2 = new JTextField (10); p2.add(t2);
l3 = new JLabel ("Blood Group");p2.add(l3);
l3.setHorizontalAlignment(JLabel.CENTER);
l3.setFont (new Font ("Times New Roman",Font.BOLD,25));
t3 = new JTextField (10); p2.add(t3);
l4 = new JLabel ("Quantity of Blood");p2.add(l4);
l4.setHorizontalAlignment(JLabel.CENTER);
l4.setFont (new Font ("Times New Roman",Font.BOLD,25));
t4 = new JTextField (10); p2.add(t4);
add (p2,BorderLayout.CENTER);

p3 = new JPanel ();
p3.setVisible (true);
p3.setLayout (new FlowLayout());
p3.setBackground (new Color (30,144,255));
l15 = new JLabel ("Welcome to the System.");p3.add(l15);
l15.setHorizontalAlignment(JLabel.CENTER);
l15.setFont (new Font ("Times New Roman",Font.BOLD,60));
add (p3,BorderLayout.CENTER);

p4 = new JPanel ();
p4.setVisible (false);
p4.setLayout (new FlowLayout());
p4.setBackground (new Color (240,128,128));
l5 = new JLabel ("Enter Donor's ID");p4.add(l5);
l5.setHorizontalAlignment(JLabel.CENTER);
l5.setFont (new Font ("Times New Roman",Font.BOLD,25));
t5 = new JTextField (20); p4.add(t5);
b3 = new JButton ("Search Donor by ID");p4.add(b3);b3.addActionListener (this);
b4 = new JButton ("Clear");p4.add(b4);b4.addActionListener (this);
add (p4,BorderLayout.CENTER);

p5 = new JPanel ();
p5.setVisible (false);
p5.setLayout (new FlowLayout());
p5.setBackground (new Color (255,228,181));
l6 = new JLabel ("Enter Donor's Name");p5.add(l6);
l6.setHorizontalAlignment(JLabel.CENTER);
l6.setFont (new Font ("Times New Roman",Font.BOLD,25));
t6 = new JTextField (20); p5.add(t6);
b5 = new JButton ("Search Donor by Name");p5.add(b5);b5.addActionListener (this);
b6 = new JButton ("Clear");p5.add(b6);b6.addActionListener (this);
add (p5,BorderLayout.CENTER);

p6 = new JPanel ();
p6.setVisible (false);
p6.setLayout (new FlowLayout());
p6.setBackground (new Color (210,180,140));
l7 = new JLabel ("Donor ID");p6.add(l7);
l7.setHorizontalAlignment(JLabel.CENTER);
l7.setFont (new Font ("Times New Roman",Font.BOLD,25));
t7 = new JTextField (10); p6.add(t7);
l8 = new JLabel ("Donor Name");p6.add(l8);
l8.setHorizontalAlignment(JLabel.CENTER);
l8.setFont (new Font ("Times New Roman",Font.BOLD,25));
t8 = new JTextField (20); p6.add(t8);
l9 = new JLabel ("Gender");p6.add(l9);
l9.setHorizontalAlignment(JLabel.CENTER);
l9.setFont (new Font ("Times New Roman",Font.BOLD,25));
t9 = new JTextField (20); p6.add(t9);
ch1 = new Choice ();
ch1.add ("Male");
ch1.add ("Female");
ch1.add ("Others");
p6.add (ch1);ch1.addItemListener (this);
l10 = new JLabel ("Age");p6.add(l10);
l10.setHorizontalAlignment(JLabel.CENTER);
l10.setFont (new Font ("Times New Roman",Font.BOLD,25));
t10 = new JTextField (20); p6.add(t10);
l11 = new JLabel ("Parent's Name");p6.add(l11);
l11.setHorizontalAlignment(JLabel.CENTER);
l11.setFont (new Font ("Times New Roman",Font.BOLD,25));
t11 = new JTextField (20); p6.add(t11);
l12 = new JLabel ("Blood Group");p6.add(l12);
l12.setHorizontalAlignment(JLabel.CENTER);
l12.setFont (new Font ("Times New Roman",Font.BOLD,25));
t12 = new JTextField (10); p6.add(t12);
ch2 = new Choice ();
ch2.add ("A+");
ch2.add ("A-");
ch2.add ("B+");
ch2.add ("B-");
ch2.add ("AB+");
ch2.add ("AB-");
ch2.add ("O+");
ch2.add ("O-");
ch2.add ("H");
p6.add (ch2);ch2.addItemListener (this);
l13 = new JLabel ("Blood Pressure");p6.add(l13);
l13.setHorizontalAlignment(JLabel.CENTER);
l13.setFont (new Font ("Times New Roman",Font.BOLD,25));
t13 = new JTextField (10); p6.add(t13);
l14 = new JLabel ("Donating Times");p6.add(l14);
l14.setHorizontalAlignment(JLabel.CENTER);
l14.setFont (new Font ("Times New Roman",Font.BOLD,25));
t14 = new JTextField (10); p6.add(t14);
b7 = new JButton ("Update");p6.add(b7);b7.addActionListener (this);
b8 = new JButton ("Generate Token");p6.add(b8);b8.addActionListener (this);
b9 = new JButton ("Clear");p6.add(b9);b9.addActionListener (this);
add (p6,BorderLayout.CENTER);

p7 = new JPanel ();
p7.setVisible (true);
p7.setLayout (new FlowLayout());
p7.setBackground (new Color (255,228,196));
l16 = new JLabel ("Last Operation Status");p7.add(l16);
l16.setHorizontalAlignment(JLabel.CENTER);
l16.setFont (new Font ("Times New Roman",Font.BOLD,20));
t15 = new JTextField (20);p7.add(t15);
add (p7,BorderLayout.CENTER);
}

public void actionPerformed (ActionEvent ae)
{
k = ae.getActionCommand ();

if (k.equals("Open"))
{
fd = new FileDialog (this,"Open",0);
fd.show ();
}

if (k.equals("Save As"))
{
fd = new FileDialog (this,"Save",1);
fd.show();
}

if (k.equals("Exit"))
{
System.exit (0);
}

if (k.equals("By ID"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (true);
p5.setVisible (false);
p6.setVisible (false);
}

if (k.equals("By Name"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (true);
p6.setVisible (false);
}

if (k.equals("By Blood Group"))
{
p1.setVisible (true);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (false);
}

if (k.equals("New Donor"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (true);

a2 =1;

try
{
rs7 = bs.show ("select * from blooddata.donordetails");
rs7.last();
a6=rs7.getInt(1) + 1;

t7.setText (""+a6);
}
catch (Exception e)
{
System.out.println (e);
}
}

if (k.equals("Create"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (true);
}

if (k.equals("Search Blood Database"))
{
p1.setVisible (false);
p2.setVisible (true);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (false);

try
{
rs5 = bs.searchBloodGroup (t1.getText());
rs5.next();

t2.setText (""+rs5.getInt (1));
t3.setText (rs5.getString (2));
t4.setText (""+rs5.getInt (3));

t15.setText ("Query Successful.");
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Query Failed.");
}
}

if (k.equals("Search Donor by ID"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (true);

try
{
rs3 = bs.searchDonorID (Integer.parseInt (t5.getText()));
rs3.next();

t7.setText (""+rs3.getInt (1));
t8.setText (rs3.getString (2));
t9.setText (rs3.getString (3));
t10.setText (""+rs3.getInt (4));
t11.setText (rs3.getString (5));
t12.setText (rs3.getString (6));
t13.setText (rs3.getString (7));
t14.setText (""+rs3.getInt (8));

t15.setText ("Query Successful.");
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Query Failed.");
}
}

if (k.equals("Search Donor by Name"))
{
p1.setVisible (false);
p2.setVisible (false);
p4.setVisible (false);
p5.setVisible (false);
p6.setVisible (true);

try
{
rs4 = bs.searchDonorName (t6.getText());
rs4.next();

t7.setText (""+rs4.getInt (1));
t8.setText (rs4.getString (2));
t9.setText (rs4.getString (3));
t10.setText (""+rs4.getInt (4));
t11.setText (rs4.getString (5));
t12.setText (rs4.getString (6));
t13.setText (rs4.getString (7));
t14.setText (""+rs4.getInt (8));

t15.setText ("Query Successful.");
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Query Failed.");
}
}

if (k.equals("Update"))
{
if (a2==1)
{
try
{
a1 = bs.insertDonorDetails (Integer.parseInt (t7.getText()),t8.getText(),t9.getText(),Integer.parseInt (t10.getText()),t11.getText(),t12.getText(),t13.getText(),Integer.parseInt (t14.getText()));

t15.setText ("Donor Inserted & Bloodbank Updated.");

rs11 = bs.searchDonorID (Integer.parseInt(t7.getText()));
rs11.next();

a12=rs11.getInt(8);

rs12=bs.searchBloodGroup (t12.getText());
rs12.next();

a13=rs12.getInt(3);

a14 = a12+a13;

rs13=bs.getBloodID (t12.getText());
rs13.next();

a15=rs13.getInt(1);

a16 = bs.updateBloodGroup (a15,a14);
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Insertion Failed.");
}
}

else
{
try
{
rs8 = bs.searchDonorID (Integer.parseInt(t7.getText()));
rs8.next();

a7=rs8.getInt(8);

a5 = bs.updateDonorDetails (Integer.parseInt(t7.getText()),Integer.parseInt(t14.getText()));

t15.setText ("Current Donor & Bloodbank Updated.");

rs9 = bs.searchDonorID (Integer.parseInt(t7.getText()));
rs9.next();

a8=rs9.getInt(8);

a9 = a8 - a7;

rs10 = bs.searchBloodGroup (t12.getText());
rs10.next();

a10=rs10.getInt(3);

a11=a10+a9;

rs5=bs.getBloodID (t12.getText());
rs5.next();

a3=rs5.getInt(1);

a4 = bs.updateBloodGroup (a3,a11);
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Updation Failed.");
}
}
a2=0;
}

if (k.equals("Generate Token"))
{
dateformat = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
date = new Date( );

s1 = t7.getText();
s2 = t8.getText();
s3 = t9.getText();
s4 = t10.getText();
s5 = t11.getText();
s6 = t12.getText();
s7 = t13.getText();
s8 = t14.getText();

try
{
fw = new FileWriter ("E:\\Token - "+s2+".txt");

fw.write (dateformat.format(date));
fw.write ("\r\n");
fw.write ("\r\n");
fw.write ("----------------------------------------------");
fw.write ("\r\n");
fw.write ("Donor ID : ");
fw.write (s1);
fw.write ("\r\n");
fw.write ("Donor's Name : ");
fw.write (s2);
fw.write ("\r\n");
fw.write ("Gender : ");
fw.write (s3);
fw.write ("\r\n");
fw.write ("Age : ");
fw.write (s4);
fw.write ("\r\n");
fw.write ("Donor's Parent Name : ");
fw.write ("Mr." + s5);
fw.write ("\r\n");
fw.write ("Donor's Blood Group : ");
fw.write (s6);
fw.write ("\r\n");
fw.write ("Donor's Blood Pressure : ");
fw.write (s7);
fw.write ("\r\n");
fw.write ("Number of times donated blood : ");
fw.write (s8);
fw.write ("\r\n");
fw.write ("----------------------------------------------");
fw.write ("\r\n");
fw.write ("\r\n");
fw.write ("\r\n");
fw.write ("Authorized Signature -");
fw.write ("\r\n");
fw.write ("Stamp -");

fw.flush();

t15.setText ("Token Generated.");
}
catch (Exception e)
{
System.out.println (e);
t15.setText ("Token Generation Failed.");
}
}

if (k.equals("Clear"))
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
t12.setText("");
t13.setText("");
t14.setText("");
}

}

public void itemStateChanged (ItemEvent ie)
{
t9.setText (ch1.getSelectedItem());
t12.setText (ch2.getSelectedItem());
}
}