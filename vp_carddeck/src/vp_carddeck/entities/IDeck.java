package vp_carddeck.entities;

import java.util.List;

/**
 * Generic interface defining basic operations of a deck
 * 
 * @author maureyes
 *
 * @param <T> Type of card of the deck
 */
public interface IDeck<T extends ICard> {

	/**
	 * @return The list of all cards on its current order
	 */
	public List<T> getCards();
	
	/**
	 * Adds card somewhere in the deck
	 * 
	 * @param card
	 */
	public void putCard(T card);
	
	/**
	 * Adds card on top of the deck
	 * 
	 * @param card
	 */
	public void putCardOnTop(T card);
	
	/**
	 * Adds card on bottom of the deck
	 * 
	 * @param card
	 */
	public void putCardOnBottom(T card);
	
	/**
	 * @return Retrieves a random card of the deck
	 */
	public T retrieveRandomCard();
	
	/**
	 * @return Retrieves the card at the top of the deck
	 */
	public T retrieveCardOnTop();
	
	/**
	 * @return Retrieves the card at the bottom of the deck
	 */
	public T retrieveCardOnBottom();
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle();
	
}
