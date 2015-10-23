package linguistic;

import java.io.*;
import java.util.*;

public class Linguistic{
	private Trie trie = new Trie();
	private Set<String> words = new HashSet<String>();
	private boolean[] used = new boolean[1000];
    private	StringBuilder out = new StringBuilder();
    private	List<String> permutations = new ArrayList<String>();
    private Map<String, Integer> chains = new HashMap<String, Integer>();

	public void addChainOrderedByLength(String chain){
		if(!checkIfContainsChain(chain)){
			chains.put(chain, 1);
		}
	}

	private boolean checkIfContainsChain(String chain){
		for(String key : chains.keySet()) {
            if(key.contains(chain)){
            	System.out.println("key: " + key + ", chain: " + chain);
            	//split for more strings, chain could be in the middle
            	//test with more that one string and arrows it woint work
            	//split get the last one
            	if(addChainToRight(getLastMemberToTheRight(key), chain)){
            		chains.remove(key);
            		System.out.println("key  =>  chain: " + key + " => " + chain);
            		String newChain = key + " => " + chain;
            		chains.put(newChain, getChainLength(newChain));
            		return true;
            	}
            }//else check if chain contains key StartingTo 
        }
        return false;
	}

	public String getLastMemberToTheRight(String chain){
		String[] chainMembers = chain.split("\\=>");
        String lastMemberToTheRight = chainMembers[chainMembers.length - 1];
		return lastMemberToTheRight.trim();
	}

	public int getChainLength(String chain){
		return chain.split("\\=>", -1).length;
	}

  	private boolean addChainToRight(String key, String chain){
        return key.length() > chain.length();
  	}

    public Map<String, Integer> getChains(){
               return chains;
    }

    public void setChains(Map<String, Integer> chains){
               this.chains = chains;
    }

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