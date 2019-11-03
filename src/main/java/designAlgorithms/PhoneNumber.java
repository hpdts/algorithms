package designAlgorithms;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.Queue;

public class PhoneNumber{

	public List<String> letterCombinations (String digits) {
		List<String> combinations = new ArrayList<>();
		Map<String,String> telephoneButtons = new HashMap<>();
		telephoneButtons.put("2", "abc");
		telephoneButtons.put("3", "def");
		telephoneButtons.put("4", "ghi");
		telephoneButtons.put("5", "jkl");
		telephoneButtons.put("6", "mno");
		telephoneButtons.put("7", "pqrs");
		telephoneButtons.put("8", "tuv");
		telephoneButtons.put("9", "wyxz");

		if(digits.length() == 2){
			String lettersFirstDigit = telephoneButtons.get("" + digits.charAt(0));
			String lettersSecondDigit = telephoneButtons.get("" + digits.charAt(1));
			System.out.println("lettersSecondDigit: " + lettersSecondDigit);
			for(int i = 0; i < lettersFirstDigit.length(); i++){
				String lettersFirst = "" + lettersFirstDigit.charAt(i);
				for(int j = 0; j < lettersSecondDigit.length(); j++){
					String lettersSecond = "" + lettersSecondDigit.charAt(j);
					combinations.add(lettersFirst + lettersSecond);
				}
			}
			return combinations;
		}
		else{
			return null;	
		}
    }

    public List<String> letterCombinations2(String digits) {
	    HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
	    dict.put('2',new char[]{'a','b','c'});
	    dict.put('3',new char[]{'d','e','f'});
	    dict.put('4',new char[]{'g','h','i'});
	    dict.put('5',new char[]{'j','k','l'});
	    dict.put('6',new char[]{'m','n','o'});
	    dict.put('7',new char[]{'p','q','r','s'});
	    dict.put('8',new char[]{'t','u','v'});
	    dict.put('9',new char[]{'w','x','y','z'});
	 
	    List<String> result = new ArrayList<String>();
	    if(digits==null||digits.length()==0){
	        return result;
	    }
	 
	    char[] arr = new char[digits.length()];
	    System.out.println("digits: " + digits);
	    System.out.println("dict: " + dict.toString());
	    System.out.println("result: " + result.toString());
	    helper(0, arr, digits, dict, result);
	 
	    return result;
	}
 
	private void helper(int index, char[] arr, String digits,  HashMap<Character, char[]> dict, 
                        List<String> result){
		System.out.println("index: " + index);
		System.out.println("arr: " + Arrays.toString(arr));

	    if(index == digits.length()){
	        result.add(new String(arr));
	        System.out.println("result: " + result.toString());
	        return;
	    }
	 
	    char number = digits.charAt(index);
	    char[] candidates = dict.get(number);
	    System.out.println("number: " + number);
	    System.out.println("candidates: " + Arrays.toString(candidates));
	    for(int i=0; i<candidates.length; i++){
	        arr[index]=candidates[i];
	        System.out.println("candidates: " + candidates[i]);
	        helper(index+1, arr, digits, dict, result);
	    }
	}

	private ArrayList<String> letterCombinationsUtil(int[] phoneNumbers, int phoneNumbersLength, String[] phoneCharacters)
    { 
        // To store the generated letter combinations 
        ArrayList<String> combinations = new ArrayList<>(); 
          
        Queue<String> queue = new LinkedList<>(); 
        queue.add(""); 
      
        while(!queue.isEmpty())  
        { 
                String word = queue.remove(); 
                System.out.println("word: " + word);
                // If complete word is generated  
                // push it in the list 
                if (word.length() == phoneNumbersLength){
                	combinations.add(word); 
                }
                else 
                { 
                	System.out.println("phoneNumber: " + phoneNumbers[word.length()]);
                    String letters = phoneCharacters[phoneNumbers[word.length()]]; 
                    System.out.println("letters: " + letters);
                    for (int i = 0; i < letters.length(); i++) 
                    { 
                    	System.out.println("letters.charAt(i): " + letters.charAt(i));
                        queue.add(word + letters.charAt(i)); 
                    } 
                }  
        } 
        return combinations; 
    }  
  
    // Function that creates the mapping and  
    // calls letterCombinationsUtil  
    public void letterCombinationsBFS(int[] phoneNumbers, int phoneNumbersLength) 
    { 
        // table[i] stores all characters that  
        // corresponds to ith digit in phone 
        String[] phoneCharacters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> combinations =  letterCombinationsUtil(phoneNumbers, phoneNumbersLength, phoneCharacters); 
        // Print the contents of the list 
        for (int i = 0; i < combinations.size(); i++) 
        { 
            System.out.print(combinations.get(i) + " "); 
        } 
    } 

    public void letterCombinationsDFS(int[] phoneNumbers, int phoneNumbersLength){
    	Map<Integer, char[]> phoneCharacters = new HashMap<Integer, char[]>();
	    phoneCharacters.put(2,new char[]{'a','b','c'});
	    phoneCharacters.put(3,new char[]{'d','e','f'});
	    phoneCharacters.put(4,new char[]{'g','h','i'});
	    phoneCharacters.put(5,new char[]{'j','k','l'});
	    phoneCharacters.put(6,new char[]{'m','n','o'});
	    phoneCharacters.put(7,new char[]{'p','q','r','s'});
	    phoneCharacters.put(8,new char[]{'t','u','v'});
	    phoneCharacters.put(9,new char[]{'w','x','y','z'});

	    List<String> combinations =  letterCombinationsUtilDFS(phoneNumbers, phoneNumbersLength, phoneCharacters);
	    for (String combination: combinations) { 
            System.out.print(combination + " "); 
        } 
    } 

    public List<String> letterCombinationsUtilDFS(int[] phoneNumbers, int phoneNumbersLength, Map<Integer, char[]> phoneCharacters){
    	List<String> combinations = new ArrayList<>();
    	Stack<String> stack = new Stack<>();
    	stack.push("");

    	while(!stack.isEmpty()){
    		String word = stack.pop();
    		if(word.length() == phoneNumbersLength){
    			combinations.add(word);
    		}else{
	    		char[] letters = phoneCharacters.get(phoneNumbers[word.length()]);
	    		for(char letter : letters){
	    			stack.push(word + letter);
	    		}
    		}

    	}
    	return combinations;
    } 

}