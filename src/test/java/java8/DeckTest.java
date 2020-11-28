package java8;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class DeckTest {

	Deck deck = new Deck();

	@Ignore
	@Test
	public void showDeck(){
		deck.initializeDeck();

		String[] deckCards = deck.getDeck();
		String[] fullHouse = new String[]{ deckCards[7], deckCards[15], deckCards[28], deckCards[20], deckCards[33] };
		System.out.println("Show fullHouse hand");
		deck.showHand(fullHouse);
		assertTrue(deck.isFullHouse(fullHouse));

		fullHouse = new String[]{ deckCards[7], deckCards[20], deckCards[33], deckCards[15], deckCards[28] };
		assertTrue(deck.isFullHouse(fullHouse));

		String[] straight = Arrays.copyOfRange(deckCards, 0, 5);
		System.out.println("Show straight hand");
		deck.showHand(straight);
		assertTrue(deck.isStraight(straight));

		deck.shuffle();
		System.out.println("Deck shuffle");
		deck.showDeck(deckCards);

		String[] hand = Arrays.copyOfRange(deckCards, 0, 5);

		System.out.println("Show hand");
		deck.showHand(hand);

		assertFalse(deck.isStraight(hand));
		assertFalse(deck.isFullHouse(hand));

		
	}

}