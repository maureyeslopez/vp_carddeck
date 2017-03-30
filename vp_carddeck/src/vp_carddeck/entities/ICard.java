package vp_carddeck.entities;

/**
 * Card definition
 * 
 * @author maureyes
 *
 */
public interface ICard extends Comparable<ICard> {

	public ISuit getSuit();
	
	public IRank getRank();
	
}
