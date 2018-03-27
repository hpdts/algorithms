package java8;

import javafx.util.Pair;
import java.util.Iterator;


public class PairIterator implements Iterator<Pair<String,Integer>>{

    private Iterator<String> original;
	private String previousElement = null;
	private String currentElement = null;
	private boolean moreElements = true;

	public PairIterator(Iterator<String> original){
		this.original = original;
	}

	public boolean hasNext(){
		return moreElements;
	}

	public Pair<String,Integer> next(){
		//foo, foo, bar, bar, abc, abc
		//foo, foo, bar
		int count = 0;
		if(currentElement != null){ 
			//System.out.println("currentElement: " + currentElement);
			previousElement = currentElement;
			if(!original.hasNext()){
				moreElements = false;
				return new Pair(previousElement, ++count);
			}else{
				while(original.hasNext() && previousElement == currentElement){
					count++;
					currentElement = original.next();  
				}
				//System.out.println("currentElement else: " + currentElement);
				if(!original.hasNext()){
					if(currentElement != null){
						count++;		
					}
					moreElements = false;
				}
				return new Pair(previousElement, count);	
			}

		}else{

			currentElement = original.next(); 
			do{
				previousElement = currentElement;    
				currentElement = original.next();  
				count++;
			}while(previousElement == currentElement);

			if(currentElement != null){
				moreElements = true;
			}else{
				moreElements = false;
			}

		}
		return new Pair(previousElement, count);
	}
}
