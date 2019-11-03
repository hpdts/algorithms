package euler;

import java.util.*;
import java.math.BigInteger;

public class Euler{

	//int[] memoization = new int[];
	Map<Integer, Integer> memoization = new HashMap<>();
	public int fibonnacci(int n){
		/*if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}*/
		if(n <= 1){
        	return n;
        }else{
        	int fibonnacciResult = fibonnacci(n-1) + fibonnacci(n-2);
        	if(memoization.put(n, fibonnacciResult) == null){
        		return fibonnacciResult;
        	}else{
        		return memoization.get(n);
        	}
        }
	}

	public int evenNumbersFibonacci(){
		int result = 0;
		int n = 0;
		int sumEvenValued = 0;
		while (result < 4000000){
			result = fibonnacci(n);
			System.out.println("n: " + n + ", fibonacci: " + result);
			//even = par
			if(result % 2 == 0){
				System.out.println("result: " + result + ", sumEven: " + sumEvenValued + "n: " + n);
				sumEvenValued+=result;
			}
			n++;
		}
		return sumEvenValued;
	}

	public static Set primeFactors(String number) {
        //long i;
        Set primefactors = new HashSet<>();
        BigInteger copyOfInput = new BigInteger(number);
 		System.out.println("copyOfInput: " + copyOfInput);
        //for (int i = 2; i <= copyOfInput; i++) {
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(copyOfInput) <= 0;
            i = i.add(BigInteger.ONE)) {

        	//System.out.println("i: " + i);
            if (copyOfInput.mod(i).compareTo(BigInteger.ZERO) == 0) {
                primefactors.add(i); // prime factor
                copyOfInput = copyOfInput.divide(i);
                i = i.subtract(BigInteger.ONE);
                //System.out.println("in prime i: " + i);
                //System.out.println("in prime copyOfInput: " + copyOfInput);
            }
        }
        return primefactors;
    }

    public int threeDigitPalidrome(){
    	//List<Integer> palindromes = new ArrayList<>();
    	int max = Integer.MIN_VALUE;
    	for(int i = 999; i > 0; i--){
    		for(int j=i; j > 0; j--){
	    		int product = i * j;
    			/*System.out.println("i: " + i);
	    		System.out.println("j: " + j);
	    		System.out.println("product: " + product);*/
	    		if(isPalindrome(String.valueOf(product))){
	    			if(product > max){
	    				max = product;
	    			}
	    			//palindromes.add(product);
	    			//return palindromes;
	    		}
    		}
    	}
    	return max;
    }

    public boolean isPalindrome(String number){
    	int endIndex = number.length() - 1;
    	for(int i = 0; i < (number.length()/2); i++){
    		char startLetter = number.charAt(i);
    		char endLetter = number.charAt(endIndex - i);
    		//System.out.println("startLetter: " + startLetter);
    		//System.out.println("endLetter: " + endLetter);
    		if (startLetter != endLetter){
    			return false;
    		}
    	}
    	return true;
    }

    //1 20
    //start from 20 for 1 to 20
    public int smallestDivisible(){
    	int number = 20;
    	while(number < Integer.MAX_VALUE){
    	//while(number < 10000000){
    		boolean evenlyDivisible = true;
    		for(int i = 1; i <= 20; i++){
    			//System.out.println("number: " + number);
    			//System.out.println("i: " + i);
    			//System.out.println("number % i: " + (number % i));
    			if((number % i) != 0){
    				evenlyDivisible = false;
    				break;
    			}
    		}
    		if(evenlyDivisible){
    			break;
    		}else{
    			number+=2;
    		}
    	}
    	return number;
    } 

    public int sumSquare(int numbers){
    	int sumOfSquares = 0;
    	int squareSum = 0;
    	for(int i = 1; i <= numbers; i++){
    		sumOfSquares+= i*i;
    	}
    	for(int i = 1; i <= numbers; i++){
    		squareSum+= i;
    	}
    	System.out.println("sumOfSquares: "+ sumOfSquares);
    	squareSum = squareSum*squareSum;
    	System.out.println("squareSum: "+ squareSum);
    	return squareSum - sumOfSquares;
    }

    public boolean isPrime(int n){
        //prime is divisible by one and itself
        boolean isPrime = true;
        for(int i = 2; i < n-1;i++){
            //System.out.println("i: " + i);
            //System.out.println("n: " + n);
            //System.out.println("n % i: " + (n % i));
            if(n % i == 0){
                isPrime = false;
            }
        }
        return isPrime;    
    }

    public int getNthPrime(int nth){
        int primesCount = 1;
        int numberCandidate = 1;
        while(primesCount < nth){
            numberCandidate = numberCandidate + 2;
            if(isPrime(numberCandidate)){
                primesCount++;
            }
        }
        return numberCandidate;
    }

    public long largestProductOnSeries(){
        String serie = new StringBuilder()
                        .append("73167176531330624919225119674426574742355349194934")
                        .append("96983520312774506326239578318016984801869478851843")
                        .append("85861560789112949495459501737958331952853208805511")
                        .append("12540698747158523863050715693290963295227443043557")
                        .append("66896648950445244523161731856403098711121722383113")
                        .append("62229893423380308135336276614282806444486645238749")
                        .append("30358907296290491560440772390713810515859307960866")
                        .append("70172427121883998797908792274921901699720888093776")
                        .append("65727333001053367881220235421809751254540594752243")
                        .append("52584907711670556013604839586446706324415722155397")
                        .append("53697817977846174064955149290862569321978468622482")
                        .append("83972241375657056057490261407972968652414535100474")
                        .append("82166370484403199890008895243450658541227588666881")
                        .append("16427171479924442928230863465674813919123162824586")
                        .append("17866458359124566529476545682848912883142607690042")
                        .append("24219022671055626321111109370544217506941658960408")
                        .append("07198403850962455444362981230987879927244284909188")
                        .append("84580156166097919133875499200524063689912560717606")
                        .append("05886116467109405077541002256983155200055935729725")
                        .append("71636269561882670428252483600823257530420752963450")
                        .toString();

        long maxProduct = 0;
        for(int i = 0; i < serie.length() - 12;i++){
            String slidingWindow = serie.substring(i, i + 13);
            long product = 1;
            //for with i ..5,000,940
            for(char numberChar : slidingWindow.toCharArray()){
                int num = Character.getNumericValue(numberChar);  
                product*=num; 
                if(product == 0){
                    break;
                }
            }
            if(product != 0){
            System.out.println("slidingWindow: " + slidingWindow);
            System.out.println("product: " + product);
        }
            if(product > maxProduct){
                maxProduct = product;
            }
            
        }
        return maxProduct;
    }
}