package assignmentFeb26;

import java.util.*;

public class Segments {

	private void addSegment(List<String> segments, int leftParenthesis, int rightParenthesis, char[] segment, int count) {
		System.out.println("segments: " + segments.toString());
		System.out.println("leftParenthesis: " + leftParenthesis);
		System.out.println("rightParenthesis: " + rightParenthesis);
		System.out.println("segment: " + String.copyValueOf(segment));
		System.out.println("count: " + count);

		if (leftParenthesis < 0 || rightParenthesis < leftParenthesis){
			return; 
		}

		if (leftParenthesis == 0 && rightParenthesis == 0) { 
			segments.add(String.copyValueOf(segment));
		} else {
			 if (leftParenthesis > 0) {
			 	segment[count] = '(';
			 	addSegment(segments, leftParenthesis - 1, rightParenthesis, segment, count + 1);
			 }
	
			 if (rightParenthesis > leftParenthesis) {
			 	segment[count] = ')';
			 	addSegment(segments, leftParenthesis, rightParenthesis - 1, segment, count + 1);
			 }
	 	}
	 }

 	public int validSegments(int numberParenthesis) {
 		char[] segment = new char[numberParenthesis * 2];
 		List<String> segments = new ArrayList<String>();
 		addSegment(segments, numberParenthesis, numberParenthesis, segment, 0);
 		System.out.println("segments final: " + segments.toString());
 		return segments.size();
 	}
}