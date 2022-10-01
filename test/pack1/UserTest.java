package pack1;	

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User test= new User();
		int output = test.getCredits();
		assertEquals(50, output);
	}
	
	@Test
	public void test2() {
		User test1= new User("user1", "123", "1111", 50);
		User test2= new User("user2", "222", "2222", 50);
		User test3= new User("user3", "333", "3333", 50);
		ArrayList <User> Users = new ArrayList<>();
		Users.add(test1);
		Users.add(test2);
		Users.add(test3);
		boolean output = test2.Is_exists(Users);
		assertEquals(true, output);
	}
	@Test
	public void test3() {
		User test1= new User("user1", "123", "1111", 50);
		User test2= new User("user2", "222", "2222", 50);
		User test3= new User("user3", "333", "3333", 50);
		ArrayList <User> Users = new ArrayList<>();
		Users.add(test1);
		Users.add(test3);
		boolean output = test2.Is_exists(Users);
		assertEquals(false, output);
	}
	
	@Test
	public void test4() {
		User test2= new User("user2", "222", "2222", 2);
		boolean output = test2.Can_send_message();
		assertEquals(false, output);
	}
	@Test
	public void test5() {
		User test1= new User("user1", "123", "1111", 50);
		boolean output = test1.Can_send_message();
		assertEquals(true, output);
	}
}
