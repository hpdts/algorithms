package reverse;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;

public class ReversePhraseTest {
    private ReversePhrase reversePhrase = new ReversePhrase();

    @Test
    public void reversePhrases() {

        String[] phrases = new String[3];
        phrases[0] = "this is a test";   
        phrases[1] = "phrase number one";   
        phrases[2] = "fail before fail now do not fail after";    
        
        reversePhrase.reverse(phrases);
        assertThat(reversePhrase.getTestCaseOutput().size(), is(3));
        assertThat(reversePhrase.getTestCaseOutput().get(0), is("test a is this "));
        assertThat(reversePhrase.getTestCaseOutput().get(1), is("one number phrase "));
        assertThat(reversePhrase.getTestCaseOutput().get(2), is("after fail not do now fail before fail "));
    }

    
} 
