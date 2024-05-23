package BankManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{
	
	JButton withdraw, back;
	JTextField amount;
	String pinNumber;
	
	Withdraw(String pinNumber){
		this.pinNumber = pinNumber;
	setLayout(null);
	
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(0, 0, 900, 900); //custom layout
	add(image);

	JLabel text = new JLabel ("Enter the amount to withdraw:");
	text.setForeground(Color.WHITE);
	text.setFont(new Font("System", Font.BOLD, 16));
	text.setBounds(170, 300, 400, 20);
	image.add(text);
	
	amount = new JTextField();
	amount.setFont(new Font("Raleway", Font.BOLD, 22));
	amount.setBounds(170, 350, 320, 25);
	image.add(amount);
	
	withdraw = new JButton("Withdraw");
	withdraw.setBounds(355, 485, 150, 30);
	withdraw.addActionListener(this);
	image.add(withdraw);
	
	back = new JButton("Back");
	back.setBounds(355, 520, 150, 30);
	back.addActionListener(this);
	image.add(back);
	
	setSize(900, 900);
	setLocation(300, 0);
	//setUndecorated(true);
	setVisible(true);
}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdraw) {
			String amt = amount.getText();
			Date date = new Date();
			if(amt.equals("")) {
    			JOptionPane.showMessageDialog(null, "Enter the amount you want to withdraw");
			}else {
				try {
				Conn c = new Conn();
				String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amt+"')";
				c.s.executeUpdate(query);
    			JOptionPane.showMessageDialog(null,"Rs" + amt + "Withdrawed Successfully");
    			setVisible(false);
    			new Transaction(pinNumber).setVisible(true);
    			
				} catch (Exception e) {
					    System.out.println(e);
				    }
				}
			} else if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
	}
public static void main(String args[]) {
    new Withdraw("");
  }
}