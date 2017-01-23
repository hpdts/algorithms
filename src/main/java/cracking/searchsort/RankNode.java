package cracking.searchsort;

import java.util.*;

public class RankNode {
 	public int left_size = 0;
 	public RankNode left, right;
 	public int data = 0;

 	public RankNode(int d) {
 		data = d;
 	}
	
 	public void insert(int d) {
 		if (d <= data) {
 			if (left != null){
 				left.insert(d);
 			} 
 			else{
 				left = new RankNode(d);
 			} 
 			left_size++;
 		} else {
 			if (right != null){
 				right.insert(d);
 			} 
 			else{
 				right = new RankNode(d);	
 			} 
 		}
 	}
	
 	public int getRank(int d) {
 		if (d == data) {
 			return left_size;
 		} else if (d < data) {
 			if (left == null){
 				return -1;
 			} else{
 				return left.getRank(d);
 			} 
 		} else {
 			int right_rank = right == null ? -1 : right.getRank(d);
 			if (right_rank == -1){
 				return -1;	
 			} 
 			else{
 				return left_size + 1 + right_rank;
 			} 
 		}
 	}

 	public void inOrder(RankNode node){
 		if(node != null){
 			inOrder(node.left);
 			System.out.println("Data: " + node.data);
 			inOrder(node.right);
 		}
 	}

 	public String levelOrderQueue(RankNode root){
		StringBuilder stringBuilder = new StringBuilder();
 		Queue<RankNode> q = new LinkedList<>();
 		int levelNodes =0; 
		
		if(root == null){
			return null;
		}

 		q.add(root);

 		while(!q.isEmpty()){
 			levelNodes = q.size();

 			while(levelNodes > 0){
				RankNode n = q.remove();
				stringBuilder.append(" " + n.data);
				if(n.left != null){
					q.add(n.left);	
				}

				if(n.right != null){
					q.add(n.right);	
				}
				levelNodes--;
			}

			stringBuilder.append(System.getProperty("line.separator"));
		}
		return stringBuilder.toString();
	}
 }