package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class UniqueTest {

	private Unique unique = new Unique();
	
	//using Set
	@Test
	public void hasAllUniqueCharacters(){
		assertTrue(unique.hasAllUniqueCharacters("abcde"));
		assertTrue(unique.hasAllUniqueCharacters("abcde通"));
		assertFalse(unique.hasAllUniqueCharacters("ana"));
	}

	@Test
	public void hasAllUniqueCharactersSortBoolean(){
		assertTrue(unique.uniqueCharsCountingSortUsingBoolean("abcde"));
		assertFalse(unique.uniqueCharsCountingSortUsingBoolean("ana"));
	}

	@Test(expected = RuntimeException.class)
	public void hasAllUniqueCharactersException(){
		assertFalse(unique.hasAllUniqueCharacters(null));
	}
	
	@Test(expected = RuntimeException.class)
	public void hasAllUniqueCharactersExceptionEmpty(){
		assertFalse(unique.hasAllUniqueCharacters(""));
	}


	//Counting sort
	@Test
	public void uniqueCharsCountingSort(){
		assertTrue(unique.uniqueCharsCountingSort("abcde"));
		assertFalse(unique.uniqueCharsCountingSort("ana"));
	}

	@Test
	public void uniqueCharsCountingSortUnicodeException(){
		try{
			unique.uniqueCharsCountingSort("abcde通");			
		}catch(Exception ex){
			//assertThat(ex.getMessage(), is("Just ASCII chars not : 36890"));
		}
	}

	@Test(expected = RuntimeException.class)
	public void uniqueCharsCountingSortException(){
		unique.uniqueCharsCountingSort(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void uniqueCharsCountingSortExceptionEmpty(){
		unique.uniqueCharsCountingSort("");
	}

	//array boolean
	@Test
	public void isUniqueChars2(){
		assertTrue(unique.isUniqueChars2("abcde"));
		assertFalse(unique.isUniqueChars2("ana"));
	}

	@Test(expected = RuntimeException.class)
	public void uniqueChars2CountingSortExceptionNull(){
		unique.isUniqueChars2(null);
	}

	@Test
	public void uniqueChars2CountingSortUnicodeException(){
		try{
			unique.isUniqueChars2("abcde通");			
		}catch(Exception ex){
			//assertThat(ex.getMessage(), is("Just ASCII chars not : 36890"));
		}
	}

	//bit vector 
	@Test
	public void isUniqueChars(){
		// check a
		assertTrue(unique.isUniqueChars("abd"));
		assertTrue(unique.isUniqueChars("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(unique.isUniqueChars("aa"));
		assertTrue(unique.isUniqueChars("abdrmwliytp"));
		assertFalse(unique.isUniqueChars("ana"));
	}


}
