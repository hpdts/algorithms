package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class LRUCacheTest {
	LRUCache lruCache = new LRUCache(3);

	@Test
    public void cache(){
     	lruCache.set("doc", "david");
     	lruCache.set("cpo", "joshua");
     	lruCache.set("ceo", "andy");
     	lruCache.display();

     	String ret = lruCache.get("doc");
     	lruCache.display();
     	assertThat(ret, is("david")); 
     	lruCache.set("swe", "ron");
     	ret = lruCache.get("cpo");
     	lruCache.display();
     	assertNull(ret); 
    }
}