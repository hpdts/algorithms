package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ExpressionTreeTest {

	private ExpressionTree expressionTree = new ExpressionTree();
	
	@Test
	public void creatingTree(){
		String postFix = "ab+ef*g*-";
		char[] charArray = postFix.toCharArray();
		ExpressionTree.Node root = expressionTree.constructTree(charArray);

		//expressionTree.inOrder(root);
		System.out.println(expressionTree.levelOrderQueue(root));
		//assertThat(expressionTree.levelOrderQueue(root), is(" -\n + *\n * g\n e f\n"));
	}
	
}
