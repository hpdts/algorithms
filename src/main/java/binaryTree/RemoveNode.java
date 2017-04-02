package binaryTree;

import java.util.*;

public class RemoveNode {

	static class Node{
		int num;
		List<Node> children = new ArrayList<>();

		Node(){
		}

		Node(int num){
			this.num = num;
		}

        public String toString() {
        	return toString(0);
        }
		public String toString(int depth){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < depth; i++) {
				sb.append("  ");
			}
			sb.append("num: ").append(num).append("\n");
			for(Node node : children) {
				sb.append(node.toString(depth+1));
			}

			return sb.toString();
		}
	}

	static class NodeNumber{
		Node node;
		int childNumber;
		NodeNumber(Node node, int childNumber){
			this.node = node;
			this.childNumber = childNumber;
		}

		public int getChildNumber(){
			return childNumber;
		}

		public Node getNode(){
			return node;
		}
	}

	static Node root;

	public Node clone(Node root, Node copy){
		copy.num = root.num;
		for(Node child : root.children){
			copy.children.add(clone(child, new Node()));
		}
		return copy;
	}

	public void cleanUp(){
		cleanUp(root, new ArrayList<Node>());
	}

	public void cleanUp(Node node, List<Node> newChildren){
		if(node == null){
			return;
		}
		List<Node> children = node.children;
		for(Node child : children){
			if(remove(child)){
				cleanUp(child, newChildren);
			}else{
				newChildren.add(child);
				cleanUp(child, new ArrayList<>());
			}
		}
		node.children = newChildren;
	}


	public void cleanUp2(){
		cleanUp2(root, null);
	}

	public void cleanUp2(Node root, Node parent)
    {
        if(root==null){
            return;
        }

        if(remove(root)){

            List<Node> parentChildren = new ArrayList<>(parent.children);
            parentChildren.addAll(root.children);
            parentChildren.remove(root);

            parent.children = parentChildren;
            Iterator<Node> iterator = parentChildren.iterator();
            while(iterator.hasNext()){
                cleanUp2(iterator.next(), parent);
            }
        }else{
            for(Node child: root.children){
                cleanUp2(child, root);
            }
        }
    }

//use stack traverse and one to add children 
	public void bfs(){
		//create a new node and add children

		//do it iteratively
		// Mark all the vertices as not visited(By default
        // set as false)
        Set<Node> visited = new HashSet<>();
 
        // Create a queue for BFS
        LinkedList<Node> queue = new LinkedList<Node>();
 
        // Mark the current node as visited and enqueue it
        Node nodeTemp = root;
        visited.add(nodeTemp);
        queue.add(nodeTemp);
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            nodeTemp = queue.poll();
 			List<Node> children = nodeTemp.children;
			for(Node child : children){
				if(!visited.contains(child)){
					if(remove(child)){
						System.out.println("Node : " + child.num);
					}
					queue.add(child);
				}
			}
            
        }

	}

	//clone b could have elements with lowercase or differents
	public Node cloneSearch(Node rootA, Node rootB, Node target){
		List<Integer> path = dfsCountChild(rootA, target);
		return getNodeFromPath(path, rootB);

	}

	public List<Integer> dfsCountChild(Node root, Node target){
		Stack<NodeNumber> stack = new Stack<>();
		List<Integer> path = new ArrayList<>();
		NodeNumber temp = new NodeNumber(root, 0);
		stack.push(temp);

		while(!stack.isEmpty()){
			temp = stack.pop();
			path.add(temp.getChildNumber());

			List<Node> children = temp.getNode().children;
			if(children.size() == 0){
				path = new ArrayList<>();
			}
			for(int i = 0; i < children.size(); i++){
				Node child = children.get(i);
				
				if(child.num == target.num){
					path.add(i);
					return path;
				}
				stack.push(new NodeNumber(child, i));
			}
		}
		return null;
	}

	public Node getNodeFromPath(List<Integer> path, Node newRoot){
		List<Node> children = newRoot.children;
		Node child = newRoot;
		for(int childNumber : path){
			child = children.get(childNumber);
			children = child.children;
		}
		return child;
	}

	public boolean remove(Node node){
		return (node.num == 11 || node.num == 20 || node.num == 30);
	}

}