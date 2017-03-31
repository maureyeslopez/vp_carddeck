package vp_carddeck.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import vp_carddeck.business.FrenchDeckFactory;
import vp_carddeck.common.CardColor;
import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;
import vp_carddeck.entities.ISuit;
import vp_carddeck.entities.french.FrenchCard;
import vp_carddeck.entities.french.FrenchDeck;

/**
 * Tests for {@link FrenchDeckFactory} and {@link FrenchDeck}
 * 
 * @author maureyes
 *
 */
public class FrenchDeckTest {

	private IDeck<FrenchCard> deck;

	/**
	 * Get a new deck before every test
	 */
	@Before
	public void before() {
		FrenchDeckFactory factory = new FrenchDeckFactory();
		deck = factory.createDeck();
	}

	@Test
	public void assertNumberOfCards() {
		assertSame(52, deck.getCards().size());
	}

	@Test
	public void assertColors() {
		Map<CardColor, Collection<FrenchCard>> cardsPerColor = new HashMap<CardColor, Collection<FrenchCard>>();
		for (FrenchCard card : deck.getCards()) {
			CardColor cardColor = card.getColor();
			Collection<FrenchCard> colorCards = cardsPerColor.get(cardColor);
			if (colorCards == null) {
				colorCards = new HashSet<FrenchCard>();
				cardsPerColor.put(cardColor, colorCards);
			}

			colorCards.add(card);
		}

		assertSame(2, cardsPerColor.keySet().size());
		for (Collection<FrenchCard> suitCards : cardsPerColor.values()) {
			assertSame("Cards Found\n" + getCardsFound(suitCards), 26, suitCards.size());
		}
	}

	@Test
	public void assertNumberOfSuitsAndItsCards() {
		Map<ISuit, Collection<ICard>> cardsPerSuit = new HashMap<ISuit, Collection<ICard>>();
		for (ICard card : deck.getCards()) {
			ISuit cardSuit = card.getSuit();
			Collection<ICard> suitCards = cardsPerSuit.get(cardSuit);
			if (suitCards == null) {
				suitCards = new HashSet<ICard>();
				cardsPerSuit.put(cardSuit, suitCards);
			}

			suitCards.add(card);
		}

		assertSame(4, cardsPerSuit.keySet().size());
		for (Collection<ICard> suitCards : cardsPerSuit.values()) {
			assertSame("Cards Found\n" + getCardsFound(suitCards), 13, suitCards.size());
		}
	}

	private String getCardsFound(Collection<? extends ICard> suitCards) {
		StringBuilder sb = new StringBuilder();
		for (ICard card : suitCards) {
			sb.append(card + "\n ");
		}

		return sb.toString();
	}

	@Test
	public void assertCardRandomPutAndRetrieval() {
		// TODO: Implement the test of both methods
	}

	@Test
	public void assertCardPutAndRetrievalPosition() {
		try {
			FrenchCard card = deck.retrieveRandomCard();

			deck.putCardOnBottom(card);
			assertEquals(card, deck.retrieveCardOnBottom());
			assertNotEquals(card, deck.retrieveCardOnBottom());
			assertNotEquals(card, deck.retrieveCardOnTop());

			card = deck.retrieveRandomCard();

			deck.putCardOnTop(card);
			assertEquals(card, deck.retrieveCardOnTop());
			assertNotEquals(card, deck.retrieveCardOnTop());
			assertNotEquals(card, deck.retrieveCardOnBottom());
		} catch (NoMoreCardsException | CardRepeatedException e) {
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void assertNoRepetition() {
		try {
			FrenchCard card = deck.retrieveRandomCard();
			FrenchCard card2 = new FrenchCard(card.getSuit(), card.getRank());

			deck.putCard(card);
			deck.putCard(card2);
			fail("Should have raised a CardRepetitionException");
		} catch (CardRepeatedException e) {
			// It's ok that the exception raises here
		} catch (NoMoreCardsException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void assertNoCardsException() {
		try {
			int i = 1;
			while (i < 53) {
				deck.retrieveRandomCard();
				i++;
			}
			deck.retrieveRandomCard();
			fail("Should have raised a NoMoreCardsException");
		} catch (NoMoreCardsException e) {
			// It's ok that the exception raises here
		}
	}

	@Test
	public void assertShuffling() {
		try {
			// Check first 5 and last 5 cards aren't the same after a several
			// shuffles
			List<String> shufflesResult = new ArrayList<String>();
			int numberOfRounds = 200000;

			for (int i = 0; i < numberOfRounds; i++) {
				FrenchCard[] round = new FrenchCard[10];
				StringBuilder cardsOfRound = new StringBuilder();
				for (int j = 0; j <= 4; j++) {
					round[j] = deck.retrieveCardOnTop();
					round[j + 5] = deck.retrieveCardOnBottom();
					// One from top and one from bottom. Doesn't matter the
					// order, just following the same criteria
					cardsOfRound.append(round[j]);
					cardsOfRound.append(round[j + 5]);
				}
				for (int j = 0; j <= 4; j++) {
					deck.putCardOnTop(round[j]);
					deck.putCardOnTop(round[j + 5]);
				}

				shufflesResult.add(cardsOfRound.toString());

				deck.shuffle();
			}

			// Check that at least 99% of rounds are different (I should do some
			// mathematics to set #rounds and probabilities)
			// P(52, 10) = 5.7407703889536E+16
			// (https://www.wolframalpha.com/input/?i=P(52,+10))
			Set<String> resultsFolded = new HashSet<String>(shufflesResult);

			assertTrue(.99 < (resultsFolded.size() / shufflesResult.size()));
		} catch (NoMoreCardsException | CardRepeatedException e) {
			fail(e.getLocalizedMessage());
		}
	}

}
