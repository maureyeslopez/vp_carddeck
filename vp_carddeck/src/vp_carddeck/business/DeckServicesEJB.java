package vp_carddeck.business;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

public class DeckServicesEJB implements DeckServices<ICard> {

	private IDeck<ICard> deck;

	@Override
	public void createDeck(DeckFactory<ICard> factory) {
		deck = factory.createDeck();
	}

	@Override
	public IDeck<ICard> initDeck() {
		return this.deck;
	}

	@Override
	public void deleteDeck() {
		this.deck = null;
	}

	@Override
	public ICard getRandomCard() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}

		return null;
	}
	
	@Override
	public ICard getCardOnTop() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}
		
		return null;
	}

	@Override
	public ICard getCardOnBottom() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}
		
		return null;
	}

	@Override
	public void putCardOnTop(ICard card) {
		if (deck != null) {
			deck.putCardOnTop(card);
		}
	}

	@Override
	public void putCardOnBottom(ICard card) {
		if (deck != null) {
			deck.putCardOnBottom(card);
		}
	}

}
