package autocomplete;

import java.util.*;

public class Autocomplete {

	class TrieNode{
		char c;
		Map<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf;
		String word;

		public TrieNode() {}

	    public TrieNode(char c){
	        this.c = c;
	    }

	    public String toString(){
    		return "letter: " + c + ", isLeaf: " + isLeaf + ", children: " + children + ", word: " + word;
    	}

	}
	//root of tree is always empty
	TrieNode root = new TrieNode(Character.MIN_VALUE);

	public TrieNode getRoot(){
		return root;
	}

	public void insert(String word){
		Map<Character, TrieNode> children = root.children;

		for(int i = 0; i < word.length(); i++){
			char letter = word.charAt(i);
			TrieNode trieNode;
			if(children.containsKey(letter)){
				trieNode = children.get(letter);
			}else{
				trieNode = new TrieNode(letter);
				children.put(letter, trieNode);
			}
			children = trieNode.children;

			if(i == word.length() -1){
				trieNode.isLeaf = true;
				trieNode.word = word;
			}
		}
	}

	public List<String> autocomplete(String search){
		List<String> relatedWords = new ArrayList<String>();
		TrieNode temp = root;
		Map<Character, TrieNode> children = root.children;
		//System.out.println("root: " + children);
        	
		//Find prefix on trie
		for (char letter : search.toCharArray()){
			for(Character key : children.keySet()){
				if(key == letter){
					temp = children.get(key);
					children = temp.children;
					break;
				}
			}
		}

        if(temp.isLeaf){
            relatedWords.add(search);
        }
       
        //DFS on Trie
        Stack<TrieNode> stack = new Stack<>();
        stack.push(temp);
        while(!stack.isEmpty()){
        	temp = stack.pop();
        	children = temp.children;

            for(Character key : children.keySet()){
            	temp = children.get(key);
            	if(temp != null){
					stack.add(temp);

					if(temp.isLeaf){
	                	relatedWords.add(temp.word);
	                }
				}
            }
        }
        return relatedWords;
	}


	//recursive solution
}
