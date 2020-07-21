package accelerator;

/*
  * Homework 12 - Heap
  *
  *
  *  Prompt: Create a Heap class/constructor
  *
  *  The Heap will take in the following input:
  *
  *                type: argument should be either 'min' or 'max'. This will
  *                      dictate whether the heap will be a minheap or maxheap.
  *                      The comparator method will be affected by this
  *                      argument. See method description below
  *
  *  The Heap will have the following property:
  *
  *             storage: array
  *
  *                type: property that will be either 'min' or 'max'. This will
  *                      be dictated by
  *
  *  The Heap will have the following methods:
  *
  *             compare: takes in two arguments (a and b). Depending on the heap
  *                      type (minheap or maxheap), the comparator will behave
  *                      differently. If the heap is a minheap, then the compare
  *                      function will return true if a is less than b, false
  *                      otherwise. If the heap is a maxheap, then the compare
  *                      function will return true if a is greater than b, false
  *                      otherwise.
  *
  *                swap: takes in two indexes and swaps the elements at the two
  *                      indexes in the storage array
  *
  *                peak: returns the peak element of the storage array. This
  *                      will be the most minimum and maximum element for a
  *                      minheap and maxheap respectively
  *
  *                size: returns the number of elements in the heap
  *
  *              insert: inserts a value into the heap. Should begin by pushing
  *                      the value onto the end of the array, and then calling
  *                      the bubbleUp method from the last index of the array
  *
  *            bubbleUp: takes in an index, and considers the element at that
  *                      index to be a child. Continues to swap that child with
  *                      its parent value if the heap comparator condition is
  *                      not fulfilled
  *
  *          removePeak: removes the peak element from the heap and returns it.
  *                      Should begin by swapping the 0th-index element with the
  *                      last element in the storage array. Uses bubbleDown
  *                      method from the 0th index
  *
  *          bubbleDown: takes in an index, and considers the element at this
  *                      index to be the parent. Continues to swap this parent
  *                      element with its children if the heap comparator
  *                      condition is not fulfilled
  *
  *              remove: takes in a value and (if it exists in the heap),
  *                      removes that value from the heap data structure and
  *                      returns it. Should rearrange the rest of the heap to
  *                      ensure the heap comparator conditions are fulfilled
  *                      for all of its elements
  *
  *
  *
  *  Input:  N/A
  *  Output: A Heap instance
  *
  *  What are the time and auxilliary space complexities of the various methods?
  *
  */

import java.util.*;

class Heap {

  List<Integer> storage;
  String type;


  public Heap(String type) {
    //YOUR WORK HERE
    this.type = type;
    this.storage = new ArrayList<Integer>();
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public boolean compare(int a, int b){
    //YOUR WORK HERE
    if(type.equals("min")){
      return (storage.get(a) < storage.get(b));
    }else{
      return (storage.get(a) > storage.get(b));
    }
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public void swap(int index1, int index2){
    //YOUR WORK HERE
    int temp = storage.get(index1);
    storage.set(index1, storage.get(index2));
    storage.set(index2, temp);
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity:  O(1)
  public int peak(){
    //YOUR WORK HERE
    return storage.size() > 0 ? storage.get(0) : -1;
  }

  // Time Complexity:
  // Auxiliary Space Complexity:
  public int size(){
    //YOUR WORK HERE
    return storage.size();
  }

  // Time Complexity:
  // Auxiliary Space Complexity:
  public void insert(int value){
    //YOUR WORK HERE
    storage.add(value);
    bubbleUp(storage.size() - 1);
    System.out.println("storage: " + storage.toString());
  }

  // Time Complexity: log(n)
  // Auxiliary Space Complexity: O(1)
  public void bubbleUp(int index){
    //YOUR WORK HERE
    if(index < 1 || index >= storage.size()){
      return;
    }
    int childIndex = index;
    int parentIndex = 0;
    if(childIndex % 2 == 0){
      parentIndex = (childIndex - 2) / 2;
    }else{
      parentIndex = (childIndex - 1) / 2;
    }

    while(childIndex > 0 && !compare(parentIndex, childIndex)){
      swap(parentIndex, childIndex);
      childIndex = parentIndex;
      if(childIndex % 2 == 0){
        parentIndex = (childIndex - 2) / 2;
      }else{
        parentIndex = (childIndex - 1) / 2;
      }
    }
  }

  // Time Complexity: O(log n)
  // Auxiliary Space Complexity: O(1)
  public int removePeak(){
    //YOUR WORK HERE
    swap(0, storage.size()-1);
    int toReturn = storage.remove(storage.size()-1);
    bubbleDown(0);
    return toReturn;
  }

  // Time Complexity: O(log n)
  // Auxiliary Space Complexity: O(1)
  public void bubbleDown(int index){
    //YOUR WORK HERE
    if(index >= size()){
      return;
    }

    int parentIndex = index;
    int childIndex1 = (2 * parentIndex) + 1;
    int childIndex2 = (2 * parentIndex) + 2;
    int masterChildIndex = 0;

    if(childIndex1 >= storage.size()){
      return;
    }else if(childIndex2 >= storage.size()){
      masterChildIndex = childIndex1;
    }else if(compare(childIndex1, childIndex2)){
      masterChildIndex = childIndex1;
    }else{
      masterChildIndex = childIndex2;
    }

    while(parentIndex < storage.size() && !compare(parentIndex, masterChildIndex)){
      swap(parentIndex, masterChildIndex);

      parentIndex = masterChildIndex;
      childIndex1 = 2 * parentIndex + 1;
      childIndex2 = 2 * parentIndex + 2;

      if(childIndex1 >= storage.size()){
        return;
      }else if(childIndex2 >= storage.size()){
        masterChildIndex = childIndex1;
      }else if(compare(childIndex1, childIndex2)){
        masterChildIndex = childIndex1;
      }else{
        masterChildIndex = childIndex2;
      }
    }

  }

  // Time Complexity:O(log n)
  // Auxiliary Space Complexity: O(1)
  public boolean remove(int value){
    for (int i = 0 ; i < this.size() ; i++) {
      if (storage.get(i) == value) {
        swap(i, this.size() - 1);
        int temp = storage.remove(size()-1);
        bubbleUp(i);
        bubbleDown(i);
        return true;
      }
    }
    return false;
  }
}
