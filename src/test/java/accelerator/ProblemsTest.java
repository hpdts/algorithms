package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class ProblemsTest {
	Problems problems = new Problems();

	@Test
    public void bfs(){
    	try {
            	Vertex test = problems.deserialize(8, new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 5}, {4, 5}, {1, 7}, {4, 6}, {4, 7}, {5, 6}});
            	List<Integer> results = problems.bfs(test);
    			System.out.println("bfss: " + results.toString());
                assertTrue(validBfs(results, test));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Test
    public void dfs(){
    	try {
	            Vertex testGraph = problems.deserialize(8, new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 5}, {4, 5}, {1, 7}, {4, 6}, {4, 7}, {5, 6}});
	            Integer destinationID = 3;
	            //List<ArrayList<Integer>> results = problems.dfs(testGraph, destinationID);
	           	//for(List<Integer> lista : results){
	           		//System.out.println("results: " + results.toString());
	           	//}
	            List<ArrayList<Integer>> solution = new ArrayList<>();
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 2, 4, 6, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 7, 4, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 7, 4, 6, 5, 3)));

	           // assertTrue(array2DEqualsUnordered(results, solution));
            } catch (Exception e) {
            }
    }

   	@Test
    public void dfs2(){
    	try {
	            Vertex testGraph = problems.deserialize(8, new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 5}, {4, 5}, {1, 7}, {4, 6}, {4, 7}, {5, 6}});
	            Integer destinationID = 3;
	            List<ArrayList<Integer>> results = problems.dfs2(testGraph, destinationID);
	           	System.out.println("results: " + results.get(0).toString());
	            List<ArrayList<Integer>> solution = new ArrayList<>();
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 2, 4, 6, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 7, 4, 5, 3)));
	            solution.add(new ArrayList<>(Arrays.asList(0, 1, 7, 4, 6, 5, 3)));

	            assertTrue(array2DEqualsUnordered(results, solution));
            } catch (Exception e) {
            }
    }

    private static boolean array2DEqualsUnordered(List<ArrayList<Integer>> arr1, List<ArrayList<Integer>> arr2) {
        if (arr1 == null) return (arr2 == null);
        if (arr2 == null) return false;
        if (arr1.size() != arr2.size()) return false;
        int count = 0;
        for(ArrayList<Integer> subArr1: arr1){
            for(ArrayList<Integer> subArr2: arr2){
                if(subArr1.equals(subArr2)){
                    count++;
                    break;
                }
            }
        }
        return count == arr1.size();
    }
     // takes in an array of path and a vertex start point and determines whether
    // the bfs is valid
    private static boolean validBfs(List<Integer> path, Vertex start) {
        if (path.size() == 0 && start != null) {
            return false;
        }
        if (path.get(0) != start.id) {
            return false;
        }

        Vertex current = start;
        Map<Integer, Vertex> visited = new HashMap<>();
        visited.put(current.id, current);
        for (int i = 0, j = 1; i < path.size() - 1; i++) {
            if (i >= j) {
                return false;
            }
            List<Vertex> neighbors = getNeighbors(current, visited);

            List<Integer> values = getValues(neighbors);
            List<Integer> subPath = path.subList(j, j + values.size());
            if (!listsMatching(values, subPath)) {
                return false;
            }
            j += values.size();
            for(int k = 0; k < neighbors.size(); k++) {
                visited.put(neighbors.get(k).id, neighbors.get(k));
            }

            current = visited.get(path.get(i + 1));
        }

        return true;
    }

    private static List<Vertex> getNeighbors(Vertex vertex, Map<Integer, Vertex> visited) {
        List<Vertex> results = new ArrayList<>();
        List<Vertex> edges = vertex.edges;
        Vertex neighbor;
        for (int i = 0; i < edges.size(); i++) {
            neighbor = edges.get(i);
            if(!visited.containsKey(neighbor.id)) {
                results.add(neighbor);
            }
        }
        return results;
    }

    private static List<Integer> getValues(List<Vertex> vertices) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            results.add(vertices.get(i).id);
        }
        return results;
    }

    private static boolean listsMatching(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            System.out.println("listMatching: not equal length");
            return false;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0 ; i < list1.size() ; i++) {
            int value = list1.get(i);
            int count = cache.containsKey(value) ? cache.get(value) : 0;
            cache.put(value, count + 1);
        }

        for (int j = 0; j < list2.size(); j++) {
            int value = list2.get(j);
            if (!cache.containsKey(value) || cache.get(value) == 0) {
                return false;
            }
            int count = cache.get(value);
            cache.put(value, count - 1);
        }

        return true;
    }



}