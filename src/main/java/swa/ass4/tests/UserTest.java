package swa.ass4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import swa.ass4.server.cxf.User;

public class UserTest {

	@Test
	public void test() {
		User user = new User("admin", "password", "Administrator");
		assertEquals("admin", user.getUserName());
		assertTrue(user.verifyPassword("password"));
		assertFalse(user.verifyPassword("wrong"));
	}

}
