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



	public boolean remove(Node node){
		return (node.num == 11 || node.num == 20 || node.num == 30);
	}

}