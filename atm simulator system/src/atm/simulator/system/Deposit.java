package atm.simulator.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	JButton deposit, cancel;
	JTextField amount;
	String pinnumber;
	

	Deposit(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
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
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setBackground(Color.white);
		text.setForeground(Color.white);
		text.setBounds(190,230,700,35);
		text.setFont(new Font("Raleway", Font.BOLD,16));
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(230,280,200,30);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(360,338,150,25);
		deposit.setBackground(Color.green);
		deposit.addActionListener(this);
		image.add(deposit);
		
	    cancel = new JButton("Back");
		cancel.setBounds(150,338,150,25);
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		image.add(cancel);
		
		JLabel t = new JLabel("Automated Teller Machine");
		t.setBounds(150,30,2000,60); 
		t.setFont(new Font("Raleway",Font.BOLD,50));
		t.setForeground(Color.white); 
		image.add(t);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==deposit)
		{
			
			String number = amount.getText();
			Date date = new Date();
			
			//Calendar myCalendar = new GregorianCalendar();
			//Date myDate = (Date) myCalendar.getTime();
			
			//LocalDate date = LocalDate.parse();
			
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
			}
			else {
				try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs."+number+" deposited successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
					}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
			
		}
		else if(ae.getSource()==cancel)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("");
	}

}
