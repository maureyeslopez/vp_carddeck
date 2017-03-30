package vp_carddeck.business;

import vp_carddeck.entities.IDeck;
import vp_carddeck.entities.french.FrenchCard;
import vp_carddeck.entities.french.FrenchCardFace;
import vp_carddeck.entities.french.FrenchDeck;
import vp_carddeck.entities.french.FrenchPip;
import vp_carddeck.entities.french.FrenchSuit;

public class FrenchDeckFactory implements DeckFactory<FrenchCard> {
	
	@Override
	public IDeck<FrenchCard> createDeck() {
		FrenchDeck frenchDeck = new FrenchDeck();
		
		// Generate cards
		for (String suitName : FrenchSuit.FRENCH_SUITS) {
			FrenchSuit suit = new FrenchSuit(suitName);
			for (int rank = 2; rank <= 10; rank++) {
				FrenchPip pip = new FrenchPip(rank);
				FrenchCard card = new FrenchCard(suit, pip);
				frenchDeck.putCard(card);
			}
			for (char faceName : FrenchCardFace.FRENCH_FACES) {
				FrenchCardFace face = new FrenchCardFace(faceName);
				FrenchCard card = new FrenchCard(suit, face);
				frenchDeck.putCard(card);
			}
		}
		
		return frenchDeck;
	}

}
