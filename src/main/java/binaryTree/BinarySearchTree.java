package binaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    class Node{
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        int data;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        Node left;

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        Node right;

        Node(Node left, Node right , int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }


    }

    Node root;

    public void insert(int dataIn) {
        root = insert(root, dataIn);
    }

    private Node insert(Node nodeIn, int dataIn){
        if (nodeIn == null) {
            nodeIn = new Node(null, null, dataIn);
        } else {
            if (dataIn < nodeIn.getData()) {
                nodeIn.setLeft(insert(nodeIn.getLeft(), dataIn));
            } else {
                nodeIn.setRight(insert(nodeIn.getRight(), dataIn));
            }
        }
        return nodeIn;
    }

    void depthFirstSearch(Node root) {
        //DFS
        if(root == null){
            return ;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){      // As we want to visit left
                stack.push(current.left);  //child first, we must push this node last
            }
        }
    }

    //Print by level
    void breadthFirstSearch(Node root){
        if(root == null){
            return;
        }
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.right != null){
                queue.add(current.right);
                nextLevelCount++;
            }

            if(current.left != null) {
                queue.add(current.left);
                nextLevelCount++;
            }
            currentLevelCount--;
            if(currentLevelCount == 0){
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

    }

    //DFS, BFS
    public static void main(String[] args) {
        //not balanced because root is 1
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(10);
        binarySearchTree.insert(8);
        System.out.println("DFS");
        binarySearchTree.depthFirstSearch(binarySearchTree.root);
        System.out.println();
        System.out.println("BFS");
        binarySearchTree.breadthFirstSearch(binarySearchTree.root);
    }
}
