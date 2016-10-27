package cracking.stringarrays;

import java.util.Scanner;
 
public class MedianOfTwoSortedArrays
{

     public static int median(int[] array1, int[] array2)
     {
         int N = array1.length;
         return median(array1, 0, N -1 , array2, 0, N - 1);
     }

     public static int median(int[] array1, int lower1, int high1, int[] array2, int low2, int high2)
     {
         int mid1 = (high1 + lower1 ) / 2;
         int mid2 = (high2 + low2 ) / 2;

         if (high1 - lower1 == 1){
             return (Math.max(array1[lower1] , array2[low2]) + Math.min(array1[high1] , array2[high2]))/2;
         }
         else if (array1[mid1] > array2[mid2]){
             return median(array1, lower1, mid1 , array2, mid2 , high2);    
         }
         else{
             return median(array1, mid1 , high1, array2, low2 , mid2 );    
         }
     }     
}