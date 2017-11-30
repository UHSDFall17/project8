import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase5 {

	@Test
	public void test() {
		Registration reg=new Registration();
		Boolean result=reg.checkNameRegularExpression("agadh123");
		assertEquals(true,result);
		
		
	}

}
