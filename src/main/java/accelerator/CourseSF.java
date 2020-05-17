package accelerator;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.math.BigDecimal;


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
}

