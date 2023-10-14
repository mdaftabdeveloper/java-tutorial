package atm.simulator.system;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, single, married;
	JDateChooser dateChooser=null;
	
	SignupOne()
	{
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L)+1000L);
		
		
		JLabel formno = new JLabel("APPLICATION FROM NO. "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(80,20,600,40);
		add(formno);
		
		JLabel persondetail = new JLabel("Page 1: Personal Details");
		persondetail.setFont(new Font("Raleway",Font.BOLD,22));
		persondetail.setBounds(220,70,600,50);
		add(persondetail);
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Raleway",Font.BOLD,18));
		name.setBounds(70,120,600,50);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300,130,300,25);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway",Font.BOLD,18));
		fname.setBounds(70,160,600,50);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300,170,300,25);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway",Font.BOLD,18));
		dob.setBounds(70,200,600,50);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,210,220,25);
		add(dateChooser);
		
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Raleway",Font.BOLD,18));
		gender.setBounds(70,240,600,50);
		add(gender);
		
		male = new JRadioButton ("Male");
		male.setBounds(300,250,100,25);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton ("Female");
		female.setBounds(400,250,100,25);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email = new JLabel("Email: ");
		email.setFont(new Font("Raleway",Font.BOLD,18));
		email.setBounds(70,280,600,50);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300,290,300,25);
		add(emailTextField);
		
		JLabel maritalstatus = new JLabel("Marital Status: ");
		maritalstatus.setFont(new Font("Raleway",Font.BOLD,18));
		maritalstatus.setBounds(70,320,600,50);
		add(maritalstatus);
		
		single = new JRadioButton ("Single");
		single.setBounds(300,330,100,25);
		single.setBackground(Color.WHITE);
		add(single);
		
		married = new JRadioButton ("Married");
		married.setBounds(400,330,100,25);
		married.setBackground(Color.WHITE);
		add(married);
		
		ButtonGroup maritalstatusgroup = new ButtonGroup();
		maritalstatusgroup.add(single);
		maritalstatusgroup.add(married);
		
		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Raleway",Font.BOLD,18));
		address.setBounds(70,360,600,50);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300,370,300,25);
		add(addressTextField);
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Raleway",Font.BOLD,18));
		city.setBounds(70,400,600,50);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300,410,300,25);
		add(cityTextField);
		
		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Raleway",Font.BOLD,18));
		state.setBounds(70,440,600,50);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300,450,300,25);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway",Font.BOLD,18));
		pincode.setBounds(70,480,600,50);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300,490,300,25);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.gray);
		next.setForeground(Color.white);
		next.setBounds(500,550,100,25);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(700,700);
		setLocation(350,10);
		setVisible(true);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		String formno = ""+random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextComponent) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected())
		{
			gender = "Male";
		}
		else if (female.isSelected())
		{
			gender = "Female";
		}
		
		String email = emailTextField.getText();
		String maritalstatus = null;
		if(single.isSelected())
		{
			maritalstatus = "Single";
		}
		else if (married.isSelected())
		{
			maritalstatus = "Married";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = "" + pincodeTextField.getText();
		
		try {
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name is Required.");
			}
			
			else if (fname.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Father's Name is Required.");
			}
			
			else if (dob.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Date of Birth is Required.");
			}
			
			else if (gender.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Gender is Required.");
			}
			
			else if (email.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Email is Required.");
			}
			
			
			 else if (maritalstatus.equals("")) { 
				 JOptionPane.showMessageDialog(null,"Marital Status is Required."); 
			}
			 
			
			else if (address.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Address is Required.");
			}
			
			else if (city.equals(""))
			{
				JOptionPane.showMessageDialog(null, "City is Required.");
			}
			
			else if (state.equals(""))
			{
				JOptionPane.showMessageDialog(null, "State is Required.");
			}
			
			else if (pincode.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Pincode is Required.");
			}
			
			else {
			
			Conn c = new Conn();
			String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalstatus+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupTwo(formno).setVisible(true);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();
	}

}
