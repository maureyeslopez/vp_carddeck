package vp_carddeck.business;

import javax.ejb.Local;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoDeckException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

@Local
public interface DeckServices<T extends ICard> {

	public void createDeck(DeckFactory<T> factory);
	
	public IDeck<T> getDeck() throws NoDeckException;
	
	public void deleteDeck();
	
	public ICard getRandomCard() throws NoDeckException, NoMoreCardsException;
	
	public ICard getCardOnTop() throws NoDeckException, NoMoreCardsException;
	
	public ICard getCardOnBottom() throws NoDeckException, NoMoreCardsException;
	
	public void putCardOnTop(T card) throws NoDeckException, CardRepeatedException;
	
	public void putCardOnBottom(T card) throws NoDeckException, CardRepeatedException;

	public void shuffle() throws NoDeckException, NoMoreCardsException;

	public void sortByRank() throws NoDeckException, NoMoreCardsException;

	public void sortBySuit() throws NoDeckException, NoMoreCardsException;

}
