package interviewCake;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

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

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        //10, 7, 5, 8, 11, 9
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
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
}