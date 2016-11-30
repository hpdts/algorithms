package cracking.recursion;

import java.util.*;
import java.awt.Point;


 public class Recursion {
	
	public int staircase(int steps){

		if(steps == 0){
			return 0;
		}

		if(steps == 1){
			return 1;
		}else{
			return staircase(steps - 1) + staircase(steps - 2);
		}		
	}

	public int fibRecur(int x) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		else {
			int f = fibRecur(x - 1) + fibRecur(x - 2);
			return f;
		}

	}


	public int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	public  int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] != 0) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
			return map[n];
 		}
 	}


 	public static List<String> robotPaths(int n){
    	List<String> pathList = new ArrayList<String>();
    	getPaths(n, 1,1, "", pathList);
    	return pathList;
	}

	public static void getPaths(int n, int i, int j, String path, List<String> pathList){
    	path += String.format(" (%d,%d)", i , j);
    	if(i == n && j == n){ //reach the (n,n) point
    	    pathList.add(path);
    	}else if( i > n || j > n){//wrong way
    	    return;
    	}else {
    	    getPaths(n, i +1, j , path, pathList);
    	    getPaths(n, i , j +1, path, pathList);
    	}
    }

    public boolean getPathBook(int x, int y, ArrayList<Point> path) {
		Point p = new Point(x, y);
		path.add(p);
		if (x == 0 && y == 0) {
			return true; // found a path
		}
		boolean success = false;
		if (x >= 1) { // Try left
			success = getPathBook(x - 1, y, path); // Free! Go left
		 }
		 if (!success && y >= 1) { // Try up
		 	success = getPathBook(x, y - 1, path); // Free! Go up
		 }
		 if (success) {
		 	path.add(p); // Right way! Add to path.
		 }
		 return success;
	}

	public boolean getPathCache(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		 Point p = new Point(x, y);
		 if (cache.containsKey(p)) { // Already visited this cell
			return cache.get(p);
		 }
		if (x == 0 && y == 0) {
			return true; // found a path
		}
		boolean success = false;
		if (x >= 1) { // Try right
			success = getPathCache(x - 1, y, path, cache); // Free! Go right
		}
		if (!success && y >= 1) { // Try down
			success = getPathCache(x, y - 1, path, cache); // Free! Go down
		}
		if (success) {
			path.add(p); // Right way! Add to path
		}
		cache.put(p, success); // Cache result

		return success;
 	}

 	public int isMagicalIndex(int[] numbers){
 		return checkIndex(numbers, 0);
 	}

 	public int checkIndex(int[] numbers, int index){
 		if(numbers[index] == index){
 			return index;
 		}else if(index > numbers.length){
 			return -1;
 		}else{
 			return checkIndex(numbers, index + 1);
 		}
 	}

 	public int magicFast(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid){
			return magicFast(array, start, mid - 1);
		 } else {
		 	return magicFast(array, mid + 1, end);
		 }
	}
		
	public int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public int magicFastBook(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		

		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastBook(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastBook(array, rightIndex, end);

		return right;
 	}

 	public int magicFastBook(int[] array) {
 		return magicFastBook(array, 0, array.length - 1);
 	}

 	public void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
        	//2 pow of N
        	System.out.println("1<<n: " + (1<<n));
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++){
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                System.out.println("i: " + i +", j: " + j +", 1<<j" + (1 << j));
                System.out.println("i binary: " + Integer.toBinaryString(i));
                if ((i & (1 << j)) > 0){
                    System.out.print(set[j] + " ");
                }
 			}
            System.out.println("}");
        }
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		System.out.println("set.size():" + set.size() + "index: " + index);
		if (set.size() == index) { // Base case - add empty set
			System.out.println("set.size() == index");
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		}else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			System.out.println("item:" + item);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			System.out.println("allsubsets: " + allsubsets.toString());
			for (ArrayList<Integer> subset : allsubsets) {
				System.out.println("subset: " + subset.toString());
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				System.out.println("newsubset: " + newsubset.toString());
				moresubsets.add(newsubset);
			}
			System.out.println("moresubsets: " + moresubsets.toString());
			allsubsets.addAll(moresubsets);
		}
		System.out.println("final allsubsets: " + allsubsets.toString());
 		return allsubsets;
 	}
 
 	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */
		System.out.println("max: " + max);
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
 	}

 	public ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
 		ArrayList<Integer> subset = new ArrayList<Integer>();
 		int index = 0;
 		System.out.println("x: "+ x);
 		for (int k = x; k > 0; k >>= 1) {
 			System.out.println("k >>= 1: " + (k >>= 1));
 			System.out.println("(k & 1): " + (k & 1));
 			if ((k & 1) == 1) {
 				subset.add(set.get(index));
 			}
 			index++;
 		}
 		return subset;
 	}

 	public void permutations(String prefix, String str, List<String> permutations){
 		int length = str.length();
 		if(length == 0){
 			permutations.add(prefix);
 			System.out.println("permutation: " + prefix);
 		}else{
 			for(int i = 0; i < length; i++){
 				String newPermutation = prefix + str.charAt(i);
 				String stringWithoutLetter = str.substring(0, i) + str.substring(i+1, length);
 				System.out.println("newPermutation: " + newPermutation);
 				System.out.println("stringWithoutLetter: " + stringWithoutLetter);
 				permutations(newPermutation, stringWithoutLetter, permutations);
 			}
 		}
 	}

 }