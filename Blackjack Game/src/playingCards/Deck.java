package playingCards;

import game.World;

public class Deck {
	
	private int numOfCards = World.numOfCards;
	private Card[] cards = new Card[numOfCards];

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
				System.out.println("Created card number " + cardTracker);
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
	
//	public static Deck createDeck()
//	{
//		if(deck == null)
//		{
//			deck = new Deck();
//		}
//		return deck;
//	}

}
