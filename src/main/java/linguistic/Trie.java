package linguistic;


import java.util.Map;


public class Trie {
    private TrieNode root;

    public TrieNode getRoot(){
        return root;
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        System.out.println("word: " + word);
        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++){
            char charFromWord = word.charAt(i);

            TrieNode trieNode;
            if(children.containsKey(charFromWord)){
                trieNode = children.get(charFromWord);
                trieNode.size++;
                System.out.println("charFromWord: " + charFromWord);
                System.out.println("Size adding: " + trieNode.size);
            }else{
                trieNode = new TrieNode(charFromWord);
                
                children.put(charFromWord, trieNode);
            }

            children = trieNode.children;


            if(i == word.length() - 1)
                trieNode.isLeaf = true;
        }
    }

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

    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public void print(TrieNode node){
        if(node == null){
            return;
        }
         Map<Character, TrieNode> children = root.children;
         for(Character letter : children.keySet()){

            //System.out.println("letter: " + letter);
            System.out.println(children.get(letter));
            //print(children.get(letter));
         }


    }

    public int countOccurrences(String str){
        int count = 0;
        Map<Character, TrieNode> children = root.children;
        TrieNode trieNode = null;
        for(int i = 0; i < str.length(); i++){
            char charAt = str.charAt(i);
            if(children.containsKey(charAt)){
                trieNode = children.get(charAt);
                children = trieNode.children;
            }
        }

        System.out.println("Size count: " + trieNode.size);
        if(trieNode.isLeaf){
            count++;
        }

        TrieNode trieNodeTemp = trieNode;
        children = trieNode.children;
        System.out.println("children map: " + children);
        while(!trieNodeTemp.children.isEmpty()){
            for(Character letter : children.keySet()){
                System.out.println("rest of letters: " + letter);
                System.out.println("children: " + children);
                System.out.println("trieNode: " + trieNode);
                trieNodeTemp = children.get(letter);
                if(trieNodeTemp.isLeaf){
                    count++;
                }
            }
            children = trieNodeTemp.children;
            System.out.println("children map after: " + children);
            System.out.println("trieNodeTemp after: " + trieNodeTemp);
        }

        return count;
    }


}
