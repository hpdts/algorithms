package interviewCake;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.math.BigDecimal;


public class Exercise{

	//length = 10. 1,3,4,5,9,7
    public boolean infligthEntertainment(int flightLength, int[] movieLengths){
    	Set<Integer> differences = new HashSet<>();
    	for(int movieLength : movieLengths){
    		int diff = flightLength - movieLength;
    		System.out.println("diff: " + diff);
    		System.out.println("movieLength: " + movieLength);
    		System.out.println("differences: " + differences);
    		if(differences.contains(movieLength)){
    			return true;
    		}else{
    			differences.add(diff);
    		}
    	}
    	return false;
    }

    public static int getMaxProfit(int[] stockPrices) {

        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];
        System.out.println("minPrice:" + minPrice);
        System.out.println("maxProfit:" + maxProfit);
        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        //10, 7, 5, 8, 11, 9
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            System.out.println("currentPrice:" + currentPrice);
            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;
        System.out.println("potentialProfit:" + potentialProfit);

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);
            System.out.println("maxProfit:" + maxProfit);
            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
            System.out.println("minPrice:" + maxProfit);
        }

        return maxProfit;
    }	

    public int highestProductOf3(int[] arrayOfInts) {

        if (arrayOfInts.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // we're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // walk through items, starting at index 2
        for (int i = 2; i < arrayOfInts.length; i++) {
            int current = arrayOfInts[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2),
                current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                highestProductOf2,
                current * highest),
                current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                lowestProductOf2,
                current * highest),
                current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public List<Integer> intersection(int[] a, int[] b){
        List<Integer> intersection = new ArrayList<>();
         int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {                 
                i++;
            } else if (b[j] < a[i]) {          
                j++;
            }
            // if both array elements are same
            else {
                intersection.add(b[j++]);
                i++;                 
            }
        }
        return intersection;
    }

    public String reverseString(String str){
        // validation & base case
        if((str == null) || (str.length() <= 1)){
            return str;
        }
        // recursive call
        return reverseString(str.substring(1)) + str.charAt(0);    
    }

    public void rearrangeEvenOdd(int[] a){
        int n = a.length;
        Arrays.sort(a);
        int[] ans = new int[n];
        int bigNumbersIndex = 0;
        int smallNumbersIndex = n - 1;

        for(int i = 0; i < n; i++){
            if((i+1) % 2 == 0){
                ans[i] = a[smallNumbersIndex--];
            }else{
                ans[i] = a[bigNumbersIndex++];
            }
        }
        System.out.println("Array: " + Arrays.toString(ans));
    }

    public int maximumCandy(int[] a){
        Map<Integer, Integer> counts = new HashMap<>();
        for(Integer number : a){
            if(counts.containsKey(number)){
                int count = counts.get(number);
                counts.put(number, count + 1);
            }else{
                counts.put(number, 1);
            }
        }

        Map<Integer, Integer> mapSortedByValue = sortByValue(counts);
        
        int half = a.length / 2;
        Iterator<Map.Entry<Integer, Integer>> itr = mapSortedByValue.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer, Integer> entry = itr.next();
            //System.out.println(entry.getKey() + " ==> " + entry.getValue());
            int key = entry.getKey();
            int count = entry.getValue() - 1;
            if(count < half){
                half--;
            }else{ // count >= half
                count = (count - half) + 1;
                half = 0;
            }
//            System.out.println("count: " + count);
  //          System.out.println("half: " + half);
            mapSortedByValue.put(key, count);
    //        System.out.println("Map: " + mapSortedByValue.toString());
            if(mapSortedByValue.get(key) == 0){
      //          System.out.println("key to remove: " + key);
                itr.remove();
            }
            if(half == 0){
                break;
            }
        }

       // System.out.println("Map Final: " + mapSortedByValue.toString());
        return mapSortedByValue.size();
    }

    private Map<Integer, Integer> sortByValue(Map<Integer, Integer> map){
         Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer, Integer>>() {
            
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v2.compareTo(v1);
            }
        };
        
        Set<Entry<Integer, Integer>> entries = map.entrySet();       
        List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Entry<Integer, Integer>>(entries);
        Collections.sort(listOfEntries, valueComparator);
        //LinkedHashMap is an ordered map by insertion
        Map<Integer, Integer> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        
        for(Entry<Integer, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }


    public boolean isPyramid(String word){
        if(word == null){
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for(char letter : word.toCharArray()){
            if(counts.containsKey(letter)){
                int count = counts.get(letter);
                counts.put(letter, count + 1);
            }else{
                counts.put(letter, 1);
            }
        }

        Map<Character, Integer> countsSorted = sortMap(counts);
        int i = 1;
        for(Entry<Character, Integer> entry : countsSorted.entrySet()){
            System.out.println("Value: " + entry.getValue());
            System.out.println("Key: " + entry.getKey());
            int count = entry.getValue();
            char letter = entry.getKey();
            if(count != i){
                return false;
            }
            i++;
        }

        return true;
    }

    public Map<Character, Integer> sortMap(Map<Character, Integer> counts){
        Comparator<Entry<Character, Integer>> valueComparator = new Comparator<Entry<Character, Integer>>(){

            @Override
            public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2){
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1.compareTo(v2);
            }

        };

        Set<Entry<Character, Integer>> entries = counts.entrySet();
        List<Entry<Character, Integer>> listOfEntries = new ArrayList<Entry<Character, Integer>>(entries); 

        Collections.sort(listOfEntries, valueComparator);

        Map<Character, Integer> sortedByValue = new LinkedHashMap<>(listOfEntries.size());

        for(Entry<Character, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }
 
    public int longestIncreasingSubArray(int[] input){
        int lengthLongest = 0;
        if(input == null || input.length < 1){
            return 0;
        }

        int lastMaxNumber = input[0];
        lengthLongest++;
        for(int i = 0; i < input.length-1;i++){
            //System.out.println("lastMaxNumber: " + lastMaxNumber);

           
            if(lastMaxNumber < input[i+1]){
                lastMaxNumber = input[i+1];
                lengthLongest++;
              //  System.out.println("input[i+1]: " + input[i+1]);
                //System.out.println("lengthLongest: " + lengthLongest);
            }
        }
         //System.out.println("last: " + input[input.length-1]);
        return lengthLongest;
    }    

    public void printAllSubArray(int[] input){
        for(int i = 0; i < input.length; i++){
            for(int j = i; j < input.length; j++){
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                for(int k = i; k <= j; k++){
                    System.out.println("k: " + k);
                    System.out.print(input[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //423865
    //spli in digits
    //create list and sort
    //put numbers together

    public int biggestNumber(int number){
        List<Integer> digits = getDigits(number);
        Collections.sort(digits, Collections.reverseOrder());
        System.out.println("digits: " + digits.toString());
        return getNumber(digits); 
    }

    private List<Integer> getDigits(int number){
        List<Integer> digits = new ArrayList<>();
        while(number > 0){
            int digit = number % 10;
            System.out.println("digit: " + digit);
            number/=10;
            System.out.println("number: " + number);
            digits.add(digit);
        }        
        return digits;
    }

    private int getNumber(List<Integer> digits){
        int index = digits.size()-1; 
        int number = 0;
        for(Integer digit : digits){
            int num = (digit * (int) Math.pow(10, index));
            System.out.println("num: " + num);
            number+= num;
            System.out.println("number: " + number);
            index--;
        }
        return number;
    }

    public float converter(float amount, String fromCode, String toCode) {
        Map<String, Map<String, Float>> converter = new HashMap<String, Map<String, Float>>();
        List<String> values = new ArrayList<>();
        values.add("1 USD = 71 INR");
        values.add("1 EUR = 1.1 USD");
        values.add("1 EUR = 1.4 CAD");
        values.add("1 CAD = 83 JPY");
        for(String input : values){
            String[] currencyValue = input.split("=");  
            String[] valueCountry1 = currencyValue[0].trim().split(" ");
            String[] valueCountry2 = currencyValue[1].trim().split(" ");   
            String firstValue =  valueCountry1[0];
            String firstCountry =  valueCountry1[1];     
            String secondValue =  valueCountry2[0];
            String secondCountry =  valueCountry2[1];  
 
            if(!converter.containsKey(firstCountry)){
                Map<String, Float> conversions = new HashMap<>();
                conversions.put(secondCountry, Float.valueOf(secondValue));
                converter.put(firstCountry, conversions);
            }else{
                Map<String, Float> conversions =  converter.get(firstCountry);
                conversions.put(secondCountry, Float.valueOf(secondValue));
            }
            if(!converter.containsKey(secondCountry)){
                Map<String, Float> conversions = new HashMap<>();
                conversions.put(firstCountry, Float.valueOf(Float.valueOf(firstValue) / Float.valueOf(secondValue)));
                converter.put(secondCountry, conversions);
            }else{
                Map<String, Float> conversions =  converter.get(secondCountry);
                conversions.put(firstCountry, Float.valueOf(firstValue) / Float.valueOf(secondValue));
            }
        }

        //converter: {JPY={CAD=0.012048192}, EUR={USD=1.1, CAD=1.4}, 
        //USD={EUR=0.9090909, INR=71.0}, CAD={JPY=83.0, EUR=0.71428573}, 
        //INR={USD=0.014084507}}
        Map<String, Float> fromValues = converter.get(fromCode);
        if(fromValues.containsKey(toCode)){
            float value1 = fromValues.get(toCode);
            return round(amount * value1, 2);
        }else{
            Map<String, Float> toValues = converter.get(toCode);
            Set<String> intersection = new HashSet<>(fromValues.keySet());
            intersection.retainAll(toValues.keySet());

            Optional<String> currencyInCommon = intersection.stream().findFirst();
            float value1 = fromValues.get(currencyInCommon.get());
            float value2 = toValues.get(currencyInCommon.get());
            return round(amount * (value1/value2), 2);
        }
        
    } 

    public static float round(float d, int decimalPlace) {
         return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).floatValue();
    }
 }