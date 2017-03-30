package vp_carddeck.entities.french;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;

public class FrenchDeck implements IDeck {

	// First position is top, last one y bottom
	private List<ICard> cards;
	
	public FrenchDeck() {
		super();
		this.cards = new ArrayList<ICard>();
	}
	
	@Override
	public List<ICard> getCards() {
		return cards;
	}

	@Override
	public void putCardOnTop(ICard card) {
		cards.add(0, card);
	}

	@Override
	public void putCardOnBottom(ICard card) {
		cards.add(card);
	}

	@Override
	public ICard getCardOnTop() {
		return cards.remove(0);
	}

	@Override
	public ICard getCardOnBottom() {
		return cards.remove(cards.size() - 1);
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cards, new Random());
	}

}
