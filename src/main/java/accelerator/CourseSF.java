package accelerator;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Queue;
import java.util.LinkedList;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.io.*;  
import java.util.Scanner;  

public class CourseSF{
	public static ArrayList<Integer> findAllDuplicates(int[] arr) {
	    Set<Integer> numbers = new HashSet<>();
	    ArrayList<Integer> duplicates = new ArrayList<>();
	    for(int num : arr){
	      if(!numbers.add(num)){
	        duplicates.add(num);
	      }
	    } 
	    return duplicates;
  }

  public boolean find2Sum(int[] nums, int target){
  	Set<Integer> diff = new HashSet<>();

  	for(int num : nums){
  		if(diff.contains(num)){
  			return true;
  		}else{
  			diff.add(target - num);
  		}
  	}
  	return false;
  }

  public int[] sortBit(int[] bits){
	int[] frequency = new int[2];

	for(int bit : bits){
		frequency[bit]++;
	}  

	int[] sorted = new int[bits.length];
	int sortedIndex = 0;
	for(int index = 0; index < frequency.length; index++){
		int count = frequency[index];
		while(count > 0){
			sorted[sortedIndex++] = index;
			count--;
		}
	}	
	return sorted;
  }

   public ArrayList unique(int[] arr) {
      // YOUR WORK HERE
      Set<Integer> dups = new HashSet<>();
      ArrayList<Integer> uniques = new ArrayList<>();
      for(int num : arr){
        if(dups.add(num)){
          uniques.add(num);
        }
      }
      return uniques;
   }

   public  HashMap wordCount(String sentence) {
      // YOUR WORK HERE
      String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
      HashMap<String, Integer> frequency = new HashMap<>();
      for(String word : words){
        if(frequency.containsKey(word)){
          int count = frequency.get(word);
          frequency.put(word, ++count);
        }else{
          frequency.put(word, 1);
        }
      }
      return frequency;
    }

    public static int rgb(String string) {
      Map<Character, Integer> counts = new HashMap<>();
      for(Character letter : string.toCharArray()){
        if(counts.containsKey(letter)){
          int count = counts.get(letter);
          counts.put(letter, ++count);
        }else{
          counts.put(letter, 1);
        }
      }

      int countR = counts.get('r');
      int countG = counts.get('g');
      int countB = counts.get('b');

      return Math.min(Math.min(countR, countG), countB);
     }

     public ArrayList missingNumber(int n, int[] arr) {
      Set<Integer> uniques = new HashSet<>();
      ArrayList<Integer> missings = new ArrayList<>();
      for(int num : arr){
        uniques.add(num);
      }
      for(int i = 1; i <= n; i++){
        if(!uniques.contains(i)){
          missings.add(i);
        }
      }
      return missings;
    }

    //recuirsive call on stack // base recursive case
    public int compute(int m, int n) {
    	// YOUR WORK HERE
	    //return paths(m, n, 0, 0); 
	    return helper(m,n,0,0);
  	}
  	//down and right // bottom up
  	public int paths(int m, int n, int d, int r){
  		//int m, int n, int d, int r
  		if(d > m || r > n){
  			return 0;
  		}
  		if(d == m && r == n){
  			return 1;
  		}
  		return paths(m,n,r+1,d) + paths(m,n,r,d+1); 
  	}

  	private static int helper(int m, int n, int currRow, int currCol) {
        //Helper method recursion (bottom-up approach, working up to m,n coordinate)
        //Base cases
        //1. Invalid path
        if(currRow > m || currCol > n) return 0;
        //2. Destination reached
        if(currRow == m && currCol == n) return 1;
        
        //Recursive case checking forward down or right
        return helper(m, n, currRow+1, currCol) + helper(m, n, currRow, currCol+1);
    }

	//botton up
	public static int latticePaths(int m, int n) {
        //Pure recursion (top-down approach, working down to 0,0 coordinate)
        //Base cases
        //1. Invalid path
        if(m < 0 || n < 0) return 0;
        //2. Destination reached
        if(m==0 && n==0) return 1;
        
        //Recursive cases checking back up or left
        return latticePaths(m-1, n) + latticePaths(m, n-1);
    }

     public String letterSort(String input) {
	     // count sort
	    int[] counts = new int[26];
      char[] sorted = input.toCharArray();
	    for(Character letter : sorted){
	      int index = letter - 'a';
	      counts[index]++;
	    }
     // System.out.println("counts:" + Arrays.toString(counts));
      int k = 0;
	    for(int i =0; i< counts.length; i++){
        int count = counts[i];
	      while(count > 0){
	        sorted[k++] = (char)('a' + i);   
	        count--;
	      }
	    }
	     return new String(sorted);
   }

    public static String characterMode(String string) {
      // YOUR WORK HERE
      int maxCount = Integer.MIN_VALUE;
      Map<Character, Integer> counts = new HashMap<>();
      String result = "";
      for(Character letter : string.toLowerCase().toCharArray()){
        if(letter != ' '){
          int countPass = 0;
          if(counts.containsKey(letter)){
            int count = counts.get(letter);
            counts.put(letter, ++count);
            countPass = count;
          }else{
            countPass = 1;
            counts.put(letter, 1);
          }
          if(countPass > maxCount){
            maxCount = countPass;
          }
        }
      }

      for(Entry<Character, Integer> entry : counts.entrySet()){
        int count = entry.getValue();
        Character key = entry.getKey();
        if(count == maxCount){
          maxCount = count;
          result+=key;
        }
      }
      return result;
    }

    public static int sortDigits(int n) {
      // YOUR WORK HERE
      int[] counts = new int[10];
      int number = n;
      int digits = -1; 
      while(number > 0){
        int digitRight = number % 10;
        number/=10;
        if(digitRight != 0){
          counts[digitRight]++;
          digits++;
        }
      }
      int numberSorted = 0;
      for(int index = 0; index < counts.length; index++){
        int count = counts[index];
        while(count > 0){
          numberSorted+= index * Math.pow(10, digits--); 
          count--;
        }
      }
      return numberSorted;
    }  

    public static ArrayList getDuplicates(int[] arr) {
      int[] counts = new int[10];
       // YOUR WORK HERE
      ArrayList<Integer> dups = new ArrayList<>();
      for(int number : arr){
        counts[number]++;
      }

      for(int index = 0; index < counts.length; index++){
        int count = counts[index];
        if(count > 1){
          dups.add(index);
        }
      }

       return dups;
   }

  public static Boolean anagramPair(String string1, String string2) {
      // YOUR WORK HERE
      Map<Character, Integer> counts1 = createCounts(string1); 
      Map<Character, Integer> counts2 = createCounts(string2); 
      return counts1.equals(counts2);
  }

