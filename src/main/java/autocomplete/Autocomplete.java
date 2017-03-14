package cracking.autocomplete;

import java.util.*;

public class Autocomplete {

	class TrieNode{
		char c;
		Map<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf;

		public TrieNode() {}

	    public TrieNode(char c){
	        this.c = c;
	    }

	    public String toString(){
    		return "letter: " + c + ", isLeaf: " + isLeaf + ", children: " + children;
    	}

	}

	TrieNode root = new TrieNode();

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
			}
		}
	}

	public List<String> autocomplete(String word){
		List<String> relatedWords = new ArrayList<String>();
		Map<Character, TrieNode> children = root.children;
		TrieNode trieNode = null;
		for (char letter : word.toCharArray()){
			if(children.containsKey(letter)){
				trieNode = children.get(letter);
			}else{
				return null;
			}

			children = trieNode.children;
		}

        if(trieNode.isLeaf){
            relatedWords.add(word);
        }

        TrieNode trieNodeTemp = trieNode;
        children = trieNode.children;
        System.out.println("children map: " + children);
        StringBuilder related = new StringBuilder(word);
        while(!trieNodeTemp.children.isEmpty()){
            for(Character letter : children.keySet()){
                related.append(letter);
                System.out.println("related: " + related.toString());
                System.out.println("rest of letters: " + letter);
                //System.out.println("children: " + children);
                //System.out.println("trieNode: " + trieNode);
                trieNodeTemp = children.get(letter);
                if(trieNodeTemp.isLeaf){
                	//concatenating letters
                	relatedWords.add(related.toString());
                	related = new StringBuilder(word);
                    System.out.println("LEAF rest of letters: " + letter);
                }
            }
            children = trieNodeTemp.children;
            //System.out.println("children map after: " + children);
            //System.out.println("trieNodeTemp after: " + trieNodeTemp);
        }
        return relatedWords;
	}

}
