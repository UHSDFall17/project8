import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase5 {

	@Test
	public void Welcome_Invalidinput() {
		Main m=new Main();
		String result=m.welcome();
		assertEquals("Invalid",result);
	}

}
