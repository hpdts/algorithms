package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinJumps{

   public int minJumps(int arr[], int source, int destination){ 
		// Base case: when source  
		// and destination are same 
		if (destination == source) {
			return 0; 
		}

		// When nothing is reachable  
		// from the given source 
		if (arr[source] == 0){
			return Integer.MAX_VALUE;
		} 

		// Traverse through all the points  
		// reachable from arr[source]. Recursively 
		// get the minimum number of jumps  
		// needed to reach arr[destination] from these 
		// reachable points. 
		int min = Integer.MAX_VALUE; 
		for (int i = source + 1; i <= destination && i <= source + arr[source]; i++) 
		{ 
		System.out.println("source: " + source);
		System.out.println("destination: " + destination);
		System.out.println("arr[source]: " + arr[source]);
		    int jumps = minJumps(arr, i, destination); 
		    System.out.println("jumps: " + jumps);
		    if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
		    	min = jumps + 1; 
		    }     
		} 
		return min; 
   } 

   public int minJumps(int arr[]){
   		return minJumps(arr, 0, arr.length - 1);
   }

   public int minJumpsDP(int[] arr, int n) {  
	    int jumps[] = new int[n];  // jumps[n-1] will hold the  
	                               // result 
	    int i, j; 
	           
	    if (n == 0 || arr[0] == 0) {
	         return Integer.MAX_VALUE;  // if first element is 0, 
	    }                               // end cannot be reached 
	           
	    jumps[0] = 0; 
	           
	    // Find the minimum number of jumps to reach arr[i] 
	    // from arr[0], and assign this value to jumps[i] 
	    for (i = 1; i < n; i++) 
	    { 
	        jumps[i] = Integer.MAX_VALUE; 
	         System.out.println("i: " + i);
	         for (j = 0; j < i; j++) 
	         { 
	         	System.out.println("j: " + j);
	         	System.out.println("jumps[j]: " + jumps[j]);
	         	System.out.println("jumps[i]: " + jumps[i]);
	         	System.out.println("arr[j]: " + arr[j]);
	              if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) 
	              { 
	              	System.out.println("min jumps[j] + 1: " + (jumps[j] + 1));
	              	System.out.println("min jumps[i]: " + jumps[i]);
	                jumps[i] = Math.min(jumps[i], jumps[j] + 1); 
	              	
	              	
	              System.out.println("after jumps[i]: " + jumps[i]);
	              System.out.println("jumps: " + Arrays.toString(jumps));
		    
	                  break; 
	              } 
	          } 
	    } 
	        return jumps[n-1]; 
    } 


    public int fibonacci(int n){
    	if(n <= 1){
    		return n;
    	}
    	return fibonacci(n-1) + fibonacci(n-2);
    }

    public int fibonacciDP(int n, int[] cache){
    	if(n <= 1){
    		return n;
    	}
    	System.out.println("n: " + n);
    	System.out.println("cache[n]: " + cache[n]);
    	//if(cache[n] == 0){
    		cache[n] = fibonacciDP(n-1, cache) + fibonacciDP(n-2, cache);
    	//}
    	//int n1 = 
    	return cache[n];
    }

    public int fibonacciWrapper(int n){
    	int[] cache = new int[n+1];
    	/*for(int i = 0; i < n; i++){
    		cache[n]=0;
    	}*/
    	return fibonacciDP(n, cache); 
    }

    public int climbStairs(int n){
    	return fibonacci(n+1);
    }
}