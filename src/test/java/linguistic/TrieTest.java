package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TrieTest {

	private Trie trie = new Trie();

	@Test
    public void addWord(){
    	trie.insert("hack");
    	trie.insert("hackerrank");

    	trie.print(trie.getRoot());

    }

}