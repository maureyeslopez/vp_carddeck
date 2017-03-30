package vp_carddeck.common;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Deck functions to be reused on implementations of {@link IDeck} 
 *  
 * @author maureyes
 *
 */
public class DeckFunctions<T extends ICard> {

	public void putCard(T card, List<T> deck) {
		putCardOnBottom(card, deck);
	}

	public void putCardOnTop(T card, List<T> deck) {
		// No repeated card on deck
		if (!deck.contains(card)) {
			deck.add(0, card);
		} else {
			// Throw exception
		}
	}

	public void putCardOnBottom(T card, List<T> deck) {
		// No repeated card on deck
		if (!deck.contains(card)) {
			deck.add(card);
		} else {
			// Throw exception
		}
	}

	public T retrieveRandomCard(List<T> deck) {
		return deck.remove(ThreadLocalRandom.current().nextInt(0, deck.size() - 1));
	}

	public T retrieveCardOnTop(List<T> deck) {
		return deck.remove(0);
	}

	public T retrieveCardOnBottom(List<T> deck) {
		return deck.remove(deck.size() - 1);
	}

	public void shuffle(List<T> deck) {
		Collections.shuffle(deck, ThreadLocalRandom.current());
	}

}
