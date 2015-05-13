package cachilupi;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;


public class CachilupiTest {

    private Cachilupi cachilupi = new Cachilupi();

    @Test
    public void getTrueWhenNumberisCachipuli() {
        assertThat(cachilupi.isNumberACachilupi("1210"), is(true));
        assertThat(cachilupi.isNumberACachilupi("121"), is(false));
    }

    @Test
    public void multiset_example () {
        
        Multiset<String> camouflage = HashMultiset.create();
        camouflage.add("Realtree APG");
        camouflage.add("Realtree Hardwoods HD");
        camouflage.add("Realtree APG");
        camouflage.add("Realtree Hardwoods Green HD");
        camouflage.add("Mossy Oak New Break-Up");
        camouflage.add("Realtree APG");

        int numberOfRealTrees = camouflage.count("Realtree APG");
        
        assertThat(numberOfRealTrees, is(3));

        Multiset<Character> camouflage2 = HashMultiset.create();
        camouflage2.add('0');
        camouflage2.add('0');

        numberOfRealTrees = camouflage2.count('0');
        
        assertThat(numberOfRealTrees, is(2));
    }
} 
