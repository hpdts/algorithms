package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LinguisticTest {
    private Linguistic linguistic = new Linguistic();


    @Test
    public void shouldGetWordsRemovingOneLetterAtTheTime(){
        String word1 = "starting";
        List<String> wordsRemovingLetters = linguistic.getWordsRemovingOneLetterAtTheTime(word1);

        assertEquals(word1.length(), wordsRemovingLetters.size());
        assertEquals("tarting", wordsRemovingLetters.get(0));

    }

    @Test
    public void shouldCreateTestDictionary(){
        Trie trie = linguistic.createDictionary("test.dictionary.txt");

        assertTrue(trie.search("starting"));
        assertTrue(trie.search("someVeryLongRepeatingWord"));
        assertTrue(trie.search("abcdefgh"));

        assertTrue(trie.search("a"));

        assertEquals(29, linguistic.getAllWords().size());

    }

     
    @Test
    public void shouldCreateDictionary(){
        Trie trie = linguistic.createDictionary("dictionary.txt");

        assertTrue(trie.search("abannition"));
        
        assertEquals(354982, linguistic.getAllWords().size());
    }

    @Test
    @Ignore
    public void shouldGetAllChains(){
        Trie trie = linguistic.createDictionary("small.chain.txt");
        List<String> chains = linguistic.getAllValidWordsFromDictionary();

        assertEquals(3, chains.size());
        assertEquals("a", chains.get(0));

    }

    @Test
    @Ignore
    public void shouldGetPermutations(){
        List<String> permutations = linguistic.permute("a");

        assertEquals(1, permutations.size());
        assertEquals("a", permutations.get(0));

        permutations = linguistic.permute("ab");

        assertEquals(3, permutations.size());

        assertEquals("a", permutations.get(0));
        assertEquals("ab", permutations.get(1));
        assertEquals("ba", permutations.get(2));

    }


    @Test(expected=Linguistic.DictionaryWordsNotFoundException.class)
    public void shouldGetExceptionWhenSetIsNotThereAllCombinations(){
        Trie trie = linguistic.createDictionary("test.dictionary.bad.path.txt");
    }
} 