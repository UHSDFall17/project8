import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase1 {

	@Test
	public void LoginSuccess() {
		Login log=new Login();
		String result=log.login();
		assertEquals("Login Successfull!",result);
		
	}

}