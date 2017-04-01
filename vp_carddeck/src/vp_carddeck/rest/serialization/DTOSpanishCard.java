package vp_carddeck.rest.serialization;

import vp_carddeck.entities.spanish.SpanishCard;
import vp_carddeck.entities.spanish.SpanishPip;
import vp_carddeck.entities.spanish.SpanishSuit;
import vp_carddeck.rest.SpanishDeckREST;

/**
 * DTO used to interact through {@link SpanishDeckREST} that can convert to {@link SpanishCard}
 * @author maureyes
 *
 */
public class DTOSpanishCard {

	public SpanishSuit suit;
	private SpanishPip rank;

	public DTOSpanishCard() {
		super();
	}

	public SpanishSuit getSuit() {
		return suit;
	}

	public void setSuit(SpanishSuit suit) {
		this.suit = suit;
	}

	public SpanishPip getRank() {
		return rank;
	}

	public void setRank(SpanishPip rank) {
		this.rank = rank;
	}
	
	public static SpanishCard convert(DTOSpanishCard dtoCard) {
		SpanishSuit theSuit = dtoCard.getSuit();
		SpanishPip theRank = dtoCard.getRank();
		
		return new SpanishCard(theSuit, theRank);
	}

}
