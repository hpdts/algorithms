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

	public List<String> getAllValidWordsFromDictionary(){
		List<String> validWords = new ArrayList<String>();
		for(String word: words){
			
			//get words removing char and see if they are valid on trie 
			//if thats the case add to list an create the chain
		}
		return validWords;
	}

	private void checkValidWordsFromPermuted(List<String> permutationsFromWordDictionary, List<String> validWords){
		for(String wordPermuted : permutationsFromWordDictionary){
			if(trie.search(wordPermuted)){
				validWords.add(wordPermuted);
			}
		}
		permutations = new ArrayList<String>();
	}

	public List<String> permute(String in){

        if( out.length() == in.length() ){
            permutations.add( out.toString() );
            return permutations;
        }
        for( int i = 0; i < in.length(); ++i ){
            if( used[i] ) continue;
            out.append( in.charAt(i) );
            used[i] = true;
            permute(in);
            used[i] = false;
            out.setLength( out.length() - 1 );
        }

        return permutations;
    }
    
	public class DictionaryWordsNotFoundException extends RuntimeException{

	}

}