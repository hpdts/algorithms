package accelerator;

/**
 *  Homework 10 - Binary Search Tree
 *
 *  Problem 1: TreeNode class
 *
 *  Prompt:    Create a TreeNode class
 *             The TreeNode class should contain the following 
 public properties:
 *
 *                   value:   {Integer}
 *                    left:   {TreeNode} (initially null)
 *                   right:   {TreeNode} (initially null)
 *
 *                 Example:   var TreeNode sample = new TreeNode(1)
 *                            sample.value        // 1
 *                            sample.left         // null
 *                            sample.right        // null
 *
 *
 *  Problem 2: BinarySearchTree class.
 *
 *  Prompt:    Create a BinarySearchTree class
 *
 *             The BinarySearchTree class should contain the following public
 *             properties:
 *
 *                    root:   {TreeNode} (initially null)
 *                    size:   {Integer}
 *
 *             The BinarySearchTree class should also contain the following
 *             public methods:
 *
*      insert:   A method that takes takes an integer value, and
*                creates a node with the given input.  The method
*                will then find the correct place to add the new
*                node. Values larger than the current node node go
*                to the right, and smaller values go to the left.
 *
 *                            Input:     {Integer}
 *                            Output:    {Void}
 *
 * search:   A method that will search to see if a node with a
 *                 specified value exists and returns true or false
 *                  if found.
 *
 *                            Input:     {Integer}
 *                            Output:    {Boolean}
 */

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value) {
    // YOUR WORK HERE
    this.value = value;
    left = right = null;
  }

  public String toString(){
    return " value: " + value;
  }

}

class NodeDouble {
  public double value;
  public NodeDouble left;
  public NodeDouble right;

  public NodeDouble(double value) {
    // YOUR WORK HERE
    this.value = value;
    left = right = null;
  }

  public String toString(){
    return " value: " + value;
  }
}

public class BinarySearchTree {



  public TreeNode root;
  public int size;

  public BinarySearchTree() {
    // YOUR WORK HERE
    root = null;
  }

  // Time Complexity: O(log n)
  // Auxiliary Space Complexity: O(1)
  public void insert(int value) {
    // YOUR WORK HERE
    TreeNode node = new TreeNode(value);
    if(root == null){
      root = node;
      return;
    }
    TreeNode parent = null;
    TreeNode child = root;

    while(child != null){
      parent = child;
      if(value < parent.value){
        child = parent.left;
      }else{
        child = parent.right;
      }
    }

    if(value < parent.value){
      parent.left = node;
    }else{
      parent.right = node;
    }
  }
/*bst.prototype.push = function(val){
  var root = this.root; 
  
  if(!root){
    this.root = new node(val);
    return;
  }
  
  var curNode = root; 
  var newNode = new node(val)
  
  while(curNode){
    if(val< curNode.val){
      if(!curNode.left){
        curNode.left = newNode;
        break;
      } else {
        curNode = curNode.left
      }
    }
    else {
      if(!curNode.right){
        curNode.right = newNode;
        break;
      } else {
        curNode = curNode.right
      }
    }
  }
}*/
  public void displayPreOrder(TreeNode root){
    System.out.println("root: " + root.value);

    if(root.left != null){
      displayPreOrder(root.left);
    }
    if(root.right != null){
      displayPreOrder(root.right);
    }
  }

  public void displayInOrder(TreeNode root){
    if(root.left != null){
      displayInOrder(root.left);
    }
    System.out.println("root: " + root.value);
    if(root.right != null){
      displayInOrder(root.right);
    }
  }

