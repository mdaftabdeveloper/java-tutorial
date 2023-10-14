package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{
	
	MiniStatement(String pinnumber)
	{
		setLayout(null);
		
		setTitle("Mini Statement");
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("Canara Bank");
		bank.setBounds(140,20,100,30);
		bank.setFont(new Font("Raleway",Font.BOLD,16));
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		
		try 
		{
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			
			while (rs.next())
			{
				card.setText("Card Number:   " + rs.getString("card_number").substring(0,4) + ("XXXXXXXX") +  rs.getString("card_number").substring(12) );
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		try 
		{
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next())
			{
				mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br>"+"<html>");
				if(rs.getString("type").equals("Deposit"))
				{
					bal += Integer.parseInt (rs.getString("amount"));
				}
				else 
				{
					bal -= Integer.parseInt (rs.getString("amount"));
				}
			}
			balance.setText("Available Balance : "+ bal);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("");
	}

}
