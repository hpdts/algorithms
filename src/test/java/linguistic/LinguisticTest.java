package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LinguisticTest {
   private Linguistic linguistic = new Linguistic();

    @Test
    public void shouldGetTwoChains(){
        List<String> chains = linguistic.getLongestChains("dictionaries/test.dictionary.txt");

        assertEquals(3, chains.size());
        assertEquals("starting => stating => statin => satin => sati => sat => at => a", chains.get(0));
        assertEquals("abcdefgh => abcdefg => abcdef => abcde => abcd => abc => ab => a", chains.get(1));
        assertEquals("abcdefgh => abcdefg => abcdef => abcde => abcd => abc => ab => b", chains.get(2));
    }

    @Test
    @Ignore
    public void shouldGetStartingChain(){
        List<String> chains = linguistic.getLongestChains("dictionaries/testStarting.dictionary.txt");

        assertEquals(1, chains.size());
        assertEquals("starting => stating => statin => tatin => satin => sati => sat => at", chains.get(0));
    }
    /*
    @Test
    public void shouldGetAllChains(){
        Trie trie = linguistic.createDictionary("dictionaries/small.chain.txt");
        displaySet(linguistic.getAllWords());

        List<String> chains = linguistic.getAllValidWordsFromDictionary();
        System.out.println("chains in test: " + chains.toString());

        assertEquals(2, chains.size());
        assertEquals("ab => b => a", chains.get(0));
        assertEquals("c", chains.get(1));
    }

    @Test
    @Ignore
    public void shouldSortSet(){
        Trie trie = linguistic.createDictionary("dictionaries/small.chain.txt");
        Set<String> set = linguistic.getAllWords();
        displaySet(set);
        assertEquals(4, set.size());
    }

    private void displaySet(Set<String> set){
      Iterator<String> iterator = set.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    }

     @Test
     @Ignore
     public void shouldAddChainTest(){
         linguistic.addChainOrderedByLength("ab");
         linguistic.addChainOrderedByLength("a");
         linguistic.addChainOrderedByLength("b");
         linguistic.addChainOrderedByLength("c");

         System.out.println(" KEYS TEST: " + linguistic.getChains().keySet().toString());

         String chain1 = "ab => a => b";
         assertEquals(2, linguistic.getChains().size());
         assertEquals(new Integer(3), linguistic.getChains().get(chain1));
         assertTrue(linguistic.getChains().containsKey(chain1));

     }


   @Test
   @Ignore
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

       String chain5 = "startingTo => starting => start => ta => a";
       linguistic.addChainOrderedByLength("startingTo");
       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(5), linguistic.getChains().get(chain5));
       assertTrue(linguistic.getChains().containsKey(chain5));

   }

   @Test
   public void getLastMemberToTheLeft(){
     assertEquals("starting", linguistic.getLastMemberToTheLeft("starting => start => ta => a"));
     assertEquals("ta", linguistic.getLastMemberToTheLeft("ta => a"));
   }

   @Test
   public void getLastMemberToTheRight(){
     assertEquals("start", linguistic.getLastMemberToTheRight("starting => start"));
     assertEquals("ta", linguistic.getLastMemberToTheRight("starting => start => ta"));
     assertEquals("ab", linguistic.getLastMemberToTheRight("ab"));
     assertEquals("a", linguistic.getLastMemberToTheRight("ab => a"));
   }

   @Test
   public void getChainLength(){
     assertEquals(2, linguistic.getChainLength("starting => start"));
     assertEquals(3, linguistic.getChainLength("starting => start => ta"));
   }


   @Test
   public void shouldAddChainInChainsMap(){
       String word1 = "starting";
       linguistic.addChainOrderedByLength(word1);

       assertEquals(1, linguistic.getChains().size());
       assertEquals(new Integer(1), linguistic.getChains().get(word1));
       assertTrue(linguistic.getChains().containsKey(word1));

   }

    @Test
    public void shouldGetWordsRemovingOneLetterAtTheTime(){
        String word1 = "starting";
        List<String> wordsRemovingLetters = linguistic.getWordsRemovingOneLetterAtTheTime(word1);

        assertEquals(word1.length(), wordsRemovingLetters.size());
        assertEquals("tarting", wordsRemovingLetters.get(0));

        word1 = "a";
        wordsRemovingLetters = linguistic.getWordsRemovingOneLetterAtTheTime(word1);

        assertEquals(0, wordsRemovingLetters.size());

    }


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
    }*/
} 