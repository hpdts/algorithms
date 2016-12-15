package cracking.searchsort;

import java.util.*;
import java.awt.Point;


 public class SearchSort {
	
	public int[] mergeArray(int[] a, int[] b){
		int[] c = Arrays.copyOf(a, a.length);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < b.length && j < b.length && k < a.length ){
			System.out.println("i=" + i + ",j=" + j + ",k=" + k);
			System.out.println("c[i] <= b[j]:" + c[i] + "," + b[j]);
			
			if(c[i] <= b[j]){
				System.out.println("a[k] = c[i]:" + a[k] + "," + c[i]);
				a[k++] = c[i];
				i++;
			}else{
				System.out.println("a[k] = b[j]:" + a[k] + "," + b[j]);
				a[k++] = b[j];
				j++;
			}

		}
		if(j < b.length){
			while(j < b.length){
				a[k++] = b[j++];
			}
		}

		if(i < b.length){
			while(j < b.length){
				a[k++] = b[i++];
			}
		}
		return a;			
	}

	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1; /* Index of last element in array a */
		int indexB = lastB - 1; /* Index of last element in array b */
		int indexMerged = lastB + lastA - 1; /* end of merged array */
		
		/* Merge a and b, starting from the last element in each */
		while (indexA >= 0 && indexB >= 0) {
			/* end of a is > than end of b */
			if (a[indexA] > b[indexB]) {
			 	a[indexMerged] = a[indexA]; // copy element
			 	indexMerged--; // move indices
			 	indexA--;
			} else {
			 	a[indexMerged] = b[indexB]; // copy element
			 	indexMerged--; // move indices
			 	indexB--;
			}
		 }
		
		 /* Copy remaining elements from b into place */
		 while (indexB >= 0) {
		 	a[indexMerged] = b[indexB];
		 	indexMerged--;
		 	indexB--;
		 }
	}

 }	
	
