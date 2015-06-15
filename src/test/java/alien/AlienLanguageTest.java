package alien;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;

public class AlienLanguageTest {
    private AlienLanguage alienLanguage = new AlienLanguage();

    @Test
    public void shouldNotGetWordsForLessWordsThanExpected() {
        int lines = 4;
        int wordLenght = 10;
        int numberOfTestCases = 6;
        String[] words = new String[3];
        alienLanguage.getWordsOntheAlienLaguage(lines, wordLenght, numberOfTestCases, words);
        assertThat(alienLanguage.getDictionary().size(), is(0));
    }

    @Test
    public void getWordsOnTheLanguage() {
        int lines = 4;
        int wordLenght = 3;
        int numberOfTestCases = 6;
        String[] words = new String[4];
        words[0] = "abc";   
        words[1] = "bca";   
        words[2] = "acb";   
        words[3] = "afc";   
        alienLanguage.getWordsOntheAlienLaguage(lines, wordLenght, numberOfTestCases, words);
        assertThat(alienLanguage.getDictionary().size(), is(lines));
        assertThat(alienLanguage.getDictionary().get(0).length(), is(wordLenght));
        assertThat(alienLanguage.getDictionary().get(1).length(), is(wordLenght));
        assertThat(alienLanguage.getDictionary().get(3).length(), is(wordLenght));
    }

    @Test
    public void shouldNotGetAllWordsForWordsOfDifferentLength() {
        int lines = 4;
        int wordLenght = 3;
        int numberOfTestCases = 6;
        String[] words = new String[4];
        words[0] = "abc";   
        words[1] = "bc";   
        words[2] = "acb";   
        words[3] = "afcddd";   
        alienLanguage.getWordsOntheAlienLaguage(lines, wordLenght, numberOfTestCases, words);
        assertThat(alienLanguage.getDictionary().size(), is(2));
        assertThat(alienLanguage.getDictionary().get(0).length(), is(wordLenght));
        assertThat(alienLanguage.getDictionary().get(1).length(), is(wordLenght));
    }

    @Test
    public void getPermutations() {
        List<String> permutations = alienLanguage.permute("xy");
        assertThat(permutations.size(), is(2));
        assertThat(permutations.get(0), is("xy"));
        assertThat(permutations.get(1), is("yx"));

        alienLanguage.cleanPermutations();        
        permutations = alienLanguage.permute("x");
        assertThat(permutations.size(), is(1));
        assertThat(permutations.get(0), is("x"));

        alienLanguage.cleanPermutations();        
        permutations = alienLanguage.permute("1234");
        assertThat(permutations.size(), is(24));
        System.out.println(permutations.toString());
    }


    
} 
