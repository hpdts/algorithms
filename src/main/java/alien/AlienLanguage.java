package alien;

import java.util.*;
import com.google.common.collect.*;


public class AlienLanguage{

	private boolean[] used = new boolean[1000];
    private StringBuilder out = new StringBuilder();
    private List<String> permutations = new ArrayList<String>();

	public List<String> getWordsOntheAlienLaguage(int lines, int wordLenght, int numberOfTestCases){
		return new ArrayList<String>();
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

}