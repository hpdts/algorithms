package linguistic;

import java.io.*;
import java.util.*;

public class Linguistic{
	private Trie trie = new Trie();
	private Set<String> words = new HashSet<String>();
	private boolean[] used = new boolean[1000];
    private	StringBuilder out = new StringBuilder();
    private	List<String> permutations = new ArrayList<String>();

    public List<String> getAllValidWordsFromDictionary(){
		List<String> longestChains = new LinkedList<String>();
		for(String word: words){
			StringBuilder chain = new StringBuilder(word);
			for(String wordLessChar : getWordsRemovingOneLetterAtTheTime(word)){
				if(trie.search(wordLessChar)){
					chain.append(" => " + wordLessChar);
				}
			}
			addOnlyLongestChains(longestChains, chain.toString());
			//get words removing char and see if they are valid on trie 
			//if thats the case add to list an create the chain
			//add to the list only the big ones
			System.out.println("WORD from dictionary: " + word + ",from that word chain " + chain.toString());
		}
		System.out.println("final chains:"+ longestChains);
		return longestChains;
	}

	private void addOnlyLongestChains(List<String> longestChains, String chain){
		if(longestChains.size() == 0) {
			longestChains.add(chain);
		}else if(getChainLength(longestChains.get(0)) ==  getChainLength(chain)){
			System.out.println(getChainLength(longestChains.get(0))  + "=" + getChainLength(chain));
			longestChains.add(chain);
		}else if(getChainLength(longestChains.get(0)) < getChainLength(chain)){
			System.out.println(getChainLength(longestChains.get(0))  + " <" + getChainLength(chain));
			removeSmallerChains(longestChains, chain);
			longestChains.add(chain);
		} 
	}

	private void removeSmallerChains(List<String> longestChains, String chain){
		System.out.println("List : " + longestChains);
		Iterator<String> chainsIterator = longestChains.iterator();
		while (chainsIterator.hasNext()) {
			String chainFromList = chainsIterator.next();
			System.out.println("chain: " + chainFromList);
			System.out.println(getChainLength(chainFromList)  + " <" + getChainLength(chain));
			if(getChainLength(chainFromList) <  getChainLength(chain)){
				System.out.println("about to be removed : " + chainFromList);
				chainsIterator.remove();
			}
		}
	}

	private int getChainLength(String chain){
		return chain.replaceAll("[^=>]", "").length();
	}

    public List<String> getWordsRemovingOneLetterAtTheTime(String word){
    	List<String> words = new ArrayList<String>();
    	StringBuilder wordBuilder;

		for(int i = 0; i < word.length(); i++){
			wordBuilder = new StringBuilder(word);
			words.add(wordBuilder.deleteCharAt(i).toString());
		}
		return words;
    }

	public Trie createDictionary(String pathToDictionaryFile){
		BufferedReader bufferedReader = new BufferedReader(readFile(pathToDictionaryFile));

		try {
    		String line = bufferedReader.readLine();
    		while (line != null) {
    			trie.insert(line);
    			words.add(line);
        		line = bufferedReader.readLine();
    		}
		}catch(Exception exception){
			System.out.println("Exception: " + exception);
		}finally {
			try{
    			bufferedReader.close();
			}catch(IOException exception){
				System.out.println("IOException: " + exception);
			}
		}
		return trie;
	}

	private FileReader readFile(String pathToFile){
		FileReader fileReader = null;
		try{
			fileReader = new FileReader(pathToFile);
		}catch(FileNotFoundException exception){
			System.out.println("FileNotFoundException: " + exception);
			throw new DictionaryWordsNotFoundException();
		}
		return fileReader;
	}

	public Set<String> getAllWords(){
		return words;
	}
    
	public class DictionaryWordsNotFoundException extends RuntimeException{

	}

}