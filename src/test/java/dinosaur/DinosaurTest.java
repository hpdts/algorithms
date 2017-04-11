package dinosaur;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.io.*;
import static org.junit.Assert.assertTrue;


public class DinosaurTest {

    private Dinosaur dinosaur = new Dinosaur();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        dinosaur = new Dinosaur();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void getBipedals() {
        String pathCsvDataset1 = "files/dataset1.csv";
        String pathCsvDataset2 = "files/dataset2.csv";
        

        dinosaur.processDinosaurs(pathCsvDataset1, pathCsvDataset2);
        String x = "foo bar";
        ///assertTrue(x.contains("foo"));
        assertTrue(outContent.toString().contains("Tyrannosaurus Rex"));
        assertTrue(outContent.toString().contains("Velociraptor"));
        assertTrue(outContent.toString().contains("Struthiomimus"));
        assertTrue(outContent.toString().contains("Hadrosaurus"));
        //Assert.assertThat(outContent, CoreMatchers.containsString("Tyrannosaurus"));
        // Rex Velociraptor Struthiomimus Hadrosaurus

    }

   
} 
