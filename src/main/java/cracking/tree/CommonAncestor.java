package cracking.tree;

import java.util.*;

public class CommonAncestor {

	public static class Node{
		int number;
		Node left;
		Node right;

		public Node(int number){
			this.number = number;
			this.left = null;
			this.right = null;
		}

		public String toString(){
			return "Number: " + this.number;
		}

		public boolean equals(Node node) {
        	return (this.number == node.number);
    	}
	}

	public static Node root;
	public void add(Node node, int number){
		//instance root on test
		if(number < node.number){
			if(node.left != null){
				add(node.left, number);
			}else{
				node.left = new Node(number);
			}
		}else if(node.right != null){
				add(node.right, number);
			}else {
				node.right = new Node(number);
			}
	}

	public void insert(int number){
		Node temp = new Node(number);
		if(root == null){
			root = temp;
			return;
		}
		Node current = root;
		Node parent = null;

		while(true){
			parent = current;
			if(number < current.number){
				current = current.left;
				if(current == null){
					parent.left = temp;
					return;
				}
			}else{
				current = current.right;
				if(current == null){
					parent.right = temp;
					return;
				}
			}
		}

	}
	public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.print(" " + node.number);
			printInOrder(node.right);
		}
	}

	public void postOrder(Node node){
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(" " + node.number);
		}
	}

	public String levelOrderQueue(Node root){
		StringBuilder stringBuilder = new StringBuilder();
 		Queue<Node> q = new LinkedList<>();
 		int levelNodes =0; 
		
		if(root == null){
			return null;
		}

 		q.add(root);

 		while(!q.isEmpty()){
 			levelNodes = q.size();

 			while(levelNodes > 0){
				Node n = q.remove();
				stringBuilder.append(" " + n.number);
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

	public List<Node> findAncestors(Node root, Node nodeTarget){
		System.out.println("nodeTarget: " + nodeTarget);
		List<Node> ancestors = new ArrayList<>();
		Node current = root;
		int target = nodeTarget.number;

		//dont get the node stop before tree could be too big
		//if parent < target && right node > target
		while(current != null && current.number != nodeTarget.number){
			System.out.println("current.number: " + current.number);
			System.out.println("target: " + target);
			ancestors.add(current);
			if(current.number > target){
				current = current.left;
			}else{
				current = current.right; 
			}
		}
		return ancestors;
	}

	public Node findCommonAncestor(Node root, Node node1, Node node2){
		List<Node> ancestorsNode1 = findAncestors(root, node1);
		List<Node> ancestorsNode2 = findAncestors(root, node2);
		System.out.println("node1: " + ancestorsNode1);
		System.out.println("node2: " + ancestorsNode2);
		ancestorsNode1.retainAll(ancestorsNode2);
		return ancestorsNode1.get(0);
	}

	public Node findCommonAncestor2(Node root, Node node1, Node node2){
		Node current = root;

		while(current != null){
			System.out.println("current.number: " + current.number);

			if(current.number > node1.number && current.number > node2.number){
				current = current.left;
			}else if(current.number < node1.number && current.number < node2.number){
				current = current.right; 
			}else break;
		}
		return current;
	}

	public Node lca(Node node, int n1, int n2) 
    {
        if (node == null){
            return null;
        }
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.number > n1 && node.number > n2){
            return lca(node.left, n1, n2);
        }
  		System.out.println("LCA node.number: " + node.number);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.number < n1 && node.number < n2){
            return lca(node.right, n1, n2);
        }
  
        return node;
    }

    public LinkedList<Node> findPath(Node root, Node node1, Node node2){
    	LinkedList<Node> path = new LinkedList<>();
    	Node commonAncestor = findCommonAncestor2(root, node1, node2);
    	Node current = commonAncestor;
    	while(current != null && !current.equals(node1)){
    		if(current.number > node1.number){
    			current = current.left;
    		}else{
    			current = current.right;
    		}
    		path.addFirst(current);
    	}
    	current = commonAncestor;
    	while(current != null && !current.equals(node2)){
    		path.addLast(current);
    		if(current.number > node2.number){
    			current = current.left;
    		}else{
    			current = current.right;
    		}
    	}
    	path.addLast(node2);
    	return path;
    }

}