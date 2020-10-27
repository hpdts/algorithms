package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class WordSearchTest {
	WordSearch word = new WordSearch();

	@Test
    public void wordsearch(){
    	char[][] matrix = new char[][]{
				 {'a', 'b', 'c', 'd'},
				 {'e', 'f', 'g', 'h'},
				 {'i', 'd', 'o', 'j'},
				 {'k', 'l', 'm', 'n'}
				};
		assertTrue(word.wordSearch(matrix, "dog"));
		assertTrue(word.wordSearch(matrix, "abcgfd"));
		assertFalse(word.wordSearch(matrix, "don"));
    }

}