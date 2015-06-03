package alien;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;

public class AlienLanguageTest {
    private AlienLanguage alienLanguage = new AlienLanguage();

    @Test
    public void getWordsOnTheLanguage() {
        int lines = 4;
        int wordLenght = 10;
        int numberOfTestCases = 6;
        //List<String> testCasesOutput = alienLanguage.getWordsOntheAlienLaguage(1,1,1);


    }


    @Test
    public void getPermutations() {
        List<String> permutations = alienLanguage.permute("xy");
        assertThat(permutations.size(), is(2));
        assertThat(permutations.get(0), is("xy"));
        assertThat(permutations.get(1), is("yx"));
    }


    
} 
