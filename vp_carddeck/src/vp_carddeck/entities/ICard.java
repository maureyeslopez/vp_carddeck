package vp_carddeck.entities;

public interface ICard extends Comparable<ICard> {

	public ISuit getSuit();
	
	public IRank getRank();
	
}
