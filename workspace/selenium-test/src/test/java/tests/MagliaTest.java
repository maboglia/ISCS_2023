package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.Maglia;

public class MagliaTest {

	@Test
	public void magliaTest() {
		Maglia m = new Maglia();
		m.setTaglia(40);
		assertEquals(40, m.getTaglia());
		
	}
	
}
