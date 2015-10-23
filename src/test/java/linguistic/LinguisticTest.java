package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LinguisticTest {
   private Linguistic linguistic = new Linguistic();

   @Test
   public void shouldAddChainInChainsMapToTheRight(){
       linguistic.addChainOrderedByLength("starting");
       linguistic.addChainOrderedByLength("start");

       String chain1 = "starting => start";
       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(2), linguistic.getChains().get(chain1));
       assertTrue(linguistic.getChains().containsKey(chain1));

       linguistic.addChainOrderedByLength("ta");

       String chain2 = "starting => start => ta";
       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(3), linguistic.getChains().get(chain2));
       assertTrue(linguistic.getChains().containsKey(chain2));

       linguistic.addChainOrderedByLength("a");
       String chain4 = "starting => start => ta => a";
       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(4), linguistic.getChains().get(chain4));
       assertTrue(linguistic.getChains().containsKey(chain4));

       linguistic.addChainOrderedByLength("startingTo");
       assertEquals(2, linguistic.getChains().size());
       assertEquals(new Integer(4), linguistic.getChains().get(chain4));
       assertTrue(linguistic.getChains().containsKey(chain4));

   }

   @Test
   public void getChainLength(){
     assertEquals(2, linguistic.getChainLength("starting => start"));
     assertEquals(3, linguistic.getChainLength("starting => start => ta"));
   }

   @Test
   public void getLastMemberToTheRight(){
     assertEquals("start", linguistic.getLastMemberToTheRight("starting => start"));
     assertEquals("ta", linguistic.getLastMemberToTheRight("starting => start => ta"));
   }

   @Test
   public void shouldAddChainInChainsMap(){
       String word1 = "starting";
       linguistic.addChainOrderedByLength(word1);

       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(1), linguistic.getChains().get(word1));
       assertTrue(linguistic.getChains().containsKey(word1));

   }

    /*@Test
    @Ignore
    public void shouldGetAllChains(){
        Trie trie = linguistic.createDictionary("dictionaries/small.chain.txt");
        List<String> chains = linguistic.getAllValidWordsFromDictionary();

        assertEquals(1, chains.size());
        assertEquals("ab => b => a", chains.get(0));
    }

    @Test
    @Ignore
    public void shouldGetTwoChains(){
        Trie trie = linguistic.createDictionary("dictionaries/test.dictionary.txt");
        List<String> chains = linguistic.getAllValidWordsFromDictionary();

        assertEquals(2, chains.size());
        assertEquals("starting => stating => statin => satin => sati => sat => at => a", chains.get(0));
        assertEquals("abcdefgh => abcdefg => abcdef => abcde => abcd => abc => ab => a", chains.get(1));
    }

    @Test
    public void shouldGetChainsFromOneLetterDictionary(){
        Trie trie = linguistic.createDictionary("dictionaries/oneletter.dictionay.txt");
        List<String> chains = linguistic.getAllValidWordsFromDictionary();

        assertEquals(3, chains.size());
        assertEquals("b", chains.get(0));
        assertEquals("c", chains.get(1));
        assertEquals("a", chains.get(2));

    }

    @Test
    public void shouldGetWordsRemovingOneLetterAtTheTime(){
        String word1 = "starting";
        List<String> wordsRemovingLetters = linguistic.getWordsRemovingOneLetterAtTheTime(word1);

        assertEquals(word1.length(), wordsRemovingLetters.size());
        assertEquals("tarting", wordsRemovingLetters.get(0));

    }*/

    @Test
    public void shouldCreateTestDictionary(){
        Trie trie = linguistic.createDictionary("dictionaries/test.dictionary.txt");

        assertTrue(trie.search("starting"));
        assertTrue(trie.search("someVeryLongRepeatingWord"));
        assertTrue(trie.search("abcdefgh"));

        assertTrue(trie.search("a"));

        assertEquals(29, linguistic.getAllWords().size());

    }

     
    @Test
    public void shouldCreateDictionary(){
        Trie trie = linguistic.createDictionary("dictionaries/dictionary.txt");

        assertTrue(trie.search("abannition"));
        
        assertEquals(354982, linguistic.getAllWords().size());
    }


    @Test(expected = Linguistic.DictionaryWordsNotFoundException.class)
    public void shouldGetExceptionWhenSetIsNotThereAllCombinations(){
        Trie trie = linguistic.createDictionary("test.dictionary.bad.path.txt");
    }
} 