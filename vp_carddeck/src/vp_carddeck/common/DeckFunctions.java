package vp_carddeck.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Deck functions to be reused on implementations of {@link IDeck}
 * 
 * @author maureyes
 *
 */
public class DeckFunctions<T extends ICard> {

	public void putCard(T card, List<T> deck) throws CardRepeatedException {
		putCardOnBottom(card, deck);
	}

	public void putCardOnTop(T card, List<T> deck) throws CardRepeatedException {
		// No repeated card on deck
		if (!deck.contains(card)) {
			deck.add(0, card);
		} else {
			throw new CardRepeatedException(card.toString() + " is already on the deck");
		}
	}

	public void putCardOnBottom(T card, List<T> deck) throws CardRepeatedException {
		// No repeated card on deck
		if (!deck.contains(card)) {
			deck.add(card);
		} else {
			throw new CardRepeatedException(card.toString() + " is already on the deck");
		}
	}

	public T retrieveRandomCard(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			if (deck.size() == 1) {
				return deck.remove(0);
			} else {
				return deck.remove(ThreadLocalRandom.current().nextInt(0, deck.size() - 1));
			}
		} else {
			throw new NoMoreCardsException();
		}
	}

	public T retrieveCardOnTop(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			return deck.remove(0);
		} else {
			throw new NoMoreCardsException();
		}
	}

	public T retrieveCardOnBottom(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			return deck.remove(deck.size() - 1);
		} else {
			throw new NoMoreCardsException();
		}
	}

	public void shuffle(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			Collections.shuffle(deck, ThreadLocalRandom.current());
		} else {
			throw new NoMoreCardsException();
		}
	}
	
	public void sort(List<T> deck, Comparator<T> criteria) throws NoMoreCardsException {
		if (deck.size() > 0) {
			Collections.sort(deck, criteria);
		} else {
			throw new NoMoreCardsException();
		}
	}

}
