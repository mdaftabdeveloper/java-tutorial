package atm.simulator.system;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	Long random;
	String formno;
	SignupThree( String formno )
	{
		this.formno = formno;
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setSize(700,700);
		setLocation(350,10);
		setVisible(true);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD,22));
		l1.setBounds(220,40,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD,18));
		type.setBounds(100,125,400,40);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBounds(300,100,150,50);
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBounds(450,100,250,50);
		r2.setBackground(Color.white);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setBounds(300,150,150,50);
		r3.setBackground(Color.white);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBounds(450,150,250,50);
		r4.setBackground(Color.white);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD,18));
		card.setBounds(100,200,400,40);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-7277");
		number.setFont(new Font("Raleway", Font.BOLD,18));
		number.setBounds(300,200,400,40);
		add(number);
		
		JLabel carddetail = new JLabel("(Your 16 Digit Card Number)");
		carddetail.setFont(new Font("Raleway", Font.BOLD,12));
		carddetail.setBounds(330,220,400,40);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD,18));
		pin.setBounds(100,270,400,40);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD,18));
		pnumber.setBounds(300,270,400,40);
		add(pnumber);
		
		JLabel pindetail = new JLabel("(Your 4 Digit PIN)");
		pindetail.setFont(new Font("Raleway", Font.BOLD,12));
		pindetail.setBounds(370,270,400,40);
		add(pindetail);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD,18));
		services.setBounds(100,340,400,40);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway", Font.BOLD, 12));
		c1.setBounds(300, 340, 150, 50);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway", Font.BOLD, 12));
		c2.setBounds(450, 340, 400, 50);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway", Font.BOLD, 12));
		c3.setBounds(300, 380, 150, 50);
		add(c3);
		
		c4 = new JCheckBox("Email Alert and SMS Alert");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway", Font.BOLD, 12));
		c4.setBounds(450, 380, 400, 50);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway", Font.BOLD, 12));
		c5.setBounds(300, 420, 150, 50);
		add(c5);
		
		c6 = new JCheckBox("E Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway", Font.BOLD, 12));
		c6.setBounds(450, 420, 400, 50);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details are correct to my best knowledge.");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 460, 800, 50);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.green);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(500,530,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(380,530,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getSource() == submit)
		{
			String accountType = null;
			if(r1.isSelected())
			{
				accountType = "Saving Account";
			}
			else if(r2.isSelected())
			{
				accountType = "Fixed Deposit Account";
			}
			else if(r3.isSelected())
			{
				accountType = "Current Account";
			}
			else if (r4.isSelected())
			{
				accountType = "Reccuring Deposit Account";
			}
			
			Random ran = new Random();
			
			
			String cardnumber = ""+ Math.abs((ran.nextLong() % 90000000L)) + 72774246L;
			
			String pinnumber= ""+ Math.abs((ran.nextLong() % 9000L) + 1000L);
			
			String facility ="";
			if(c1.isSelected())
			{
				facility = facility + " ATM Card";
			}
			if (c2.isSelected())
			{
				facility = facility + " Internet Banking";
			}
			if (c3.isSelected())
			{
				facility = facility + " Mobile Banking";
			}
			if (c4.isSelected())
			{
				facility = facility+ " SMS & Email Alerts";
			}
			if (c5.isSelected())
			{
				facility = facility + " Cheque Book";
			}
			if (c6.isSelected())
			{
				facility = facility + " E Statement";
			}
			if(c7.equals(null))
			{
				JOptionPane.showMessageDialog(null, "Please check the declaration box.");
			}
			
			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				
				else {
					Conn conn = new Conn();
					//String formno;
					String query1 = "insert into signup3 values ('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
					conn.s.executeUpdate(query1);
					
					String query2 = "insert into login values ('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: "+ pinnumber);
					setVisible(false);
					
					new Deposit(pinnumber).setVisible(true);
				}
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
		
		else if (ae.getSource() == cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupThree("");
	}

}
