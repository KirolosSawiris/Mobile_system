package pack1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		
		ArrayList<User> Users = new ArrayList<User>();
		Users = Serialize.load();
		LoginPage page = new LoginPage(Users);

	}

}
