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

    public static class Interval{
        int start;
        int end;
        Interval(int inferior, int superior){
            this.start = inferior;
            this.end = superior;
        }

        public String toString(){
            return "start: " + start + "; end: " + end + "/n";
        }
    }

    //log n2 compare every interval with all of them
    /*public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> newInterval = new ArrayList<Interval>();
        for(int i = 0; i < intervals.size() -1; i++){
            Interval current = intervals.get(i);
            Interval next = (i + 1 >= intervals.size()) ? intervals.get(i+1) : null;
            if(next != null && current.superior >= next.inferior){
                Interval mergeInterval = new Interval(current.inferior, next.superior);
                newInterval.add(mergeInterval);
                i++;
            }else{
                newInterval.add(current);
                //newInterval.add(next);               
            }
        }
        return newInterval;
    }*/

    public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
     
        if(intervals==null||intervals.size()==0)
            return result;
     
        /* negative zero or positive as the first argument is less, equal 
        or greater than the second*/
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });
     
        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            System.out.println("pre: " + pre);
             System.out.println("curr: " + curr);

            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);
     
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
 
        ArrayList<Interval> result = new ArrayList<Interval>();
 
        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;        
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
 
        result.add(newInterval); 
 
        return result;
    }

    public int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n -1) + fibonacci(n -2);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int findFibonacciValue(int number) {
        if (number == 0 || number == 1) {
          return number;
        }
        else if (map.containsKey(number)) {
          return map.get(number);
        }
        else {
          int fibonacciValue = findFibonacciValue(number - 2) + findFibonacciValue(number - 1);
          map.put(number, fibonacciValue);
          return fibonacciValue;
        }
    }

    public int fibonacciIterative(int number) {
        int n1 = 0;
        int n2 = 1;
        int result = 0;  
        if(number <= 1){
            return number;
        } 
        //loop starts from 2 because 0 and 1 are already printed   
         for(int i = 2;i <= number; ++i)    
         {    
              result = n1 + n2;    
              System.out.print(" "+result);    
              n1 = n2;    
              n2 = result;    
         }    
         return result;
    }

    public boolean areAnagrams(String word1, String word2){
        int[] countWord1 = getLetterCount(word1);
        int[] countWord2 = getLetterCount(word2);
        return Arrays.equals(countWord1, countWord2);
    }

    public int[] getLetterCount(String word1){
        char[] letters = word1.toCharArray();
        int[] counts = new int[27];
        for(Character letter : letters){
            int index = letter - 'a';
            int countPrevious = counts[index];
            counts[index] = countPrevious+1;
        }
        return counts;
    } 

    public List<Integer> addTwoNumbersList(List<Integer> num1, List<Integer> num2){
        int size = num1.size();
        LinkedList<Integer> result = new LinkedList<>();
        int carryOver = 0;
        for(int i = size - 1; i >= 0 ; i--){
            int number1 = num1.get(i) + carryOver;
            int number2 = num2.get(i);
            int sum = number1 + number2;

            carryOver = (sum - 10) >= 0 ? 1 : 0;
            if(carryOver == 0){
                result.addFirst(sum);
            }else{
                result.addFirst(sum - 10);
            }
        }
        if(carryOver == 1){
            result.addFirst(carryOver);
        }
        return result;
    }    

    public void twoSumUp(int[] numbers, int target){
        Map<Integer, Integer> sum = new HashMap<>();
        for(int i=0; i< numbers.length; i++){
            int number = numbers[i];
            if(sum.containsKey(target - number)){
                System.out.println("i: "  + i + " + j: " + sum.get(target - number) );
                return;
            }else{
                sum.put(number, i);
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2){
            return new int[]{0,0};
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target - nums[i], i);
            }
        }
     
        return new int[]{0,0};
    }

    public int[] twoSumOrder(int[] numbers, int target) {
        //binary search approach
        if (numbers == null || numbers.length == 0){
            return null;
        }

        int i = 0;
        int j = numbers.length - 1;
     
        while (i < j) {
            int x = numbers[i] + numbers[j];

            System.out.println("x: "  + x + ", i: " + i + ", j: " + j );
 
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i, j };
            }
        }
     
        return null;
    }

    //brute force solution 3 fors cuadratic runtime
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
     
        if(nums == null || nums.length<3)
            return result;
     
        Arrays.sort(nums);
     
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
     
                while(j<k){
                    System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
     
                        j++;
                        k--;
     
                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;
     
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
     
        }
     
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
     
        if(nums==null|| nums.length<4)
            return result;
     
        Arrays.sort(nums);
     
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
     
                        k++;
                        l--;
     
                        while(k<l &&nums[l]==nums[l+1] ){
                            l--;
                        }
     
                        while(k<l &&nums[k]==nums[k-1]){
                            k++;
                        }
                    }
     
     
                }
            }
        }
     
        return result;
    }

    public void getPrimeNumbers(int n){
        //divisible by 1 and itself
        //1 2 3 4 5 6 7 8 9 10
        List<Integer> primes = new ArrayList<>();

        primes.add(1);
        for(int i = 2; i <= n; i++){
            boolean prime = true;
            for(int j = i - 1; j > 1 ; j--){
               // System.out.println("i: " + i + ", j: " + j);
                //System.out.println("(i % j)" + (i % j));
                
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }    
            if(prime){
                 primes.add(i);
            }
        }

        System.out.println("Primes: " + primes.toString());
    }

    //the Sieve of Eratosthenes
    public void getPrimeSieve(int n){
         List<Integer> primesList = new ArrayList<>();
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]){
              primes++;
              primesList.add(i);
            } 
        }
        System.out.println("The number of primes <= " + n + " is " + primes);
        System.out.println("Primes: " + primesList.toString());
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
 
        Arrays.sort(nums);
        System.out.println("array: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                System.out.println("nums[i] : " + nums[i] + "nums[j]: " + nums[j] + "nums[k]" + nums[k]);
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
     
                if(diff == 0){
                    System.out.println("3 numbers are:  " + nums[i] + ", " + nums[j] + ", " + nums[k]);
                    return sum;
                } 
     
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
 
        return result;
    }

    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
     
        // trim white spaces
        str = str.trim();
     
        char flag = '+';
     
        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
     
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            System.out.println("char: " + (str.charAt(i) - '0'));
            System.out.println("result: " + result);
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
     
        if (flag == '-')
            result = -result;
     
        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
     
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
     
        return (int) result;
    }

    public void merge(int A[], int B[]) {
        merge(A, A.length, B, B.length);
    }

    public void merge(int A[], int m, int B[], int n) {

        while(m > 0 && n > 0){

            System.out.println("A[m-1]: " + A[m-1]);
            System.out.println("m: " + m);
            System.out.println("n: " + n);
            System.out.println("B[n-1]: " + B[n-1]);

            if(A[m-1] > B[n-1]){
                System.out.println("A[m+n-1]: " + A[m+n-1]);
                A[m+n-1] = A[m-1];
                m--;
            }else{
                System.out.println("A[m+n-1]: " + A[m+n-1]);
                A[m+n-1] = B[n-1];
                n--;
            }
        }

        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }

    public void merge2(int A[], int B[]) {
        merge2(A, A.length, B, B.length);
    }

    public void merge2(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
     
        while (k >= 0) {
            if (j < 0 || (i >= 0 && A[i] > B[j]))
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
     
        Stack<Character> stack = new Stack<Character>();
     
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
     
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
     
        return stack.empty();
    }

    public void spiralOrder(int[][] matrix){
        int i, k = 0, l = 0;
        int m = matrix.length;
        int n = matrix[0].length;
 
        /*  k - starting row index
            m - ending row index
            l - starting column index
            n - ending column index
            i - iterator
        */
     
        while (k < m && l < n)
        {
            /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i)
            {
                System.out.format("%d ", matrix[k][i]);
            }
            k++;
     
            /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i)
            {
                System.out.format("%d ", matrix[i][n-1]);
            }
            n--;
     
            /* Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.format("%d ", matrix[m-1][i]);
                }
                m--;
            }
     
            /* Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.format("%d ", matrix[i][l]);
                }
                l++;    
            }        
        }

    }

    public String[] wordsFixWidth(String words){
        int fixedLength = 10;
        int indexRows = 0;
        int counterPositions = 0;
        String[] wordsParsed = words.split(" ");
        String[] result = new String[100];
        for(String word : wordsParsed){
            counterPositions += word.length();
            System.out.println("word: " + word);
            System.out.println("counterPositions: " + counterPositions);

            if(counterPositions > fixedLength){
                indexRows++;
                counterPositions = word.length();
            }
            result[indexRows] = result[indexRows] == null ? word : result[indexRows] + " " + word;
            System.out.println("result: " + result[indexRows]);
        }
        return result;
    }

    public  int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;
     
        for(int i=0; i<=s.length()-1; i++){
            char c = s.charAt(i);
            System.out.println("c: "+ c);
            System.out.println("stack: "+ stack.toString());
            if(c=='('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        System.out.println("currentLen: "+ stack.toString());
                        System.out.println("stack.peek()[0]: "+ stack.peek()[0]);
                        System.out.println("i: "+ i);
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }
     
        return result;
    }
}