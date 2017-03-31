package vp_carddeck.common.exceptions;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Exception to be raised when an {@link ICard} is already in the {@link IDeck}
 * 
 * @author maureyes
 *
 */
public class CardRepeatedException extends Exception {

	private static final long serialVersionUID = 6012762491566509913L;
	
	public CardRepeatedException() {
		super("Same card is already in the deck");
	}

	public CardRepeatedException(String message) {
		super(message);
	}
}
