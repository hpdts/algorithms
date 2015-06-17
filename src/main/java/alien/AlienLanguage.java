package alien;

import java.util.*;
import com.google.common.collect.*;


public class AlienLanguage{

	private boolean[] used = new boolean[1000];
    private StringBuilder out = new StringBuilder();
    private List<String> permutations = new ArrayList<String>();
    private Set<String> dictionary = new HashSet<String>();
    private List<String> dictionaryList = new ArrayList<String>();
    private List<String> testCaseOutput = new ArrayList<String>();

	public void getWordsOntheAlienLanguage(int lines, int wordLength, int numberOfTestCases, String[] words, String[] testCases){
        if(words.length != lines){
            System.out.println("Number of words " + words.length + " but should be " + lines);
            return;
        }
        for(int i=0; i < lines; i++){
            if(wordLength == words[i].length()){
                dictionary.add(words[i]);                
            }else{
               System.out.println("Length of word " + words[i].length() + " but should be " + wordLength);     
            }
        }
        if(testCases.length != numberOfTestCases){
            System.out.println("Number of test " + testCases.length + " but should be " + numberOfTestCases);
            return;
        }else{
             for(int i=0; i < numberOfTestCases; i++){
                if(dictionary.contains(testCases[i])){
                    testCaseOutput.add(testCases[i]);
                }else{
                    //check permutations
                    System.out.println("Word not in the alien language " + testCases[i]);
                }
             }
        }

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

    public void cleanPermutations(){
        permutations.clear();
    }

    public Set<String> getDictionary(){
        return dictionary;
    }

    public List<String> getDictionaryList(){
        dictionaryList.addAll(dictionary);
        return dictionaryList;
    }

    public List<String> getTestCaseOutput(){
        return testCaseOutput;
    }

}