package occurrences;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import java.io.*;
import org.junit.*;

public class OccurrenceTest {
    private Occurrence occurrence;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


	@Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        occurrence = new Occurrence();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldGetOddOccurrences(){
        int[] numbers = { 1, 3, 4, 5, 6, 6, 6, 1, 3, 9, 6, 2, 9, 9, 9, 9, 5, 4, 7, 3, 1, 10 };

        occurrence.oddOccurrences(numbers);

        assertThat(outContent.toString(), is("Numbers with odd occurrences: 1, 2, 3, 7, 9, 10"));
    }

    @Test
    public void shouldGetEvenOccurrences(){
        int[] numbers = { 1, 3, 4, 5, 6, 6, 6, 1, 3, 9, 6, 2, 9, 9, 9, 9, 5, 4, 7, 3, 1 };

        occurrence.evenOccurrences(numbers);

        assertThat(outContent.toString(), is("Numbers with even occurrences: 4, 5, 6"));
    }
    
} 
