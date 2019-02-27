package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence{

	public int getLongestIncreasingSubsequence(Integer[] input){

		int n = input.length;
        Integer[] arr = input.clone();
        Integer[] lis = new Integer[n];
        int i,j,max = 0; 
  
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ ) {
              lis[i] = 1; 
           }
  
           /* Compute optimized LIS values in bottom up manner */
           for ( i = 1; i < n; i++ ) {
           	System.out.println("i: " + i);
              for ( j = 0; j < i; j++ )  {
              	System.out.println("j: " + j);
              	System.out.println("arr[i]: " + arr[i]);
              	System.out.println("arr[j]: " + arr[j]);
              	System.out.println("lis[i]: " + lis[i]);
              	System.out.println("lis[j]: " + lis[j]);

                 if ( arr[i] > arr[j] && (lis[i] < (lis[j] + 1))) {
                    lis[i] = lis[j] + 1; 
                 }
                 System.out.println("LIS j: " + Arrays.toString(lis));
              }
           }
  			System.out.println("LIS: " + Arrays.toString(lis));
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ ) {
              if ( max < lis[i] ) {
                 max = lis[i]; 
              }
           }
  
            return max;  


	}
}