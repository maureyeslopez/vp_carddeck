package vp_carddeck.entities.spanish;

import vp_carddeck.entities.Card;
import vp_carddeck.entities.IRank;
import vp_carddeck.entities.ISuit;

/**
 * Extension of {@link Card} for Spanish Card implementation.
 * 
 * @author maureyes
 *
 */
public class SpanishCard extends Card {

	public SpanishCard() {
		super();
	}
	
	public SpanishCard(ISuit suit, IRank rank) {
		super(suit, rank);
	}

}
