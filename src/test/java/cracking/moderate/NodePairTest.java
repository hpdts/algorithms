package cracking.moderate;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;



public class NodePairTest {
	private NodePair nodePair = new NodePair();

	@Test
	public void binaryTree(){

		BiNode root = new BiNode(4);
		root.node1 = new BiNode(2);
		root.node2 = new BiNode(5);
		root.node2.node2 = new BiNode(6);

		root.node1.node1 = new BiNode(1);
		root.node1.node2 = new BiNode(3);
		root.node1.node1.node1 = new BiNode(0);

		NodePair node = nodePair.convert(root);

	}


}