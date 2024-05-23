package BankManagementSystem;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.Random;
	import com.toedter.calendar.JDateChooser;

	public class SignupTwo extends JFrame implements ActionListener{
		JComboBox religion1,category1;
		JTextField incomeTextField, eduTextField, occTextField, panTextField, aadhaarTextField;
		JRadioButton seniorYes, seniorNo, accYes, accNo;
		JButton next;
		String formno;
		
	    SignupTwo(String formno){
	    	this.formno = formno;
	    	setLayout(null);
	    	
	    	setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");
	    	
	    	JLabel additionalDetails = new JLabel("Page 2: Additional Details");
	    	additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
	    	additionalDetails.setBounds(290, 80, 400, 30);
			add(additionalDetails);
			
			/*JTextField nameTextField = new JTextField();
			nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			nameTextField.setBounds(300, 140, 400, 30);
			add(nameTextField);
			*/
			JLabel religion = new JLabel("Religion:");
			religion.setFont(new Font("Raleway", Font.BOLD,20));
			religion.setBounds(100, 140, 100, 30);
			add(religion);
			
			String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian"};
			religion1 = new JComboBox(valReligion);
			religion1.setBounds(300, 140, 400, 30);
			religion1.setBackground(Color.WHITE);
			add(religion1);
			
			/*JTextField fnameTextField = new JTextField();
			fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			fnameTextField.setBounds(300, 190, 400, 30);
			add(fnameTextField);*/
			
			JLabel category = new JLabel("Category:");
			category.setFont(new Font("Raleway", Font.BOLD,20));
			category.setBounds(100, 190, 200, 30);
			add(category);
			
			String[] valCategory = {"General", "OBC", "ST", "SC"};
			category1 = new JComboBox(valCategory);
			category1.setBounds(300, 190, 400, 30);
			category1.setBackground(Color.WHITE);
			add(category1);
			
			JLabel income = new JLabel("Income:");
			income.setFont(new Font("Raleway", Font.BOLD,20));
			income.setBounds(100, 240, 200, 30);
			add(income);
			
			incomeTextField = new JTextField();
			incomeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			incomeTextField.setBounds(300, 240, 400, 30);
			add(incomeTextField);
			
			JLabel education = new JLabel("Education:");
			education.setFont(new Font("Raleway", Font.BOLD,20));
			education.setBounds(100, 290, 200, 30);
			add(education);
			
			eduTextField = new JTextField();
			eduTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			eduTextField.setBounds(300, 290, 400, 30);
			add(eduTextField);
			
			
			JLabel occupation = new JLabel("Occupation:");
			occupation.setFont(new Font("Raleway", Font.BOLD,20));
			occupation.setBounds(100, 340, 200, 30);
			add(occupation);
			
			occTextField = new JTextField();
			occTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			occTextField.setBounds(300, 340, 400, 30);
			add(occTextField);
			
			JLabel panno = new JLabel("PAN Number:");
			panno.setFont(new Font("Raleway", Font.BOLD,20));
			panno.setBounds(100, 390, 200, 30);
			add(panno);
			
			panTextField = new JTextField();
			panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			panTextField.setBounds(300, 390, 400, 30);
			add(panTextField);
			
			JLabel aadhaarno = new JLabel("Aadhaar Card No.:");
			aadhaarno.setFont(new Font("Raleway", Font.BOLD,20));
			aadhaarno.setBounds(100, 440, 200, 30);
			add(aadhaarno);
			
			aadhaarTextField = new JTextField();
			aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			aadhaarTextField.setBounds(300, 440, 400, 30);
			add(aadhaarTextField);
			
			JLabel seniorCitizen = new JLabel("Senior Citizen:");
			seniorCitizen.setFont(new Font("Raleway", Font.BOLD,20));
			seniorCitizen.setBounds(100, 490, 200, 30);
			add(seniorCitizen);
			
			seniorYes = new JRadioButton("YES");
			seniorYes.setBounds(300, 490, 60, 30);
			seniorYes.setBackground(Color.WHITE);
			add(seniorYes);
			
			seniorNo = new JRadioButton("NO");
			seniorNo.setBounds(450, 490, 120, 30);
			seniorNo.setBackground(Color.WHITE);
			add(seniorNo);
			
			ButtonGroup seniorGroup = new ButtonGroup();
			seniorGroup.add(seniorYes);
			seniorGroup.add(seniorNo);
			
			JLabel existAcc = new JLabel("Existing Account:");
			existAcc.setFont(new Font("Raleway", Font.BOLD,20));
			existAcc.setBounds(100, 540, 200, 30);
			add(existAcc);
			
			accYes = new JRadioButton("YES");
			accYes.setBounds(300, 540, 60, 30);
			accYes.setBackground(Color.WHITE);
			add(accYes);
			
			accNo = new JRadioButton("NO");
			accNo.setBounds(450, 540, 120, 30);
			accNo.setBackground(Color.WHITE);
			add(accNo);
			
			ButtonGroup accGroup = new ButtonGroup();
			accGroup.add(accYes);
			accGroup.add(accNo);
			
			JButton next = new JButton("NEXT");
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
	    	
	    	String sreligion = (String)religion1.getSelectedItem();
			String scatrgory = (String)category1.getSelectedItem();
			String income = incomeTextField.getText();
	        String education =  eduTextField.getText();
	        String occupation =  occTextField.getText();
	        String panNo =  panTextField.getText();
	        String aadhaarNo =  aadhaarTextField.getText();
	        
	       String seniorCitizen = null;
	    	if(seniorYes.isSelected()) {
	    		seniorCitizen = "YES";
	    	} else if(seniorNo.isSelected()) {
	    		seniorCitizen = "NO";
	    	}
	    	String existAccount = null;
	    	if(accYes.isSelected()) {
	    		existAccount = "YES";
	    	} else if(accNo.isSelected()) {
	    		existAccount = "NO";
	    	}

	    	try {
	    		Conn c = new Conn();
	    		String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scatrgory+"','"+income+"','"+education+"','"+occupation+"','"+panNo+"','"+aadhaarNo+"','"+seniorCitizen+"','"+existAccount+"')";
	    		c.s.executeUpdate(query);
	    		
	    		//signupThree object
	    		setVisible(false);
	    		new SignupThree(formno).setVisible(true);
	    		
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
	    }
		
		public static void main(String args[]) {
			new SignupTwo("");
		}

	}
