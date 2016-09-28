package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class RotatedStringTest {

	private RotatedString rotatedString = new RotatedString();
	
	

	@Test
	public void permutation(){
		assertTrue( rotatedString.isRotationStackOverflow("waterbottLe", "erbottLewat"));
		assertTrue( rotatedString.isRotationStackOverflow("ana","naa"));
		assertFalse(rotatedString.isRotationStackOverflow("ana","nada"));
		assertTrue( rotatedString.isRotationStackOverflow("benja","abenj"));
	}


}
