package Studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostAndUserTest {

	@Test
	public void test() {
		User u = new User("KerstingJ", "Password");
		assertEquals("Wrong USername", "KerstingJ", u.getUsername());
		assertEquals("Wrong Password", "Password", u.getPassHash());
		
	}

}
