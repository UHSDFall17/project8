import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase3 {

	@Test
	public void Register_PwdMismatch() {
		Registration reg=new Registration();
		String result=reg.Register();
		assertEquals("Passwords don't match!",result);
	}

}
