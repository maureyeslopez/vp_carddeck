package vp_carddeck.business;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

public interface DeckFactory<T extends ICard> {

	public IDeck<T> createDeck();
	
}
