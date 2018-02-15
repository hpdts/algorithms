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

    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)    
            return 0;
     
        if(needle.length() == 0)
            return 0;
     
        for(int i=0; i<haystack.length(); i++){
            if(i + needle.length() > haystack.length())
                return -1;
     
            int m = i;
            for(int j=0; j<needle.length(); j++){
                if(needle.charAt(j)==haystack.charAt(m)){
                    if(j==needle.length()-1)
                        return i;
                    m++;
                }else{
                    break;
                }
     
            }    
        }   
     
        return -1;
    }

    public void getWinnersBoard(String winners) {
        Map<String, Integer> winnersCount = new HashMap<>();
        String[] winnersSplit = winners.split(",");
        for(String winner : winnersSplit){
            if(winnersCount.containsKey(winner)){
                int count = winnersCount.get(winner);
                winnersCount.put(winner, ++count);
            }else{
                winnersCount.put(winner, 1);
            }
        }
        System.out.println("Map: " + winnersCount.toString());
        Comparator<String> comparator = new ValueComparator(winnersCount);
        Map<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(winnersCount);

        System.out.println("Sorted Map: " + result.toString());
    }

    class ValueComparator implements Comparator<String>{
     
        Map<String, Integer> map = new HashMap<String, Integer>();
     
        public ValueComparator(Map<String, Integer> map){
            this.map.putAll(map);
        }
     
        @Override
        public int compare(String s1, String s2) {
            if(map.get(s1) > map.get(s2)){
                return -1;
            }else if(map.get(s1) < map.get(s2)){
                return 1;
            }else{
                return s1.compareTo(s2);
            }   
        }
    }

    public int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }
     
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
     
        for (int e : num)
            set.add(e);
     
        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
     
            System.out.println("left: " + left + ", right: " + right + ", count: " + count);

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
     
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
     
            max = Math.max(count, max);
        }
     
        return max;
    }

    public int[] rotate(int[] elements, int pivotalIndex){
        int rotations = elements.length - pivotalIndex;
        System.out.println("rotations: " + rotations);
        for(int i = 0; i < rotations; i++){
            shiftingOncetoRight(elements);
        }
        return elements;
    }

    public void shiftingOncetoRight(int[] elements){
        int sizeArray = elements.length -1;
        int lastElement = elements[sizeArray];
        for(int i = sizeArray; i > 0; i--){
            elements[i] = elements[i-1];
        }
        elements[0] = lastElement;
    }

     public  boolean isPalindrome(String s) {
 
        if(s == null) return false;
        if(s.length() < 2) return true;
 
        char[] charArray = s.toCharArray();
        int len = s.length();
 
        int i=0;
        int j=len-1;
        char left = charArray[i];
        char right = charArray[j];
 
        while(i<j){

            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            while(i<len-1 && !isAlpha(left) && !isNum(left)){
                i++;
                left =  charArray[i];
            }
 
            while(j>0 && !isAlpha(right) && !isNum(right)){
                j--;
                right = charArray[j];
            }
 
            if(i >= j)
                break;
 
            left =  charArray[i];
            right = charArray[j];
 
            if(!isSame(left, right)){
                return false;
            }
 
            i++;
            j--;
        }
        return true;
    }
 
    public  boolean isAlpha(char a){
        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
            return true;
        }else{
            return false;
        }
    }
 
    public  boolean isNum(char a){
        if(a >= '0' && a <= '9'){
            return true;
        }else{
            return false;
        }
    }
 
    public  boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPalindromeStack(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
     
        int len = s.length();
        if (len < 2)
            return true;
     
        Stack<Character> stack = new Stack<Character>();
     
        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }
     
        if (len % 2 == 1)
            index++;
     
        while (index < len) {
            if (stack.empty())
                return false;
     
            char temp = stack.pop();
            System.out.println("s: " + s.charAt(index));
            System.out.println("temp: " + temp);

            if (s.charAt(index) != temp)
                return false;
            else
                index++;
        }
     
        return true;
    }

    public static boolean isValidPalindromePointers(String s){
        if(s==null||s.length()==0) return false;
 
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //System.out.println(s);
 
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
 
        return true;
    }

    public Integer isAConsecutiveMissing(int[] numbers){
        
        for (int i =0 ; i < numbers.length -1; i++ ){
            if(numbers[i] + 1 != numbers[i + 1]){
                return numbers[i] + 1;
            }
        }
        return null;
    }

    public Integer isAConsecutiveMissingBinarySearch(int[] numbers){
        int start = 0;
        int end = numbers.length -1;
        int middle = (start + end) / 2;

        while(start < end){
            if((numbers[middle] - numbers[start]) != (middle - start)){
                if((middle - start) == 1 && (numbers[middle] - numbers[start] > 1)){
                    return (numbers[middle] - 1);
                }
                end = middle;
            }else if((numbers[end] - numbers[middle]) != (end - middle)){
                if((end - middle) == 1 && (numbers[end] - numbers[middle] > 1)){
                    return (numbers[middle] + 1);
                }
                start = middle;
            }else{
                return null;
            }
            middle = (start + end) / 2;
        }
        return null;
    }


    public Integer isAConsecutiveMissingSum(int[] numbers){
        int n = numbers.length -1;
        int total = ((n + 1) * (n + 2))/2;
        //System.out.println("total: " + total);
        for(int i = 0; i < n; i++){
            total-= numbers[i];
        }
        if(total == 0){
            return null;
        }else{
            return total;
        }
    }

    public String zigZagConversion(String s, int numRows){
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = (2 * numRows) - 2;

        for(int i = 0; i < numRows; i++){
            //first & last rows
            if(i == 0 || i == numRows - 1){
                for(int j = i; j < s.length(); j = j + step){
                    System.out.println("First s.charAt(j): " + s.charAt(j));
                    sb.append(s.charAt(j));
                }
            }// middle rows
            else{
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 -i);
                int step2 = step - step1;
                while(j < s.length()){
                    System.out.println("Middle s.charAt(j): " + s.charAt(j));
                    sb.append(s.charAt(j));
                    if(flag){
                        j = j + step1;
                    }else{
                        j = j + step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public int solveArithmeticExpression(String input) {
        Stack<Integer> stack = new Stack<>();
        char lastOperand = '\0';
        int result = 0;

        for(char element : input.toCharArray()){
            System.out.println("element: " + element);
            if(isOperand(element)){
                lastOperand = element;
            }else if(lastOperand != '\0') {
                int previousNumber = stack.pop();
                System.out.println("previousNumber: " + previousNumber);
                result = applyOperand(lastOperand, previousNumber, Character.getNumericValue(element));
                System.out.println("result: " + result);
       
                lastOperand = '\0';
                stack.push(result);
            }else{
                stack.push(Character.getNumericValue(element));
            }

            System.out.println("lastOperand: " + lastOperand);
            System.out.println("stack: " + stack.toString());
        }
        return stack.pop();
    }

    public boolean isOperand(char element){
        return String.valueOf(element).matches("[-+*/]");    
    }

    public int applyOperand(char operand, int previousNumber, int element){
        if(operand == '-'){
            return previousNumber - element;
        }else if (operand == '+'){
            return previousNumber + element;
        }else if(operand == '*'){
            return previousNumber * element;
        }else if (operand == '/'){
            return previousNumber / element;
        }
        return 0;
    }

    public String addBinary(String binary1, String binary2) {
        if(binary1 == null || binary1.length() == 0){
            return binary2;
        }
        if(binary2 == null || binary2.length() == 0){
            return binary1;
        }
            
        int indexBinary1 = binary1.length() - 1;
        int indexBinary2 = binary2.length() - 1;
     
        int carryOver = 0;
        StringBuilder sb = new StringBuilder();
        while(indexBinary1 >= 0 || indexBinary2 >=0){
            int valueBinary1 = 0;
            int valueBinary2 = 0;
     
            if(indexBinary1 >= 0){
                valueBinary1 = binary1.charAt(indexBinary1) == '0' ? 0 : 1;    
                indexBinary1--;
            }
            if(indexBinary2 >= 0){
                valueBinary2 = binary2.charAt(indexBinary2) =='0' ? 0 : 1;
                indexBinary2--;
            }
     
            int sum = valueBinary1 + valueBinary2 + carryOver;
            if(sum >= 2){
                sb.append(String.valueOf(sum - 2));
                carryOver = 1;
            }else{
                carryOver = 0;
                sb.append(String.valueOf(sum));
            }
        }
     
        if(carryOver == 1){
            sb.append("1");
        }
        System.out.println("reverse: " + sb.toString());
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
     
        int i = a.length()-1;
        int j = b.length()-1;
     
        int carry = 0;
     
        while(i>=0 || j>=0){
            int sum=0;
     
            if(i>=0 && a.charAt(i)=='1'){
                sum++;    
            }
     
            if(j>=0 && b.charAt(j)=='1'){
                sum++;
            }
     
            sum += carry;
     
            if(sum>=2){
                carry=1;
            }else{
                carry=0;
            }
     
            sb.insert(0,  (char) ((sum % 2) + '0'));
     
            i--;
            j--;
        }
     
        if(carry==1){
            sb.insert(0, '1');
        }
     
        return sb.toString();
    }

    public int lengthOfLastWord(String words) { 
        if( words ==null || words.length() == 0){
            return 0;
        }
     
        int result = 0;
        int wordsSize = words.length();
     
        boolean flag = false;
        for(int i = wordsSize - 1; i >= 0; i--){
            char letter = words.charAt(i);
            System.out.println("letter: " + letter);
            if(( letter >='a' && letter <='z') || ( letter >='A' && letter <='Z')){
                flag = true;
                result++;
            }else{
                if(flag){
                    return result;
                }
            }
        }
        return result;
    }


    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int rows = triangle.size() - 1;
     
        for (int i = 0; i < triangle.get(rows).size(); i++) {
            System.out.println("first for: " + triangle.get(rows).get(i));
            total[i] = triangle.get(rows).get(i);
        }
        System.out.println("array: " + Arrays.toString(total));
        // iterate from last second row
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row + 1).size() - 1; col++) {
                 System.out.println("row: " + row + ", col: " + col);
                System.out.println("second for: " + triangle.get(row).get(col));
                System.out.println("min: " + Math.min(total[col], total[col + 1]));
                total[col] = triangle.get(row).get(col) + Math.min(total[col], total[col + 1]);
                System.out.println("total[col]: " + Arrays.toString(total));
            }
        }
     
        return total[0];
    }


    public boolean isThereDuplicatesI(int[] numbers){
        Set<Integer> uniques = new HashSet<>();
        for(int number : numbers){
            if(!uniques.add(number)){
                return true;
            }
        }

        return false;
    }

    public boolean isThereDuplicatesII(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = Integer.MAX_VALUE;
     
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                int gap = i - preIndex;
                min = Math.min(min, gap);
                System.out.println("gap: " + gap + ", min: " + min);
            }
            map.put(nums[i], i);
        }
     
        if(min <= k){
            return true;
        }else{
            return false;
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
     
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int pre = map.get(nums[i]);
                if(i - pre <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
     
        return false;
    }

    public boolean containsNearbyDuplicateI(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k == 0){
            return false;
        }
            
        int i = 0; 
     
        HashSet<Integer> set = new HashSet<Integer>();
     
        for(int j=0; j<nums.length; j++){
            if(!set.add(nums[j])){
                return true;
            }            
            System.out.println("set size: " + set.size() + ", k + 1: " + (k+1));
            if(set.size() >= k + 1){
                set.remove(nums[i++]);
            }
        }
     
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 0 || t < 0){
            return false;
        }
     
        TreeSet<Long> uniques = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            long current = (long) nums[i];
     
            long leftBoundary = (long) current - t;
            long rightBoundary = (long) current + t + 1; //right boundary is exclusive, so +1
            System.out.println("leftBoundary: " + leftBoundary);
            System.out.println("rightBoundary: " + rightBoundary);
            SortedSet<Long> sub = uniques.subSet(leftBoundary, rightBoundary);
            System.out.println("sub: " + sub.toString());
            if(sub.size() > 0){
                return true;
            }
     
            uniques.add(current);   
     
            if(i >= k){ // or if(uniques.size()>=k+1)
                uniques.remove( (long) nums[i-k]);
            }
        }
        return false;
    }

    public int[] removeDuplicatesSortedArray(int[] input) {
        if (input.length < 2){
            return input;
        }
     
        int distinct = 0;
        int index = 1;
     
        while (index < input.length) {
            if (input[index] == input[distinct]) {
                index++;
            } else {
                distinct++;
                input[distinct] = input[index];
                index++;
            }
        }
        return Arrays.copyOf(input, distinct + 1);
    }

    public int removeDuplicatesIII(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
 
        int previousDistinct = A[0];
        boolean flag = false;
        int count = 0;
 
        // index for updating
        int index = 1;
 
        for (int i = 1; i < A.length; i++) {
            int current = A[i];
 
            if (current == previousDistinct) {
                if (!flag) {
                    flag = true;
                    A[index++] = current;
                    continue;
                } else {
                    count++;
                }
            } else {
                previousDistinct = current;
                A[index++] = current;
                flag = false;
            }
        }
 
        return A.length - count;
    }


    public int removeDuplicatesIV(int[] A) {
        if (A.length <= 2)
            return A.length;
 
        int prev = 1; // point to previous
        int curr = 2; // point to current
 
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
 
        return prev + 1;
    }

    public int removeElement(int[] A, int element) {
        int indexDistinct = 0;
        int index = 0;
     
        while(index < A.length){
            if(A[index] != element){
                A[indexDistinct] = A[index];
                indexDistinct++; 
            }
     
            index++;
        }
     
        return indexDistinct;
    }

    public void moveZeroes(int[] nums) {
        int indexZero = -1; 
     
        for(int i = 0; i < nums.length; i++){
            System.out.println("i: " + i + ", Num: " + nums[i] + ", indexZero: " + indexZero);
            if(nums[i] == 0){
                if(indexZero == -1 || nums[indexZero] != 0){
                    System.out.println("YES i: " + i);
                    indexZero = i;
                }
            }else{
                if(indexZero != -1){
                    int temp = nums[i];
                    nums[i] = nums[indexZero];
                    nums[indexZero] = temp;
                    indexZero++;
                }
            }

            System.out.println("end: " + Arrays.toString(nums));
        }
    }

    public void moveZeroesII(int[] nums) {
        int indexLastZero = 0;
        int index = 0;
     
        while(index < nums.length){
             System.out.println("Index: " + index); 
             System.out.println("Num: " + nums[index]);
             System.out.println("indexLastZero: " + indexLastZero);
           
            if(nums[index] == 0){
                index++;
            }else{
                nums[indexLastZero] = nums[index];
                indexLastZero++;
                index++;
            }
            System.out.println("endII: " + Arrays.toString(nums));
        }
     
        while(indexLastZero < nums.length){
            nums[indexLastZero] = 0;
            indexLastZero++;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        boolean[] flag = new boolean[256];
     
        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();
     
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {

                System.out.println("result: " + result);
                System.out.println("current: " + current);
                System.out.println("start: " + start);
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1; 
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }
     
        result = Math.max(arr.length - start, result);
     
        return result;
    }


    public int lengthOfLongestSubstringI(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
     
        int start = 0;
        int max = 0;
     
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
     
            if(!set.contains(c)){
                set.add(c);
     
                max = Math.max(max, i-start+1);
            }else{
                for(int j=start; j<i; j++){
                    System.out.println("char: " + s.charAt(j) + "i: " + i);
                    
                    set.remove(s.charAt(j));
     
                    if(s.charAt(j) == c){
                        start=j+1;
                        break;    
                    }
                }        
     
                set.add(c);
            }
        }
     
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start = 0;
     
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println("c: " + c);
            System.out.println("map: " + map.toString());
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
     
            if(map.size() > 2){
                max = Math.max(max, i - start);
                System.out.println("max: " + max);
                while(map.size() > 2){
                    char t = s.charAt(start);
                    System.out.println("t: " + t);
                    int count = map.get(t);
                    System.out.println("count: " + count);
                    if(count > 1){
                        map.put(t, count - 1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
     
        max = Math.max(max, s.length() - start);
     
        return max;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        } 
     
        //frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }
     
        int len = words[0].length();
     
        for(int j=0; j<len; j++){
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;//start index of start
            int count = 0;//count totoal qualified words so far
     
            for(int i=j; i<=s.length()-len; i=i+len){
                String sub = s.substring(i, i+len);
                System.out.println("sub: " + sub);
                System.out.println("map: " + map.toString());
                System.out.println("currentMap: " + currentMap.toString());
                if(map.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }
     
                    count++;
     
                    while(currentMap.get(sub) > map.get(sub)){
                        String left = s.substring(start, start+len);
                        System.out.println("left: " + sub);
                        currentMap.put(left, currentMap.get(left)-1);
     
                        count--;
                        start = start + len;
                    }
     
     
                    if(count == words.length){
                        result.add(start); //add to result
     
                        //shift right and reset currentMap, count & start point         
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }else{
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }
     
        return result;
    }

    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        String result = "";
     
        //character counter for t
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);    
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);  
            }
        }
     
        // character counter for s
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int minLen = s.length()+1;
     
        int count = 0; // the total of mapped characters
     
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
     
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
     
            if(count == t.length()){
                char sc = s.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    sc = s.charAt(left);
                }
     
                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
     
        return result;
    }

    //Not working
    public String getMinSubstring(String alphabet, String str){
        int alphabet_lenght = alphabet.length();
        int alphabet_visited = 0;
        Map<String, Boolean> alphabet_map = loadAlphabetInMap(alphabet);
        System.out.println("alphabet_map: " + alphabet_map.toString());
        String minSubstring = "";
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()){
            sb.append(""+c);
            if (!alphabet_map.get(""+c)){
                System.out.println("alphabet character found: " + c);
                alphabet_map.put(""+c,true);
                alphabet_visited++;
            }
            System.out.println("alphabet_visited: " + alphabet_visited + ", alphabet_lenght: " + alphabet_lenght);
            if (alphabet_visited == alphabet_lenght){
                System.out.println("substring found: " + sb.toString());
                if (minSubstring.length() == 0 || minSubstring.length() > sb.toString().length()){
                    minSubstring = sb.toString();
                    sb.setLength(0);
                    alphabet_visited=0;
                    alphabet_map = loadAlphabetInMap(alphabet);
                }
            }
        }
        return minSubstring;
    }

    private Map<String, Boolean> loadAlphabetInMap(String alphabet){
        Map<String, Boolean> alphabet_map = new HashMap<>();
        for (char c: alphabet.toCharArray()){
            alphabet_map.put("" + c, false);
        }
        return alphabet_map;
    }

    //Brute force solution
    public String findShortest(String input, String alphabet){
        //System.out.println("alphabet.length() : " + alphabet.length());
        Map<String, Integer> subAlphabets = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            for(int j = alphabet.length(); (i + j) <= input.length(); j++){
                //System.out.println("i : " + i + ", j: " + j + ", i+j: " + (i+j));
                String subString = input.substring(i, i + j);
                //System.out.println("subString : " + subString);
                //compare with alphabet 
                if(containsArgument(subString, alphabet)){
                    //System.out.println("match : " + subString);
                    subAlphabets.put(subString, subString.length());
                }
            }
        }
        return shortestSubstring(subAlphabets);
    }

    //alphabet sorted and no duplicates
    public boolean containsArgument(String subString, String alphabet){
        for(Character letter : alphabet.toCharArray()){
            if(subString.indexOf(letter) == -1){
                return false;
            }
        }
        return true;
    }

    public String shortestSubstring(Map<String, Integer> subAlphabets){
        int min = Integer.MAX_VALUE;
        String subString = "";
        //System.out.println("map: " + subAlphabets);
        for(String key : subAlphabets.keySet()){
            int length = subAlphabets.get(key);
            if(length < min){
                subString = key;
                min = length;
            }
        }
        return subString;
    }

    final int no_of_chars = 27;
     
    // Function to find smallest window containing
    // all characters of 'pat'
    public String findAlphabetSubString(String input, String alphabet)
    {
        int lengthInput = input.length();
        int lengthAlphabet = alphabet.length();
      
        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (lengthInput < lengthAlphabet)
        {
            System.out.println("No such window exists");
            return "";
        }
      
        //this could less 'c' - 'a' only 27        
        int hashAlphabet[] = new int[no_of_chars];
        int hashInput[] = new int[no_of_chars];
      
        // store occurrence ofs characters of pattern
        for (int i = 0; i < lengthAlphabet; i++){
            int index_hash_alphabet = alphabet.charAt(i) - 'a';
            hashAlphabet[index_hash_alphabet]++;
        }
        System.out.println("Alphabet: " + Arrays.toString(hashAlphabet));

        int start = 0;
        int start_index = -1; 
        int min_len = Integer.MAX_VALUE;
      
        // start traversing the string
        int count = 0;  // count of characters
        for (int j = 0; j < lengthInput ; j++)
        {
            System.out.println("input.charAt(j) " + input.charAt(j));
            // count occurrence of characters of string
            int index_hash_input = input.charAt(j) - 'a';
            System.out.println("index_hash_input " + index_hash_input);
            hashInput[index_hash_input]++;
      
            // If string's char matches with pattern's char
            // then increment count
            if (hashAlphabet[index_hash_input] != 0 &&
                hashInput[index_hash_input] <= hashAlphabet[index_hash_input] ){
                count++;
            }
            System.out.println("hashInput: " + Arrays.toString(hashInput));
            // if all the characters are matched
            if (count == lengthAlphabet)
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                System.out.println("input.charAt(start): " + input.charAt(start));
                int index_hash_start = input.charAt(start) - 'a';
                while ( hashInput[index_hash_start] > hashAlphabet[index_hash_start]
                       || hashAlphabet[index_hash_start] == 0) {
                    if (hashInput[index_hash_start] > hashAlphabet[index_hash_start]){
                        hashInput[index_hash_start]--;
                    }
                    start++;
                    index_hash_start = input.charAt(start) - 'a';
                }
                System.out.println("start after cleaning: " + start);
                System.out.println("after cleaning: " + Arrays.toString(hashInput));    
                // update window size
                int len_window = j - start + 1;
                System.out.println("len_window: " + len_window);  
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
      
        // If no window found
        if (start_index == -1)
        {
           System.out.println("No such window exists");
           return "";
        }
        System.out.println("start_index: " + start_index);
      
        // Return substring starting from start_index
        // and length min_len
        return input.substring(start_index, start_index + min_len);
    }

    public List<Integer> findSubstringII(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        } 
     
        //frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }
     
        int len = words[0].length();
     
        for(int j=0; j<len; j++){
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;//start index of start
            int count = 0;//count totoal qualified words so far
     
            for(int i=j; i<=s.length()-len; i=i+len){
                String sub = s.substring(i, i+len);
                System.out.println("sub: " + sub);
                if(map.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }
     
                    count++;
     
                    while(currentMap.get(sub)>map.get(sub)){
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
     
                        count--;
                        start = start + len;
                    }
     
     
                    if(count==words.length){
                        result.add(start); //add to result
     
                        //shift right and reset currentMap, count & start point         
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }else{
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }
     
        return result;
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
     
        int start = 0; 
        int end = nums.length - 1;
     
        while(start <= end){
            if(nums[start] <= nums[end]){
                return nums[start];
            }
     
            int middle = (start + end) / 2;
     
            if(nums[middle] >= nums[start]){
                start = middle + 1;
            }else{
                end = middle;
            }
        }
     
        return -1;
    }

    public int findMinWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length-1;
     
        while(start <= end){
     
            //handle cases like [3, 1, 3]
            while(nums[start] == nums[end] && start != end){
                start++;
            }
     
            if(nums[start] <= nums[end]){
                return nums[start];
            }
     
            int middle = (start + end)/2;
            System.out.println("start: " + start + ", end: " + end + ", middle: " + middle);
            System.out.println("nums[start]: " + nums[start] + ", nums[end]: " + nums[end] + ", middle: " + nums[middle]);
    
            if(nums[middle] >= nums[start]){
                start = middle + 1;
            }else{
                end = middle;
            }
        }
        return -1;
    }

}