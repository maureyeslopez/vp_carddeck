package vp_carddeck.common.exceptions;

import vp_carddeck.entities.IDeck;

/**
 * Exception to be raised when there isn't an {@link IDeck} to work with
 * 
 * @author maureyes
 *
 */
public class NoDeckException extends Exception {

	private static final long serialVersionUID = 6012762491566509913L;
	
	public NoDeckException() {
		super("There's no deck");
	}

	public NoDeckException(String message) {
		super(message);
	}
}
