package accelerator;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    public Integer id;
    public List<Vertex> edges;

    public Vertex(Integer id) {
        this.id = id;
        this.edges = new ArrayList<Vertex>();
    }

    public String toString(){
        return "id: " + id;
    }
}

public class Problems {

    // DO NOT EDIT
    // generate graph from int and array of arrays
    public static Vertex deserialize(int n, int[][] edges){
        Map<Integer, Vertex> vertices = new HashMap<>();
        for (Integer i = 0; i < n; i++) {
            vertices.put(i, new Vertex(i));
        }
        int v1;
        int v2;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            v1 = edge[0];
            v2 = edge[1];
            vertices.get(v1).edges.add(vertices.get(v2));
            vertices.get(v2).edges.add(vertices.get(v1));
        }
        return vertices.get(0);
    }

    /**
     *  1. Implement Breadth First Search using a queue and while loop.
     *
     *  Input: {Vertex} - the starting vertex
     *  Output: {List} - an list of vertex ids of the path
     *
     *  HINT: Use a set or hash map to handle redundancy
     */

    public static List<Integer> bfs(Vertex vertex) {
     // YOUR WORK HERE
        // Write your code here
        List<Integer> output = new ArrayList<Integer>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        if(vertex != null){
            queue.add(vertex);
            visited.add(vertex);
        }

        while(!queue.isEmpty()){
            Vertex curr = queue.remove();
            output.add(curr.id);

            for(Vertex neighbor : curr.edges){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return output;
    }

    /**
     *  2. Given a starting vertex, and an integer destination, return all valid
     *     paths for a given source and destination.
     *
     *  Input: {Vertex} - the starting vertex
     *         {Destination} - integer value of the destination vertex
     *  Output: {List} - a list of lists of vertex ids (integers) for different paths
     *
     *  HINT: Use a set or hash map to handle redundancy
     *
     *  NOTE: Please be aware that this problem is a slight variation
     *    of the HackerRank challenge that was provided in class. How would you
     *    handle things differently if each path returned needed to be a list?
     */

    public static List<ArrayList<Integer>> dfs(Vertex src, Integer dest) {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        if(src != null){
            stack.push(src);
        }
        List<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            Vertex curr = stack.pop();
            visited.add(curr);
            path.add(curr.id);
            if(curr.id == dest){
                System.out.println("path: " + path.toString());
                paths.add(new ArrayList<Integer>(path));
             
               // System.out.println("path rem: " + path.toString());
               // System.out.println("visited rem: " + visited.toString());
              /*  System.out.println("stack: " + stack.toString());
                System.out.println("curr: " + curr.id);
                int indexCurr = path.lastIndexOf(curr.id);
                System.out.println("indexCurr: " + indexCurr);
                List<Integer> backtracking = path.subList(indexCurr, path.size());
                for(Integer rem : backtracking){
                     visited.remove(rem);
                }  
                   System.out.println("backtracking: " + backtracking);
                   backtracking.clear();
                System.out.println("path after: " + path.toString());
                curr = stack.pop();*/

            }
            for(Vertex neighbor : curr.edges){
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                }
            }
            //backtracking loop condition
               visited.remove(curr);
                path.remove(path.size() - 1);
                //backyracking separadtly

        }
        return paths;
    }

     public static List<ArrayList<Integer>> dfs2(Vertex src, Integer dest) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<Vertex> visited = new HashSet<>();

        traverse(src, new ArrayList<Integer>(), dest, result, visited);

        return result;
    }

    public static void traverse(Vertex current, ArrayList<Integer> path, Integer destID,
                                ArrayList<ArrayList<Integer>> result, HashSet<Vertex> visited){
        if(visited.contains(current)) return;

        if(current.id.equals(destID)) {
            path.add(current.id);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }

        visited.add(current);
        path.add(current.id);

        for(Vertex edgeVertex: current.edges){
            traverse(edgeVertex, path, destID, result, visited);
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }
}