package vp_carddeck.business;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Provides a very restrictive singleton for working with a deck of cards
 * 
 * @author maureyes
 *
 */
@Startup
@Singleton
public class DeckServicesEJB implements DeckServices<ICard> {

	private IDeck<ICard> deck;

	@Override
	@Lock(LockType.WRITE)
	public void createDeck(DeckFactory<ICard> factory) {
		deck = factory.createDeck();
	}

	@Override
	public IDeck<ICard> initDeck() {
		return this.deck;
	}

	@Override
	@Lock(LockType.WRITE)
	public void deleteDeck() {
		this.deck = null;
	}

	@Override
	@Lock(LockType.WRITE)
	public ICard getRandomCard() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}

		return null;
	}
	
	@Override
	@Lock(LockType.WRITE)
	public ICard getCardOnTop() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}
		
		return null;
	}

	@Override
	@Lock(LockType.WRITE)
	public ICard getCardOnBottom() {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		}
		
		return null;
	}

	@Override
	@Lock(LockType.WRITE)
	public void putCardOnTop(ICard card) {
		if (deck != null) {
			deck.putCardOnTop(card);
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public void putCardOnBottom(ICard card) {
		if (deck != null) {
			deck.putCardOnBottom(card);
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void shuffle() {
		if (deck != null) {
			deck.shuffle();
		}
	}

}
