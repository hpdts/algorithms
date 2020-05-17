package accelerator;

import java.util.*;

public class DP{

	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34 
	//top down
	public int fibonacci(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibonacci(n-1) + fibonacci (n-2);
	}

	public int fibonacciMemoization(int n){
		return fibonacci(n, new int[n + 1]);
	}

	public int fibonacci(int n, int[] memo){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(memo[n] == 0){
			memo[n] = fibonacci(n-1, memo) + fibonacci (n-2, memo);
		}
		return memo[n];
	}

	//bottom up
	public int fibonacciBottom(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}

		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;

		for(int i = 2; i < n; i++){
			memo[i] = memo[i -1] + memo[i - 2];
		}
		return memo[n - 1] + memo[n -2];
	}

	public int fibonacciFor(int n){
		if(n == 0){
			return 0;
		}
		int a = 0;
		int b = 1;
		for(int i = 2; i < n; i++){
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}

	public int latticePaths(int height, int width) {
    	//YOUR WORK HERE
   		Map<String, Integer> memoization = new HashMap<>();
     	return helperLattice(height, width, 0, 0, memoization);
   	}

   	public int helperLattice(int height, int width, int x, int y, Map<String, Integer> memoization) {
   		String key = x + "#" + y;
   		if(memoization.containsKey(key)){
   			return memoization.get(key);
   		}
   		if(x == height && y == width){
   			return 1;
   		}else if(x > height || y > width){
   			return 0;
   		}
   		int paths = helperLattice(height, width, x + 1, y, memoization) + helperLattice(height, width, x, y + 1, memoization);
   		memoization.put(key, paths);
   		return paths;
   	}

   	//n=2 00 10 01
   	//o=00 10 01
    //n=3 O=000 001 010 100 101 N011 N110 N111
    //o=000 001 010 100 101
   	List<String> numbers = new ArrayList<>();
   	public List<String> nonConsecutives1(int n){	
   		helperNonConsecutives1("", n);
   		return numbers;
   	}
   	public void helperNonConsecutives1(String binaryNumber, int n){
   		if(hasConsecutive1(binaryNumber)){
   			return;
   		}
   		if(binaryNumber.length() == n){
   			numbers.add(binaryNumber);
   			return;
   		}
   		helperNonConsecutives1(binaryNumber+"0", n); 
   		helperNonConsecutives1(binaryNumber+"1", n);
   	}

   	public boolean hasConsecutive1(String binaryNumber){
   		//111
   		String twoNums = "";
   		for(int i = 0; i < binaryNumber.length()-1; i++){
   			twoNums = binaryNumber.substring(i, i+2);
   			if(twoNums.equals("11")){
   				return true;
   			}
   		}
   		return false;
   	}

   	public int maxConsecutiveSum(int [] numbers){
        int [] tabulation = new int[numbers.length+1];
        tabulation[0] = 0;

        for (int j = 1; j < tabulation.length ; j++) {
        	//System.out.println("tabulation[j-1]: "+ tabulation[j-1]);
        	//System.out.println("numbers[j-1]: "+ numbers[j-1]);
            tabulation[j] = Math.max(tabulation[j-1] + numbers[j-1], numbers[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(tabulation));
        //now return the maximum in the solution arrayyy
        int result = tabulation[0];
        for (int j = 1; j <tabulation.length ; j++) {
            if(result < tabulation[j])
                result = tabulation[j];
        }
        return result;
    }

 	public static int BitFlip(int[] arr, int N) {
	     int max = 0;
	     int streak = 0;
	     int start = 0;

	     for (int i = 0 ; i < arr.length ; i++) {
	       if (arr[i] == 0) {
	         if (N > 0) {
	           N--;
	         } else {
	           int subtract = 1;
	           while (arr[start] == 1) {
	             start++;
	             subtract++;
	           }
	           start++;
	           streak -= subtract;
	         }
	       }
	       streak++;
	       max = Math.max(max, streak);
	     }
	     return max;
   }

   /*
   pmin
   pmax 
   2,    3,   -2,   4
      cuMax
      cuMin */
	public int maxProductSubarray(int[] array){
		int max = Integer.MIN_VALUE;
		int prevMin = array[0];
		int prevMax = array[0];
		int currMax = array[0];
		int currMin = array[0];

		for(int i = 1; i < array.length ; i++){
			int productPrevMax = prevMax * array[i];
			int productPrevMin = prevMin * array[i];
			System.out.println("productPrevMax: " + productPrevMax);
			System.out.println("productPrevMin: " + productPrevMin);
			currMax = Math.max(productPrevMax, Math.max(productPrevMin, array[i]));
			currMin = Math.min(productPrevMax, Math.min(productPrevMin, array[i]));
			System.out.println("currMax: " + currMax);
			System.out.println("currMin: " + currMin);
			max = Math.max(max, currMax);
			System.out.println("max: " + max);
			prevMax = currMax;
			prevMin = currMin;
		}
		return max;
   }

}
