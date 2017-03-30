package vp_carddeck.entities;

import java.util.List;

public interface IDeck {

	public List<ICard> getCards();
	
	public void putCardOnTop(ICard card);
	
	public void putCardOnBottom(ICard card);
	
	public ICard getCardOnTop();
	
	public ICard getCardOnBottom();
	
	public void shuffle();
	
}
