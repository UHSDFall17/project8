import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase2 {

	@Test
	public void LoginFailure() {
		Login log=new Login();
		String result=log.login();
		assertEquals("Invalid !! ",result);
		
	}

}

