package linguistic;

import static org.junit.Assert.*;
import org.junit.*;

public class LinguisticTest {
    private Linguistic linguistic = new Linguistic();

    @Test
    public void shouldCreateTestDictionary(){
        Trie trie = linguistic.createDictionary("test.dictionary.txt");

        assertTrue(trie.search("starting"));
        assertTrue(trie.search("someVeryLongRepeatingWord"));
        assertTrue(trie.search("abcdefgh"));
        assertTrue(trie.search("a"));
    }

     
    @Test
    public void shouldCreateDictionary(){
        Trie trie = linguistic.createDictionary("dictionary.txt");

        assertTrue(trie.search("abannition"));
    }

    
} 
