package interviewCake;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class WordCloudData {

    private Map<String, Integer> wordsToCounts = new HashMap<>();

    public WordCloudData(String inputString) {
        populateWordsToCounts(inputString);
    }

    public Map<String, Integer> getWordsToCounts() {
        return wordsToCounts;
    }

    private void populateWordsToCounts(String inputString) {
        // iterates over each character in the input string, splitting
        // words and passing them to addWordToHashMap()

        int currentWordStartIndex = 0;
        int currentWordLength = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);

            // if we reached the end of the string we check if the last
            // character is a letter and add the last word to our hash map
            if (i == inputString.length() - 1) {
                if (Character.isLetter(character)) {
                    currentWordLength++;
                }
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                        currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                }

            // if we reach a space or emdash we know we're at the end of a word
            // so we add it to our hash map and reset our current word
            } else if (character == ' ' || character == '\u2014') {
                if (currentWordLength > 0) {
                    String currentWord = inputString.substring(currentWordStartIndex,
                        currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                    currentWordLength = 0;
                }

            // we want to make sure we split on ellipses so if we get two periods in
            // a row we add the current word to our hash map and reset our current word
            } else if (character == '.') {
                if (i < inputString.length() - 1 && inputString.charAt(i + 1) == '.') {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }

            // if the character is a letter or an apostrophe, we add it to our current word
            } else if (Character.isLetter(character) || character == '\'') {
                if (currentWordLength == 0) {
                    currentWordStartIndex = i;
                }
                currentWordLength++;

            // if the character is a hyphen, we want to check if it's surrounded by letters
            // if it is, we add it to our current word
            } else if (character == '-') {
                if (i > 0 && Character.isLetter(inputString.charAt(i - 1))
                        && Character.isLetter(inputString.charAt(i + 1))) {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }
                    currentWordLength++;
                } else {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }
            }
        }
    }

    private void addWordToHashMap(String word) {

        // if the word is already in the hash map we increment its count
        if (wordsToCounts.containsKey(word)) {
            wordsToCounts.put(word, wordsToCounts.get(word) + 1);

        // if a lowercase version is in the hash map, we know our input word must be uppercase
        // but we only include uppercase words if they're always uppercase
        // so we just increment the lowercase version's count
        } else if (wordsToCounts.containsKey(word.toLowerCase())) {
            int newCount = wordsToCounts.get(word.toLowerCase()) + 1;
            wordsToCounts.put(word.toLowerCase(), newCount);

        // if an uppercase version is in the hash map, we know our input word must be lowercase.
        // since we only include uppercase words if they're always uppercase, we add the
        // lowercase version and give it the uppercase version's count
        } else if (wordsToCounts.containsKey(capitalize(word))) {
            int newCount = wordsToCounts.get(capitalize(word)) + 1;
            wordsToCounts.put(word, newCount);
            wordsToCounts.remove(capitalize(word));

        // otherwise, the word is not in the hash map at all, lowercase or uppercase
        // so we add it to the hash map
        } else {
            wordsToCounts.put(word, 1);
        }
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public int findDuplicate(int[] intArray) {

        final int n = intArray.length - 1;

        // STEP 1: GET INSIDE A CYCLE
        // start at position n+1 and walk n steps to
        // find a position guaranteed to be in a cycle
        int positionInCycle = n + 1;
        System.out.println("positionInCycle: " + positionInCycle);
        for (int i = 0; i < n; i++) {

            // we subtract 1 from the current position to step ahead:
            // the 2nd *position* in an array is *index* 1
            positionInCycle = intArray[positionInCycle - 1];
            System.out.println("positionInCycle: " + positionInCycle);
        }

        // STEP 2: FIND THE LENGTH OF THE CYCLE
        // find the length of the cycle by remembering a position in the cycle
        // and counting the steps it takes to get back to that position
        int rememberedPositionInCycle = positionInCycle;
        int currentPositionInCycle = intArray[positionInCycle - 1];  // 1 step ahead
        int cycleStepCount = 1;
        System.out.println("rememberedPositionInCycle: " + rememberedPositionInCycle);
        System.out.println("currentPositionInCycle: " + currentPositionInCycle);
        while (currentPositionInCycle != rememberedPositionInCycle) {
            currentPositionInCycle = intArray[currentPositionInCycle - 1];
            System.out.println("currentPositionInCycle: " + currentPositionInCycle);
            cycleStepCount += 1;
        }
        System.out.println("cycleStepCount: " + cycleStepCount);
        // STEP 3: FIND THE FIRST NODE OF THE CYCLE
        // start two pointers
        //   (1) at position n+1
        //   (2) ahead of position n+1 as many steps as the cycle's length
        int pointerStart = n + 1;
        int pointerAhead = n + 1;
        for (int i = 0; i < cycleStepCount; i++) {
            pointerAhead = intArray[pointerAhead - 1];
        }

        // advance until the pointers are in the same position
        // which is the first node in the cycle
        while (pointerStart != pointerAhead) {
            pointerStart = intArray[pointerStart - 1];
            pointerAhead = intArray[pointerAhead - 1];
        }

        // since there are multiple values pointing to the first node
        // in the cycle, its position is a duplicate in our array
        return pointerStart;
    }

    public int[] sortScores(int[] unsortedScores, int maxScore){
        int[] countScores = new int[maxScore+1];

        for(int score : unsortedScores){
            countScores[score]++;
        }

        int[] sortedScores = new int[maxScore];
        int currentSortedIndex = 0;

        for(int score = maxScore; score >= 0; score--){
            int count = countScores[score];

            for(int i = 0; i < count; i++){
                sortedScores[currentSortedIndex++] = score;
            }

        }
        return Arrays.copyOfRange(sortedScores, 0, currentSortedIndex);
    }
}