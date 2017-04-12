package leetcode;

import java.util.*;
import static java.lang.Math.*;

public class Problems {

	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
 
 	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);

        System.out.println("dict: " + wordDict.toString());	
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

 			System.out.println("word Top from queue: " + word);

            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 					//System.out.println("new word: " + Arrays.toString(arr));
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }

    public int[] mergeTwoSortedArrays(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        System.out.println("c: " + Arrays.toString(c));
        int i = 0;
        int j = 0;
        int k = 0;
        //i index a j indexb
        //compare first element list and move to the second one
        while(i < a.length && j < b.length){
            System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            if(a[i] <= b[j]){
                c[k] = a[i];
                i++;
            }else{
                c[k] = b[j];
                j++;
            }
            k++;
        }

        System.out.println("LeftOver i: " + i + ", j: " + j + ", k: " + k);
        while(k <= c.length-1){
            if(i <= a.length-1){
                c[k] = a[i];
                i++;
            }

            if(j <= b.length-1){
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c;
    }

    public void keyboard(int columns, String word){
        for(Character letter : word.toCharArray()){
            System.out.println("letter: " + letter);
            int diff = letter - 'a';
            System.out.println("diff: " + diff);
            int lefts = diff;
            int downs = diff / columns;
            if(diff < columns){
                System.out.println("Number of lefts: " + lefts);
            }else{
                lefts = diff - (columns * downs);
                System.out.println("Number of downs: " + downs);
                System.out.println("Number of lefts: " + lefts);
            }
        }
    }
}