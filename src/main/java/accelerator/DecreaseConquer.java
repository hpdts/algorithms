package accelerator;

import java.util.*;

public class DecreaseConquer{

	public int numberOfOnes(int[] arr) {
	    // YOUR WORK HERE
	    //binary serah to find one and count all the way to the end
	    int start = 0;
	    int end = arr.length - 1;
	    int mid = 0;
	    while(start <= end){
	      mid = (start + end) / 2;
	        if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)){
	            break;
	        }	   
	        // first '1' lies to the left of 'mid' 
	       	else if (arr[mid] == 1) {
	            end = mid - 1;  
	        }else{
	        	start = mid + 1;
	      	}
	    }
	    if(mid == arr.length-1){
	    	return 0;
	    }else{
	    	return arr.length - mid;
	    }
  	}

  	public int closestValue(int[] arr, int target) {
		// YOUR WORK HERE
  		int start = 0;
  		int end = arr.length;
  		int mid = 0;
  		int n = arr.length; 
  		if(arr[0] >= target){
  			return arr[0];
  		}
  		if(arr[n-1] <= target){
  			return arr[n-1];
  		}

  		while(start <= end){
  			mid = (start + end) / 2;
  			if(arr[mid] ==  target){
  				return arr[mid];
  			}else if(target < arr[mid]){
  				if (mid > 0 && target > arr[mid - 1]) {
  					return getClosest(arr[mid - 1], arr[mid], target);
  				}
  				end = mid - 1;
  			}else{ 
  				 if (mid < n-1 && target < arr[mid + 1]) {
  					return getClosest(arr[mid], arr[mid + 1], target);
  				 }
  				start = mid + 1;
  			}
  		}
	  	return -1;
	}

	public int getClosest(int leftValue, int rightValue, int target){
		int diff1 = target - leftValue;
		int diff2 = rightValue - target;
		if(diff1 == diff2){
			return leftValue;
		}else if(diff1 > diff2){
			return rightValue;
		}else{
			return leftValue;
		}
	}

	public Double squareRoot(int n) {
	 	int start = 0, end = n; 
        int mid; 
  
        // variable to store the answer 
        double ans = 0.0; 
  
        // for computing integral part 
        // of square root of n 
        while (start <= end)  
        { 
            mid = (start + end) / 2; 
              
            if (mid * mid == n)  
            { 
                ans = mid; 
                break; 
            } 
  
            // incrementing start if integral 
            // part lies on right side of the mid 
            if (mid * mid < n) { 
                start = mid + 1; 
                ans = mid; 
            } 
  
            // decrementing end if integral part 
            // lies on the left side of the mid 
            else { 
                end = mid - 1; 
            } 
        } 
  
        // For computing the fractional part 
        // of square root upto given precision 
        double increment = 0.1; 
        double precision = 3;
        for (int i = 0; i < precision; i++) { 
            while (ans * ans <= n) { 
                ans += increment; 
            } 
            // loop terminates when ans * ans > number 
            ans = ans - increment; 
            increment = increment / 10; 
        } 
        return ans; 
    } 


	public static int greaterValues(int[] arr, int target) {
	  // YOUR WORK HERE
	  //binary search stop before the number is too slow
		 //s		  m 				e
		//1, 2, 3, 5, 5, 7, 9, 10, 11], 7 --> 4
	  int start = 0;
	  int end = arr.length;
	  int mid = 0;
	  while(start < end){
	  	mid = (start + end) / 2;
	  	if(arr[mid] == target){
	  		break;
	  	}else if(target < arr[mid]){
	  		end = mid - 1;
	  	}else{
	  		start = mid + 1;
	  	}
	  }
	  //System.out.println("mid: " + mid);

	  return (arr.length -1) - mid;
	}

	public boolean binarySearch(int[] nums, int start, int end, int target) {
	  // YOUR WORK HERE
	  //        m
	  //1, 2, 3, 4, 5, 6 //t = 2
	  int mid = 0;
	  while (start < end){
	    mid = (start + end) / 2;
	    if(nums[mid] == target){
	      return true;
	    }else if(target < nums[mid]){
	      end = mid - 1;
	    }else{
	      start = mid + 1;
	    }
	  }
	  return false;
	}


	public boolean rotatedArraySearch(int[] nums, int target) {
	  	// YOUR WORK HERE
		//find minimum
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		//find minimum thats the pivot
		//s e  m  e	
		//4 3 1 2 
	    //     m    s  e             	
		//7, 8, 9, 10, 1, 2, 3, 4, 5, 6
		while(start < end){
			mid = (start + end) / 2;
			if(nums[mid] > nums[end]){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		int pivotIndex = start;
		//System.out.println("pivot: " + pivotIndex);
		//t=3
		if(target >= nums[pivotIndex] && target <= nums[nums.length - 1]){
			start = pivotIndex;
			end = nums.length - 1;
		}else{//8
			start = 0;
			end = pivotIndex - 1;
		}
		//s   m  e
		//1 2 3 4 // t 3
		while(start <= end){
			mid = (start + end) / 2;
			if(nums[mid] == target){
				return true;
			}else if(nums[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
	 	return false;
	}

}