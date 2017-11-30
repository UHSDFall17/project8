import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase6 {

	@Test
	public void test() {
		Registration reg=new Registration();
		Boolean result=reg.checkEmailRegularExpression("as@");
		assertEquals(false,result);
		
	}

}
