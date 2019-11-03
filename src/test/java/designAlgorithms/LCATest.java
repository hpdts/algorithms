package designAlgorithms;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import static designAlgorithms.LCA.*;

public class LCATest {

	public LCA lca = new LCA();

	@Test
	public void pathtoRoot(){
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		root.left = two;
		two.left = three;
		two.right = four;
		four.right = five;

		root.right = six;
		six.left = seven;
		six.right = eight;
		seven.left = nine;

		List<Node> path = lca.pathToRoot(root, nine);
		System.out.println("TEST path: " + path);
 
		List<Integer> path2 = new ArrayList<>();

		//lca.hasPath(root, path2, 9);

		System.out.println("TEST new: " + path2);

		System.out.println("splosion: " + lca.stringSplosion("Code"));
	}

	@Test
	public void logicalIndexes(){
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);

		root.left = two;
		two.left = four;
		two.right = five;
		five.left = ten;

		root.right = three;
		three.left = six;

			/*
			  1
	        /    \
	       2      3
		  / \    /
		 4   5   6  
	         /
	         10
			*/
		 assertTrue(lca.exists(root, 10));
		 assertFalse(lca.exists(root, 13));

		 //Node root2 = new Node(2);
		 //assertTrue(lca.exists(root2, 2));
		 //assertFalse(lca.exists(root2, 13));
	}

	@Test
	public void spiral(){
		int[][] number = {
							{1, 2, 3, 4},
							{5, 6, 7, 8},
							{9,10,11,12}
							};

		lca.showInSpiral(number);
	}

	@Test
	public void countAndSay(){
		String term = lca.countAndSay(1);
		assertThat(term, is("1"));

		term = lca.countAndSay(2);
		assertThat(term, is("11"));

		term = lca.countAndSay(3);
		assertThat(term, is("21"));

		term = lca.countAndSay(4);
		assertThat(term, is("1211"));

		term = lca.countAndSay(5);
		assertThat(term, is("111221"));

	}

	@Test
	public void permuteBackTracking(){
		String word = "ABC";

		lca.permute(word, 0, word.length()-1);
		//lca.permute("AB", 0, word.length()-1);
	}

	@Test
	public void nthSmallest(){
		//1,3,6,7,19
		int[] numbers = {1,19, 3,5,6,7};
		int min = lca.nthSmallest(numbers, 2);
		assertThat(min, is(3));
		min = lca.nthSmallest(numbers, 1);
		//assertThat(min, is(1));
	}
}