package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import static accelerator.CourseSF.*;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    @Test
    public void getIndexFirstOne(){
        int[] arr2 = new int[]{0,1};
        int index2 = courseSF.getIndexFirstOne(arr2);
        assertThat(index2, is(1)); 
        int[] arr = new int[]{0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1,1};
        int index = courseSF.getIndexFirstOne(arr);
        assertThat(index, is(8)); 
        int[] arr3 = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1,1};
        index = courseSF.getIndexFirstOne(arr3);
        assertThat(index, is(13)); 
    }

    @Test
    public void heapSort(){
        int[] array = new int[] {4,15,16,50,8,23,42,108};
        courseSF.heapify(array);
        System.out.println("heapify: ");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void findLongestPathSubsequenceNumbers(){
        int[][] matrix = new int[][]{
        {3,3,3,3},                      
        {2,3,2,3},
        {1,3,1,3},
        {3,3,1,3},
        {2,2,2,3},
        {1,3,3,3}};
        int longest = courseSF.findLongestPathSubsequenceNumbers(matrix);
        assertThat(longest, is(11)); 
    }

    @Test
    public void freeTime(){
        //Java 9List<Interval> alice = List.of(new Interval(13.5, 14.0), new Interval(15.75, 17.0));
        List<Interval> alice = new ArrayList<>(Arrays.asList(new Interval(13.5, 14.0), new Interval(15.75, 17.0)));
        List<Interval> bob =  new ArrayList<>(Arrays.asList(new Interval(9.0, 12.0), new Interval(13.0, 14.0), new Interval(14.0, 16.0)));
        List<Interval> result = courseSF.getFreeTime(alice, bob);
        System.out.println("result: " + result);
    }

    @Test
    public void getSubArrays(){
        int[] arr = new int[]{1,2,3};
        courseSF.getSubArrays(arr);
    }

    @Test
    public void fizzBuzz(){
        courseSF.fizzBuzz();
    }

    /*Given a grid represented as a 2D array, 
    find the longest line in the grid. 
    Lines were represented by 1s, 0s meant no lines. 
    Lines could run horizontal, vertical or diagonal.
    0,0,0,0
    0,1,0,0
    0,1,1,0
    0,1,0,1*/

    @Test
    public void longestLine(){
        int[][] grid = new int[][]{
           //0 1 2 3 
            {0,0,0,0},//0
            {0,1,0,0},//1
            {0,1,1,0},//2
            {0,1,0,1} //3
        };
        int line = courseSF.findLongestLine(grid);
        assertThat(line, is(5)); 
        int[][] grid2 = new int[][]{
        //   0 1 2 3 4 5 6 7
            {0,0,1,0,0,0,0,0},//0
            {0,1,0,0,0,1,0,1},//1
            {0,1,0,0,0,1,1,0},//2
            {0,1,0,0,0,1,0,1} //3
        };
        int line2 = courseSF.findLongestLine(grid2);
        assertThat(line2, is(6)); 
    }

    @Test
    public void knapSack(){
        int[] weights = new int[]{10, 20, 30};
        int[] values = new int[]{60, 100, 120};
        int capacity = 50;
        int max = courseSF.knapSack(weights, values, capacity);
        assertThat(max, is(220));
        max = courseSF.knapSackBottomUp(weights, values, capacity);
        //assertThat(max, is(220));
    }

    @Test
    public void stock(){
        int profit = courseSF.stock(new int[]{7, 1, 5, 3, 6, 4});
        assertThat(profit, is(5));
    }

    @Test
    public void bikes(){
        char[][] bikes = new char[][] {{'b','b','p'},
                                       {'b','b','b'}};
        int[][] dist = courseSF.getMinDistances(bikes);
        assertThat(dist[0][0], is(2));
        assertThat(dist[0][1], is(1));
        assertThat(dist[1][0], is(3));
    }

    @Test
    public void zombies(){
        int[][] grid = new int[][]  {{0, 1, 1, 0, 1},
                                    {0, 1, 0, 1, 0},
                                    {0, 0, 0, 0, 1},
                                    {0, 1, 0, 0, 0}};
        int hours = courseSF.getManyHoursInfection(grid);
        assertThat(hours, is(2));
    }

    @Test
    public void comparativeAdvantage(){
        Set<String> tasks = new HashSet<>(Arrays.asList("coding","cleaning","listening","eating"));
        String[] peopleArray = new String[] {"cory","dennis","genji","joanna"};
        Map<String, Map<String, Integer>> teamSkills = new HashMap<>();
        
        Map<String, Integer> expertiseJoanna = new HashMap<>();
        expertiseJoanna.put("coding", 3);
        expertiseJoanna.put("cleaning", 4);
        expertiseJoanna.put("listening", 10);
        expertiseJoanna.put("eating", 10);
        teamSkills.put("joanna" , expertiseJoanna);

        Map<String, Integer> expertiseCory = new HashMap<>();
        expertiseCory.put("coding", 7);
        expertiseCory.put("cleaning", 5);
        expertiseCory.put("listening", 4);
        expertiseCory.put("eating", 7);
        teamSkills.put("cory" , expertiseCory);

        Map<String, Integer> expertiseDennis = new HashMap<>();
        expertiseDennis.put("coding", 6);
        expertiseDennis.put("cleaning", 7);
        expertiseDennis.put("listening", 9);
        expertiseDennis.put("eating", 3);
        teamSkills.put("dennis" , expertiseDennis);

        Map<String, Integer> expertiseGenji = new HashMap<>();
        expertiseGenji.put("coding", 5);
        expertiseGenji.put("cleaning", 4);
        expertiseGenji.put("listening", 10);
        expertiseGenji.put("eating", 1);
        teamSkills.put("genji" , expertiseGenji);

        int tot = courseSF.getComparativeAdvantage(tasks, peopleArray, teamSkills);
        assertThat(tot, is(34));
    }

     @Test
    public void comparativeAdvantage2(){
        Set<String> tasks = new HashSet<>(Arrays.asList("coding","cleaning"));
        String[] peopleArray = new String[] {"genji","joanna"};
        Map<String, Map<String, Integer>> teamSkills = new HashMap<>();
        
        Map<String, Integer> expertiseJoanna = new HashMap<>();
        expertiseJoanna.put("coding", 3);
        expertiseJoanna.put("cleaning", 4);
        teamSkills.put("joanna" , expertiseJoanna);

        Map<String, Integer> expertiseGenji = new HashMap<>();
        expertiseGenji.put("coding", 5);
        expertiseGenji.put("cleaning", 4);
        teamSkills.put("genji" , expertiseGenji);

        int tot = courseSF.getComparativeAdvantage(tasks, peopleArray, teamSkills);
        assertThat(tot, is(9));
    }

    @Test
    public void eightQueens(){
       List<Integer[]> results = new ArrayList<Integer[]>(); 

       courseSF.placeQueens(0, new Integer[8], results);
        for(Integer[] res : results){
            System.out.println("res: " + Arrays.toString(res));
            int resIndex = 0;
            for(int row = 0; row < 8; row++){
                for(int col = 0 ; col < 8; col++){
                    if(res[resIndex] == col){
                        System.out.print("Q");
                    }else{
                        System.out.print(" ,");
                    }
                }
                resIndex++;
                System.out.println("");
            }

        }
    }

    @Test
    public void ambigram(){
        assertTrue(courseSF.isAmbigram("hola"));
        assertTrue(courseSF.isAmbigram("pod"));
        assertTrue(courseSF.isAmbigram("suns"));
        assertTrue(courseSF.isAmbigram("dollop"));
        assertFalse(courseSF.isAmbigram("casa"));
    }

/**
    1 -----  2
    |   /    |
    |  /     |
    0 ------ 3 
**/    
    @Test
    public void cycle(){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> neighbors0 = new ArrayList<>(Arrays.asList(1,2,3));
        graph.put(0, neighbors0);

        List<Integer> neighbors1 = new ArrayList<>(Arrays.asList(0,2));
        graph.put(1, neighbors1);

        List<Integer> neighbors2 = new ArrayList<>(Arrays.asList(1,0,3));
        graph.put(2, neighbors2);

        List<Integer> neighbors3 = new ArrayList<>(Arrays.asList(0,2));
        graph.put(3, neighbors3);

        assertTrue(courseSF.haveACycle(graph));
    }

    @Test
    public void fibo(){
        assertThat(courseSF.fibonacci(5),is(5));
    }

    @Test
    public void perfect(){
        assertThat(courseSF.smallNumberPerfectSquare(259),is(9.0));
    }

    @Test
    public void edit(){
        assertThat(courseSF.editDistance("sunday", "saturday"), is(3));
    }

    @Test
    public void gaussianDistribution(){
        assertThat(courseSF.getMaxGaussianDistribution(new int[] {1,2,3,4,5,4,3,2}), is(5));
        assertThat(courseSF.getMaxGaussianDistribution(new int[] {3,1,0}), is(3));
        assertThat(courseSF.getMaxGaussianDistribution(new int[] {1,2,3,4,5,4}), is(5));
        assertThat(courseSF.getMaxGaussianDistribution(new int[] {1,2,3,4,5,2}), is(5));
    }

    @Test
    public void getWeightById() throws Exception{
        courseSF.createGraph();
        assertThat(courseSF.getWeightById("null"), is(160));
        assertThat(courseSF.getWeightById("2"), is(90));
        assertThat(courseSF.getWeightById("6"), is(60));
        assertThat(courseSF.getWeightById("3"), is(30));
    }   

    @Test
    public void shortestPath(){
        int[] path = courseSF.shortestPath(new int[] {1, 0, 0, 7, 1, 2, 2, 2, 3, 7});
        System.out.println("path: " + path);
        assertThat(path[3], is(9));
    } 

    @Test
    @Ignore
    public void validRequestRate() throws InterruptedException{
      Date date = new Date();
       //Pattern for showing milliseconds in the time "SSS"
       DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
       String stringDate = sdf.format(date);
       System.out.println(stringDate);

       Date date2 = new Date();
       //Pattern for showing milliseconds in the time "SSS"
       //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
       String stringDate2 = sdf.format(date2);
       System.out.println(stringDate2);

long difference_In_Time 
                = date2.getTime() - date.getTime();  
    System.out.println("difference_In_Time: " + difference_In_Time);

                long difference_In_Seconds 
                = (difference_In_Time 
                   / 1000) 
                  % 60; 
System.out.println("difference_In_Seconds: " + difference_In_Seconds);

             long millis = System.currentTimeMillis();
  System.out.println("now: " + millis); // prints a Unix timestamp in milliseconds
  System.out.println(millis / 1000); // prints the same Unix timestamp in seconds

   millis = System.currentTimeMillis();
  System.out.println(millis); // prints a Unix timestamp in milliseconds
  System.out.println(millis / 1000); // prints the same Unix timestamp in seconds
  
  long now = Instant.now().toEpochMilli();
  long now2 = Instant.now().toEpochMilli();

  System.out.println("now: " + now); 
  System.out.println("now2: " + now2); 
        assertTrue(courseSF.validRequestRate()); // true
        assertTrue(courseSF.validRequestRate()); // true
        assertTrue(courseSF.validRequestRate()); // true
        assertFalse(courseSF.validRequestRate()); // false
        assertFalse(courseSF.validRequestRate()); // false
        assertFalse(courseSF.validRequestRate()); // false
        Thread.sleep(1000);
        System.out.println("after 1 sec: ");
        assertTrue(courseSF.validRequestRate()); // true
        assertTrue(courseSF.validRequestRate()); // true
        assertFalse(courseSF.validRequestRate()); // true
        assertFalse(courseSF.validRequestRate()); // false

    } 

    @Test
    public void cutTree(){
        List<Integer> parent = Arrays.asList(-1,0,0,1,1,2);
       Map<Integer, List<Integer>> adjacency = courseSF.constructTree(parent);
       System.out.println("adjacency: " + adjacency);
       assertThat(adjacency.get(2).toString(), is("[5]"));
       List<Integer> file_size = Arrays.asList(1,2,2,1,1,1);
       int totalFromRoot = courseSF.getTotalSizeFromNode(0, file_size, adjacency);
       assertThat(totalFromRoot, is(8));
       int totalFromTwo = courseSF.getTotalSizeFromNode(2, file_size, adjacency);
       assertThat(totalFromTwo, is(3));
       int totalFromOne = courseSF.getTotalSizeFromNode(1, file_size, adjacency);
       assertThat(totalFromOne, is(4));

       int diffAbsoulte = courseSF.mostBalancedPartition(parent, file_size);
       assertThat(diffAbsoulte, is(0));
    }

    /*
    Given an array of integers, 
    print sums of all subsets in it. 
    Output sums can be printed in any order.
    Examples :

    Input : arr[] = {2, 3}
    Output: 0 2 3 5

    null

    0

    2

    3

    2+3 = 5
    Input : arr[] = {2, 4, 5}
    Output : 0 2 4 5 6 7 9 11

    0
    2
    4
    5
    2+4
    2+5
    4+5
    2+4+5= 11
        */

    @Test
    public void subset(){
        int[] arr = new int[]{2, 3};
        List<Integer> ret = courseSF.subsetSum(arr);
        assertThat(ret.toString(), is("[0, 2, 3, 5]"));
        ret = courseSF.subsetSum(new int[]{2, 4, 5});
        assertThat(ret.toString(), is("[0, 2, 4, 5, 6, 7, 9, 11]"));
    }
}