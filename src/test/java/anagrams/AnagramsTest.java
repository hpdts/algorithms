package anagrams;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;


public class AnagramsTest {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void checkAnagrams() {
        Map<String, List<String>> anagramsOutcome = anagrams.getAnagrams(Arrays.asList("rats","star", "arts", "bike", "piso", "sopi"));

        assertThat(anagramsOutcome.values().toString(), is("[[piso, sopi], [bike], [rats, star, arts]]"));

    }

} 
