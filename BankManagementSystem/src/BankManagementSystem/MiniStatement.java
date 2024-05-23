package BankManagementSystem;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class MiniStatement  extends JFrame{

	String pinNumber;
	
	MiniStatement(String pinNumber){
		setTitle("MINI STATEMENT");
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140,400, 200);
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150, 20, 100, 20);
		add(bank);
		
		JLabel card = new JLabel("Card");
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel("Balance");
		balance.setBounds(20, 80, 300, 20);
		add(balance);
		
		try {
			Conn c = new Conn();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
			
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+ rs.getString("cardnumber").substring(12,16));
				
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
		    }
			balance.setText("Your current account Balance is Rs" + bal);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			ResultSet rs1 = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			
			while(rs1.next()) {
				mini.setText(mini.getText() + "<html>" + rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br><html>");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public static void main(String args[]) {
	    new MiniStatement("");
	  }
}
