package vp_carddeck.entities.french;

import vp_carddeck.common.CardColor;
import vp_carddeck.entities.Card;
import vp_carddeck.entities.IRank;
import vp_carddeck.entities.ISuit;

/**
 * Extension of {@link Card} for French Card implementation.
 * 
 * @author maureyes
 *
 */
public class FrenchCard extends Card {

	public FrenchCard() {
		super();
	}
	
	public FrenchCard(ISuit suit, IRank rank) {
		super(suit, rank);
	}

	public CardColor getColor() {
		return FrenchSuit.getColor(this);
	}
}
