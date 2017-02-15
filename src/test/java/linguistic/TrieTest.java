package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import static org.hamcrest.Matchers.*;

public class TrieTest {

	private Trie trie = new Trie();

	@Test
    public void addWord(){
    	trie.insert("hack");
    	trie.insert("car");
    	trie.insert("cars");
    	trie.insert("carson");
    	//trie.insert("hackerrank");

    	trie.print(trie.getRoot());

    	assertTrue(trie.startsWith("hac"));
    	assertThat(trie.countOccurrences("car"), is(3));

    }

}