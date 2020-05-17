package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class CourseSFTest {
	CourseSF courseSF = new CourseSF();

	@Test
    public void dups(){
    	List<Integer> dups = courseSF.findAllDuplicates(new int[] {1,2,1,2,3,4});
    	System.out.println(dups.toString());
    }

	@Test
    public void sum2(){
    	assertTrue(courseSF.find2Sum(new int[] {4,2,6,5,7,9,10}, 13));
    	assertFalse(courseSF.find2Sum(new int[] {4,2,6,5,15,12,10}, 13));
    }

    @Test
    public void bits(){
    	int[] bits = courseSF.sortBit(new int[] {0, 1, 1, 0, 1, 1, 1, 0});
    	assertTrue(Arrays.equals(bits, new int[] {0, 0, 0, 1, 1, 1, 1, 1}));
    }

    @Test
    public void unique(){
    	ArrayList<Integer> uniques = courseSF.unique(new int[] {0, 1, 1, 0, 1, 1, 1, 0});
    	System.out.println("uniques: " + uniques.toString());
    }

    @Test
    public void words(){
    	HashMap<String, Integer> frequency = courseSF.wordCount("It's a man, it's a plane, it's superman!");
    	System.out.println("frequency: " + frequency.toString());
    }

    @Test
    public void rgb(){
        int count = courseSF.rgb("rbgrbrgrgbgrrggbbbbrgrgrgrg");
        assertThat(count, is(7));
        count = courseSF.rgb("rgbrgb");
        assertThat(count, is(2));        
    }

    @Test
    public void missings(){
        ArrayList<Integer> missings = courseSF.missingNumber(4, new int[] {1, 4, 2});
        assertThat(missings.toString(), is("[3]"));     
        missings = courseSF.missingNumber(8, new int[] {4, 7, 1, 6});
        assertThat(missings.toString(), is("[2, 3, 5, 8]"));       
        missings = courseSF.missingNumber(6, new int[] {6, 4, 2, 1});
        assertThat(missings.toString(), is("[3, 5]"));
    }

    @Test
    public void paths(){
        int numPaths = courseSF.compute(1,1);
        assertThat(numPaths, is(2));   
        numPaths = courseSF.compute(2,2);
        assertThat(numPaths, is(6));   
        //numPaths = courseSF.uniquePaths(7,3);
        //assertThat(numPaths, is(28));  
        numPaths = courseSF.latticePaths(1,2);
        assertThat(numPaths, is(3));  
    }

    @Test
    public void letterSort(){
        String sorted = courseSF.letterSort("hello");
        assertThat(sorted, is("ehllo"));
        sorted = courseSF.letterSort("whiteboard");
        assertThat(sorted, is("abdehiortw"));
        sorted = courseSF.letterSort("one");
        assertThat(sorted, is("eno"));
    }

    @Test
    public void characterMode(){
        String sorted = courseSF.characterMode("hello");
        assertThat(sorted, is("l"));
         sorted = courseSF.characterMode("A walk in the park");
        assertThat(sorted, is("a"));
         sorted = courseSF.characterMode("noon");
        assertThat(sorted, is("no"));
    }

  
    @Test
    public void sortDigits(){
        int sorted = courseSF.sortDigits(8970);
        assertThat(sorted, is(789));
        sorted = courseSF.sortDigits(32445);
        assertThat(sorted, is(23445));
        sorted = courseSF.sortDigits(10101);
        assertThat(sorted, is(111));
      /* 
           --> 789
   * 32445 --> 23445
   * 10101 --> 111*/
    }

    @Test
    public void getDuplicates(){
        ArrayList<Integer> dups = courseSF.getDuplicates(new int[] {1, 2, 4, 2});
        assertThat(dups.toString(), is("[2]"));
        dups = courseSF.getDuplicates(new int[] {3, 2, 3, 2, 3, 3, 4});
        assertThat(dups.toString(), is("[2, 3]"));
        dups = courseSF.getDuplicates(new int[] {1, 2, 3, 4});
        assertThat(dups.toString(), is("[]"));
    }
   /* [1, 2, 4, 2] --> [2]
    *  [3, 2, 3, 2, 3, 3, 4] --> [3, 2]
    *  [1, 2, 3, 4] --> []*/

    @Test
    public void anagramPair(){
        //"cat", "act" --> true
        assertTrue(courseSF.anagramPair("cat", "act"));
        assertFalse(courseSF.anagramPair("cat", "dog"));
        assertFalse(courseSF.anagramPair("racecar", "aaccrres"));
      //  "cat", "dog" --> false
    //  "racecar", "aaccrres" --> false
    }

    @Test
    public void anagramPalindrome(){
      //  "carrace" --> true ("carrace" can be rearranged to "racecar")`
     //*  `"cat" --> false`
        assertTrue(courseSF.anagramPalindrome("carrace"));
        assertFalse(courseSF.anagramPalindrome("cat"));
    }

    @Test
    public void contiguosSequence(){
        int[] nums = new int[] {1, 3, 1, 4, 23, -10};
        assertTrue(courseSF.contiguosSequenceSumGivenInt(nums, 8));
        assertFalse(courseSF.contiguosSequenceSumGivenInt(nums, 7));
    }

    @Test
    public void contiguosSequence2(){
        int[] nums = new int[] {1, 3, 1, 4, 23, -10};
        assertTrue(courseSF.contiguosSequenceSumGivenInt2(nums, 8));
        assertFalse(courseSF.contiguosSequenceSumGivenInt2(nums, 7));
        int[] nums2 = new int[] {-1, -3, -1, -4, -23, -10};
        assertTrue(courseSF.contiguosSequenceSumGivenInt2(nums2, -23));
        assertTrue(courseSF.contiguosSequenceSumGivenInt2(nums2, -1));
    }

    @Test
    public void pharmacy(){
        courseSF.altoPharmacy();
    }

    @Test
    public void findBadCommit(){
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        int commit = courseSF.findBadCommit(nums);
        assertThat(commit, is(5)); 
    }

    @Test
    public void kthLargestNumber(){
        int[] nums = new int[] {5, 6, 1, 2, 3, 4, 7 , 8,  23, -10, 10, 50, 27, 47, 98, 65};
        int number = courseSF.kthLargestNumber(nums, 1);
        assertThat(number, is(98)); 

        number = courseSF.kthLargestNumber(nums, 4);
        assertThat(number, is(47)); 

        number = courseSF.kthLargestNumber(new int[]{10, 50, 27, 47, 98}, 4);
        assertThat(number, is(27)); 
        
    }

    @Test
    public void sortArrayUsingHeap(){
        int[] sort = courseSF.sortArrayUsingHeap(new int[]{10, 50, 27, 47, 98});
        System.out.println("sort: " + Arrays.toString(sort));
    }
}