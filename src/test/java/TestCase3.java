import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase3 {

	@Test
	public void Register_checkName() {
		Registration reg=new Registration();
		Boolean result=reg.checkNameRegularExpression("ro");
		assertEquals(true,result);
	}

}
