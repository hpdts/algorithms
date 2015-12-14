package linguistic;

import java.io.*;
import java.util.*;

public class Linguistic{
	private Trie trie = new Trie();
	private Set<String> words = new HashSet<String>(); 
	private Set<String> wordsAnalyzed = new HashSet<String>(); 
    private Map<String, Integer> chains = new HashMap<String, Integer>();

    public List<String> getAllValidWordsFromDictionary(){
		for(String word: words){
			System.out.println("word from dict: " + word);
			addChainOrderedByLength(word);
			wordsAnalyzed.add(word);
			//System.out.println("remove: " + getWordsRemovingOneLetterAtTheTime(word).toString());
			for(String wordLessChar : getWordsRemovingOneLetterAtTheTime(word)){
				//System.out.println("wordLessChar: " + wordLessChar);
				if(trie.search(wordLessChar) && !wordsAnalyzed.contains(wordLessChar)){				
					addChainOrderedByLength(wordLessChar);
					wordsAnalyzed.add(wordLessChar);
				}
			}
			System.out.println("chains: " + chains.toString());
		}
		return createListFromSet();
	}

	private boolean checkIfContainsChain(String chain){
		for(String key : chains.keySet()) {
		//System.out.println("key : " + key + " self contains, chain: " + chain 
		//	+ ", charIsAWordChain(key, chain)" + charIsAWordChain(key, chain));
			if(!charIsAWordChain(key, chain)){
				//contains list
	            if(sub(key, chain) || getWordsRemovingOneLetterAtTheTime(key).contains(chain)){
	            	chains.remove(key);
			        //System.out.println("key : " + key + " contains, chain: " + chain);		
					//System.out.println("NEW CHAIN: key  =>  chain: " + key + " => " + chain);
					String newChain = key + " => " + chain;
					chains.put(addSortChain(newChain), getChainLength(newChain));
					return true;
	            }else if(sub(chain, getLastMemberToTheLeft(key)) ||  getWordsRemovingOneLetterAtTheTime(chain).contains(getLastMemberToTheLeft(key))){
	            	//System.out.println("chain : " + chain + "contains, key: " + key);		
	            	chains.remove(key);
	            	String newChain = chain + " => " + key;
	            	chains.put(addSortChain(newChain), getChainLength(newChain));
		            return true;
	            }
			}else{
				return true;
			}
        }
        return false;
	}

	private List<String> createListFromSet(){
		List<String> wordList = new ArrayList<String>();
		for(String chain : chains.keySet()){
			wordList.add(chain);
		}
		return wordList;
	}

	private boolean charIsAWordChain(String key, String charWord){
		String[] chainMembers = key.split("\\=>");
		for(String keyChar : chainMembers){
			if(keyChar.trim().equals(charWord.trim())){
				return true;
			}
		}
		return false;
	}

    public List<String> getWordsRemovingOneLetterAtTheTime(String word){
    	List<String> words = new ArrayList<String>();
    	StringBuilder wordBuilder;
    	if(word.length() > 1){
			for(int i = 0; i < word.length(); i++){
				wordBuilder = new StringBuilder(word);
				words.add(wordBuilder.deleteCharAt(i).toString());
			}
    	}
		return words;
    }

	public void addChainOrderedByLength(String chain){
		if(!checkIfContainsChain(chain)){
			chains.put(chain, 1);
		}
	}

	private boolean sub(String string, String substring) {
	    int index = 0;
	    for (char character : substring.toCharArray()) {
	        index = string.indexOf(character, index);
	        if (index == -1)
	            return false;
	    }
	    return true;
	}


	private String addSortChain(String chain){
		Set<String> mySet = new TreeSet<String>(new StringLengthCompare());
		mySet.addAll(Arrays.asList(chain.split("\\=>")));
		String newKeys = "";
		for(String keyMember : mySet){
			if(newKeys.equals("")){
				newKeys = keyMember.trim();
			}else{				
				newKeys = keyMember.trim() + " => " + newKeys;
			}
		}
		return newKeys;	
	}

	public String getLastMemberToTheRight(String chain){
		String[] chainMembers = chain.split("\\=>");
		if(chainMembers.length > 0){
        	String lastMemberToTheRight = chainMembers[chainMembers.length - 1];
			return lastMemberToTheRight.trim();
		}else{
			return chain;
		}
	}

	public String getLastMemberToTheLeft(String chain){
		String[] chainMembers = chain.split("\\=>");
		if(chainMembers.length > 0){
        	String lastMemberToTheLeft = chainMembers[0];
			return lastMemberToTheLeft.trim();
		}else{
			return chain;
		}
	}

	public int getChainLength(String chain){
		return chain.split("\\=>", -1).length;
	}

    public Map<String, Integer> getChains(){
       return chains;
    }

    public void setChains(Map<String, Integer> chains){
       this.chains = chains;
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

	public class StringLengthCompare implements Comparator<String> {

		@Override
       public int compare(String o1, String o2) {
	        if (o1.length() < o2.length()) {
	            return -1;
	        } else if (o1.length() > o2.length()) {
	            return 1;
	        } else {
	            return o1.compareTo(o2);
	        }
    	}

    }


}