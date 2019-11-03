package assignmentFeb26;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class SegmentsTest {

	private Segments segments = new Segments();

	@Ignore
	@Test
	public void validSegments1(){
		int validSegments = segments.validSegments(1);
        assertThat(validSegments, is(1));       
	}

	@Ignore
	@Test
	public void validSegments2(){
        int validSegments = segments.validSegments(2);
        assertThat(validSegments, is(2));   
	}

	@Test
	public void validSegments3(){
        int validSegments = segments.validSegments(3);
        assertThat(validSegments, is(5));        
	}

	@Ignore
	@Test
	public void validSegments4(){
        int validSegments = segments.validSegments(4);
        assertThat(validSegments, is(14));              
	}

	@Ignore
	@Test
	public void validSegments5(){
        int validSegments = segments.validSegments(5);
        assertThat(validSegments, is(42));        
	}
}