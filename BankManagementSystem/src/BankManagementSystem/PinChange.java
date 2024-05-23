package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	
	String pinNumber;
	JPasswordField pin, repin;
	JButton change, back;
	
	PinChange(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900); //custom layout
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(250, 280, 500, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		image.add(text);
		
		JLabel newPin = new JLabel("NEW PIN: ");
		newPin.setBounds(165, 320, 180, 25);
		newPin.setForeground(Color.WHITE);
		newPin.setFont(new Font("System", Font.BOLD,16));
		image.add(newPin);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(330, 320, 180, 30);
		add(pin);
		
		JLabel rePin = new JLabel("RE-ENTER PIN: ");
		rePin.setBounds(165, 360, 180, 25);
		rePin.setForeground(Color.WHITE);
		rePin.setFont(new Font("System", Font.BOLD,16));
		image.add(rePin);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(330, 360, 180, 30);
		add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355, 480, 150, 30);	
		change.addActionListener(this);
		add(change);
		
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
	    if(ae.getSource() == change) {
		try {
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter PIN ");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter PIN ");
				return;
			}
			Conn c = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
			String query2 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
			String query3 = "update signupThree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";

			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed successfully");

			setVisible(false);
			new Transaction(rpin).setVisible(true);
		} catch(Exception e) {
			System.out.println(e);
		}
	    } else {
	    	setVisible(false);
	    	new Transaction(pinNumber).setVisible(true);
	    }
	}
 
	
	public static void main(String args[]) {
	    new PinChange("");
	  }
}
