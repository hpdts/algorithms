package cracking.searchsort;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class QuestionTest {

	private Question question = new Question();
	
	@Test
	public void streamInts(){

		question.track(26);
		question.track(10);
		question.track(45);
		question.track(5);
		question.track(3);
		question.track(6);
		question.track(7);
		question.track(7);

		assertThat(question.getRankOfNumber(5), is(1));
		assertThat(question.getRankOfNumber(10), is(5));

		question.inOrder();

		question.levelOrderQueue();
	}	
}