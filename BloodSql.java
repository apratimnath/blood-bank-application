package datacon;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class BloodSql extends JFrame implements ActionListener
{
Connection con;
Statement st;
PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7;
ResultSet rs1,rs2,rs3,rs4,rs5;
int port = 0;
String k = null;
String schemaname = null;
String username = null;
String password = null;
int i=0,j=0,l=0;

JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4,t5;
JButton b1,b2,b3,b4,b5;
TitledBorder tb1,tb2;
JPanel p1,p2;

public BloodSql ()
{
setSize (500,500);
setUndecorated (true);
setExtendedState (MAXIMIZED_BOTH);
setLayout (new GridLayout (2,1));
setBackground (new Color (255,228,225));

p1 = new JPanel ();
p1.setVisible (true);
p1.setLayout (new FlowLayout());
p1.setBackground (new Color (250,128,114));
tb1 = new TitledBorder ("Connectivity Options");p1.setBorder (tb1);
b1 = new JButton ("Pre-established Connection");p1.add (b1);b1.addActionListener (this);
b2 = new JButton ("New Connection");p1.add (b2);b2.addActionListener (this);
add (p1,BorderLayout.NORTH);

p2 = new JPanel ();
p2.setVisible (false);
p2.setLayout(new FlowLayout());
p2.setBackground (new Color (135,206,250));
tb2 = new TitledBorder ("Database Credentials");p2.setBorder (tb2);
l1 = new JLabel ("Port Number");p2.add (l1);
l1.setHorizontalAlignment(JLabel.CENTER);
l1.setFont (new Font ("Times New Roman",Font.BOLD,25));
t1 = new JTextField (10);p2.add(t1);
l2 = new JLabel ("Schema Name");p2.add (l2);
l2.setHorizontalAlignment(JLabel.CENTER);
l2.setFont (new Font ("Times New Roman",Font.BOLD,25));
t2 = new JTextField (20);p2.add(t2);
l3 = new JLabel ("Username");p2.add (l3);
l3.setHorizontalAlignment(JLabel.CENTER);
l3.setFont (new Font ("Times New Roman",Font.BOLD,25));
t3 = new JTextField (20);p2.add(t3);
l4 = new JLabel ("Password");p2.add (l4);
l4.setHorizontalAlignment(JLabel.CENTER);
l4.setFont (new Font ("Times New Roman",Font.BOLD,25));
t4 = new JTextField (20);p2.add(t4);
b3 = new JButton ("Connect");p2.add (b3);b3.addActionListener (this);
b4 = new JButton ("Clear");p2.add (b4);b4.addActionListener (this);
b5 = new JButton ("Abort");p2.add (b5);b5.addActionListener (this);
l5 = new JLabel ("Message");p2.add(l5);
l5.setHorizontalAlignment(JLabel.CENTER);
l5.setFont (new Font ("Times New Roman",Font.BOLD,35));
t5 = new JTextField (20);p2.add(t5);
add (p2,BorderLayout.SOUTH);
}

public void actionPerformed (ActionEvent ae)
{
k = ae.getActionCommand ();

if (k.equals("Pre-established Connection"))
{
p1.setVisible (false);
p2.setVisible (true);

t1.setText ("3306");
t2.setText ("blooddata");
t3.setText("root");
t4.setText("apratim");
}

if (k.equals("New Connection"))
{
p1.setVisible (false);
p2.setVisible (true);
}

if (k.equals("Connect"))
{
port = Integer.parseInt (t1.getText());
schemaname = t2.getText();
username = t3.getText();
password = t4.getText();

try
{
Class.forName ("com.mysql.jdbc.Driver");
con = DriverManager.getConnection ("jdbc:mysql://localhost:" + port + "/" + schemaname + "?user=" + username + "&password=" + password);

st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

t5.setText ("Connection succesful.");
}

catch (Exception e)
{
System.out.println (e);
}
}

if (k.equals("Clear"))
{
t1.setText ("");
t2.setText ("");
t3.setText("");
t4.setText("");
t5.setText("");
}

if (k.equals("Abort"))
{
t5.setText ("Aborting.");

System.exit(0);
}
}

public ResultSet show (String s1)
{
try
{
rs1 = st.executeQuery (s1);
}
catch (Exception e)
{
System.out.println (e);
}

return (rs1);

}

public ResultSet searchDonorID (int did)
{
try
{
ps1 = con.prepareStatement ("select * from donordetails where DonorID=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ps1.setInt (1,did);
rs2 = ps1.executeQuery();
}
catch (Exception e)
{
System.out.println (e);
}

return (rs2);
}

public ResultSet searchDonorName (String name)
{
try
{
ps2 = con.prepareStatement ("select * from donordetails where DonorName = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ps2.setString (1,name);
rs3= ps2.executeQuery();

}
catch (Exception e)
{
System.out.println (e);
}

return (rs3);
}

public ResultSet searchBloodGroup (String bgroup)
{
try
{
ps3 = con.prepareStatement ("select * from blooddata.blooddetails where BloodGroup = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ps3.setString (1,bgroup);
rs4= ps3.executeQuery();
}
catch (Exception e)
{
System.out.println (e);
}

return (rs4);
}

public ResultSet getBloodID (String gblgroup)
{
try
{
ps5 = con.prepareStatement ("select BloodID from blooddata.blooddetails where BloodGroup = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ps5.setString (1,gblgroup);
rs5=ps5.executeQuery();
}
catch (Exception e)
{
System.out.println (e);
} 

return (rs5);
}

public int updateBloodGroup (int uid,int utime)
{
try
{
ps6 = con.prepareStatement ("update blooddata.blooddetails set Quantity = ? where BloodID = ?");

ps6.setInt (1,utime);
ps6.setInt (2,uid);

j=ps6.executeUpdate();
}
catch (Exception e)
{
System.out.println (e);
}

return (j);
}

public int insertDonorDetails (int id,String name,String gender,int age,String parent,String blgroup,String bpressure,int time)
{
try
{
ps4 = con.prepareStatement ("insert into donordetails values (?,?,?,?,?,?,?,?)");

ps4.setInt (1,id);
ps4.setString (2,name);
ps4.setString (3,gender);
ps4.setInt (4,age);
ps4.setString (5,parent);
ps4.setString (6,blgroup);
ps4.setString (7,bpressure);
ps4.setInt (8,time);

i = ps4.executeUpdate();
}
catch (Exception e)
{
System.out.println (e);
}

return (i);
}

public int updateDonorDetails (int udid,int udtime)
{
try
{
ps7 = con.prepareStatement ("update blooddata.donordetails set DonateTime = ? where DonorID = ?");

ps7.setInt (1,udtime);
ps7.setInt (2,udid);

l = ps7.executeUpdate();
}
catch (Exception e)
{
System.out.println (e);
}

return (l);
}

}