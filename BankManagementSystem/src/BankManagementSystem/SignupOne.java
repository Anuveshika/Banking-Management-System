package BankManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField, fnameTextField, emailTextField, addTextField,cityTextField, stateTextField, pinTextField; 
	JDateChooser dateChooser;
	JRadioButton male, female;
	JButton next;
	
    SignupOne(){
    	
    	setLayout(null);
    	
    	Random ran = new Random();
    	random = Math.abs(ran.nextLong()%9000L + 1000L);
    	
    	JLabel formNo = new JLabel("APPLICATION FORM NO." + random);
    	formNo.setFont(new Font("Raleway", Font.BOLD,38));
    	formNo.setBounds(140, 20, 600, 40);
		add(formNo);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105,105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD,20));
		gender.setBounds(100, 290, 100, 30);
		add(gender);
		
		male = new JRadioButton("MALE");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("FEMALE");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 350, 400, 30);
		add(emailTextField);
		
		JLabel email = new JLabel("E Mail:");
		email.setFont(new Font("Raleway", Font.BOLD,20));
		email.setBounds(100, 340, 100, 30);
		add(email);
		
		addTextField = new JTextField();
		addTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addTextField.setBounds(300, 400, 400, 30);
		add(addTextField);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD,20));
		address.setBounds(100, 390, 100, 30);
		add(address);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 450, 400, 30);
		add(cityTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD,20));
		city.setBounds(100, 440, 100, 30);
		add(city);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 500, 400, 30);
		add(stateTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD,20));
		state.setBounds(100, 490, 100, 30);
		add(state);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(300, 550, 400, 30);
		add(pinTextField);
		
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway", Font.BOLD,20));
		pincode.setBounds(100, 540, 100, 30);
		add(pincode);
		
		next = new JButton("NEXT");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620, 600, 80, 30);
		next.addActionListener(this);
		add(next);

	    getContentPane().setBackground(Color.WHITE);
	    
		setSize(850, 800);
		setVisible(true);
		setLocation(350, 200);
		
	}
    public void actionPerformed(ActionEvent ae) {
    	String formno ="" + random; //long to string
    	String name = nameTextField.getText();
        String fname =  fnameTextField.getText();
       String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    	String gender = null;
    	if(male.isSelected()) {
    		gender = "Male";
    	} else if(female.isSelected()) {
    		gender = "Female";
    	}
        String email = emailTextField.getText();
        String address = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText(); 

    	try {
    		if(name.equals("")) {
    			JOptionPane.showMessageDialog(null, "Name is required");
    		} else {
    			Conn c = new Conn();
    			String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
    		    c.s.executeUpdate(query);
    		    
    		    setVisible(false);
    		    new SignupTwo(formno).setVisible(true);
    		}
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
	
	public static void main(String args[]) {
		new SignupOne();
	}

}
