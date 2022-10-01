package pack1;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String Name;
	private String PhoneNum;
	private String Password;
	private int Credits;
	
	public User() {
		this.Name= "";
		this.PhoneNum = "";
		this.Password= "";
		this.Credits = 50;
	}
	public User(String Name, String PhoneNum, String Password, int Credits) {
		this.Name = Name;
		this.PhoneNum = PhoneNum;
		this.Password = Password;
		this.Credits = Credits;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getCredits() {
		return Credits;
	}

	public void setCredits(int credits) {
		Credits = credits;
	}
	
	public boolean Is_exists(ArrayList<User> Users)
	{
		for(User i : Users)
		{
			if(i.getPhoneNum().equals(this.PhoneNum))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean Can_Login(ArrayList<User> Users)
	{
		for(User i : Users)
		{
			if(i.getPhoneNum().equals(this.PhoneNum) && i.getPassword().equals(this.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean Can_send_message()
	{
		final int message_cost = 5;
		if(this.Credits >= message_cost)
		{
			return true;
		}
		else return false;
	}
	
}
