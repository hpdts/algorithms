package cracking.searchsort;

public class Question {
	private  RankNode root = null;
	
	public void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		}else {
			root.insert(number);
		}
	}
	
	 public int getRankOfNumber(int number) {
	 	return root.getRank(number);
	 }
	
	 public void inOrder() {
	 	root.inOrder(root);
	 }

	 public void levelOrderQueue(){
	 	System.out.println("level: " + root.levelOrderQueue(root));
	 }
}