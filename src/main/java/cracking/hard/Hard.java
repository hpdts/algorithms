package cracking.hard;

import java.util.*;

public class Hard {

	public int add(int a, int b) {
	 	if (b == 0){
	 		return a;	
	 	} 
	 	int sum = a ^ b; // add without carrying
	 	int carry = (a & b) << 1; // carry, but don't add
	 	return add(sum, carry); // recurse
	}

	int rand(int lower, int higher) {
	 	return lower + (int)(Math.random() * (higher - lower + 1));
	}

	void shuffleArrayInteratively(int[] cards) {
		 for (int i = 0; i < cards.length; i++) {
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
 	}

 	/*public int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}
		
			while (left <= right && array[right] > pivot) {
				right--;
			}
			
		
			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	 }

	public void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int rank(int[] array, int left, int right, int rank) {
	 	int pivot = array[rand(left, right)];
		
	 	//Partition and return end of left partition
	 	int leftEnd = partition(array, left, right, pivot);
		
	 	int leftSize = leftEnd - left + 1;
	 	if (leftSize == rank + 1) {
	 		return max(array, left, leftEnd);
	 	} else if (rank < leftSize) {
	 		return rank(array, left, leftEnd, rank);
	 	} else {
	 		return rank(array, leftEnd + 1, right, rank - leftSize);
	 	}
	}*/

	//max get in a range


}