package pack1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginbutton = new JButton("Login");
	JButton resetbutton = new JButton("Reset");
	JButton registerbutton = new JButton("Register");
	JTextField PhoneNumField = new JTextField();
	JPasswordField PasswordField = new JPasswordField();
	JLabel UserPhone = new JLabel("Phone Number:");
	JLabel UserPassword = new JLabel("Password:");
	JLabel Message = new JLabel();
	ArrayList <User> Users = new ArrayList <User>();
	
	LoginPage(ArrayList<User> OUsers)
	{
		Users = OUsers;
		
		UserPhone.setBounds(50, 100, 125, 25);
		UserPassword.setBounds(50, 150, 125, 25);
		Message.setBounds(125, 250, 250, 35);
		Message.setFont(new Font(null, Font.ITALIC, 25));
		PhoneNumField.setBounds(175, 100 , 200, 25);
		PasswordField.setBounds(175, 150 , 200, 25);
		loginbutton.setBounds(125, 200, 100, 25);
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(this);
		resetbutton.setBounds(225, 200, 100, 25);
		resetbutton.setFocusable(false);
		resetbutton.addActionListener(this);
		registerbutton.setBounds(325, 200, 100, 25);
		registerbutton.setFocusable(false);
		registerbutton.addActionListener(this);
		
		frame.add(loginbutton);
		frame.add(resetbutton);
		frame.add(registerbutton);
		frame.add(Message);
		frame.add(UserPhone);
		frame.add(UserPassword);
		frame.add(PhoneNumField);
		frame.add(PasswordField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetbutton) {
			PhoneNumField.setText("");
			PasswordField.setText("");
			Message.setText("");
		}
		if(e.getSource() == loginbutton) {
			String PhoneNum = PhoneNumField.getText();
			String Password = String.copyValueOf(PasswordField.getPassword());
			int i;
			for(i = 0; i < Users.size(); i++)
			{
				if(Users.get(i).getPhoneNum().equals(PhoneNum) && Users.get(i).getPassword().equals(Password))
				{
					Message.setText("Weclcome");
					frame.dispose();
					HomePage homepage = new HomePage(i, Users);
				}
				else
				{
					PasswordField.setText("");
					Message.setText("Invalid Data");
				}
			}
			
		}
		if(e.getSource() == registerbutton) {
			frame.dispose();
			RegistrationPage registrationPage = new RegistrationPage(Users);
		}
		
	}

}
