package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, ministatement, fastcash, balanceenquiry, pinchange, exit, fundtransfer;
	private String pinnumber;
	
	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		
		setLayout(null);
		setTitle("AUTOMATED TELLER MACHINE");
		setSize(915,735);
		setLocation(240,0);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,700);
		add(image);
		
		JLabel text = new JLabel ("Select Withdrawl Amount");
		text.setBounds(210,230,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("100");
		deposit.setBounds(150,338,150,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("200");
		withdrawl.setBounds(150,368,150,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("500");
		fastcash.setBounds(150,398,150,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("1000");
		ministatement.setBounds(150,428,150,25);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("5000");
		pinchange.setBounds(365,338,150,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("8000");
		balanceenquiry.setBounds(365,368,150,25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		
		fundtransfer = new JButton("10000");
		fundtransfer.setBounds(365,398,150,25);
		fundtransfer.addActionListener(this);
		image.add(fundtransfer);
		
		exit = new JButton("Back");
		exit.setBounds(365,428,150,25);
		exit.addActionListener(this);
		exit.setBackground(Color.red);
		image.add(exit);
		
		JLabel t = new JLabel("Automated Teller Machine");
		t.setBounds(150,30,2000,60); 
		t.setFont(new Font("Raleway",Font.BOLD,50));
		t.setForeground(Color.white); 
		image.add(t);
		
		/*
		 * JLabel t = new JLabel("Tichkule and Tichkule IT Company");
		 * t.setBounds(30,30,2000,60); t.setFont(new Font("Raleway",Font.BOLD,50));
		 * t.setForeground(Color.white); image.add(t);
		 */
		
		
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else 
			{
				String amount = ((JButton) ae.getSource()).getText();
				Conn conn = new Conn();
				try {
					
					ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
					int balance = 0;
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
					
					if(ae.getSource() != exit && balance < Integer.parseInt(amount))
					{
						
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					
					Date date = new Date();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs."+amount+"debited successfully");
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}	
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("");
	}

}