  public static Map<Character, Integer> createCounts(String string1){
    Map<Character, Integer> counts1 = new HashMap<Character, Integer>();
      for(Character letter : string1.toCharArray()){
        if(counts1.containsKey(letter)){
          int count = counts1.get(letter);
          counts1.put(letter, ++count);
        }else{
          counts1.put(letter, 1);
        }
      }
    return counts1;
  }

   public static Boolean anagramPalindrome(String str) {
    // YOUR WORK HERE
    Map<Character, Integer> counts1 = createCounts(str);

    boolean oneOddCount = false;
    for(Entry<Character, Integer> entry : counts1.entrySet()){
      int count = entry.getValue();
      Character letter = entry.getKey();
      if(count % 2 != 0){
        if(oneOddCount){
          return false;
        }
        oneOddCount = true;
      }
    }

    return true;
  }

  public boolean contiguosSequenceSumGivenInt(int[] nums, int target){
    int slow = 0;
    int fast = slow + 1;
    int windowSum = 0;

    windowSum = nums[slow];
    while(fast < nums.length){
      System.out.println("windowSum: " + windowSum);
      if(windowSum == target){
        return true;
      }else if(windowSum > target){
        windowSum -= nums[slow];
        slow++;
      }else{
        windowSum += nums[fast];
        fast++;
      }
    }
    return false;
  }

