package pack1;

import java.io.Serializable;

public class Message implements Serializable {
	
	private String Sender;
	private String Receiver;
	private String Content;
	
	Message()
	{
		this.Sender = "";
		this.Receiver = "";
		this.Content = "";
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	public boolean Is_Empty()
	{
		if(this.Content.equals(""))
		{
			return true;
		}
		else return false;
	}

}
