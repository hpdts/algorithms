package autocomplete;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class AutocompleteTest {
	Autocomplete autocomplete = new Autocomplete();

	@Test
	public void autocomplete2(){
		autocomplete.insert("next");
		autocomplete.insert("net");
		autocomplete.insert("network");
		autocomplete.insert("never");
		autocomplete.insert("avocado");
		
		List<String> words = autocomplete.autocomplete("ne");
		assertThat(words.size(), is(4));
		assertTrue(words.contains("net"));
		assertTrue(words.contains("network"));

		words = autocomplete.autocompleteRecursive("ne");
		assertThat(words.size(), is(4));
		
	}
}