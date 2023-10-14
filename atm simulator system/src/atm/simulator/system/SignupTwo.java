package atm.simulator.system;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
	
	String formno;
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;

	JComboBox religion, category, income, occupation, education;
	
	SignupTwo( String formno)
	{
		setLayout(null);
		
		this.formno = formno;
		
		JLabel additionaldetails = new JLabel("Page 2: Additional Details");
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionaldetails.setBounds(220,50,600,50);
		add(additionaldetails);
		
		JLabel name = new JLabel("Religion: ");
		name.setFont(new Font("Raleway",Font.BOLD,18));
		name.setBounds(70,120,600,50);
		add(name);
		
		String valreligion[] = {"Muslim","Hindu","Christian","Sikhism","Other"};
		religion = new JComboBox(valreligion);
		religion.setBounds(300,130,200,25);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		
		
		
		JLabel fname = new JLabel("Category: ");
		fname.setFont(new Font("Raleway",Font.BOLD,18));
		fname.setBounds(70,160,600,50);
		add(fname);
		
		
		String valcategory[] = {"General","OBC","SC","ST","Other"};
		category = new JComboBox(valcategory);
		category.setBounds(300,170,200,25);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel dob = new JLabel("Income: ");
		dob.setFont(new Font("Raleway",Font.BOLD,18));
		dob.setBounds(70,200,600,50);
		add(dob);
		
		String incomecategory[] = {"Null","<150000","<250000","<500000",">1000000"};
		income = new JComboBox(incomecategory);
		income.setBackground(Color.WHITE);
		income.setBounds(300,210,200,25);
		add(income);
		
		
		
		
		
		JLabel gender = new JLabel("Educational ");
		gender.setFont(new Font("Raleway",Font.BOLD,18));
		gender.setBounds(70,240,600,50);
		add(gender);
		
		JLabel email = new JLabel("Qualification: ");
		email.setFont(new Font("Raleway",Font.BOLD,18));
		email.setBounds(70,260,600,50);
		add(email);
		
		
		String educationalvalues[] = {"Non Graduate","Graduate","Post Graduate","Doctrate","Others"};
		education = new JComboBox(educationalvalues);
		education.setBackground(Color.WHITE);
		education.setBounds(300,260,200,25);
		add(education);
		
		
		
		
		JLabel maritalstatus = new JLabel("Occupation: ");
		maritalstatus.setFont(new Font("Raleway",Font.BOLD,18));
		maritalstatus.setBounds(70,300,600,50);
		add(maritalstatus);
		
		String occupationalvalues[] = {"Salaried","Self Employed","Businessman","Student","Retired","Other"};
		occupation = new JComboBox(occupationalvalues);
		occupation.setBackground(Color.WHITE);
		occupation.setBounds(300,310,200,25);
		add(occupation);
		
		JLabel address = new JLabel("PAN No: ");
		address.setFont(new Font("Raleway",Font.BOLD,18));
		address.setBounds(70,340,600,50);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300,350,200,25);
		add(pan);
		
		JLabel city = new JLabel("Aadhar No: ");
		city.setFont(new Font("Raleway",Font.BOLD,18));
		city.setBounds(70,380,600,50);
		add(city);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300,390,200,25);
		add(aadhar);
		
		JLabel state = new JLabel("Senior Citizen: ");
		state.setFont(new Font("Raleway",Font.BOLD,18));
		state.setBounds(70,420,600,50);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.white);
		syes.setBounds(300,430,70,25);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(400,430,100,25);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorcitizen = new ButtonGroup();
		seniorcitizen.add(syes);
		seniorcitizen.add(sno);
		
		JLabel pincode = new JLabel("Existing Account: ");
		pincode.setFont(new Font("Raleway",Font.BOLD,18));
		pincode.setBounds(70,460,600,50);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setBackground(Color.white);
		eyes.setBounds(300,470,70,25);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(400,470,100,25);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup existingaccount = new ButtonGroup();
		existingaccount.add(eyes);
		existingaccount.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.gray);
		next.setForeground(Color.white);
		next.setBounds(500,510,100,25);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(700,700);
		setLocation(350,10);
		setVisible(true);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		
		String seniorcitizen = null;
		if(syes.isSelected())
		{
			seniorcitizen = "Yes";
		}
		else if (sno.isSelected())
		{
			seniorcitizen = "No";
		}
		
		
		String existingaccount = null;
		if(eyes.isSelected())
		{
			existingaccount = "Yes";
		}
		else if (eno.isSelected())
		{
			existingaccount = "No";
		}
		
		String span = pan.getText();
		String saadhar = aadhar.getText();
	
		
		try {
			
			
			if (pan.equals("")) { 
				 JOptionPane.showMessageDialog(null,"PAN No. is Required."); 
			}
			 
			
			else if (aadhar.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Aadhar No. is Required.");
			}
			
			else if (existingaccount.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Existing Account Confirmation is Required.");
			}
			
			
			
			else {
			
			Conn c = new Conn();
			String query = "insert into signup2 values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");
	}

}
