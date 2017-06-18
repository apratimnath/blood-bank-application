import datacon.*;
import java.io.*;
import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainBloodBank
{
public static void main (String args[]) throws IOException
{
BloodBankTitle bbt = new BloodBankTitle ();
bbt.setVisible (true);

try
{
Thread.sleep (10000);
}
catch (Exception e)
{
System.out.println (e);
}
bbt.setVisible (false);

BloodBankFrame bbf = new BloodBankFrame ();
bbf.setVisible (true);
}
}