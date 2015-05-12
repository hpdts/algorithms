package cachilupi;


import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CachilupiTest {

    private Cachilupi cachilupi = new Cachilupi();;

    @Test
    public void getTrueWhenNumberisCachipuli() {
        assertTrue(cachilupi.isNumberACachilupi("1210"));
    }


   /* @Test
    public void getNumberCountfromIndex() {
        assertThat(cachilupi.occurrencesOfNumbers("1210"), is(1));
        //assertThat(cachilupi.countTotalOfNumbers("1210", 1), is(2));
        //assertThat(cachilupi.countTotalOfNumbers("1210", 2), is(1));
        //assertThat(cachilupi.countTotalOfNumbers("1210", 3), is(0));
    }*/

} 
