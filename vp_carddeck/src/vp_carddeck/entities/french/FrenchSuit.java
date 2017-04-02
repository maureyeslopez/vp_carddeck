package vp_carddeck.entities.french;

import org.apache.commons.lang3.ArrayUtils;

import vp_carddeck.common.CardColor;
import vp_carddeck.common.exceptions.UnrecognizedCardException;
import vp_carddeck.entities.Suit;

public class FrenchSuit extends Suit {

	public final static String HEARTS = "Hearts";
	public final static String CLUBS = "Clubs";
	public final static String DIAMONDS = "Diamonds";
	public final static String SPADES = "Spades";
	
	public final static String[] FRENCH_SUITS = new String[]{ HEARTS, CLUBS, DIAMONDS, SPADES };
	
	public FrenchSuit() {
		super();
	}
	
	public FrenchSuit(String name) throws UnrecognizedCardException {
		super(name);
	}

	@Override
	public boolean validSuitName(String name) {
		return ArrayUtils.contains(FRENCH_SUITS, name);
	}
	
	/**
	 * @param card
	 * @return The color of the FrenchSuit
	 */
	public static CardColor getColor(FrenchCard card) {
		String cardSuit = card.getSuit().getName();
		if (cardSuit.equals(HEARTS) || cardSuit.equals(DIAMONDS)) {
			return CardColor.RED;
		} else if (cardSuit.equals(CLUBS) || cardSuit.equals(SPADES)) {
			return CardColor.BLACK;
		} else {
			// Wrong FrenchCard definition. 
			// TODO: Maybe raise Exception?
			return null;
		}
	}

}