  public void printTree(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    int currentLevelCount = 1;
    int nextLevelCount = 0;
    queue.add(root);
    while(!queue.isEmpty()){
      TreeNode curr = queue.remove();
      System.out.print(curr.value + " ");
      if(curr.left != null){
        queue.add(curr.left);
        nextLevelCount++;
      }
      if(curr.right != null){
        queue.add(curr.right);
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

  // Time Complexity:log(n)
  // Auxiliary Space Complexity:O(1)
  public boolean search(int value) {
    // YOUR WORK HERE
    return searchBST(value, root);
  }

  public boolean searchBST(int value,TreeNode root){
    if(root == null){
      return false;
    }else if(value == root.value){
      return true;
    }
    System.out.println("root: " + root.value);
    if(value < root.value){
       return searchBST(value, root.left);
    }else{
      return searchBST(value, root.right);
    }
  }

  //path from root
  //lca
  //distance to LCA to node 1 + LCA node 2
  public int distance2Nodes(TreeNode root, int node1, int node2){
    List<TreeNode> path1ToRoot = new ArrayList<>();
    List<TreeNode> path2ToRoot = new ArrayList<>();
    pathToRootRecursive(root, node1, path1ToRoot);
    pathToRootRecursive(root, node2, path2ToRoot);

    System.out.println("path: " + path1ToRoot);
    System.out.println("path2ToRoot: " + path2ToRoot);
    path1ToRoot.retainAll(path2ToRoot);
    System.out.println("path1ToRoot: " + path1ToRoot);
    List<TreeNode> path1ToLCA = new ArrayList<>();
    List<TreeNode> path2ToLCA = new ArrayList<>();
    pathToRootRecursive(path1ToRoot.get(0), node1, path1ToLCA);
    pathToRootRecursive(path1ToRoot.get(0), node2, path2ToLCA);
    return path1ToLCA.size() + path2ToLCA.size() - 1;
  }

  public boolean pathToRootRecursive(TreeNode root, int node, List<TreeNode> path){
    if(root == null){
      return false;
    }
    //System.out.println("out root: " + root.value);
    //System.out.println("path: " + path);

    if((root.value == node) || pathToRootRecursive(root.left, node , path) || pathToRootRecursive(root.right, node , path)){
      //System.out.println("root: " + root.value);
      path.add(root);
      return true;
    }
    return false;
  }

  //dfs to find node
  public List<Integer> pathToRoot(TreeNode root, int node){
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    List<Integer> path = new ArrayList<>();

    while(!stack.isEmpty()){
      TreeNode curr = stack.pop();
      path.add(curr.value);
      if(curr.value == node){
        break;
      }

      if(curr.right != null){
        stack.push(curr.right);
      }

      if(curr.left != null){
        stack.push(curr.left);
      }
        //path.remove(path.size() - 1);
    }
    return path;
  }

  public boolean checkAverage(NodeDouble node){
    Queue<NodeDouble> queue = new LinkedList<>();
    queue.add(node);
    NodeDouble parent = node;
    boolean isParentAverage = true;

    while(!queue.isEmpty()){
      NodeDouble curr = queue.remove();
      double sumChildren = 0;
      int countChildren = 0;

      if(curr.left != null){
        queue.add(curr.left);
        sumChildren+= curr.left.value;
        countChildren++;
      }

      if(curr.right != null){
        queue.add(curr.right);
        sumChildren+= curr.right.value;
        countChildren++;
      }
      if(countChildren != 0){
        //System.out.println("sumChildren: " + sumChildren);
        //System.out.println("countChildren: " + countChildren);
        double average = sumChildren / countChildren;
        //System.out.println("average: " + average);
        if(average != curr.value){
          isParentAverage = false;
          break;
        }
      }
      parent = curr;
    }
    return isParentAverage;
  }

  public int[] checkAverageByLevel(TreeNode root){
    System.out.println("checkAverageByLevel ");
    Map<Integer, List<Integer>> nodesByLevel = new HashMap<>();
    helper(root, nodesByLevel, 0);
    int[] result = new int[nodesByLevel.size()];

   // System.out.println("nodesByLevel: " + nodesByLevel.toString());
    for(Map.Entry<Integer, List<Integer>> entry : nodesByLevel.entrySet()){
      int level = entry.getKey();
      List<Integer> nodes = entry.getValue();
      int sum = nodes.stream().mapToInt(Integer::intValue).sum();
    //  System.out.println("sum: " + sum);
    // System.out.println("level: " + level);
    // System.out.println("nodes: " + nodes.toString());
      result[level] = sum / nodes.size();
    }
    System.out.println(Arrays.toString(result));
    return result;
  }

  public void helper(TreeNode root, Map<Integer, List<Integer>> nodesByLevel, int level){
    if(root == null){
      return;
    }
    List<Integer> nodes = nodesByLevel.getOrDefault(level, new ArrayList<>());
    nodes.add(root.value);
    nodesByLevel.put(level, nodes);

    helper(root.left, nodesByLevel, level+1);
    helper(root.right, nodesByLevel, level+1);
  }

  public int[] checkAverageByLevelBFS(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<Integer> result = new ArrayList(); 
    while(true){
      int nodeCount = queue.size();
      if(nodeCount == 0){
        break;
      }
      int sumNodes = 0;
      int sumCount = nodeCount;
      while(nodeCount > 0){
        TreeNode curr = queue.remove();
        sumNodes+= curr.value;
        if(curr.left != null){
          queue.add(curr.left);
        }
        if(curr.right != null){
          queue.add(curr.right);
        }
        nodeCount--;
      }
      System.out.println("sumNodes: " + sumNodes);
      System.out.println("sumCount: " + sumCount);
      result.add(sumNodes/sumCount);
    }
    int[] resultArray = new int[result.size()]; 
    for(int i = 0; i < result.size();i++){
      resultArray[i] = result.get(i);
    }
    System.out.println(Arrays.toString(resultArray));
    return resultArray;
  }

  public int inOrderIteratively(TreeNode root, int k){
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while(curr != null || !stack.isEmpty()){
      while(curr != null){
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      --k;
      if(k == 0){
        return curr.value;
      }
      System.out.println("curr.value: " + curr.value);
      curr = curr.right;
    }
    return -1;
  }
}