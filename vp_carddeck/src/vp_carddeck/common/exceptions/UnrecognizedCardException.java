package vp_carddeck.common.exceptions;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

/**
 * Exception to be raised when an {@link IDeck} doesn't recognize the type of an {@link ICard}
 * @author maureyes
 *
 */
public class UnrecognizedCardException extends Exception {

	private static final long serialVersionUID = 3247621984267753925L;

	public UnrecognizedCardException(String message) {
		super(message);
	}
}
