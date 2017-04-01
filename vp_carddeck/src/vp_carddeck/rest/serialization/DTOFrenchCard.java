package vp_carddeck.rest.serialization;

import vp_carddeck.entities.french.FrenchCard;
import vp_carddeck.entities.french.FrenchSuit;
import vp_carddeck.rest.FrenchDeckREST;

/**
 * DTO used to interact through {@link FrenchDeckREST} that can convert to {@link FrenchCard}
 * @author maureyes
 *
 */
public class DTOFrenchCard {

	public FrenchSuit suit;
	private DTOFrenchRank rank;

	public DTOFrenchCard() {
		super();
	}

	public FrenchSuit getSuit() {
		return suit;
	}

	public void setSuit(FrenchSuit suit) {
		this.suit = suit;
	}

	public DTOFrenchRank getRank() {
		return rank;
	}

	public void setRank(DTOFrenchRank rank) {
		this.rank = rank;
	}
	
	public static FrenchCard convert(DTOFrenchCard dtoCard) {
		FrenchSuit theSuit = dtoCard.getSuit();
		DTOFrenchRank dtoRank = dtoCard.getRank();
		
		return new FrenchCard(theSuit, DTOFrenchRank.convert(dtoRank));
	}

}
