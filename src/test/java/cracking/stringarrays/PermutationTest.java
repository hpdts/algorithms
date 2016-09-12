package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class PermutationTest {

	private Permutation permutation = new Permutation();
	
	@Test
	public void isAPermutation(){
		assertTrue(permutation.isAPermutation("gol", "log"));
		assertTrue(permutation.isAPermutation("ana","naa"));
		assertFalse(permutation.isAPermutation("ana","nada"));
		assertFalse(permutation.isAPermutation("benja","tom"));
	}

}
