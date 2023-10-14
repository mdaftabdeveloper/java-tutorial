package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login,clear,signup ;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login()
	{
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(50, 30, 100, 100);
		add(label);
		getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(250,60,400,40);
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,400,40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300,160,250,30);
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(125,220,400,40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,225,250,30);
		add(pinTextField);
		
		login = new JButton("LOGIN");
		login.setBounds(300,270,100,30);
		login.setBackground(Color.gray);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR"); 
		clear.setBounds(450,270,100,30);
		clear.setBackground(Color.gray);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		 
		signup = new JButton("SIGN UP");
		signup.setBounds(300,320,250,30);
		signup.setBackground(Color.gray);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		
		setSize(800,480);
		setVisible(true);
		setLocation(290,150);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
		}
		
		else if(ae.getSource() == signup)
		{
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		
		else if (ae.getSource()==login)
		{
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where card_number = '"+cardnumber+"' and  pin = '"+pinnumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card No. or PIN");
				}
				
			}
			catch (Exception e) {
			System.out.println(e);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
