package atm.simulator.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;
	PinChange(String pinnumber)
	{
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
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD,16));
		text.setBounds(250,250,500,35);
		image.add(text);
		
		
		JLabel pintext = new JLabel("New PIN");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("Raleway", Font.BOLD,16));
		pintext.setBounds(180,300,200,25);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,16));
		pin.setBounds(300,300,200,25);
		image.add(pin);
		
		
		JLabel repintext = new JLabel("Re-enter PIN");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("Raleway", Font.BOLD,16));
		repintext.setBounds(180,350,200,25);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,16));
		repin.setBounds(300,350,200,25);
		image.add(repin);
		
		change = new JButton("Change");
		change.setBounds(360,400,150,25);
		change.setBackground(Color.green);
		change.addActionListener(this);
		image.add(change);
		
	    back = new JButton("Back");
	    back.setBounds(150,400,150,25);
	    back.setBackground(Color.red);
	    back.setForeground(Color.white);
	    back.addActionListener(this);
		image.add(back);
		
		JLabel t = new JLabel("Automated Teller Machine");
		t.setBounds(150,30,2000,60); 
		t.setFont(new Font("Raleway",Font.BOLD,50));
		t.setForeground(Color.white); 
		image.add(t);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
			try 
			{
				
				if (ae.getSource()==change)
				{
					String npin = pin.getText();
					String rpin = repin.getText();
					
					if(!npin.equals(rpin))
					{
						JOptionPane.showMessageDialog(null, "PIN does not match.");
						pin.setText("");
						repin.setText("");
						return;
					}
					if(npin.equals(""))
					{
						JOptionPane.showMessageDialog(null, "PIN is empty.");
						return;
					}
					if(rpin.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Re-enter PIN is empty.");
						return;
					}
					
					
					Conn conn = new Conn();
					String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					conn.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "PIN changed successfully.");
					setVisible(false);
					
					new Transactions(rpin).setVisible(true);
					
				}
				else if (ae.getSource()==back)
				{
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
					
			}
				
			
			
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("");
	}

}
