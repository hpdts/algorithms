package java8;

import java.util.*;


public class Problems2018 {


	public static class Interval implements Comparable<Interval>{
		int x,y;

		Interval(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int compareTo(Interval interval){
			if(this.x != interval.x){
				return this.x - interval.x;
			}else{
				return this.y - interval.y;
			}
		}

	}


	public List<Interval> mergeIntervals(List<Interval> intervals){
		Collections.sort(intervals);
		List<Interval> output = new ArrayList<>();

		Interval previous = intervals.get(0);

		for(int i = 1; i < intervals.size(); i++){
			Interval current = intervals.get(i);
			
			if(current.x > previous.y){
				output.add(previous);
				previous = current;
			}else{ //merge
				Interval merge = new Interval(previous.x, Math.max(previous.y , current.y));
				previous = merge;
			} 
		}
		output.add(previous);

		return output;

	}

	public String formLargestNumber(int[] numbers){
		String[] numbersStrings = new String[numbers.length];
		int i = 0;
		for(int number : numbers){
			numbersStrings[i] = String.valueOf(number);
			i++;
		}

		Arrays.sort(numbersStrings, new Comparator<String>(){
			public int compare(String a, String b){
				System.out.println("b+a: " + (b+a));
				System.out.println("a+b: " + (a+b));
				return (b+a).compareTo(a+b);
			}
		});

		System.out.println("numbersStrings: " + Arrays.toString(numbersStrings));

		StringBuilder largestNumber = new StringBuilder();
		for(String s : numbersStrings){
			largestNumber.append(s);			
		}

		while(largestNumber.charAt(0) == '0' && largestNumber.length() > 1){
			largestNumber.deleteCharAt(0);
		}
		return largestNumber.toString();
	}
}