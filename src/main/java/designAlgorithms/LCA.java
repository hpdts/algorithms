package designAlgorithms;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LCA{

	static class Node{
		int label;
		Node left;
		Node right;

		Node(int label){
			this.label = label;
			left = right = null;
		}

		public String toString(){
			return "Label: " + this.label;
		}
	}

	public List<Node> pathToRoot(Node root, Node destination){
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		List<Node> path = new ArrayList<>();

		while(!stack.isEmpty()){
			Node actual = stack.pop();
			path.add(actual);
			System.out.println("path: " + path);	
			if(actual.label == destination.label){
				return path;
			}
			if(actual.left == null && actual.right == null){
				path.remove(actual);
			}
			if(actual.left != null){
				System.out.println("actual.left: " + actual.left);
				stack.push(actual.left);
			}

			if(actual.right != null){
				System.out.println("actual.right: " + actual.right);
				stack.push(actual.right);
			}
		}
		return null;
	}

	public static String stringSplosion(String str) {
		if (str.length() == 0) {
			return str;
		}
		return stringSplosion(str.substring(0, str.length() - 1)) + str;
	}

	public boolean hasPath(Node root, List<Integer> arr, int x)  
    {  
        // if root is NULL  
        // there is no path  
        if (root == null)  {
            return false;  
        }
        
        // push the node's value in 'arr'  
        arr.add(root.label);      
        
        // if it is the required node  
        // return true  
        if (root.label == x){    
            return true;  
        }
        
        // else check whether the required node lies  
        // in the left subtree or right subtree of   
        // the current node  
        if (hasPath(root.left, arr, x) ||  hasPath(root.right, arr, x)){
            return true;  
        }
        
        // required node does not lie either in the   
        // left or right subtree of the current node  
        // Thus, remove current node's value from   
        // 'arr'and then return false      
        arr.remove(arr.size()-1);  
        return false;              
    } 

    public boolean exists(Node root, int index){
    	if(root == null){
    		return false;
    	}
    	List<Integer> path = new ArrayList<>();
    	path.add(index);
    	int result = index / 2;
    	//System.out.println("result: " + result);
    	while(result != 1){
    		path.add(result);
    		result = result / 2;
    	}

    	System.out.println("path: " + path.toString());

    	Node temp = root;
    	//reverse list oposite
    	for(int i = path.size()-1; i >= 0; i--){
    		//even
    		if((path.get(i) % 2) == 0){
    			temp = temp.left;
    		//odd	
    		}else{
    			temp = temp.right;
    		}
	    	if(temp == null){
	    		return false;
	    	}
    		//System.out.println("i: " + i);
    		System.out.println("each: " + path.get(i));
    		System.out.println("temp: " + temp);
    	}
    	return true;

    }

    public void showInSpiral(int[][] numbers){
    	int rows = numbers.length;
    	int cols = numbers[0].length;
    	int indexCol = 0;
    	int indexRow = 0;
    	int i;

    	System.out.println("rows: " + rows);
    	System.out.println("cols: " + cols);

    	//while(indexCol < cols && indexRow < rows){

    		for(i = 0; i < cols;i++){
    			System.out.println(numbers[indexRow][i]);
    		}
    		indexRow++;

    		for(i = indexRow; i < rows;i++){
    			System.out.println(numbers[i][cols-1]);
    		}
    		indexRow++;

    		for(i = indexRow; i < rows;i++){
    			System.out.println(numbers[indexRow][i]);
    		}

    	//}



    }

    String countAndSay(int n) { 
	    // Base cases 
	    if (n == 1){     
	    	return "1"; 
	    }

	    if (n == 2) {    
	    	return "11";
	    } 
	  
	    // Find n'th term by generating  
	    // all terms from 3 to n-1.  
	    // Every term is generated  
	    // using previous term 
	      
	    // Initialize previous term 
	    String str = "11";  
	    for (int i = 3; i <= n; i++) 
	    { 
	        // In below for loop, previous  
	        // character is processed in  
	        // current iteration. That is 
	        // why a dummy character is  
	        // added to make sure that loop 
	        // runs one extra iteration. 
	        str += '$'; 
	        int len = str.length(); 
	  
	        int cnt = 1; // Initialize count  
	                     // of matching chars 
	        String tmp = ""; // Initialize i'th  
	                         // term in series 
	        char []arr = str.toCharArray(); 
	          
	        // Process previous term 
	        // to find the next term 
	        for (int j = 1; j < len; j++) 
	        { 
	            // If current character 
	            // does't match 
	            if (arr[j] != arr[j - 1]) 
	            { 
	                // Append count of  
	                // str[j-1] to temp 
	                tmp += cnt + 0; 
	  
	                // Append str[j-1] 
	                tmp += arr[j - 1]; 
	  				System.out.println("tmp: " + tmp);
	  				System.out.println("arr[j - 1]: " + arr[j - 1]);
	  				System.out.println("arr[j]: " + arr[j]);
	                // Reset count 
	                cnt = 1; 
	            } 
	  
	            // If matches, then increment  
	            // count of matching characters 
	            else cnt++; 
	        } 
	  
	        // Update str 
	        str = tmp; 
	    } 
	  
	    return str; 
	} 

	public void permute(String str, int begin, int end){
		if(begin == end){
			System.out.println("Permutation: " + str);
		}else{ 
            for (int i = begin; i <= end; i++) 
            { 
            	System.out.println("begin: " + begin);
            	System.out.println("end: " + end);
                str = swapChar(str, begin ,i); 
                System.out.println("str after swap: " + str);
                permute(str, begin+1, end);
                System.out.println("str after permute: " + str); 
                str = swapChar(str,begin, i); 
                System.out.println("str after second swap: " + str); 
            } 
        } 
	}

	public String swapChar(String str, int from, int to){
		char[] letters = str.toCharArray();
		char temp = letters[from];
		letters[from] = letters[to];
		letters[to] = temp;
		return String.valueOf(letters);
	}

	public int nthSmallest(int[] arr, int m){
		if(arr.length == 0){
			return -1;
		}
		/*int min = arr[0];
		int min2 = arr[1]; 
		for(int i=0; i < arr.length; i++){
			System.out.println("min: " + min);
			System.out.println("min2: " + min2);
			System.out.println("arr[i]: " + arr[i]);
			if(arr[i] < min){
				min2 = min;
				min = arr[i];
			}else if(arr[i] < min2 && arr[i] != min){
				min2 = arr[i];
			}
		}
		return min2;*/
		System.out.println("array first : " + Arrays.toString(arr));
		System.out.println("m : " + m);
		int start = 0;
		int end = arr.length - 2;
		int index = 0;
		int[] newArray = new int[arr.length-1];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[index]){
				newArray[start++] = arr[i];
			}else{
				newArray[end--] = arr[i];
			}
		}
		System.out.println("new array: " + Arrays.toString(newArray));
		System.out.println("start: " + start);

		if(m > start){
			return nthSmallest(Arrays.copyOfRange(newArray, start + 1, newArray.length), m-start);
		}else if(m < start){
			return nthSmallest(Arrays.copyOfRange(newArray, 0, start), m);
		}else{
			return arr[start];
		}		
	}
}