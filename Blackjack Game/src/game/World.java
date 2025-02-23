package game;

import playingCards.Card;
import playingCards.Deck;
import java.util.Scanner;

public class World {

	private static World gameWorld;
	private Deck deck;
	private static Scanner in = new Scanner(System.in);
	private static String input = "initialized";
	
	public static int numOfCards = 52;
	
	private World()
	{
		System.out.println("world called"); //debug output
		
		deck = new Deck();
		
//		printDeck(deck);
		
//		printRandomCard(deck);
	}
	
	public static World createWorld()
	{
		synchronized(World.class)
		{
			if(gameWorld == null)
			{
				gameWorld = new World();
			}
		}
		
		return gameWorld;
	}
	
	public void startGame()
	{
		Card card;
		int test = 1;
		int looper = 0;
		while(true && looper == 0)
		{
		card = deck.dealCard();
		if(card != null)
		{
		System.out.println(test + " Card Dealt was: " + card.getCardName());
		test++;
		}
		else
			looper++;
		}

		deck.reShuffle();
		
		while(true && looper == 1)
		{
		card = deck.dealCard();
		if(card != null)
		{
		System.out.println(test + " Card Dealt was: " + card.getCardName());
		test++;
		}
		else
			looper++;
		}
	}
	
	//outputs a given deck to the console
	private void printDeck(Deck deck)
	{
		Card[] cards = deck.getCards();
//		String value = " value not pulled, an error has occured";
		
		for(Card current : cards)
		{
//			if(current.value == 1)
//				value = "Ace";
//			else if(current.value == 11)
//				value = "Jack";
//			else if (current.value == 12)
//				value = "Queen";
//			else if (current.value == 13)
//				value = "King";
//			else
//				value = Integer.toString(current.value);
//			
//			System.out.println(value + " of " + current.suit);
			
			System.out.println(current.getCardName());
		}
	}
	
	//outputs a random card from the given deck
	private void printRandomCard(Deck deck)
	{
		int selector = (int) (Math.random() * deck.getNumOfCards());
		
		System.out.println("Card " + selector + " was selected: " + deck.getCardName(selector));
	}

}
