package vp_carddeck.entities.spanish;

import java.util.ArrayList;
import java.util.List;

import vp_carddeck.common.DeckFunctions;
import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.IDeck;

/**
 * Specification of {@link IDeck} for {@link SpanishCard}
 * 
 * @author maureyes
 *
 */
public class SpanishDeck implements IDeck<SpanishCard> {

	private List<SpanishCard> cards;
	private DeckFunctions<SpanishCard> deckUtils;

	public SpanishDeck() {
		super();
		this.deckUtils = new DeckFunctions<SpanishCard>();
		this.cards = new ArrayList<SpanishCard>();
	}

	@Override
	public List<SpanishCard> getCards() {
		return cards;
	}

	@Override
	public void putCard(SpanishCard card) throws CardRepeatedException {
		deckUtils.putCard(card, cards);
	}

	@Override
	public void putCardOnTop(SpanishCard card) throws CardRepeatedException {
		deckUtils.putCardOnTop(card, cards);
	}

	@Override
	public void putCardOnBottom(SpanishCard card) throws CardRepeatedException {
		deckUtils.putCardOnBottom(card, cards);
	}

	@Override
	public SpanishCard retrieveRandomCard() throws NoMoreCardsException {
		return deckUtils.retrieveRandomCard(cards);
	}

	@Override
	public SpanishCard retrieveCardOnTop() throws NoMoreCardsException {
		return deckUtils.retrieveCardOnTop(cards);
	}

	@Override
	public SpanishCard retrieveCardOnBottom() throws NoMoreCardsException {
		return deckUtils.retrieveCardOnBottom(cards);
	}

	@Override
	public void shuffle() throws NoMoreCardsException {
		deckUtils.shuffle(cards);
	}
	
}
