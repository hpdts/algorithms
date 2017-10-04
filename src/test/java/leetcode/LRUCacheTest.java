package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class LRUCacheTest {

	LRUCache cache = new LRUCache(100);

	@Test
    public void cache(){
		cache.set(1, 1);
		System.out.println(cache.get(1));
    }


}