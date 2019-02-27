package assignmentFeb26;

import java.util.*;

public class Segments {

	private void addSegment(List<String> segments, int leftParenthesis, int rightParenthesis, char[] segment, int count) {
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
 		return segments.size();
 	}
}