   public boolean contiguosSequenceSumGivenInt2(int[] nums, int target){
    int start = 0;
    int end = 0;
    int currSum = 0;
    Map<Integer,Integer> complements = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      currSum+= nums[i];
      if(currSum == target){
        start = 0;
        end = i;
        return true;
      } 
      int complement = currSum - target;
      if(complements.containsKey(complement)){
        start = complements.get(complement);
        end = i;
        return true;
      }
      complements.put(currSum, i);
    }
    return false;
  }

  class Employee{
    int employeeId;
    String username;
    Role role;
    public Employee (int employeeId, String username, Role role){
      this.employeeId = employeeId;
      this.username = username;
      this.role = role;
    }
  }
    
  class Role{
   int roleId;
   String name;
    List<Task> tasks;
   public Role (int roleId, String name, List<Task> tasks){
      this.roleId = roleId;
      this.name = name;
      this.tasks = tasks;
  }
    
    public List<Task> getTasks(){
      return tasks;
    }
 }
  
  class Task implements Comparable<Task>{
   int taskId;
   String name;
   TaskType taskType;
   public Task (int taskId, String name, TaskType taskType){
      this.taskId = taskId;
      this.name = name;
      this.taskType = taskType;
  }
   
  public TaskType getTaskType(){
    return taskType;
  }

  @Override
  public int compareTo(Task task){
    return this.taskType.urgency - task.taskType.urgency;
  }
   
 }
    
  class TaskType{
   int taskTypeId;
   int urgency;
   public TaskType (int taskTypeId, int urgency){
      this.taskTypeId = taskTypeId;
      this.urgency = urgency;
    }
 }
  
  
  
  public void altoPharmacy() {
    TaskType mins30 = new TaskType(1, 30);
    TaskType mins10 = new TaskType(2, 10);
    TaskType mins60 = new TaskType(3, 60);
    
    Task patientMsg = new Task(1, "patient message", mins30);
    Task prescription = new Task(2, "update a prescription", mins60);
    Task door = new Task(3, "open door", mins60);
    
    List<Task> tasksPharmacist = new ArrayList<>();
    tasksPharmacist.add(patientMsg);
    tasksPharmacist.add(prescription);
    
    Role pharmacist = new Role(1, "Pharmacist", tasksPharmacist);
    
    Employee johnPharmacist = new Employee(1, "John", pharmacist);
    
    Role role = johnPharmacist.role;
    List<Task> tasks = role.getTasks();
    Collections.sort(tasks);
    for(Task task : role.getTasks()){
      System.out.println(task.taskId + "," + task.name);
      TaskType type = task.getTaskType();
      System.out.println(type.urgency);//sort by urgency;
    }
  }

  public int findBadCommit(int[] commits){
    int start = 0; //0
    int end = commits.length; // 7
    int middle = 0;
    //3 mistakes 1 help FB 5/14/2020
    while(start < end){// 0 < 7. 4 < 7
      middle = (start + end) / 2; //3.5 => 3
      /*System.out.println("start: " + start);
      System.out.println("end: " + end);
      System.out.println("middle: " + middle);
      System.out.println("commits[middle]: " + commits[middle]);*/
      if(runTest(commits[middle])){  //good build look on the right
        start = middle + 1; // build on the right middle + 1 
      }else{ //bad build look for the one on the left
        end = middle;
      }
      
    }
    /* System.out.println("start: " + start);
      System.out.println("end: " + end);
      System.out.println("middle: " + middle);
      System.out.println("commits[middle]: " + commits[middle]);*/

    return commits[start];
  }

  public boolean runTest(int commit){
    //from here to end is all red build
    if(commit >= 5){
      return false;  
    }else{
      return true;
    }
  }


  public int kthLargestNumber(int[] nums, int k){
    
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    
    for(int num : nums){
      queue.add(num);
    }
    System.out.println("heapify array: " + queue.toString());
    System.out.println("heap head: " + queue.peek());
    int number = 0;
    while(k > 0) 
    {
        number = queue.poll();
        System.out.println(number);
        k--;
    }
    //[10, 50, 27, 47, 98]
    //poll
 /*   for(int i=0; i < k; i++ ){
      queue.remove();
    }
    int number = queue.remove();*/
    return number;
  }

  public int[] sortArrayUsingHeap(int[] input){
     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      int lengthNewArray = 0;
      //for(int[] sortedArray : input){
     for(int numbers : input){
       minHeap.add(numbers);
       lengthNewArray++;
     } 
      //}
      int[] sortBigArray = new int[lengthNewArray];
      int i = 0;
      while(minHeap.size() > 0){
        int number = minHeap.remove();
        //System.out.println("number: " + number);
        sortBigArray[i] = number;
        i++;
      }
      return sortBigArray;
  }

  public int getIndexFirstOne(int[] arr){
    int start = 1;
    if(arr[start] == 1){
        return arr[start-1] == 0 ? arr[start] : arr[start -1]; 
    }else{
        while(arr[start] == 0){
          System.out.println("start: " + start);
          start*=2;
        }
        if(arr[start-1] == 0){
          return start;
        }
    }
    System.out.println("arr[start]: " + arr[start]);
    System.out.println("start: " + start);
    //arr[start] == 1
    //                                e 
    //0,0,0,0,0,0,0,.....,0,1,1,1, 1, 1,
    //s                         m    
    int end = start;
    start = 0;
    int middle = 0;
    while(start < end){
      middle = (start + end)/2;
      if(arr[middle] == 0){
        start = middle +1;
      }else if(arr[middle-1] == 0){
         return middle;
      }else{
        end = middle;
      }
    }
    return -1;
  }

  int heapLength = 1;
  public void heapify(int[] arr){

    while(heapLength < arr.length){
      insert(arr);
    }

    while(heapLength > 1){
      remove(arr);
    }
  }

  public int getChild(int parent, int[] arr){
    int leftChild = parent * 2 + 1;
    int rightChild = leftChild + 1;
    if(leftChild >= heapLength-1 || arr[leftChild] >= arr[rightChild]){
      return leftChild;
    }
    return rightChild;
  }

  public void bubbleDown(int[] arr){
    int parent = 0;
    int child = getChild(parent, arr);
    while(child < heapLength && arr[parent] < arr[child]){
      swap(arr, parent, child);
      parent = child;
      child = getChild(parent, arr);
    }
  }

  public void remove(int[] arr){
    swap(arr, 0, heapLength-1);
    heapLength--;
    bubbleDown(arr);
  }

  public void insert(int[] arr){
    heapLength++;
    bubbleUp(arr);
  }

  public void bubbleUp(int[] arr){
    int child = heapLength - 1;
    int parent = getParent(child);
    while(child > 0 && arr[parent] < arr[child]){
      swap(arr, child, parent);
      child = parent;
      parent = getParent(child);
    }
  }

  public int getParent(int child){
    return (child-1)/2;
  }

  public void swap(int arr[], int child, int parent){
    int temp = arr[child];
    arr[child] = arr[parent];
    arr[parent] = temp;
  }

  public int findLongestPathSubsequenceNumbers(int[][] matrix){
    Queue<Point> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    int maxLength = Integer.MIN_VALUE;
    for(int i = 0; i < matrix.length ; i++ ){
       for(int j = 0; j < matrix[0].length ; j++ ){
        String coordinateCandidate = i + "," + j;
        if(!visited.contains(coordinateCandidate)){
          queue.add(new Point(i, j, 1));
          while(!queue.isEmpty()){
            Point curr = queue.remove();
            //System.out.println("curr 1: " + curr);

            int x = curr.x;
            int y = curr.y;
            int currLength = curr.length;
            int currNumber = matrix[x][y];
            String coordinate = x + "," + y;
            visited.add(coordinate);
            boolean isPathFind = false;
            //right 
            //check boundaries
            String coordinateRight = (x+1) + "," + y;
            String coordinateLeft = (x-1) + "," + y;
            String coordinateDown = x + "," + (y-1);
            String coordinateUp = x + "," + (y+1);
            if(!visited.contains(coordinateRight) && x+1 >= 0 && x+1 < matrix.length && y >= 0 && y < matrix[0].length && currNumber == matrix[x+1][y]){
              queue.add(new Point(x+1, y, currLength+1));
              isPathFind = true;
            }
            //left
            if(!visited.contains(coordinateLeft) && x-1 >= 0 && x-1 < matrix.length && y >= 0 && y < matrix[0].length && currNumber == matrix[x-1][y]){
              queue.add(new Point(x-1, y, currLength+1));
              isPathFind = true;
            }
            //down
            if(!visited.contains(coordinateDown) && x >= 0 && x < matrix.length && y-1 >= 0 && y-1 < matrix[0].length && currNumber == matrix[x][y-1]){
              queue.add(new Point(x, y-1, currLength+1));
              isPathFind = true;
            }
            //up
            if(!visited.contains(coordinateUp) && x >= 0 && x < matrix.length && y+1 >= 0 && y+1 < matrix[0].length && currNumber == matrix[x][y+1]){
              queue.add(new Point(x, y+1, currLength+1));
              isPathFind = true;
            }
            if(!isPathFind){
             /* System.out.println("point: " + curr);
              System.out.println("value: " + matrix[x][y]);
              System.out.println("queue: " + queue.toString());
              System.out.println("visited: " + visited.toString());*/
              maxLength = Math.max(maxLength, currLength);
            }
          }
        }
      }
    }
    return maxLength;
  }
  
  public class Point{
    int x;
    int y;
    int length;
    public Point(int x, int y, int length){
      this.x = x;
      this.y = y;
      this.length = length;
    }
    public String toString(){
      return "x: " + x + ", y: " + y + ", length: " + length;
    }

    public boolean equals(Point p){
      return x == p.x && y == p.y;
    }
    public int hashCode(){
        return x + y;
    }
  }

  public static class Interval{
    double start_time;
    double end_time;
    
    public Interval(double start_time, double end_time){
      this.start_time = start_time;
      this.end_time = end_time;
    }
    
    public String toString(){
      return "start_time: " + start_time + ", end_time: " + end_time;
    }
  }
  
 /* public List<Interval> freeIntervals(List<List<Interval>> intervals){
    for(List<Interval> interval : intervals){
      
    }
    return null;
  }*/
  public List<Interval> getFreeTime(List<Interval> intervals1, List<Interval> intervals2){
    List<Interval> allIntervals = new ArrayList<>();
    allIntervals.addAll(intervals1);
    allIntervals.addAll(intervals2);
    Collections.sort(allIntervals, new Comparator<Interval>(){
      //-1 if (x < y)
        public int compare(Interval i1, Interval i2){
          return Double.compare(i1.start_time, i2.start_time);
        }
    });

    Interval first = allIntervals.get(0);
    double start = first.start_time;
    double end = first.end_time;

    List<Interval> merged = new ArrayList<>();
    for(int i = 1; i < allIntervals.size(); i++){
      Interval current = allIntervals.get(i);
      if(current.start_time <= end){
        end = Math.max(end, current.end_time);
      }else{
        merged.add(new Interval(start, end));
        start = current.start_time;
        end = current.end_time;
      }
    }
    merged.add(new Interval(start, end));
    //get Free time
    List<Interval> resultFreeTime = new ArrayList<>();
    if(merged.get(0).start_time != 0.0){
      resultFreeTime.add(new Interval(0.0, merged.get(0).start_time));
    }
    for(int i = 1;i< merged.size(); i++){
      Interval prev = merged.get(i-1);
      Interval cur = merged.get(i);
      if(prev.end_time < cur.start_time){
        resultFreeTime.add(new Interval(prev.end_time, cur.start_time));
      }
    }
    if(merged.get(merged.size()-1).end_time != 24.0){
      resultFreeTime.add(new Interval(merged.get(merged.size()-1).end_time, 24.0));
    }
    return resultFreeTime;
  }

  public List<Interval> mergeIntervalBAD(List<Interval> intervals1, List<Interval> intervals2){
    //(13.5, 14)
    // (13, 14)
    //(15.75, 17)
    //(14, 16)
    List<Interval> result = new ArrayList<>();
    for(Interval interval1 : intervals1){
      for(Interval interval2 : intervals2){
          double newStartTime = 0;
          double newEndTime = 0;
        if(interval1.end_time < interval2.start_time){
          result.add(interval1);
          result.add(interval2);
        }else if(interval2.start_time <= interval1.start_time){
            newStartTime = interval2.start_time;
          }else{
            newStartTime = interval1.start_time;
          }

          if(interval2.end_time >= interval1.end_time){
            newEndTime = interval2.end_time;
          }else{
            newEndTime = interval1.end_time;
          }
        System.out.println(newStartTime);
        System.out.println(newEndTime);
         System.out.println("interval2; " + interval2);
         System.out.println("interval1; " + interval1);
          result.add(new Interval(newStartTime, newEndTime));
      }
    }
    
    return result;
    
  }

  public void getSubArrays(int[] arr){
    helper(arr, 0, 0);
  }


  public void helper(int[] arr, int start, int end){
    if(end == arr.length){
      return;
    }else if(start > end){
      helper(arr, 0, end + 1);
    }else{
      System.out.print("[");
      for(int i = start; i < end;i++){
        System.out.print(arr[i] + ",");
      }
      System.out.println(arr[end]+"]");
      helper(arr, start + 1, end);
    }
    return;
  }

  /**
Fizz Buzz Implementation
Fizz Buzz is a very simple programming task, 
asked in software developer job interviews.

A typical round of Fizz Buzz can be:
Write a program that prints the numbers from 1 to 100 and 
for multiples of '3' print "Fizz" instead of the number and 
for the multiples of '5' print "Buzz".
  **/
  //FizzBuzz 40% of engineers dont know how to code this problem
  public void fizzBuzz(){
    for(int i=1; i <= 100; i++){
      if((i % 3) == 0){
        System.out.print("Fizz,");
      }else if((i % 5) == 0){
        if(i == 100){
          System.out.println("Buzz");
        }else{
         System.out.print("Buzz,");
        }
      }else{
          System.out.print(i+",");
      }
    }
  }


  public int findLongestLine(int[][] grid){
    Queue<Point> queue = new LinkedList<>();
    int longestLine = 0;
    Set<String> visited = new HashSet<>();

Set<Point> visited2 = new HashSet<>();
Point p = new Point(0,0,0);
Point p1 = new Point(0,0,2);
visited2.add(p);
System.out.println("conm:" + visited2.contains(p1));
    for(int i = 0; i < grid.length;i++){
      for(int j = 0; j < grid[0].length;j++){
        String pointStringOne = i + "," + j;
        if(!visited.contains(pointStringOne) && grid[i][j] == 1){
        System.out.println("pointStringOne: " + pointStringOne);
          //BFS
          //you add it to queue is visited
          queue.add(new Point(i, j, 1));
          visited.add(pointStringOne);
          int len = 0;
          while(!queue.isEmpty()){
            Point curr = queue.remove();
            System.out.println("curr: " + curr);
            int x = curr.x;
            int y = curr.y;
            int length = curr.length;
            len++;
            //down
            Point down = new Point(x, y-1, length+1);
            if(isValid(down, visited, grid)){
              String pointString = x + "," + (y-1);
              visited.add(pointString);
              queue.add(down);
            }
            Point up = new Point(x, y+1, length+1);
            if(isValid(up, visited, grid)){
              String pointString = x + "," + (y+1);
              visited.add(pointString);
              queue.add(up);
            }
            Point left = new Point(x-1, y, length+1);
            if(isValid(left, visited, grid)){
              String pointString = (x-1) + "," + y;
              visited.add(pointString);
              queue.add(left);
            }
            Point right = new Point(x+1, y, length+1);
            if(isValid(right, visited, grid)){
              String pointString = (x+1) + "," + y;
              visited.add(pointString);
              queue.add(right);
            }
            Point diagonalUpLeft = new Point(x-1, y+1, length+1);
            if(isValid(diagonalUpLeft, visited, grid)){
              String pointString = (x-1) + "," + (y+1);
              visited.add(pointString);
              queue.add(diagonalUpLeft);
            }
            Point diagonalUpRight = new Point(x+1, y+1, length+1);
            if(isValid(diagonalUpRight, visited, grid)){
              String pointString = (x+1) + "," + (y+1);
              visited.add(pointString);
              queue.add(diagonalUpRight);
            }
            Point diagonalDownLeft = new Point(x-1, y-1, length+1);
            if(isValid(diagonalDownLeft, visited, grid)){
               String pointString = (x-1) + "," + (y-1);
              visited.add(pointString);
              queue.add(diagonalDownLeft);
            }
            Point diagonalDownRight = new Point(x+1, y-1, length+1);
            if(isValid(diagonalDownRight, visited, grid)){
              String pointString = (x+1) + "," + (y-1);
              visited.add(pointString);
              queue.add(diagonalDownRight);
            }
          }
          longestLine = Math.max(longestLine, len);
          len=0;
        }
      }
    }
    return longestLine;
  }

  public boolean isValid(Point move, Set<String> visited, int[][] grid){
    int x = move.x;
    int y = move.y;
    String pointString = x + "," + y;
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length 
    && !visited.contains(pointString) && grid[x][y] == 1;
  }

  public int knapSack(int[] weights, int[] values, int capacity){
    int[][] memo = new int[values.length][capacity + 1];

    for (int i = 0; i < values.length; i++){
        for (int j = 0; j < capacity + 1; j++){
            memo[i][j] = -1; 
        }
    }
    return helperKnapSack(weights, values, capacity, values.length, memo);
  }

  public int helperKnapSack(int[] weights, int[] values, int capacity, int element,int[][] memo){
    if(element == 0 || capacity == 0){
      return 0;
    }

    if(memo[element-1][capacity] != -1){
      return memo[element-1][capacity];
    }

    if(weights[element-1] > capacity){ 
      memo[element-1][capacity] = helperKnapSack(weights, values, capacity, element - 1, memo);
      return memo[element-1][capacity];
    }else{
      memo[element-1][capacity] = Math.max(values[element-1] + helperKnapSack(weights, values, capacity - weights[element-1], element-1, memo)
        , helperKnapSack(weights, values, capacity, element-1, memo));
      return memo[element-1][capacity];
    }
  }

  public int knapSackBottomUp(int[] weights, int[] values, int capacity){
    int[][] tabulation = new int[weights.length+1][capacity+1];
    for(int i = 0; i <= values.length; i++){
      for(int w = 0; w <= capacity; w++){
        if(i == 0 || w == 0){
          tabulation[i][w] = 0;
        }else if(weights[i-1] <= capacity){
          tabulation[i][w] = Math.max(values[i-1] + tabulation[i-1][capacity - weights[i-1]],
            tabulation[i-1][capacity]);
        }else{
          tabulation[i][w] = tabulation[i-1][capacity];
        }
       /* for(int[] weightstabu : tabulation){
          System.out.println("tabu: " + Arrays.toString(weightstabu));
        }*/
      }
    }
    return tabulation[values.length][capacity];
  }

  public int stock(int[] prices){
    if(prices.length == 0){
      return 0;
    }
    int maxProfit = 0;
    int minPrice = prices[0];
    for(int i = 0; i < prices.length; i++){
      minPrice = Math.min(minPrice, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }
    return maxProfit;
  }

  class PointBike{
    int row;
    int column;
    int distance;
    PointBike(int row, int column, int distance){
      this.row = row;
      this.column = column;
      this.distance = distance;
    }

    public String toString(){
      return "row: " + row + ", column: " + column + ", distance: " + distance;
    }
  }

  public int[][] getMinDistances(char[][] bikes){
    PointBike person = null;
    int[][] out = new int[bikes.length][bikes[0].length];

    for(int i = 0; i < bikes.length; i++){
      for(int j = 0; j < bikes[0].length; j++){
        if(bikes[i][j] == 'p'){
          person = new PointBike(i, j, 0);
          out[i][j] = 0;
        }
      }
    }
    Queue<PointBike> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    for(int i = 0; i < bikes.length; i++){
      for(int j = 0; j < bikes[0].length; j++){
        if(bikes[i][j] == 'b'){
          PointBike bikePoint = new PointBike(i, j, 0);
          queue.add(bikePoint);

          int minDist = Integer.MAX_VALUE;
          while(!queue.isEmpty()){
            PointBike curr = queue.remove();
            int currRow = curr.row;
            int currCol = curr.column;
            int currDist = curr.distance;
            String pointString = currRow + "," + currCol;
            visited.add(pointString);
            if(currRow == person.row && currCol == person.column){
              minDist = Math.min(minDist, currDist);
            }
            //Down
            PointBike down = new PointBike(currRow+1, currCol, currDist+1);
            if(isValidPointBike(down, bikes,visited)){
              queue.add(down);
            }
            //up
            PointBike up = new PointBike(currRow-1, currCol, currDist+1);
            if(isValidPointBike(up, bikes,visited)){
              queue.add(up);
            }
            //left
            PointBike left = new PointBike(currRow, currCol-1, currDist+1);
            if(isValidPointBike(left, bikes, visited)){
              queue.add(left);
            }
            //right
            PointBike right = new PointBike(currRow, currCol+1, currDist+1);
            if(isValidPointBike(right, bikes, visited)){
              queue.add(right);
            }
          }
          out[i][j] = minDist;
          visited.clear();
        }
      }
    }
    return out;
  }

  public boolean isValidPointBike(PointBike point, char[][] bikes, Set<String> visited){
    int row = point.row;
    int col = point.column;
    String pointString = row + "," + col;
    return row >= 0 && row < bikes.length && col >= 0 && col < bikes[0].length && !visited.contains(pointString);
  }

  class PointZombie{
    int row;
    int col;
    PointZombie(int row, int col){
      this.row = row;
      this.col = col;
    }

    public String toString(){
      return row + "-" + col;
    }
  }

  public int getManyHoursInfection(int[][] grid){
    int countHuman = 0;
    int hours = 0;
    Queue<PointZombie> queue = new LinkedList<>();
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == 1){
          queue.add(new PointZombie(i, j));
        }else{
          countHuman++;
        }
      }
    }

    int[][] moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    while(!queue.isEmpty()){
      int size = queue.size();
      System.out.println("size: " + size);
      System.out.println("queue: " + queue);
      if(countHuman == 0){
        return hours;
      }
      while(size != 0){
        PointZombie curr = queue.remove();
        int currRow = curr.row;
        int currCol = curr.col;

        for(int[] move : moves){
           int newRow = currRow + move[0];
           int newCol = currCol + move[1];
           if(isValidPointZombie(new PointZombie(newRow, newCol), grid)){
              queue.add(new PointZombie(newRow, newCol));
              grid[newRow][newCol] = 1;
              countHuman--;
            }
        }
        size--;
      }
      hours++;
    }
    return -1;
  }

  public boolean isValidPointZombie(PointZombie curr, int[][] grid){
    int row = curr.row;
    int col = curr.col;
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
  }

  Integer maxScore = Integer.MIN_VALUE;
  Map<String, String> taskAssigment = new HashMap<>();
  Set<String> taskTaken = new HashSet<>();
  public int getComparativeAdvantage(Set<String> tasks, String[] peopleArray, Map<String, Map<String, Integer>> teamSkills){
    helper(tasks, peopleArray, teamSkills, 0, 0);
    //Get all permutations
   // System.out.println(taskAssigment.toString());
    return maxScore;
  }


  public void helper(Set<String> tasks, String[] peopleArray, Map<String, Map<String, Integer>> teamSkills, int score, int level){
    if(level == peopleArray.length){
      if(score >= maxScore){
        System.out.println(taskAssigment.toString());
        System.out.println("score: " + score);
        maxScore = score;
      }
      return;
    }

    for(String task : tasks){
      if(!taskTaken.contains(task)){
        taskTaken.add(task);
        taskAssigment.put(task, peopleArray[level]);
        int expertise = teamSkills.get(peopleArray[level]).get(task);
        helper(tasks, peopleArray, teamSkills, score + expertise, level+1);
        taskTaken.remove(task);
        //backtracking
      }
    }
  }

  int GRID_SIZE = 8;

  public void placeQueens(int row, Integer[] columns, List<Integer[]> results){
    if(row == GRID_SIZE){
      results.add(columns.clone());
    }else{
      for(int col = 0; col < GRID_SIZE; col++){
        if(checkValid(columns, row, col)){
          columns[row] = col;
          placeQueens(row + 1, columns, results);
        }
      }
    }
  }

  public boolean checkValid(Integer[] columns, int row1, int column1){
    for(int row2 = 0; row2 < row1; row2++){
      int column2 = columns[row2];
      if(column1 == column2){
        return false;
      }
      int columnDistance = Math.abs(column2 - column1);

      int rowDistance = row1 - row2;
      if(columnDistance == rowDistance){
        return false;
      }
    }
    return true;
  }

  public boolean isAmbigram(String candidate){
    //No ambigrams c,f,g,k,v 
    Map<Character, Character> rotatedLetters = new HashMap<>();
    rotatedLetters.put('a', 'e');
    rotatedLetters.put('b', 'q');
    rotatedLetters.put('d', 'p');
    rotatedLetters.put('e', 'a');
    rotatedLetters.put('h', 'y');
    rotatedLetters.put('i', 'i');
    rotatedLetters.put('j', 'r');
    rotatedLetters.put('l', 'l');
    rotatedLetters.put('m', 'w');
    rotatedLetters.put('n', 'u');
    rotatedLetters.put('o', 'o');
    rotatedLetters.put('p', 'd');
    rotatedLetters.put('s', 's');
    rotatedLetters.put('t', 't');
    rotatedLetters.put('u', 'u');
    rotatedLetters.put('x', 'x');
    rotatedLetters.put('y', 'h');
    rotatedLetters.put('z', 'z');
    StringBuilder wordRotated = new StringBuilder();

    for(char letter : candidate.toCharArray()){
      if(rotatedLetters.containsKey(letter)){
        char rotation = rotatedLetters.get(letter);
        wordRotated.append(rotation);
      }else{
        return false;
      }
    }
    System.out.println("wordRotated: " + wordRotated.toString());
    return true;
  }

  public boolean haveACycle(Map<Integer,List<Integer>> graph){
    //get each vertex
    Set<Integer> visited = new HashSet<>();
    for(int vertex : graph.keySet()){
      if(!visited.contains(vertex)){
        if(isCycle(vertex, -1, graph, visited)){
          return true;
        }
      }
    }
    return false;
  }

  public boolean isCycle(int currentVertex, int parentVertex, Map<Integer,List<Integer>> graph, Set<Integer> visited){
    System.out.println("currentVertex: " + currentVertex);
    System.out.println("parentVertex: " + parentVertex);
    System.out.println("visited: " + visited);
    visited.add(currentVertex);
    List<Integer> neighbors = graph.get(currentVertex);
    for(int neighbor : neighbors){
      System.out.println("neighbor: " + neighbor);
        if(!visited.contains(neighbor)){
          isCycle(neighbor, currentVertex, graph, visited);
        }else if(neighbor != parentVertex){
          System.out.println("CYCLE");
          return true;
        }
    }
    return false;
  }

  public int fibonacci(int n){
    Timestamp timestampStart = new Timestamp(System.currentTimeMillis());
    System.out.println("Fibonacci start " + timestampStart + "n: " + n);
    if(n <= 0){
      return 0;
    }else if(n == 1){
      return 1;
    }else{
      int result = fibonacci(n-1) + fibonacci(n-2);
      Timestamp timestampStop = new Timestamp(System.currentTimeMillis());
      System.out.println("Fibonacci end " + timestampStop + "n: " + n);
      return result;
    }
  }

  Double smallestNumber = Double.MAX_VALUE;
  //minimum digits to remove to get a perfect square root
  public Double smallNumberPerfectSquare(int number){
    helperSmallNumber(String.valueOf(number), "");
    return smallestNumber;
  }
  //(Pick and Don’t Pick Concept)
  public void helperSmallNumber(String number, String subSequence){
   //System.out.println("number: " + number + "sub: " + subSequence);
    if(number.length() == 0){
      System.out.println("seq: " + subSequence);
      if(!subSequence.isEmpty()){
        double subSequenceDouble = Double.parseDouble(subSequence);
        double squareRoot = Math.sqrt(subSequenceDouble);
        //System.out.println("squareRoot: " + squareRoot);
        //System.out.println("Math.floor(squareRoot): " + Math.floor(squareRoot));
        if((squareRoot - Math.floor(squareRoot)) == 0){
          System.out.println("perfect squareRoot: " + subSequenceDouble);
          smallestNumber = Math.min(smallestNumber, subSequenceDouble);
        }
      }
      return;
    }
    //System.out.println("before recursion number: " + number + "sub: " + subSequence);
    helperSmallNumber(number.substring(1), subSequence + number.charAt(0));
    //System.out.println("seq after " + subSequence);
    //System.out.println("number.substring(1): " + number.substring(1));
    helperSmallNumber(number.substring(1), subSequence);
  }

  public int editDistance(String s1, String s2){
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    return helperDistance(s1, s2, s1.length(), s2.length(), dp);
  }

  public int helperDistance(String s1, String s2, int lengthS1, int lengthS2, int[][] dp){
    if(dp[lengthS1][lengthS2] != 0){
      return dp[lengthS1][lengthS2];
    }

    if(lengthS1 == 0){
      dp[lengthS1][lengthS2] = lengthS2;
      return lengthS2;
    }

    if(lengthS2 == 0){
      dp[lengthS1][lengthS2] = lengthS1;
      return lengthS1;
    }

    if(s1.charAt(lengthS1 - 1) == s2.charAt(lengthS2 -1)){
      dp[lengthS1][lengthS2] = helperDistance(s1, s2, lengthS1 - 1, lengthS2 - 1, dp);
      return dp[lengthS1][lengthS2];
    }

    dp[lengthS1][lengthS2] = 1 + min(helperDistance(s1, s2, lengthS1, lengthS2 - 1, dp),  //insert
            helperDistance(s1, s2, lengthS1 - 1, lengthS2, dp), //delete
            helperDistance(s1, s2, lengthS1 - 1, lengthS2 - 1, dp));

    return dp[lengthS1][lengthS2];
  }

  public int min(int x, int y, int z){
    if(x <= y && x <= z){
      return x;
    }
    if(y <= x && y <= z){
      return y;
    }else{
      return z;
    }
  }

  /**
  Only 1 max
  0 1 2 3 4 5 6 7
  1,2,3,4,5,4,3,2,
          s
          e 
            m

  0 1 2
  3,1,0
  s
      e 
    m
   length 3
 
  0 1 2 3 4 5
  1,2,3,4,5,4
          s
        e
        m 
  0 1 2 3 4 5
  1,2,3,4,5,2
          s
        e
        m

  while(start >= end){
    mid = (end + start) / 2;
    if(arr[mid] > arr[end] && arr[mid] > arr[mid+1]){
        end = mid - 1;      
    }else{
        start = mid + 1;
    }           
  }  
  return start;


    if(arr[mid] > arr[mid+1]){
      return mid;
    }else 
 || 
    

  
  rotated
  4,5,6,1,2,3
  **/
  public int getMaxGaussianDistribution(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    int mid = 0;

    while(start <= end){
      mid = (end + start) / 2;
      System.out.println("start: " + start);
      System.out.println("middle: " + mid);
      System.out.println("end: " + end);
      if(arr[mid] >= arr[end] && arr[mid] > arr[mid+1]){
        end = mid - 1;      
      }else{
        start = mid +1;
      }           
    }   
    return arr[start];
  }

  class NodeWeight{
    String id;
    String parentId;
    String weight;
    public NodeWeight(String id, String parentId, String weight){
      this.id = id;
      this.parentId = parentId;
      this.weight = weight;
    }

    public String toString(){
      return "id: " + id + ", parentId: " + parentId + ", weight: " + weight;
    }
  }
  //read csv
  Map<String, List<NodeWeight>> graph = new HashMap<>();  
  public void createGraph() throws Exception{
    Scanner scanner = new Scanner(new File("files/idParentWeight.csv"));
    while(scanner.hasNext()){
      String line = scanner.next();
      String[] lineSplit = line.split(",");
      String id = lineSplit[0];
      String parentId = lineSplit[1]; 
      String weight = lineSplit[2];
      NodeWeight nodeweight = new NodeWeight(id, parentId, weight);
      //add id
      if(graph.containsKey(id)){
        List<NodeWeight> adj = graph.get(parentId);
        adj.add(nodeweight);
        graph.put(id, adj);
      }else{
        List<NodeWeight> adj = new ArrayList<>();
        adj.add(nodeweight);
        graph.put(id, adj);
      }
      //add children
      if(graph.containsKey(parentId)){
        List<NodeWeight> adj = graph.get(parentId);
        adj.add(nodeweight);
        graph.put(parentId, adj);
      }else{
        List<NodeWeight> adj = new ArrayList<>();
        adj.add(nodeweight);
        graph.put(parentId, adj);
      }
      System.out.println("line: " + line);
    }
    System.out.println("graph: " + graph);
    scanner.close();
  }

  public int getWeightById(String nodeId){
    //BFS
    int sum = 0;
    Queue<NodeWeight> queue = new LinkedList<>();
    Set<String> visited = new HashSet();
    //how you get the entire node based on the id
    queue.add(graph.get(nodeId).get(0));
    while(!queue.isEmpty()){
      NodeWeight curr = queue.remove();
      System.out.println("curr weight: " + curr);
      String currId = curr.id;
      visited.add(currId);
      sum+= Integer.parseInt(curr.weight);
      if(graph.containsKey(currId)){
        for(NodeWeight adj : graph.get(currId)){
          if(!visited.contains(adj.id)){
            queue.add(adj);
          }
        }
      }
    }
    
    return sum;
  }

