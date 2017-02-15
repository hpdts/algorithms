package linguistic;


import java.util.HashMap;
import java.util.Map;


public class TrieNode {

    char c;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    int size = 0;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }

    public String toString(){
    	return "letter: " + c + ", isLeaf: " + isLeaf + ", children: " + children;
    }

}
