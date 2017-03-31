package vp_carddeck.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.entities.IDeck;
import vp_carddeck.entities.spanish.SpanishCard;
import vp_carddeck.entities.spanish.SpanishDeck;
import vp_carddeck.entities.spanish.SpanishPip;
import vp_carddeck.entities.spanish.SpanishSuit;

public class SpanishDeckFactory implements DeckFactory<SpanishCard> {
	
	private Logger logger = LoggerFactory.getLogger(SpanishDeckFactory.class);
	
	@Override
	public IDeck<SpanishCard> createDeck() {
		SpanishDeck frenchDeck = new SpanishDeck();
		
		// Generate cards
		for (String suitName : SpanishSuit.SPANISH_SUITS) {
			SpanishSuit suit = new SpanishSuit(suitName);
			for (int rank = 1; rank <= 12; rank++) {
				SpanishPip pip = new SpanishPip(rank);
				SpanishCard card = new SpanishCard(suit, pip);
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
