package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, ministatement, fastcash, balanceenquiry, pinchange, exit, back;
	private String pinnumber;
	
	Transactions(String pinnumber) {
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
		
		JLabel text = new JLabel ("Please select your transaction");
		text.setBounds(210,230,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(150,338,150,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(365,338,150,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(150,398,150,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(365,398,150,25);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("PIN Change");
		pinchange.setBounds(150,368,150,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(365,368,150,25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		
		back = new JButton("Back");
		back.setBounds(150,428,150,25);
		back.addActionListener(this);
		image.add(back);
		
		exit = new JButton("Exit");
		exit.setBounds(365,428,150,25);
		exit.addActionListener(this);
		image.add(exit);
		
		
		JLabel t = new JLabel("Automated Teller Machine");
		t.setBounds(150,30,2000,60); 
		t.setFont(new Font("Raleway",Font.BOLD,50));
		t.setForeground(Color.white); 
		image.add(t);
		
		
		
		 
		
		
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==deposit)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		else if (ae.getSource()== withdrawl)
			{
				setVisible(false);
				new Withdrawal(pinnumber).setVisible(true);
			}
		else if(ae.getSource()== fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==balanceenquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==ministatement)
		{
			setVisible(false);
			new MiniStatement(pinnumber).setVisible(true);
		}
		else if (ae.getSource()==back)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");
	}

}
