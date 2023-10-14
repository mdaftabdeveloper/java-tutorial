package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber)
	{
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		setLayout(null);
		setTitle("AUTOMATED TELLER MACHINE");
		setSize(915,735);
		setLocation(240,0);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		back = new JButton("Back");
		back.setBounds(150,400,150,25);
		back.addActionListener(this);
		image.add(back);
		
		JLabel t = new JLabel("Automated Teller Machine");
		t.setBounds(150,30,2000,60); 
		t.setFont(new Font("Raleway",Font.BOLD,50));
		t.setForeground(Color.white); 
		image.add(t);
		
		Conn conn = new Conn();
		int balance = 0;
		
		try
		{
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balance += Integer.parseInt (rs.getString("amount"));
				}
				else 
				{
					balance -= Integer.parseInt (rs.getString("amount"));
				}
			}
		}
		catch (Exception e )
		{
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current balance is Rs. "+balance);
		text.setForeground(Color.white);
		text.setBounds(180,300,500,25);
		text.setFont(new Font ("Raleway", Font.BOLD,20));
		image.add(text);
	}	
		
	public void actionPerformed (ActionEvent ae)
	{
		setVisible(false);
		
		new Transactions(pinnumber).setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("");
	}

}
