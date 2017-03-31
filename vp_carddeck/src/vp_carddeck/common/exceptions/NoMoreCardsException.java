package vp_carddeck.common.exceptions;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Exception to be raised when an {@link IDeck} doesn't have any more {@link ICard}
 * @author maureyes
 *
 */
public class NoMoreCardsException extends Exception {

	private static final long serialVersionUID = -9087936694063490729L;

	public NoMoreCardsException() {
		super("No more cards in the deck");
	}
}
