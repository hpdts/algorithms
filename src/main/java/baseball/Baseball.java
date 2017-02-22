package baseball;

import java.util.*;


public class Baseball {

   public int getScore(String[] blocks, int numberSymbols){
        int score = 0;
        LinkedList<Integer> scores = new LinkedList<>();
        int currentScore = 0;
        for(String block : blocks){
            //if char is number add previuos
            if(block.matches("-?\\d+(.\\d+)?")){
                System.out.println("int: " + Integer.valueOf(block));
                currentScore = Integer.valueOf(block);
                scores.addLast(currentScore);
                score+= currentScore;
            }else if(block.equals("X")){
                System.out.println("symbol: " + block);
                currentScore = scores.getLast() * 2;
                scores.addLast(currentScore);
                score+= currentScore;
            }else if(block.equals("+")){
                int scoreLast = scores.getLast();
                int scoreLastBefore = scores.get(scores.size() -2);
                System.out.println("scoreLast : "+ scoreLast);
                System.out.println("scoreLastBefore : "+ scoreLastBefore);
                currentScore = scoreLast + scoreLastBefore;
                scores.addLast(currentScore);
                score+= currentScore;
            }else if(block.equals("Z")){
                System.out.println("symbol: " + block); 
                score-=scores.getLast();
                scores.removeLast();
            }
            System.out.println("currentScore: " + currentScore);
            System.out.println("score: " + score);
               
        }
        return score;
   }

	
}