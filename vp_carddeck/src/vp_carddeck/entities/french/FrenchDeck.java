package vp_carddeck.entities.french;

import java.util.ArrayList;
import java.util.List;

import vp_carddeck.common.DeckFunctions;
import vp_carddeck.entities.IDeck;

/**
 * Specification of {@link IDeck} for {@link FrenchCard}
 * 
 * @author maureyes
 *
 */
public class FrenchDeck implements IDeck<FrenchCard> {

	private List<FrenchCard> cards;
	private DeckFunctions<FrenchCard> deckUtils;

	public FrenchDeck() {
		super();
		this.deckUtils = new DeckFunctions<FrenchCard>();
		this.cards = new ArrayList<FrenchCard>();
	}

	@Override
	public List<FrenchCard> getCards() {
		return cards;
	}

	@Override
	public void putCard(FrenchCard card) {
		deckUtils.putCard(card, cards);
	}

	@Override
	public void putCardOnTop(FrenchCard card) {
		deckUtils.putCardOnTop(card, cards);
	}

	@Override
	public void putCardOnBottom(FrenchCard card) {
		deckUtils.putCardOnBottom(card, cards);
	}

	@Override
	public FrenchCard retrieveRandomCard() {
		return deckUtils.retrieveRandomCard(cards);
	}

	@Override
	public FrenchCard retrieveCardOnTop() {
		return deckUtils.retrieveCardOnTop(cards);
	}

	@Override
	public FrenchCard retrieveCardOnBottom() {
		return deckUtils.retrieveCardOnBottom(cards);
	}

	@Override
	public void shuffle() {
		deckUtils.shuffle(cards);
	}
	
}
