/**
 *  Homework 14 - Hash Table
 *
 *  Problem: Hash Table
 *
 *  Prompt: Create a hash table class using separate chaining.
 *
 *  The HashTable will have the following properties:
 *
 *         storage:  {ArrayList[]} - an array of array lists containing key-value pairs
 *                                   key-value pairs are String[]{key, value}
 *         buckets:  {Integer} - the maximum number of buckets that your
 *                   storage can contain. Initially set to 8.
 *           size:   {Integer} count of key-value pairs in the storage
 *
 *  The HashTable will also have the following methods:
 *
 *           hash:   Method that takes a key and bucket number and provides a
 *                   hashed value. The dbjb2 hashing function has been
 *                   provided.
 *
 *                   Input:      key {String}
 *                   Input:      buckets {Integer}
 *                   Output:     index {Integer}
 *
 *         insert:   Method that adds a key-value pair into the storage. If the
 *                   key already exists, the value should be updated. Use
 *                   separate chaining to handle collisions.
 *
 *                   Input:      key {String}
 *                   Input:      value {String}
 *                   Output:     {Void}
 *
 *            get:   Method that given a key, return its corresponding value.
 *                   If the key does not exist, return null.
 *
 *                   Input:      key {String}
 *                   Output:     value {String}
 *
 *         remove:   Method that takes a key as its input, and looks for the
 *                   and removes the key-value pair from the bucket.
 *
 *                   Input:      key {String}
 *                   Output:     {Void}
 *
 *         resize:   If the load factor reaches a critical 0.75 or higher,
 *                   double the number of buckets. If the load factor is 0.25
 *                   or less, half the number of buckets. Make sure the number
 *                   of buckets do not fall below 8 and re-index all key-value
 *                   pairs if bucket size is changed.
 *
 *                   Input:      key {String}
 *                   Output:     {Void}
 *
 *  Input: N/A
 *  Output: A HashTable instance
 */

import java.util.*;


class HashTable {

  public int buckets = 8;
  public int size = 0;
  public List[] storage = new ArrayList[buckets];

  // Time Complexity:
  // Auxiliary Space Complexity:
  public int hash(String key, int buckets) {
    int hash = 5381;
    for (int i = 0; i < key.length(); i++) {
      hash = ((hash << 5) + hash) + key.charAt(i);
    }
    return hash % buckets;
  }

  // Amortized Time Complexity (amortized):
  // Auxiliary Space Complexity (amortized):
  public void insert(String key, String value) {
    // YOUR WORK HERE
  }

  // Time Complexity:
  // Auxiliary Space Complexity:
  public String get(String key) {
    // YOUR WORK HERE
    return null;
  }

  // Amortized Time Complexity (amortized):
  // Auxiliary Space Complexity (amortized):
  public void remove(String key) {
    // YOUR WORK HERE
  }

  // Time Complexity:
  // Auxiliary Space Complexity:
  public void resize() {
    // YOUR WORK HERE
  }
}