package cracking.autocomplete;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class AutocompleteTest {
	Autocomplete autocomplete = new Autocomplete();

	@Test
	public void autocomplete(){
		autocomplete.insert("ana");
		autocomplete.insert("anamaria");
		autocomplete.insert("francisco");
		autocomplete.insert("hello");
		autocomplete.insert("avocado");

		autocomplete.insert("car");
		autocomplete.insert("cars");
		autocomplete.insert("carouge");

		System.out.println("trie: " + autocomplete.getRoot());

		List<String> words = autocomplete.autocomplete("ana");
		assertThat(words.size(), is(2));

		words = autocomplete.autocomplete("car");
		assertThat(words.size(), is(3));

		System.out.println("words: " + words);
	}
}