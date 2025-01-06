package playingCards;

import game.World;

public class Deck {
	
	private int numOfCards = World.numOfCards;
	private Card[] cards = new Card[numOfCards];
	private boolean[] usedCard = new boolean[numOfCards];

	public Deck()
	{
		int cardTracker = 0;
		String suit = null;
		for(int suits = 0; suits < 4; suits++)
		{
			for(int value = 1; value < 14; value++)
			{
				if(cardTracker > (numOfCards-1))
				{
					System.out.println("Deck Creation Failed");
					System.exit(1); //not the best way to do this but whatever
				}
				
				//determines correct suit for card from for loop iterator
				if(suits == 0)
					suit = "Diamonds";
				else if(suits == 1)
					suit = "Hearts";
				else if(suits == 2)
					suit = "Spades";
				else if(suits == 3)
					suit = "Clubs";
				else
				{
					System.out.println("Unexpected Suit control integer");
					System.exit(1);
				}
				
				cards[cardTracker] = new Card(suit, value);
				usedCard[cardTracker] = false;
//				System.out.println("Created card number " + cardTracker); //debug output
				cardTracker++;
			}
		}
	}
	
	public Card[] getCards()
	{
		return cards;
	}
	
	public int getNumOfCards()
	{
		return numOfCards;
	}
	
	public String getCardName(int card)
	{
		return cards[card].getCardName();
	}
	
	//returns a random card that has not been used
	//if all cards have already been used, returns null
	public Card dealCard()
	{
		if(areAllCardsUsed())
			return null;
		boolean checkUsed = true;
		int selector = (int) (Math.random() * numOfCards);
		
		while(checkUsed == true)
		{
			selector = (int) (Math.random() * numOfCards);
			checkUsed = usedCard[selector];
		}
		
		usedCard[selector] = true;
		return cards[selector];
		
	}
	
	//sets all values in usedCard to true, essentially "reshuffling" the deck
	public void reShuffle()
	{
		for(int cardNumber = 0; cardNumber < numOfCards; cardNumber++)
		{
			usedCard[cardNumber] = false;
		}
	}
	
	//checks if there are still usable cards in the deck
	private boolean areAllCardsUsed()
	{
		for(boolean check : usedCard)
		{
			if(check == true)
				continue;
			else
				return false;
		}	
		return true;
	}
	
	
//	public static Deck createDeck()
//	{
//		if(deck == null)
//		{
//			deck = new Deck();
//		}
//		return deck;
//	}

}
