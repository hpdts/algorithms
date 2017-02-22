package baseball;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.junit.*;

public class BaseballTest {
    private Baseball baseball = new Baseball();


 
    @Test
    public void getScore(){
        String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        int numbersSymbols = 8;

        int score = baseball.getScore(blocks, numbersSymbols);
        System.out.println("score: " + score);
        assertThat(score, is(27));
    }

    
} 
