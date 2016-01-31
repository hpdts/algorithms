package linguistic;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;

public class Linguistic{
	 class QueueLengthCompare implements Comparator<Deque> {
         @Override
         public int compare(Deque o1, Deque o2) {
             return o2.size() - o1.size();
         }
     }

    List<Deque<String>> solutionChains = new ArrayList<>();

    private boolean getWordsRemovingOneLetterAtTheTime(String word, String wordPeek){
        List<String> words = new ArrayList<String>();
        StringBuilder wordBuilder;
        if(word.length() > 1){
            for(int i = 0; i < word.length(); i++){
                wordBuilder = new StringBuilder(word);
                words.add(wordBuilder.deleteCharAt(i).toString());
            }
        }
        return words.contains(wordPeek);
    }

	private Map<Integer, List<String>> createDictionaryByLevel(String pathToDictionaryFile){
		Map<Integer, List<String>> dictionary = new TreeMap<>();
		try {
                List<String> words = new ArrayList<>();
                Scanner scanner = new Scanner(new File(pathToDictionaryFile));
                while(scanner.hasNext()){
                    words.add(scanner.nextLine());
                }

                dictionary = words.stream().collect(groupingBy(String::length));

    	    } catch (FileNotFoundException exception) {
            	System.out.println("FileNotFoundException: " + exception);
    			throw new DictionaryWordsNotFoundException();
        	}
    	return dictionary;    
	}

    public List<String> getLongestChains(String pathToDictionaryFile){
		 Map<Integer, List<String>> dictionaryByLevel = createDictionaryByLevel(pathToDictionaryFile);
		 System.out.println(dictionaryByLevel);

		 Iterator<Map.Entry<Integer, List<String>>> charBylevels = dictionaryByLevel.entrySet().iterator();
        while (charBylevels.hasNext()) {
            Map.Entry<Integer, List<String>> pairChars = charBylevels.next();
            Integer level = pairChars.getKey();
            List<String> tokens = pairChars.getValue();
            for (String token : tokens) {
                boolean added = false;
                List<Deque<String>> solutionChainsTemp = new ArrayList<>();

                for(Deque<String> chain : solutionChains){
                    Deque<String> tokensByLevel = new LinkedList<>();
                    String peek = chain.peek();
                    if(getWordsRemovingOneLetterAtTheTime(token, peek) && (token.length() == (peek.length() + 1))){
                        tokensByLevel.addAll(chain);
                        tokensByLevel.addFirst(token);
                        solutionChainsTemp.add(tokensByLevel);
                        added = true;
                    }
                }
                if(!added){
                    Deque<String> newChain = new LinkedList<>();
                    newChain.addFirst(token);
                    solutionChains.add(newChain);
                }else{
                    solutionChains.addAll(solutionChainsTemp);
                }
            }
        }
        Collections.sort(solutionChains, new QueueLengthCompare());


        List<String> output = new ArrayList<String>();
        int sizeBefore = solutionChains.get(0).size();
        for(Deque<String> chain: solutionChains){
            int sizeActual = chain.size();
            if(sizeActual!=sizeBefore){
                break;
            }
           output.add(chain.toString().replace("[","").replace("]","").replace(", "," => "));

        }

		 return output;
	}
    
	public class DictionaryWordsNotFoundException extends RuntimeException{

	}

}