package linguistic;

import java.io.*;
import java.util.*;

public class Linguistic{
	private Trie trie = new Trie();
	private Set<String> words = new HashSet<String>();
	private boolean[] used = new boolean[1000];
    private	StringBuilder out = new StringBuilder();
    private	List<String> permutations = new ArrayList<String>();

    public List<String> getWordsRemovingOneLetterAtTheTime(String word){
    	List<String> words = new ArrayList<String>();
    	StringBuilder wordBuilder;

		for(int i = 0; i < word.length(); i++){
			wordBuilder = new StringBuilder(word);
			words.add(wordBuilder.deleteCharAt(i).toString());
		}
		return words;
    }

    public List<String> getAllValidWordsFromDictionary(){
		List<String> validWords = new ArrayList<String>();
		for(String word: words){
			StringBuilder chain = new StringBuilder(word);
			for(String wordLessChar : getWordsRemovingOneLetterAtTheTime(word)){
				if(trie.search(wordLessChar)){
					chain.append("," + wordLessChar);
				}
			}
			//get words removing char and see if they are valid on trie 
			//if thats the case add to list an create the chain
			validWords.add(chain.toString());
			System.out.println("WORD from dictionary: " + word + "," + chain.toString());
			
		}
		return validWords;
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