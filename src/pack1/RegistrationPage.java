package pack1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationPage implements ActionListener {

	JFrame frame = new JFrame();
	JButton registerButton = new JButton("Register");
	JButton cancelButton = new JButton("Cancel");
	JButton resetButton = new JButton("Reset");
	JTextField PhoneNumField = new JTextField();
	JTextField NameField = new JTextField();
	JPasswordField PasswordField = new JPasswordField();
	JLabel UserPhone = new JLabel("Phone Number:");
	JLabel UserPassword = new JLabel("Password:");
	JLabel UserName = new JLabel("Name:");
	JLabel Message = new JLabel();
	ArrayList <User>  Users = new ArrayList <User>();
	
	RegistrationPage(ArrayList<User> OUsers){
		
		Users = OUsers;
		UserPhone.setBounds(50, 100, 125, 25);
		UserPassword.setBounds(50, 150, 125, 25);
		UserName.setBounds(50, 200, 125, 25);
		Message.setBounds(125, 300, 250, 35);
		Message.setFont(new Font(null, Font.ITALIC, 20));
		PhoneNumField.setBounds(175, 100 , 200, 25);
		PasswordField.setBounds(175, 150 , 200, 25);
		NameField.setBounds(175, 200 , 200, 25);
		registerButton.setBounds(125, 250, 100, 25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		cancelButton.setBounds(325, 250, 100, 25);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(this);
		resetButton.setBounds(225, 250, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(registerButton);
		frame.add(resetButton);
		frame.add(UserName);
		frame.add(UserPassword);
		frame.add(UserPhone);
		frame.add(Message);
		frame.add(NameField);
		frame.add(PasswordField);
		frame.add(PhoneNumField);
		frame.add(cancelButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registerButton)
		{
			boolean unvalid = false;
			User user = new User();
			user.setName(NameField.getText());
			user.setPassword(String.valueOf(PasswordField.getPassword()));
			user.setPhoneNum(PhoneNumField.getText());
				if (user.Is_exists(Users)) {
					Message.setText("Phone Number Exists");
					unvalid = true;
				}
			if(PhoneNumField.getText().isEmpty() || NameField.getText().isEmpty() || String.valueOf(PasswordField.getPassword()).isEmpty())
			{
				Message.setText("Invalid data");
				unvalid = true;
			}
			user.setPhoneNum(PhoneNumField.getText());
			user.setCredits(50);
			if(unvalid == false) {
				Users.add(user);
				Serialize.Save(Users);
				JOptionPane pane = new JOptionPane();
				pane.setMessage("Successfully Registered");
				JDialog d = pane.createDialog((frame), "Message");
				d.setLocation(200, 200);
				d.setVisible(true);
				frame.dispose();
				LoginPage loginpage = new LoginPage(Users);
			}
			//Message.setText(Users.get(6).getName());
		}
		if(e.getSource() == cancelButton)
		{
			frame.dispose();
			LoginPage loginpage = new LoginPage(Users);
		}
		if(e.getSource() == resetButton) {
			PhoneNumField.setText("");
			PasswordField.setText("");
			NameField.setText("");
			Message.setText("");
		}
		
	}

}
	
