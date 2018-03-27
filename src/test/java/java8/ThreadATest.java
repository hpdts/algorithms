package java8;

import org.junit.*;

public class ThreadATest {
    private ThreadA threadA = new ThreadA();

    @Test
	public void startThread(){
		threadA.start();
	}
}