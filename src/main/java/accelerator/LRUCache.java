package accelerator;

import java.util.*;




public class LRUCache{

class Node {
  Node next;
  Node prev;
  String key;
  String val;

  public Node(String key, String val){
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }

}

  /**
   * Always add the new node right after head;
   */
  private void addNode(Node node){
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;

  }

  /**
   * Remove an existing node from the linked list.
   */
  private void removeNode(Node node){
    node.prev.next = node.next;
    node.next.prev = node.prev;

    node.next = null;
    node.prev = null;
  }

  /**
   * Move certain node in between to the head.
   */
  private void moveToHead(Node node){
    this.removeNode(node);
    this.addNode(node);
  }

  // pop the current tail.
  private Node removeFromTail(){
    //YOUR WORK HERE
    Node res = tail.prev;
    this.removeNode(res);
    return res;
  }

  private Hashtable<String, Node> cache = new Hashtable<String, Node>();
  private int count;
  private int capacity;
  private Node head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    //dummy nodes
    head = new Node("0", "0");
    tail = new Node("0", "0");

    head.next = tail;
    tail.prev = head;
  }

  public String get(String key) {
    Node node = cache.get(key);
    if(node == null){
      return null;
    }

    this.moveToHead(node);
    return node.val;
  }


  public void set(String key, String value) {
    Node node = cache.get(key);
    if(node == null){
      Node newNode = new Node(key, value); 
      this.cache.put(key, newNode);
      this.addNode(newNode);
      count++;

      if(count > capacity){
        count--;
        Node tail = removeFromTail();
        cache.remove(tail.key);
      }
    }else{
      node.val = value;
      this.moveToHead(node);
    }
  }

   public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}

























////////////////////////////////////////////////////////////
///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class Main {
  private int[] testCount;

  // an interface to perform tests
  public interface Test {
    public boolean execute();
  }

  public static void main(String[] args) {

    // instantiate the testing of each module by resetting count and printing title of module
    int[] testCount = {0, 0};
    System.out.println("LRU Cache tests");

    // tests are in the form as shown
    assertTest(testCount, "should be able to set and get key-value pairs", new Test() {
      public boolean execute() {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set("doc", "david");
        lruCache.set("cpo", "joshua");
        lruCache.set("ceo", "andy");
        String example1 = lruCache.get("doc");
        String example2 = lruCache.get("cpo");
        String example3 = lruCache.get("ceo");
        return example1 == "david" && example2 == "joshua" && example3 == "andy";

      }
    });

    // tests are in the form as shown
    assertTest(testCount, "should be able overwrite values with same keys when using set method", new Test() {
      public boolean execute() {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set("student", "henry");
        lruCache.set("student", "eliza");
        String example = lruCache.get("student");
        return example == "eliza";
      }
    });

    // tests are in the form as shown
    assertTest(testCount, "old key value pairs should be removed when capacity has been exceeded", new Test() {
      public boolean execute() {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set("dentist", "akali");
        lruCache.set("doctor", "swain");
        lruCache.set("lawyer", "kennan");
        lruCache.set("judge", "leona");
        return lruCache.get("dentist") == null && lruCache.get("doctor") == "swain";
      }
    });

    // tests are in the form as shown
    assertTest(testCount, "most recently modified/viewed items should be moved to front of LRU cache while stale items are moved to end", new Test() {
      public boolean execute() {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set("doc", "david");
        lruCache.set("cpo", "joshua");
        lruCache.set("ceo", "andy");
        lruCache.get("doc");
        lruCache.set("swe", "ron");
        return lruCache.get("cpo") == null && lruCache.get("swe") == "ron";
      }
    });

    // tests are in the form as shown
    assertTest(testCount, "should be able to replace multiple stale items", new Test() {
      public boolean execute() {

        LRUCache lruCache = new LRUCache(3);
        lruCache.set("one", "hello");
        lruCache.set("two", "bye");
        lruCache.set("three", "blah");
        lruCache.set("four", "foo");
        lruCache.set("five", "fum");
        lruCache.set("six", "great");
        String ex1 = lruCache.get("one");
        String ex2 = lruCache.get("two");
        String ex3 = lruCache.get("three");
        String ex4 = lruCache.get("four");
        String ex5 = lruCache.get("five");
        String ex6 = lruCache.get("six");
        return ex1 == null && ex2 == null && ex3 == null && ex4 == "foo" && ex5 == "fum" && ex6 == "great";
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

  }


  // do not edit below, this is to wrap the test and check for exceptions
  private static void assertTest(int[] count, String name, Test test) {
    String pass = "false";
    count[1]++;

    try {
      if (test.execute()) {
        pass = " true";
        count[0]++;
      }
    } catch(Exception e) {}
    String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
    System.out.println(result);
  }
}
