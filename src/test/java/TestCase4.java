import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase4 {

	@Test
	public void RegistrationFlow() {
		Registration reg=new Registration();
		String result=reg.Register();
		assertEquals("Registration Successfull!!",result);
	}

}
