package accelerator;
/**
 *  Homework 13 - Graph
 *
 *  Problem: Graph
 *
 *  Prompt: Create a directed graph class using adjacency list edge
 *          representation.
 *
 *  The Graph will have the following properties:
 *
 *             storage: {HashMap} - the keys represent unique vertex ids {Integer}
 *                      and the values are Lists representing the
 *                      vertex ids of its neighors.
 *
 *  The Graph will also have the following methods:
 *
 *           addVertex: Method that accepts a vertex id {Integer} and adds the
 *                      vertex to the graph.  Return true if success and false
 *                      if failed.
 *
 *                      Input:    id {Integer}
 *                     Output:    {Boolean}
 *
 *        removeVertex: Method that accepts a vertex id and removes the vertex
 *                      with the matching id. Return true if success and false
 *                      if failed.
 *
 *                      Input:    id {Integer}
 *                     Output:    {Boolean}
 *
 *             addEdge: Method that accepts two vertex ids and creates a
 *                      directed edge from the first vertex to the second.
 *                      Returns true if success and false if failed.
 *
 *                      Input:    id1 {Integer}
 *                      Input:    id2 {Integer}
 *                     Output:    {Boolean}
 *
 *          removeEdge: Method that accepts two vertex id's and removes the
 *                      directed edge from the first vertex to the second.
 *                      Returns true if success and false if failed.
 *
 *                       Input:    id1 {Integer}
 *                       Input:    id2 {Integer}
 *                      Output:    {Boolean}
 *
 *           isVertex:  Method that accepts an id, and returns whether the vertex
 *                      exists in the graph.
 *
 *                       Input:    id {Integer}
 *                      Output:   {Boolean}
 *
 *           neighbors: Method that accepts a vertex id, and returns all of the
 *                      edges of that vertex.
 *
 *                       Input:    id {Integer}
 *                      Output:   {List<Integer>}
 *
 *
 *  Input:  {Void}
 *  Output: {Graph}
 *
 *  Notes:   The notation for Time/Auxiliary Space Complexity for graphs
 *           is slightly different since certain functions depend on
 *           either the number of vertices, edges or even both
 *
 *           O(V) = Linear w/ respect to the number of vertices
 *           O(E) = Linear w/ respect to the number of edges
 *           O(V+E) = Linear w/ respect to the number of vertices * number of edges
 */

import java.util.*;

public class Graph {

  //adjacency lists
  public Map<Integer, List<Integer>> storage = new HashMap<>();

  //   Time Complexity: O(1)
  //   Auxiliary Space Complexity:O(V)
  public boolean addVertex(Integer id) {
    // YOUR WORK HERE
    try{
      storage.put(id, new ArrayList<>());
    }catch (Exception e){
      return false;
    }
    return true;
  }

  public boolean removeVertex(Integer id) {
    // YOUR WORK HERE
    try{
      storage.remove(id);
    }catch (Exception e){
      return false;
    }
    return true;
  }

  //   Time Complexity: O(1)
  //   Auxiliary Space Complexity: O(V+E)
  public boolean addEdge(Integer id1, Integer id2) {
    // YOUR WORK HERE
    if(storage.containsKey(id1)){
      List<Integer> neighbors = storage.get(id1);
      return neighbors.add(id2);
    }else{
      return false; 
    }
  }

  // Time Complexity: O(E)
  // Auxiliary Space Complexity: O(V+E)
  public boolean removeEdge(Integer id1, Integer id2) {
    if(storage.containsKey(id1)){
      List<Integer> neighbors = storage.get(id1);
      return neighbors.remove(id2);
    }else{
      return false; 
    }
  }

  //   Time Complexity:O(1)
  //   Auxiliary Space Complexity: O(V)
  public boolean isVertex(Integer id) {
    // YOUR WORK HERE
    return storage.containsKey(id);
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(V)
  public List<Integer> neighbors(Integer id) {
    // YOUR WORK HERE
    return storage.get(id);
  }

  public void display(){
    System.out.println("storage: " + storage.toString());
  }
}