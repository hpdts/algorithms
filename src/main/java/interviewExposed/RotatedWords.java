package interviewExposed;

import java.util.*;
import java.util.Arrays;

class Delivery implements Comparable<Delivery>{
		int x;
		int y;
		double distance;

		Delivery(int x, int y, double distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		public int compareTo(Delivery m) 
	    { 
	    	if(this.distance > m.distance){
	    		return 1;
	    	}else if(this.distance < m.distance){
	    		return -1;
	    	}else{
	    		return -1;
	    	}
	    } 
	    public String toString(){
	    	return "x: " + this.x + ";y: " + this.y + ";distance: " + this.distance;
	    }
	}

public class RotatedWords{

	public boolean isSameReflection(String word1, String word2){
		List<String> rotatedWords = new ArrayList<String>();
		rotatedWords.add(word1);

		for(int i = 1; i < word1.length(); i++){
			String rotationLeft = word1.substring(i);
			String rotationRight = word1.substring(0, i);
			String rotatedWord = rotationLeft + rotationRight;
			rotatedWords.add(rotatedWord);
		}

		//System.out.println("rotatedWords: " + rotatedWords.toString());
		return rotatedWords.contains(word2);
	}

	

	public List<List<Integer>> ClosestXdestinations(int numDestinations, 
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
        // WRITE YOUR CODE HERE
		List<Delivery> deliveries = new ArrayList<>();
    
        for(List<Integer> locations : allLocations){
        	int x = locations.get(0);
        	int y = locations.get(1);
        	double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        	deliveries.add(new Delivery(x,y,distance));

        }
        Collections.sort(deliveries);
        System.out.println("deliveries: " + deliveries);
        List<Delivery> subDeliveries = deliveries.subList(0, numDeliveries);

        List<List<Integer>> closestDestinations = new ArrayList<List<Integer>>();
        for(Delivery delivery : subDeliveries){
        	List<Integer> location = new ArrayList<>();
        	location.add(delivery.x);
        	location.add(delivery.y);
        	closestDestinations.add(location);
        }
         System.out.println("closestDestinations: " + closestDestinations);
        return closestDestinations;

    }


    public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        // WRITE YOUR CODE HERE
        //advance for only 1
    	int rows = 0;
    	int columns = 0;
        for(List<Integer> row : area){
        	rows++;
        	for(int columnValue : row){
				if(columnValue == 9){
					return rows + columns;
				}
        		columns++;
        	}
        }
        return -1;
    }
}