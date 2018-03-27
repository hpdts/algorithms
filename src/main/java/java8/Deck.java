package java8;

import java.util.*;
import static java.lang.Math.*;
import java.util.stream.*;

public class Deck {

	private String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "1"};

    private int totalCards = SUITS.length * RANKS.length;
    private String[] deck = new String[totalCards];

    public String[] getDeck(){
    	return deck;
    }

    public String showCard(String card){
    	String[] rankSuit = card.split(" of ");
    	String rank = rankSuit[0];
    	String suit = rankSuit[1];

    	String rankSymbol = "";
    	switch(rank) {
    		case "11" : rankSymbol = "Jack"; 
    		               break;
    		case "12" : rankSymbol = "Queen"; 
    		               break;  
    		case "13" : rankSymbol = "King"; 
    		               break; 
    		case "1" : rankSymbol = "Ace"; 
    		               break; 
    		default:  rankSymbol = rank;                                                    
    	}

    	char suitSymbol = Character.MIN_VALUE;
    	switch(suit) {
    		case "Clubs" : suitSymbol = '♣'; 
    		               break;
    		case "Diamonds" : suitSymbol = '♦'; 
    		               break;  
    		case "Hearts" : suitSymbol = '♥'; 
    		               break; 
    		case "Spades" : suitSymbol = '♠'; 
    		               break; 
    		default:  suitSymbol = Character.MIN_VALUE;                                                         
    	}

    	return rankSymbol + "" + suitSymbol;
    }

    public void showDeck(String[] deck){
    	StringBuilder each12 = new StringBuilder();
    	int twelve = 0;
	    for(String card : deck){
    		each12.append(showCard(card));
    		if(twelve == 12){
    			System.out.println(each12.toString());
    			twelve = 0;
    			each12 = new StringBuilder();
    		}else{
    			each12.append(",");
    			twelve++;
    		}
    	}
    }

    public void showHand(String[] hand){
    	StringBuilder cards = new StringBuilder();
    	int i = 1;
	    for(String card : hand){
    		cards.append(showCard(card));
    		if(i != hand.length){
    			cards.append(",");
    		}
    		i++;
    	}
    	System.out.println(cards.toString());
    }

    public void initializeDeck(){
    	int cardIndex = 0;
	    for (int j = 0; j < SUITS.length; j++) {
	    	for (int i = 0; i < RANKS.length; i++) {
	            deck[cardIndex++] = RANKS[i] + " of " + SUITS[j];
	        }
	    }
	    showDeck(this.deck);
    }

    public void shuffle(){
    	for(int i = 0; i < deck.length; i++){
    		int randomNumber = (int) (Math.random() * 52);
    		//System.out.println("randomNumber: " + randomNumber);
    		String cardAux = deck[randomNumber];
    		deck[randomNumber] = deck[i];
    		deck[i] = cardAux;
    	}
    }

    //Poker hand 5 cars, straight mixed suits on sequence
    public boolean isStraight(String[] hand){
    	if(hand.length != 5){
    		System.out.println("Hand is only 5 cards and I have " + hand.length);
    	}

    	Arrays.sort(hand);

    	for(int i = 0; i < hand.length - 1; i++){
    		String[] rankSuit = hand[i].split(" of ");
    		String rank =  rankSuit[0];
    		String suit = rankSuit[1];

    		String[] rankSuitNext = hand[(i+1)].split(" of ");
    		String rankNext = rankSuitNext[0];
    		String suitNext = rankSuitNext[1];

    		int difference = Integer.valueOf(rankNext) - Integer.valueOf(rank);
    		if(difference != 1){
    			return false;
    		}
    	}
    	return true;
    }

    //fullHouse 3 cards one rank and 2 cards another rank
    public boolean isFullHouse(String[] hand){
    	if(hand.length != 5){
    		System.out.println("Hand is only 5 cards and I have " + hand.length);
    	}
    	Map<String, Integer> occurences = new HashMap<>();

    	for(int i = 0; i < hand.length; i++){
    		String[] rankSuit = hand[i].split(" of ");
    		String rank =  rankSuit[0];
    		String suit = rankSuit[1];
    		if(occurences.containsKey(rank)){
    			int occurence = occurences.get(rank);
    			occurences.put(rank, ++occurence);
    		}else{
    			occurences.put(rank, 1);
    		}
    	}
    	if(occurences.size() != 2){
    		return false;
    	}
    	List<Integer> occurencesRanks = new ArrayList<>(occurences.values()); 
    	int valueOne = occurencesRanks.get(0);
    	int valueTwo = occurencesRanks.get(1);

    	if((valueOne == 3 && valueTwo == 2) || (valueTwo == 3 && valueOne == 2)){
    		return true;
    	}

    	return false;
    }

}