//save path
  class IndexPath{
    int index;
    List<Integer> path = new ArrayList<>();
    int distance;
    public IndexPath(int index, List<Integer> path, int distance){
      this.index = index;
      this.path = path;
      this.distance = distance;
    }
    public String toString(){
      return "index: " + index + ", path: " + path.toString() + ", distance: " + distance;
    }
  }
  public int[] shortestPath(int[] arr){
    int sizeMinPath = Integer.MAX_VALUE;
    List<Integer> minPath = new ArrayList<>();
    Queue<IndexPath> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(new IndexPath(0, new ArrayList<>(), 0));
    visited.add(0);
    while(!queue.isEmpty()){
      IndexPath indexPath = queue.remove();
      int currIndex = indexPath.index;
      //System.out.println("currIndex: " + currIndex);
      // System.out.println("queue: " + queue);
      // System.out.println("visited: " + visited);
      List<Integer> currPath = indexPath.path;
      int distance = indexPath.distance;
     // System.out.println("distance: " + distance);
      currPath.add(currIndex);
      if(currIndex == arr.length -1){
      //  System.out.println("currPath: " + currPath);
        if(distance < sizeMinPath){
          minPath = new ArrayList<>(currPath);
          sizeMinPath = currPath.size();
        }
        currPath = new ArrayList<>();
      }
      int nextIndexLeft = currIndex - 1;
      if(isValidShortest(nextIndexLeft, arr, visited)){
        visited.add(nextIndexLeft);
      //  System.out.println("nextIndexLeft: " + nextIndexLeft);
        queue.add(new IndexPath(nextIndexLeft, currPath, distance+1));
      }

      int nextIndexRight = currIndex + 1;
      if(isValidShortest(nextIndexRight, arr, visited)){
        visited.add(nextIndexRight);
       //  System.out.println("nextIndexRight: " + nextIndexRight);
        queue.add(new IndexPath(nextIndexRight, new ArrayList<>(currPath), distance+1));
      }
      int nextJump = getSameValueForward(currIndex, arr);
      if(isValidShortest(nextJump, arr, visited)){
        visited.add(nextJump);
       // System.out.println("nextJump: " + nextJump);
        queue.add(new IndexPath(nextJump, new ArrayList<>(currPath), distance+1));
      }
    }
    //System.out.println("minPath: " + minPath);
    int[] ret = new int[minPath.size()];
    int index = 0;
    for(int num : minPath){
      ret[index++] = num;
    } 
    return ret;
  }

  public int getSameValueForward(int index, int[] arr){
    int value = arr[index]; 
    System.out.println("value: " + value);
    for(int i = index + 1; i < arr.length; i++){
      if(value == arr[i]){
        return i;
      }
    }
    return -1;
  }

  public boolean isValidShortest(int next, int[] arr, Set<Integer> visited){
    return next >= 0 && next < arr.length && !visited.contains(next);
  }

  public void reverseStack(Stack<Integer> stack){

  }

  //int requestCounts = 0; 
  Date date = new Date();
  //long start = date.getTime();//current miliseconds 1

  public boolean validRequestRate() {
    Date date2 = new Date();

long difference_In_Time 
                = date2.getTime() - date.getTime();  
    System.out.println("difference_In_Time: " + difference_In_Time);

   /* //start
    requestCounts++;
    long millis = System.currentTimeMillis();
    System.out.println(millis); // prints a Unix timestamp in milliseconds
    System.out.println(millis / 1000); // prints the same Unix timestamp in seconds

    Date date2 = new Date();
    long end = date2.getTime();//2 3 4 1000
    //end
    long elapseTimeMili = end - start;

    System.out.println("elapseTimeMili: " + elapseTimeMili);
    long elapseSec = elapseTimeMili / 1000;
    System.out.println("start: " + start);
    System.out.println("end: " + end);
    System.out.println("elapseSec: " + elapseSec);
    System.out.println("requestCounts: " + requestCounts);
    //reset
    if(requestCounts <= 3 && elapseSec < 1l){
        //requestCounts = 0;
       // start = date.getTime();
        return true;
    }else{
       requestCounts = 0;
       Date date2 = new Date();
       start = date2.getTime();
       return false;
    }
  //System.out.println("start2: " + start);
  */

    return true;

  }

  public Map<Integer, List<Integer>> constructTree(List<Integer> parent){
    Map<Integer, List<Integer>> adjacency = new HashMap<>();
    //get parent and append the children
    //Node root = new Node(files_size.get(0), 0);
    //adjacency.put(0, new ArrayList<>());
   // System.out.println("parent: " + parent);
   // System.out.println("files_size: " + files_size);
    for(int nodeID = 0; nodeID < parent.size(); nodeID++){
       // System.out.println("nodeID: " + nodeID);
        for(int childrenID = nodeID + 1; childrenID < parent.size(); childrenID++){
            int parentId = parent.get(childrenID);
     //       System.out.println("parentId: " + parentId);
      //      System.out.println("childrenID: " + childrenID);
            if(parentId == nodeID){
                List<Integer> children = adjacency.getOrDefault(parentId, new ArrayList<>());
                children.add(childrenID);
                adjacency.put(parentId, children);
            }
        }
    }
    return adjacency;
  }
  /**
  construct the tree
  get Total of all the tree
  get Total of each node and his subtree
  get Min (total - subtreeTotal) - subtreeTotal
  **/
  public int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
    // Write your code here
    int midDiff = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> adjacency = constructTree(parent);  
    System.out.println("adjacency: " + adjacency);
    //dfs from root
    int sumFromRoot = getTotalSizeFromNode(0, files_size, adjacency);      
    System.out.println("sum: " + sumFromRoot);
    //when no children substract only once
    for(int nodeID = 1; nodeID < parent.size(); nodeID++){
      int sumFromNode = getTotalSizeFromNode(nodeID, files_size, adjacency);
      System.out.println("nodeID: " + nodeID);
      System.out.println("sumFromNode: " + sumFromNode);
      int diff = 0;
      if(adjacency.containsKey(nodeID)){
        diff = Math.abs((sumFromRoot - sumFromNode) - sumFromNode);
      }else{
        diff = Math.abs(sumFromRoot - sumFromNode);
      }
      System.out.println("diff from root: " + diff);
      midDiff = Math.min(diff, midDiff);
    }
    return midDiff;
  }

  public int getTotalSizeFromNode(int node, List<Integer> files_size, Map<Integer, List<Integer>> adjacency){
    //System.out.println("node: " + node);
    int size = files_size.get(node);
    if(size <= 0){
        return 0;
    }
    int sumRoot = 0; 
    sumRoot+= size;
   // System.out.println("sumRoot: " + sumRoot);
    List<Integer> neighbors = adjacency.get(node);
    if(neighbors == null){
        return sumRoot;
    }
    for(int neighbor : neighbors){
      sumRoot+= getTotalSizeFromNode(neighbor, files_size, adjacency);
    }
    return sumRoot;
  }
   List<List<Integer>> ret2 = new ArrayList<>();
    int numbersSize, level;
    public List<List<Integer>> subsets(int[] nums) {
        numbersSize = nums.length;
        //helper(2, new ArrayList<Integer>(), nums);
        
        for(level = 0; level < numbersSize + 1; ++level){
            helperSubsets(0, new ArrayList<Integer>(), nums);
        }
        System.out.println("ret2: " + ret2);
        return ret2;
    }
    
    public void helperSubsets(int first, ArrayList<Integer> curr, int[] nums){
        if(curr.size() == level){
           // System.out.println("curr: " + curr);
            ret2.add(new ArrayList(curr));
        }
        
        for(int i = first; i < numbersSize; ++i){
            //System.out.println("nums[i]: " + nums[i]);
            curr.add(nums[i]);
            helperSubsets(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
       // System.out.println("endcurr: " + curr);
    }

  /*public int subsetSumIndex(int[] arr){
                //Biggest contiguos sum
        int currSum=0;
        int max=Integer.MIN_VALUE;
        for(int i = 0; i < arr.length(); i++){
                      //     -1              
          if(arr[i] > currSum){}
              currSUm =0;
          }
          currSum+=arr[i];//-3
          max = Math.max(currSum, max);//-1
        }
        return max;
    } */
    
  List<List<Integer>> ret;
  public List<Integer> subsetSum(int[] arr){
    ret = new ArrayList<>();
    for(int level = 0; level <= arr.length; level++){
      helperSum(level, 0, new ArrayList<>(), arr); //level
    }    
    System.out.println("ret: " + ret);
    List<Integer> sums = new ArrayList<>();
    for(List<Integer> level : ret){
      int currSum = 0;
      for(int num : level){
        currSum+=num;
      }
      sums.add(currSum);
    }
    return sums;
  }

  public void helperSum(int level, int first, List<Integer> curr, int[] arr){
    System.out.println("level: " + level);
    if(level == curr.size()){
    System.out.println("curr: " + curr);
      ret.add(new ArrayList<>(curr));
      return;
    }

    for(int i = first; i < arr.length; i++){
    System.out.println("arr[i]: " + arr[i]);
      curr.add(arr[i]);
      helperSum(level, i + 1, curr, arr);
      curr.remove(curr.size()-1);  
    }
    // System.out.println("endcurr: " + curr);
  }

  public Map<Integer, List<Integer>> createAdjacencyList(int[][] tree){
    Map<Integer, List<Integer>> adjacency = new HashMap<>();

    for(int[] pair : tree){
      int node1 = pair[0];
      int node2 = pair[1];
      //System.out.println("node1: " + node1);
      //System.out.println("node2: " + node2);
      //undirected 
      List<Integer> neighborsNode1 = adjacency.getOrDefault(node1, new ArrayList<>());
      neighborsNode1.add(node2);
      adjacency.put(node1, neighborsNode1);
      List<Integer> neighborsNode2 = adjacency.getOrDefault(node2, new ArrayList<>());
      neighborsNode2.add(node1);
      adjacency.put(node2, neighborsNode2);
    }
    System.out.println("adjacency tree: " + adjacency.toString());
    return adjacency;
  }

   public double calculateTaxes(int amount, List<List<Double>> brackets){
      double taxesAmount = 0;                                      
      for(List<Double> bracket : brackets){        
        double range = bracket.get(0);   // 5K  10000  20000
        double percentage =  bracket.get(1);  // 0 0.1  0.2
        int prevAmount = amount;
        //while(amount > 0){  
        amount-=range; 
        if(amount > range){
          taxesAmount = taxesAmount + (percentage * range);    //0 + (0* 500)    0 + (0.1 * 10000)
        }else {
          taxesAmount = taxesAmount + (percentage * prevAmount);
          break;
          //get the tax according to that value 
          //break;
        }          
        //get the total and substract first bracket
       // calculate taxes acording to the bracket second value
        //}
  
      }
    return taxesAmount;
  }

}