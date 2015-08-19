package linguistic;


import java.util.Map;


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++){
            char charFromWord = word.charAt(i);

            TrieNode trieNode;
            if(children.containsKey(charFromWord)){
                trieNode = children.get(charFromWord);
            }else{
                trieNode = new TrieNode(charFromWord);
                children.put(charFromWord, trieNode);
            }

            children = trieNode.children;

            //set leaf node
            if(i == word.length() - 1)
                trieNode.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode trieNode = searchNode(word);

        if(trieNode != null && trieNode.isLeaf){
            return true;
        }
        else{
            return false;
        }
    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode trieNode = null;
        for(int i = 0; i < str.length(); i++){
            char charAt = str.charAt(i);
            if(children.containsKey(charAt)){
                trieNode = children.get(charAt);
                children = trieNode.children;
            }else{
                return null;
            }
        }
        return trieNode;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }


}
