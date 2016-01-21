package linguistic;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LinguisticTest {
   private Linguistic linguistic;

    @Before 
    public void initialize() {
       linguistic = new Linguistic();
    }

    @Test
    public void shouldGetChains(){
        List<String> chains = linguistic.getLongestChains("dictionaries/test.dictionary.txt");

        assertEquals(3, chains.size());
        assertEquals("starting => stating => statin => satin => sati => sat => at => a", chains.get(0));
        assertEquals("abcdefgh => abcdefg => abcdef => abcde => abcd => abc => ab => a", chains.get(1));
        assertEquals("abcdefgh => abcdefg => abcdef => abcde => abcd => abc => ab => b", chains.get(2));
    }

    @Test
    public void shouldGetStartingChain(){
        List<String> chains = linguistic.getLongestChains("dictionaries/testStarting.dictionary.txt");
        System.out.println(chains.toString());
        assertEquals(1, chains.size());
        assertEquals("starting => stating => statin => satin => sati => sat => at", chains.get(0));
    }
    
    @Test
    public void shouldGetAllChains(){
      List<String> chains = linguistic.getLongestChains("dictionaries/small.chain.txt");
      assertEquals(2, chains.size());
      assertEquals("ab => a", chains.get(0));
      assertEquals("ab => b", chains.get(1));
    }


    @Test(expected = Linguistic.DictionaryWordsNotFoundException.class)
    public void shouldGetExceptionWhenSetIsNotThereAllCombinations(){
        List<String> chains = linguistic.getLongestChains("test.dictionary.bad.path.txt");
    }
} 