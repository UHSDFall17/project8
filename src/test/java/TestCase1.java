import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase1 {

	@Test
	public void WelcomePage() {
		Login log=new Login();
		String result=log.login();
		System.out.println(result);
		assertEquals("Login Successfull!",result);
		
	}

}