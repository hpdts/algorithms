package linguistic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import java.io.*;
import org.junit.*;

public class LinguisticTest {
    private Trie trie;



    @Test
    public void shouldCreateDictionary(){
        trie = new Trie();

        trie.insert("a");
        trie.insert("at");
        trie.insert("bat");
        trie.insert("be");
        trie.insert("bee");
        trie.insert("sat");
        trie.insert("sati");
        trie.insert("satin");
        trie.insert("starting");
        trie.insert("statin");
        trie.insert("stating");


        if(trie.search("starting")){
            System.out.println("Tea is a valid word");
        }
    }

    
} 
