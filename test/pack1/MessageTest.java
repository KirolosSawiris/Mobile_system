package pack1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTest {

	@Test
	public void test() {
		Message test = new Message();
		boolean output = test.Is_Empty();
		assertEquals(true, output);
	}
	
	@Test
	public void test2() {
		Message test = new Message();
		test.setContent("some content");
		boolean output = test.Is_Empty();
		assertEquals(false, output);
	}

}

