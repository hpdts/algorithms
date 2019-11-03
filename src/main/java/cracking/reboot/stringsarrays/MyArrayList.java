package cracking.reboot.stringarrays;

import java.util.*;

public class MyArrayList implements Iterable<Integer> {


	int size = 0;

	public int size(){
		return size;
	}

	int[] myList = new int[10];

	@Override
	public Iterator<Integer> iterator() {
	    Iterator<Integer> it = new Iterator<Integer>() {
	        private int currentIndex = 0;

	        @Override
	        public boolean hasNext() {
	            return currentIndex < size && myList[currentIndex] != 0;
	        }

	        @Override
	        public Integer next() {
	            return myList[currentIndex++];
	        }

	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }

	    };
	    return it;
	}

	public void add(int element){
		if(size >= myList.length){
			int newSize = myList.length * 2;
			int[] newList = new int[newSize];
			for(int i = 0; i < myList.length; i++){
				newList[i] = myList[i];
			}
			myList = newList;
		}

		myList[size++] = element;
	}

	public String toString(){
		StringBuilder allList = new StringBuilder();
		for(int i =0; i < size;i++){
			allList.append(myList[i] + "\n");
		}
		return allList.toString();
	}

	public Integer get(int index){
		return myList[size];
	}
}

/*class CustomIterator<Integer> implements Iterator<Integer> { 
      
    // constructor 
    /*CustomIterator<Integer>(MyArrayList obj) { 
        // initialize cursor 
    } 
      
    // Checks if the next element exists 
    public boolean hasNext() { 
    	return size() != 0;
    } 
      
    // moves the cursor/iterator to next element 
    public Integer next() { 
    	return get(size());
    } 
      
    // Used to remove an element. Implement only if needed 
    public void remove() { 
        // Default throws UnsupportedOperationException. 
    } 
} */