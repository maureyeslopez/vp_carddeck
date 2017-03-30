package vp_carddeck.business;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

public interface DeckServices<T extends ICard> {

	public void createDeck(DeckFactory<T> factory);
	
	public IDeck<T> initDeck();
	
	public void deleteDeck();
	
	public ICard getRandomCard();
	
	public ICard getCardOnTop();
	
	public ICard getCardOnBottom();
	
	public void putCardOnTop(T card);
	
	public void putCardOnBottom(T card);
	
}