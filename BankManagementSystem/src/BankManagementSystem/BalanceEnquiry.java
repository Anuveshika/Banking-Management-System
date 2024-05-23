package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinNumber;
	JButton back;
	
	BalanceEnquiry(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900); //custom layout
		add(image);
		
		int balance = 0;
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
		    }
		}catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Current Account Balance is Rs:"+ balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);	
		back.addActionListener(this);
		add(back);
		
		
		setSize(900, 900);
		setLocation(300, 0);
		//setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if(ae.getSource() == back) {
	    	setVisible(false);
	    	new Transaction(pinNumber).setVisible(true);
	    }
	}
 
	
	public static void main(String args[]) {
	    new BalanceEnquiry("");
	  }
}
