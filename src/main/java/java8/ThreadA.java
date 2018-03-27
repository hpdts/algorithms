package java8;

import java.util.*;
import static java.lang.Math.*;
import java.util.stream.*;

public class ThreadA {

	public void start(){
		ThreadB threadB = new ThreadB();
		threadB.start();

		synchronized(threadB){
			try{
				System.out.println("Waiting for b to be completed");
				threadB.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("total: " + threadB.total);

		}
	}
}


class ThreadB extends Thread{
	int total = 0;
	
	@Override
	public void run(){
		synchronized(this){
			for(int i = 0; i < 100; i++ ){
				total+=i;
			}
			notify();
		}
	}

} 