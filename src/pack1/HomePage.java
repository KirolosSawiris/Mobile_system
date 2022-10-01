package pack1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class HomePage implements ActionListener{
	
	final int message_price = 5;
	JFrame frame = new JFrame();
	JLabel Message = new JLabel();
	JLabel Message2 = new JLabel();
	JTextField textfield = new JTextField();
	JTextField textfield2 = new JTextField();
	JButton changepass = new JButton("OK");
	JButton changename = new JButton("OK");
	JButton addmessage = new JButton("OK");
	JButton addcredit = new JButton("OK");
	JButton addtans = new JButton("OK");
	JPasswordField passwordfield = new JPasswordField();
	JMenuBar menuBar = new JMenuBar();
	JMenu infomenu = new JMenu("Your info");
	JMenu editmenu = new JMenu("Edit");
	JMenu messagemenu = new JMenu("Message");
	JMenu creditsmenu = new JMenu("Your Credits");
	JMenu Exit = new JMenu("Sign out");
	int Current_user;
	ArrayList<User> Users = new ArrayList<User>();
	ArrayList <Message> Messages = new ArrayList <Message>();
	
	
	JMenuItem i1 = new JMenuItem("View your info");
	
	JMenuItem e2 = new JMenuItem("Edit your password");
	JMenuItem e3 = new JMenuItem("Edit your Name");
	
	JMenuItem m1 = new JMenuItem("New Message");
	JMenuItem m2 = new JMenuItem("View sent Messages");
	JMenuItem m3 = new JMenuItem("View received Messages");
	
	JMenuItem t1 = new JMenuItem("New Transaction");
	JMenuItem t4 = new JMenuItem("Top up Credits");
	
	JMenuItem q1 = new JMenuItem("Sign out");
	
	Message me1 = new Message();
	Message me2 = new Message();
	
	
	HomePage(int i, ArrayList<User> OUsers){
		
		
		Current_user= i;
		Users = OUsers;
		infomenu.add(i1);
		infomenu.add(editmenu);
		Messages = Serialize.Mload();
		
		passwordfield.setBounds(250, 105, 125, 25);
		textfield.setBounds(250, 105, 125, 25);
		textfield2.setBounds(250, 80, 125, 25);
		
		changepass.setBounds(20, 135, 100, 25);
		changepass.setFocusable(false);
		changepass.addActionListener(this);
		
		addcredit.setBounds(20, 135, 100, 25);
		addcredit.setFocusable(false);
		addcredit.addActionListener(this);
		
		changename.setBounds(20, 135, 100, 25);
		changename.setFocusable(false);
		changename.addActionListener(this);
		
		addmessage.setBounds(20, 135, 100, 25);
		addmessage.setFocusable(false);
		addmessage.addActionListener(this);
		
		addtans.setBounds(20, 135, 100, 25);
		addtans.setFocusable(false);
		addtans.addActionListener(this);
		
		editmenu.add(e2);
		editmenu.add(e3);
		
		messagemenu.add(m1);
		messagemenu.add(m2);
		messagemenu.add(m3);
		
		creditsmenu.add(t1);
		creditsmenu.add(t4);
		
		Exit.add(q1);
		
		menuBar.add(infomenu);
		menuBar.add(messagemenu);
		menuBar.add(creditsmenu);
		menuBar.add(Exit);
		
		e2.addActionListener(this);
		e3.addActionListener(this);
		i1.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		t4.addActionListener(this);
		q1.addActionListener(this);
		t1.addActionListener(this);
		
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		Message.setText("Welcome " + Users.get(i).getName());
		Message.setBounds(10, 10, 250, 20);
		Message.setFont(new Font(null, Font.ITALIC, 16));
		Message2.setBounds(10, 60, 250, 100);
		Message2.setFont(new Font(null, Font.PLAIN, 16));
		frame.add(Message);
		frame.add(Message2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == i1)
		{
			Message2.setText("<html>Phone Number: " + Users.get(Current_user).getPhoneNum() + "<br/>Password: " + Users.get(Current_user).getPassword() +"<br/>Name: " + Users.get(Current_user).getName()+ "<br/>Credits: "+ Users.get(Current_user).getCredits() + "</html>");
		}
		if(e.getSource() == e2)
		{
			Message2.setText("Enter the new Password: ");
			changepass.setVisible(true);
			passwordfield.setVisible(true);
			frame.add(passwordfield);
			frame.add(changepass);
		}
		if(e.getSource() == changepass)
		{
			Users.get(Current_user).setPassword(String.valueOf(passwordfield.getPassword()));
			Message2.setText("Done!");
			passwordfield.setText("");
			passwordfield.setVisible(false);
			changepass.setVisible(false);
			Serialize.Save(Users);
		}
		if(e.getSource() == e3)
		{
			Message2.setText("Enter the new Name: ");
			changename.setVisible(true);
			textfield.setVisible(true);
			frame.add(textfield);
			frame.add(changename);
		}
		if(e.getSource() == changename)
		{
			Users.get(Current_user).setName(textfield.getText());
			Message.setText("Welcome " + Users.get(Current_user).getName());
			Message2.setText("Done!");
			textfield.setText("");
			textfield.setVisible(false);
			changename.setVisible(false);
			Serialize.Save(Users);
		}
		if(e.getSource() == m1)
		{
			Message2.setText("<html>Enter the Number: <br/> Enter the Message: ");
			addmessage.setVisible(true);
			textfield.setVisible(true);
			textfield2.setVisible(true);
			frame.add(addmessage);
			frame.add(textfield);
			frame.add(textfield2);
		}
		if(e.getSource() == addmessage)
		{
			if(Users.get(Current_user).Can_send_message())
			{
				Message m = new Message();
				m.setSender(Users.get(Current_user).getPhoneNum());
				m.setReceiver(textfield2.getText());
				m.setContent(textfield.getText());
				if(!(m.Is_Empty()))
				{
					Users.get(Current_user).setCredits(Users.get(Current_user).getCredits() - message_price);
					Messages.add(m);
					Serialize.Save(Users);
					Serialize.Msave(Messages);
					Message2.setText("Done!");
				}
				else
				{
					Message2.setText("Sorry message empty!");
				}
			}
			else
			{
				Message2.setText("You don't have enogh credits!");
				
			}
			
			textfield.setText("");
			textfield2.setText("");
			textfield.setVisible(false);
			textfield2.setVisible(false);
			addmessage.setVisible(false);
			
		}
		if(e.getSource() == m2)
		{
			ArrayList<Message> SentM = new ArrayList<>();
			for (int i = 0; i < Messages.size(); i++) {
				if(Users.get(Current_user).getPhoneNum().equals(Messages.get(i).getSender()))
				{
					SentM.add(Messages.get(i));
				}
			}
			JFrame f=new JFrame();
			String[][] data = new String[SentM.size()][];
			for (int i = 0; i < SentM.size(); i++) {
				data[i] = new String[]{SentM.get(i).getReceiver(), SentM.get(i).getContent()};
			}
			
			String[] columnNames = { "To", "Message"};
			JTable jt=new JTable(data,columnNames);    
		    jt.setBounds(10,10,500,500);          
		    JScrollPane sp=new JScrollPane(jt);    
		    f.add(sp);          
		    f.setSize(500,500);    
		    f.setVisible(true);
			
		}
		if(e.getSource() == m3)
		{
			ArrayList<Message> RecivedM = new ArrayList<>();
			for (int i = 0; i < Messages.size(); i++) {
				if(Users.get(Current_user).getPhoneNum().equals(Messages.get(i).getReceiver()))
				{
					RecivedM.add(Messages.get(i));
				}
			}
				JFrame f=new JFrame();
				String[][] data = new String[RecivedM.size()][];
				for (int j = 0; j < RecivedM.size(); j++) {
					data[j] = new String[]{RecivedM.get(j).getSender(), RecivedM.get(j).getContent()};
				}
				
				String[] columnNames = { "From", "Message"};
				JTable jt=new JTable(data,columnNames);    
			    jt.setBounds(10,10,500,500);          
			    JScrollPane sp=new JScrollPane(jt);    
			    f.add(sp);          
			    f.setSize(500,500);    
			    f.setVisible(true);
		}
		if(e.getSource() == t4)
		{
			Message2.setText("Enter number of Credits: ");
			addcredit.setVisible(true);
			textfield.setVisible(true);
			frame.add(textfield);
			frame.add(addcredit);
		}
		if (e.getSource() == addcredit)
		{
			Users.get(Current_user).setCredits(Users.get(Current_user).getCredits()+ Integer.parseInt(textfield.getText()));
			Message2.setText("Done!");
			textfield.setText("");
			textfield.setVisible(false);
			addcredit.setVisible(false);
			Serialize.Save(Users);
		}
		if(e.getSource() == q1)
		{
			frame.dispose();
			LoginPage loginpage = new LoginPage(Users);
		}
		if(e.getSource() == t1)
		{
			Message2.setText("<html>Enter the Number: <br/> Enter the ammount: ");
			addtans.setVisible(true);
			textfield.setVisible(true);
			textfield2.setVisible(true);
			frame.add(addtans);
			frame.add(textfield);
			frame.add(textfield2);
		}
		if(e.getSource() == addtans)
		{
			for(User i : Users)
			{
				if(i.getPhoneNum().equals(textfield2.getText()))
				{
					i.setCredits(i.getCredits() + Integer.parseInt(textfield.getText()));
				}
			}
			Users.get(Current_user).setCredits(Users.get(Current_user).getCredits() - Integer.parseInt(textfield.getText()));
			Serialize.Save(Users);
			Message2.setText("Done!");
			textfield.setText("");
			textfield2.setText("");
			textfield.setVisible(false);
			textfield2.setVisible(false);
			addtans.setVisible(false);
		}
	}

}



