package pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serialize implements Serializable{

	public static void Save(ArrayList<User> Users) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Users.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Users);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<User> load() {
		ArrayList<User> Users = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream("Users.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Users = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException a) {
			System.out.println("User class not found");
			a.printStackTrace();
		}
		return Users;

	}
	public static void Msave(ArrayList<Message> Messages) {
		try {
			FileOutputStream fileOut1 = new FileOutputStream("Messages.ser");
			ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
			out1.writeObject(Messages);
			out1.close();
			fileOut1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Message> Mload() {
		ArrayList<Message> Messages = new ArrayList<>();
		try {
			FileInputStream fileIn1 = new FileInputStream("Messages.ser");
			ObjectInputStream in1 = new ObjectInputStream(fileIn1);
			Messages = (ArrayList<Message>) in1.readObject();
			in1.close();
			fileIn1.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException a) {
			System.out.println("Message class not found");
			a.printStackTrace();
		}
		return Messages;
	}
	
}
