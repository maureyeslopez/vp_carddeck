package vp_carddeck.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.entities.IDeck;
import vp_carddeck.entities.french.FrenchCard;
import vp_carddeck.entities.french.FrenchCardFace;
import vp_carddeck.entities.french.FrenchDeck;
import vp_carddeck.entities.french.FrenchPip;
import vp_carddeck.entities.french.FrenchSuit;

public class FrenchDeckFactory implements DeckFactory<FrenchCard> {
	
	private Logger logger = LoggerFactory.getLogger(FrenchDeckFactory.class);
	
	@Override
	public IDeck<FrenchCard> createDeck() {
		FrenchDeck frenchDeck = new FrenchDeck();
		
		// Generate cards
		for (String suitName : FrenchSuit.FRENCH_SUITS) {
			FrenchSuit suit = new FrenchSuit(suitName);
			for (int rank = 2; rank <= 10; rank++) {
				FrenchPip pip = new FrenchPip(rank);
				FrenchCard card = new FrenchCard(suit, pip);
				try {
					frenchDeck.putCard(card);
				} catch (CardRepeatedException e) {
					logger.error("Factory not working properly!", e);
					throw new RuntimeException("Error on deck creation");
				}
			}
			for (char faceName : FrenchCardFace.FRENCH_FACES) {
				FrenchCardFace face = new FrenchCardFace(faceName);
				FrenchCard card = new FrenchCard(suit, face);
				try {
					frenchDeck.putCard(card);
				} catch (CardRepeatedException e) {
					logger.error("Factory not working properly!", e);
					throw new RuntimeException("Error on deck creation");
				}
			}
		}
		
		return frenchDeck;
	}

}
