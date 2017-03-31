package vp_carddeck.business;

import java.util.Comparator;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateful;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoDeckException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Provides a very restrictive singleton for working with a deck of cards
 * 
 * @author maureyes
 *
 */
@Stateful
public class DeckServicesEJB implements DeckServices<ICard> {

	private IDeck<ICard> deck;

	@Override
	@Lock(LockType.WRITE)
	public void createDeck(DeckFactory<ICard> factory) {
		deck = factory.createDeck();
	}

	@Override
	public IDeck<ICard> getDeck() throws NoDeckException {
		if(this.deck != null) {
			return this.deck;
		} else {
			throw new NoDeckException();
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public void deleteDeck() {
		this.deck = null;
	}

	@Override
	@Lock(LockType.WRITE)
	public ICard getRandomCard() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		} else {
			throw new NoDeckException();
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public ICard getCardOnTop() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		} else {
			throw new NoDeckException();
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public ICard getCardOnBottom() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			return deck.retrieveCardOnTop();
		} else {
			throw new NoDeckException();
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public void putCardOnTop(ICard card) throws NoDeckException, CardRepeatedException {
		if (deck != null) {
			deck.putCardOnTop(card);
		} else {
			throw new NoDeckException();
		}
	}

	@Override
	@Lock(LockType.WRITE)
	public void putCardOnBottom(ICard card) throws NoDeckException, CardRepeatedException {
		if (deck != null) {
			deck.putCardOnBottom(card);
		} else {
			throw new NoDeckException();
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void shuffle() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			deck.shuffle();
		} else {
			throw new NoDeckException();
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void sortByRank() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			deck.sort(null);
		} else {
			throw new NoDeckException();
		}
	}
	
	@Override
	@Lock(LockType.WRITE)
	public void sortBySuit() throws NoDeckException, NoMoreCardsException {
		if (deck != null) {
			deck.sort(new Comparator<ICard>() {
				
				@Override
				public int compare(ICard c1, ICard c2) {
					int comparison = c1.getSuit().compareTo(c2.getSuit());
					if (comparison == 0) {
						comparison = c1.getRank().compareTo(c2.getRank());
					}
					
					return comparison;
				}
			});
		} else {
			throw new NoDeckException();
		}
	}

}
