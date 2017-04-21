package leetcode;

import java.util.*;
import static java.lang.Math.*;

public class Problems {

	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
 
 	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);

        System.out.println("dict: " + wordDict.toString());	
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

 			System.out.println("word Top from queue: " + word);

            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 					//System.out.println("new word: " + Arrays.toString(arr));
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }

    public int[] mergeTwoSortedArrays(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        System.out.println("c: " + Arrays.toString(c));
        int i = 0;
        int j = 0;
        int k = 0;
        //i index a j indexb
        //compare first element list and move to the second one
        while(i < a.length && j < b.length){
            System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            if(a[i] <= b[j]){
                c[k] = a[i];
                i++;
            }else{
                c[k] = b[j];
                j++;
            }
            k++;
        }

        System.out.println("LeftOver i: " + i + ", j: " + j + ", k: " + k);
        while(k <= c.length-1){
            if(i <= a.length-1){
                c[k] = a[i];
                i++;
            }

            if(j <= b.length-1){
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c;
    }

    public String keyboard(int columns, String word){
        StringBuilder path = new StringBuilder();
        for(Character letter : word.toCharArray()){
            System.out.println("letter: " + letter);
            int diff = letter - 'a';
            System.out.println("diff: " + diff);
            int rights = diff;
            int downs = diff / columns;
            if(diff == 0){
                path.append("!");
            }else if (diff < columns){
                path.append(new String(new char[rights]).replace("\0", "R"));
                /*for(int i=0; i < rights; i++){
                    path.append("R");
                }*/
                path.append("!");
                System.out.println("Number of rights: " + rights);
            }else{
                rights = diff - (columns * downs);
                for(int i=0; i < downs; i++){
                    path.append("D");
                }
                for(int i=0; i < rights; i++){
                    path.append("R");
                }
                path.append("!");
                System.out.println("Number of downs: " + downs);
                System.out.println("Number of lefts: " + rights);
            }
        }
        return path.toString();
    }

    enum WILDCARE { SIMPLE, QUESTION_MARK, ASTERISK }; 
    class TypeExpression{
        char letter;
        WILDCARE type;
        public TypeExpression(char letter, WILDCARE type){
            this.letter = letter;
            this.type = type;
        }
        public String toString(){
            return "letter: " + letter + ", type: " + type;
        }
    }

    public boolean matches(String value, String pattern){
        List<TypeExpression> exps = processPattern(pattern);
        System.out.println("exps: " + exps);
        return evaluateRegularExpression(value, exps);
    }

    public List<TypeExpression> processPattern(String pattern){
        List<TypeExpression> exps = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        for(int i=0; i < chars.length; i++){
            char current = chars[i];
            char next = (i+1 < chars.length) ? chars[i+1] : '\0';
            if(next == '?'){
                exps.add(new TypeExpression(current, WILDCARE.QUESTION_MARK));
            }else if(Character.isLetter(current) || Character.isDigit(current)){
                exps.add(new TypeExpression(current, WILDCARE.SIMPLE));
            }
        }
        return exps;
    }

    public boolean evaluateRegularExpression(String value, List<TypeExpression> exps){
      char[] chars = value.toCharArray();
      for(int i=0; i < chars.length; i++){
        char letterFromValue = chars[i];
        char letterFromExp  = exps.get(i).letter;
        WILDCARE typeExp  = exps.get(i).type;

        if(typeExp == WILDCARE.SIMPLE){
            if(letterFromExp != letterFromValue){
                return false;
            }
        }else if(typeExp == WILDCARE.QUESTION_MARK){
            if(letterFromExp == '\0' || letterFromExp != letterFromValue){
                return false;
            }
        }
      }
      return true;
    }

    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;
     
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;      
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex+1;
                iIndex++;
            } else {
                return false;
            }
        }
     
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
     
        return j == p.length();
    }

    public double powerOfIterative(double num, int exponent)
    {
        double value = 1.0;
        if(exponent == 0){
            return value;
        }

        if(exponent < 0){
            num = 1/num;
            exponent= exponent * -1;
        }

        while(exponent>0){
            value *= num;
            --exponent;
            System.out.println("value: " + value + ", exponent: " + exponent);
        }
        return value;
    }

    //a^n == a^(n/2)*a^(n/2)
    public long pow(long base, long exp){
        System.out.println("base: " + base + ", exp: " + exp);
        if(exp == 0){
            return 1;
        }
        if(exp == 1){
            return base;
        }

        if(exp % 2 == 0){
            long half = pow(base, exp/2);
            System.out.println("half: " + half);
            return half * half;
        }else{
            long half = pow(base, (exp -1) / 2);
            return base * half * half;
        }       
    }

    public boolean isUniqueCharacters(String input){
        Set<Character> uniques = new HashSet<>();
        for(Character letter : input.toCharArray()){
            if(!uniques.add(letter)){
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueChars(String str) {
        // short circuit - supposed to imply that
        // there are no more than 256 different characters.
        // this is broken, because in Java, char's are Unicode,
        // and 2-byte values so there are 32768 values
        // (or so - technically not all 32768 are valid chars)
        if (str.length() > 256) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
             System.out.println("nums: " + (1 << i));
        }

        // checker is used as a bitmap to indicate which characters
        // have been seen already
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // set val to be the difference between the char at i and 'a'
            // unicode 'a' is 97
            // if you have an upper-case letter e.g. 'A' you will get a
            // negative 'val' which is illegal
            System.out.println("str.charAt(i): " + str.charAt(i));
            int val = str.charAt(i) - 'a';
            System.out.println("val: " + val);
            // if this lowercase letter has been seen before, then
            // the corresponding bit in checker will have been set and
            // we can exit immediately.
            System.out.println("checker bit: " + Integer.toBinaryString(checker));
            System.out.println("val: " + Integer.toBinaryString((1 << val)));
            if ((checker & (1 << val)) > 0) return false;
            // set the bit to indicate we have now seen the letter.
            checker |= (1 << val);
             System.out.println("checker: " + checker);

        }
        // none of the characters has been seen more than once.
        return true;
    }

}