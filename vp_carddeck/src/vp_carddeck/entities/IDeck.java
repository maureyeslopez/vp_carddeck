package vp_carddeck.entities;

import java.util.List;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoMoreCardsException;

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
	 * @throws CardRepeatedException 
	 */
	public void putCard(T card) throws CardRepeatedException;
	
	/**
	 * Adds card on top of the deck
	 * 
	 * @param card
	 * @throws CardRepeatedException 
	 */
	public void putCardOnTop(T card) throws CardRepeatedException;
	
	/**
	 * Adds card on bottom of the deck
	 * 
	 * @param card
	 * @throws CardRepeatedException 
	 */
	public void putCardOnBottom(T card) throws CardRepeatedException;
	
	/**
	 * @return Retrieves a random card of the deck
	 * @throws NoMoreCardsException 
	 */
	public T retrieveRandomCard() throws NoMoreCardsException;
	
	/**
	 * @return Retrieves the card at the top of the deck
	 * @throws NoMoreCardsException 
	 */
	public T retrieveCardOnTop() throws NoMoreCardsException;
	
	/**
	 * @return Retrieves the card at the bottom of the deck
	 * @throws NoMoreCardsException 
	 */
	public T retrieveCardOnBottom() throws NoMoreCardsException;
	
	/**
	 * Shuffles the deck
	 * @throws NoMoreCardsException 
	 */
	public void shuffle() throws NoMoreCardsException;
	
}
