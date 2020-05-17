package accelerator;

import java.util.*;

public class Helper{

 public void printArray(int[] arr) {
    // YOUR WORK HERE
    printArrayHelper(arr, 0);
  }

  public void printArrayHelper(int[] arr, int index) {
    // YOUR WORK HERE
    if(index > arr.length-1){
    	return;
    }
    System.out.println(arr[index]);
    printArrayHelper(arr, index + 1);
  }

  public void printArrayreverse(int[] arr) {
    // YOUR WORK HERE
    traverse(arr, 0);
  }

  private void traverse(int[] arr, int index) {
    // YOUR WORK HERE
    if(index > arr.length-1){
    	return;
    }
    traverse(arr, index+1);
    System.out.println(arr[index]);
  }

  public String reverseString(String str) {
    // YOUR WORK HERE
    return reverseStringHelper(str, "");
  }

  public String reverseStringHelper(String str, String outPutStr){
  	if(str.length() == 0){
  		return outPutStr;
  	}
  	System.out.println("str : " + str);
  	outPutStr = str.charAt(0) + outPutStr;
  	System.out.println("outPutStr : " + outPutStr);
  	return reverseStringHelper(str.substring(1), outPutStr);
  }
	/*You have a string containing digits only (from 2-9). 
	Write a function that would return all possible 
	combinations of letters from that number.

	2   ABC
	3   DEF
	4   GHI
	5   JKL
	6   MNO
	7   PQRS 
	8   TUV
	9   WXYZ 

	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	*/

	public void getCombos(String number){
		Map<String, String> phone = new HashMap<>();
		phone.put("2", "ABC");
		phone.put("3", "DEF");
		List<String> combos = new ArrayList<>();
		helper(number, phone, "", combos);
		System.out.println("combos: " + combos.toString());
	} 

	public void helper(String number, Map<String, String> phone, String output, List<String> combos){

		if(number.length() == 0){
			combos.add(output);
			return;
		}
		char digit = number.charAt(0);
		for (char s : phone.get(""+digit).toCharArray()){
			helper(number.substring(1,number.length()), phone, output+s,combos);
		}

	}

	public int[][] compute(int[] arr) {
		int length = arr.length % 2 == 0 ? arr.length/2 : (arr.length/2) + 1;
    	int[][] result = new int[length][2];
		helperTwoArrays(arr, result, 0, 0, new ArrayList<Integer>());
    	return result;
  	}

  	private void helperTwoArrays(int[] arr, int[][] result, int indexResult, int count, List<Integer> pairs){
  		if(count == arr.length){   
        	int index = 0;
        	for(int num : pairs){
        		result[indexResult][index++] = num;
        	}
        	if(pairs.size() == 1){
        		result[indexResult][index++] = -1;
        	}
        	indexResult++;
  			return;
  		}
  		if(count > 0 && count % 2 == 0){
        	int index = 0;
        	for(int num : pairs){
        		result[indexResult][index++] = num;
        	}
        	indexResult++;
  			pairs.clear();
  		}
  		pairs.add(arr[count++]);
  		helperTwoArrays(arr, result, indexResult, count, pairs);
  	}

 	public int[] computeFlatten(int[][] matrix) {
	    int[] result = new int[matrix.length * matrix[0].length];
	    helperFlatten(matrix, result, 0, 0);
	    return result;
	}

	public void helperFlatten(int[][] matrix,int[] result, int indexResult, int rows){
	    if(rows == matrix.length){
	      return;
	    }
	    for(int num : matrix[rows]){
	      result[indexResult++] = num; 
	    }
	    helperFlatten(matrix, result, indexResult, rows+1);
	}

	class ResultPow{
		int result = 1;
		public int getResult(){
			return result;
		}
		public void setResult(int result){
			this.result = result;
		}
	}
	public int computePow(int a, int b) {
    	// YOUR WORK HERE
    	ResultPow resultPow = new ResultPow();
    	helperPow(a, b, resultPow);
    	return resultPow.getResult();
  	}

  	public void helperPow(int base, int exponent, ResultPow resultPow){
  		if(exponent == 0){
  			return;
  		}
  		resultPow.setResult(resultPow.getResult()*base);
  		helperPow(base, exponent-1, resultPow);
  	}

  	public static int[] computeMerge(int[] arr1, int[] arr2) {
    	// YOUR WORK HERE
    	int[] result = new int[arr1.length + arr2.length];
    	helperArrayMerge(arr1, arr2, result,0, 0, 0);
    	return result;
  	}

  	public static void helperArrayMerge(int[] arr1, int[] arr2, int[] result, int indexA, int indexB, int indexResult){
  		if(indexA == arr1.length && indexB == arr2.length){
  			return;
  		}else if(indexA < arr1.length && indexB < arr2.length){
  			if(arr1[indexA] <= arr2[indexB]){
  				result[indexResult] = arr1[indexA++];
  			}else{
  				result[indexResult] = arr2[indexB++];
  			}
  		}else if(indexA < arr1.length){
  			result[indexResult] = arr1[indexA++];
  		}else{
  			result[indexResult] = arr2[indexB++];
  		}
  		helperArrayMerge(arr1, arr2, result, indexA, indexB, indexResult+1);
  	}

	public static List<String> computePowerSet(String str) {
    	List<String> combos = new ArrayList<>();
    	traversePowerSet(str, combos, "", 0);
    	return combos;
  	}

  	public static void traversePowerSet(String input, List<String> combos, String output, int depth){
  		//System.out.println("output: " + output + ", depth: " + depth);
  		if(depth == input.length()){
  			combos.add(output);
  			return;
  		}
  		traversePowerSet(input, combos, output, depth + 1);
  		//System.out.println("input.substring(depth, depth + 1): " + input.substring(depth, depth + 1) + ", depth: " + depth);
	  	traversePowerSet(input, combos, output + input.substring(depth, depth + 1), depth + 1);	
  	}

  	public List<Integer> intersection(int[] nums1, int[] nums2){
  		int indexA = 0;
  		int indexB = 0;
  		List<Integer> intersection = new ArrayList<>();

  		while(indexA < nums1.length && indexB < nums2.length){
  			if(nums1[indexA] < nums2[indexB]){
  				indexA++;
  			}else if(nums2[indexB] < nums1[indexA]){
  				indexB++;
  			}else{
  				intersection.add(nums1[indexA]);
  				indexA++;
  				indexB++;
  			}
  		}
  		return intersection;
  	}
}