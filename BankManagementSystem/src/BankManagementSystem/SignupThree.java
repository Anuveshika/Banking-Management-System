package BankManagementSystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;
	
	SignupThree(String formno){
		this.formno = formno;
		setLayout(null);
		
		JLabel label3 = new JLabel("Page 3: Account Details");
		label3.setFont(new Font("Raleway", Font.BOLD,28));
		label3.setBounds(280, 40, 400, 40);
		add(label3);
		
		JLabel accountType = new JLabel("Account Type:");
		accountType.setFont(new Font("Raleway", Font.BOLD,20));
		accountType.setBounds(100, 140, 200, 30);
		add(accountType);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBounds(100, 180,250, 20);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Current Account");
		r2.setBounds(350, 180,250, 20);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		r3 = new JRadioButton("Fixed Deposit Account");
		r3.setBounds(100, 220,250, 20);
		r3.setBackground(Color.WHITE);
		add(r3);
		
		r4 = new JRadioButton("Recurring Account");
		r4.setBounds(350, 220,250, 20);
		r4.setBackground(Color.WHITE);
		add(r4);
		
		ButtonGroup accGroup = new ButtonGroup();
		accGroup.add(r1);
		accGroup.add(r2);
		accGroup.add(r3);
		accGroup.add(r4);
		
		JLabel cardNumber = new JLabel("Card Number:");
		cardNumber.setFont(new Font("Raleway", Font.BOLD,20));
		cardNumber.setBounds(100, 260, 200, 30);
		add(cardNumber);
		
		JLabel sampleNumber = new JLabel("XXXX-XXXX-XXXX-XXXX");
		sampleNumber.setFont(new Font("Raleway", Font.BOLD,20));
		sampleNumber.setBounds(350, 260, 400, 30);
		add(sampleNumber);
		
		JLabel details = new JLabel("Your 16-Digit Card Number");
		details.setFont(new Font("Raleway", Font.BOLD,12));
		details.setBounds(100, 290, 200, 20);
		add(details);
		
		JLabel pinNumber = new JLabel("PIN:");
		pinNumber.setFont(new Font("Raleway", Font.BOLD,20));
		pinNumber.setBounds(100, 320, 200, 30);
		add(pinNumber);
		
		JLabel pNumber = new JLabel("XXXX");
		pNumber.setFont(new Font("Raleway", Font.BOLD,20));
		pNumber.setBounds(350, 320, 400, 30);
		add(pNumber);
		
		JLabel pdetails = new JLabel("Your 4-Digit PIN");
		pdetails.setFont(new Font("Raleway", Font.BOLD,12));
		pdetails.setBounds(100, 350, 200, 20);
		add(pdetails);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD,20));
		services.setBounds(100, 390, 200, 30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Raleway", Font.BOLD,16));
		c1.setBounds(100, 430,250, 20);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("Mobile Banking");
		c2.setFont(new Font("Raleway", Font.BOLD,16));
		c2.setBounds(350, 430,250, 20);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		c3 = new JCheckBox("Internet Banking");
		c3.setFont(new Font("Raleway", Font.BOLD,16));
		c3.setBounds(100, 460,250, 20);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		c4 = new JCheckBox("Cheque Book");
		c4.setFont(new Font("Raleway", Font.BOLD,16));
		c4.setBounds(350, 460,250, 20);
		c4.setBackground(Color.WHITE);
		add(c4);
		
		c5 = new JCheckBox("EMAIL and SMS Alerts");
		c5.setFont(new Font("Raleway", Font.BOLD,16));
		c5.setBounds(100, 490,250, 20);
		c5.setBackground(Color.WHITE);
		add(c5);
		
		c6 = new JCheckBox("E-Statament");
		c6.setFont(new Font("Raleway", Font.BOLD,16));
		c6.setBounds(350, 490,250, 20);
		c6.setBackground(Color.WHITE);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above details are corrrect");
		c7.setFont(new Font("Raleway", Font.BOLD,12));
		c7.setBounds(100, 600,500, 20);
		c7.setBackground(Color.WHITE);
		add(c7);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD,14));
		submit.setBounds(320, 630, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD,14));
		cancel.setBounds(520, 630, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

	    getContentPane().setBackground(Color.WHITE);
	    
		setSize(850, 800);
		setVisible(true);
		setLocation(350, 200);
	}
	public void actionPerformed(ActionEvent ae) {
		//if(ae.getSource() == submit) {
			
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account";
	    	} else if(r2.isSelected()) {
	    		accountType = "Current Account";
	    	}else if(r3.isSelected()) {
	    		accountType = "Fixed Deposit Account";
	    	}else if(r4.isSelected()) {
	    		accountType = "Recurring Account";
	    	}
			
			Random random = new Random();
			String cardNumber =""+ Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
			
			String pinNumber = "" + Math.abs((random.nextLong()%9000L) + 1000L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + " ATM CARD";
			} else if(c2.isSelected()){
				facility = facility + " Mobile Banking";
			} else if(c3.isSelected()){
				facility = facility + " Internet Banking";
			} else if(c4.isSelected()){
				facility = facility + " Cheque Book";
			} else if(c5.isSelected()){
				facility = facility + " EMAIL and SMS Alerts";
			} else if(c6.isSelected()) {
				facility = facility + " E-Statament";
			}
			
			if(ae.getSource() == submit) {
			try {
				if(accountType.equals("")) {
	    			JOptionPane.showMessageDialog(null, "Account Type is required");
	    		} else {
	    		Conn c = new Conn();
	    		String query1 = "insert into signupThree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
	    		String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
    			
	    		JOptionPane.showMessageDialog(null, "Card Number:" + cardNumber + "\n Pin:" + pinNumber);

	    		setVisible(false);
	    		//new Deposit(pinNumber).setVisible(true);
	    		}
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
			
		} else if (ae.getSource() == cancel) {
			setVisible(false);
    		new Login().setVisible(true);
		}
	}
	
public static void main(String args[]) {
    new SignupThree("");
  }
}
