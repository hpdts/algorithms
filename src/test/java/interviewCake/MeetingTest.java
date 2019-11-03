package interviewCake;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class MeetingTest {

	public Meeting meeting = new Meeting(1,8);

	@Test
    public void mergeIntervals(){
		List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1,3));
        meetings.add(new Meeting(2,6));
        meetings.add(new Meeting(8,10));
        meetings.add(new Meeting(15,18));

        List<Meeting> merge = meeting.mergeRanges(meetings);



    }
}