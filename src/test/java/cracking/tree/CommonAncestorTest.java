package cracking.tree;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static cracking.tree.CommonAncestor.*;
import java.util.*;


public class CommonAncestorTest {


	private CommonAncestor commonAncestor = new CommonAncestor();
    private	CommonAncestor.Node root = new CommonAncestor.Node(40);

	@Before
    public void setUp() {
    	commonAncestor.add(root, 20);
    	commonAncestor.add(root, 60);
    	commonAncestor.add(root, 10);
    	commonAncestor.add(root, 30);
    	commonAncestor.add(root, 50);
    	commonAncestor.add(root, 70);
    	//commonAncestor.add(root, 80);
    	//commonAncestor.add(root, 90);
    	/*     40
             /   \
           20    60
           / \	 / \
          10 30 50  70
		 */	                	
    }

    @Test
    public void createBST(){

		System.out.println("InOrder: ");
    	commonAncestor.printInOrder(root);
    	System.out.println("\nPostOrder: ");
    	commonAncestor.postOrder(root);

    	System.out.println("\nlevelOrderQueue: \n" + commonAncestor.levelOrderQueue(root));


    	System.out.println("\n Tree 2 iterative: ");

    	commonAncestor.insert(40);
    	commonAncestor.insert(20);
    	commonAncestor.insert(60);
    	commonAncestor.insert(10);
    	commonAncestor.insert(30);
    	commonAncestor.insert(50);
    	commonAncestor.insert(70);

    	System.out.println("\nPostOrder: ");
    	commonAncestor.postOrder(CommonAncestor.root);


    }

    @Test
    public void findAncestors(){
    	Node node10 = new Node(10);
    	List<Node> ancestors = commonAncestor.findAncestors(root, node10);
    	assertThat(ancestors.size(), is(2));

    	Node node60 = new Node(60);
    	Node common = commonAncestor.findCommonAncestor(root, node10, node60);

    	System.out.println("\nAncestors: " + ancestors);
    	System.out.println("\n common: " + common);
    	assertThat(common.number, is(40));

		Node node30 = new Node(30);
    	common = commonAncestor.lca(root, node10.number, node30.number);
    	assertThat(common.number, is(20));

    	Node common2 = commonAncestor.lca(root, node10.number, node60.number);
    	System.out.println("\n common2: " + common2);

    	Node common3 = commonAncestor.findCommonAncestor2(root, node10, node60);
    	assertThat(common3.number, is(40));
    }

    @Test
    public void findPath(){
    	Node node10 = new Node(10);
    	Node node60 = new Node(60);
    	Node node30 = new Node(30);

		List<Node> path = commonAncestor.findPath(root, node10, node60);
    	assertThat(path.size(), is(4));

    	System.out.println("\n path: " + path);

   	    path = commonAncestor.findPath(root, node10, node30);
    	assertThat(path.size(), is(3));

    	System.out.println("\n path: " + path);

    }


}