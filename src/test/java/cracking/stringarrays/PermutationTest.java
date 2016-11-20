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

	@Test
	public void permutation(){
		assertTrue(permutation.permutation("gol", "log"));
		assertTrue(permutation.permutation("ana","naa"));
		assertFalse(permutation.permutation("ana","nada"));
		assertFalse(permutation.permutation("benja","tom"));
	}


	@Test
	public void permutationArray(){
		assertTrue(permutation.permutationArray("gol", "log"));
		assertTrue(permutation.permutationArray("ana","naa"));
		assertFalse(permutation.permutationArray("ana","nada"));
		assertFalse(permutation.permutationArray("benja","tom"));
	}

	@Test
	public void permutationAll(){
		permutation.allPermutation("", "log");
		assertThat(permutation.permutations.size(), is(6));
	}
}
