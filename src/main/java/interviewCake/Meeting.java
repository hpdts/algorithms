package interviewCake;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Meeting{
	private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String toString(){
            return "start: " + this.startTime + "; end: " + this.endTime + "/n";
    }

    public List<Meeting> mergeRanges(List<Meeting> meetings) {
    	List<Meeting> result = new ArrayList<>();

    	Collections.sort(meetings, new Comparator<Meeting>(){
    		public int compare(Meeting m1, Meeting m2){
    			if(m1.startTime != m2.startTime){
    				return (m1.startTime - m2.startTime);
    			}else{
    				return	m1.endTime - m2.endTime;
    			}
    		}
    	});

    	System.out.println("result: " + result.toString());

    	return result;
    }
}