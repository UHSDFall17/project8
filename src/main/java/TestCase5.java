import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase5 {

	@Test
	public void Welcome_Invalidinput() {
		Welcome w=new Welcome();
		String result=w.welcome();
		assertEquals("Invalid",result);
	}

}
