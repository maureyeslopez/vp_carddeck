package vp_carddeck.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.common.exceptions.UnrecognizedCardException;
import vp_carddeck.entities.ICard;
import vp_carddeck.entities.IDeck;
import vp_carddeck.entities.IRank;

/**
 * Deck functions to be reused on implementations of {@link IDeck}
 * 
 * @author maureyes
 *
 */
public class DeckFunctions<T extends ICard> {
	
	public void putCard(T card, List<T> deck) throws CardRepeatedException, UnrecognizedCardException {
		putCardOnBottom(card, deck);
	}

	public void putCardOnTop(T card, List<T> deck) throws CardRepeatedException, UnrecognizedCardException {
		if (checkCardDefinition(card)) {
			// No repeated card on deck
			if (!deck.contains(card)) {
				deck.add(0, card); // First position is the top
			} else {
				throw new CardRepeatedException(card.toString() + " is already on the deck");
			}
		}
	}

	public void putCardOnBottom(T card, List<T> deck) throws CardRepeatedException, UnrecognizedCardException {
		if (checkCardDefinition(card)) {
			// No repeated card on deck
			if (!deck.contains(card)) {
				deck.add(card); // Last position is the bottom
			} else {
				throw new CardRepeatedException(card.toString() + " is already on the deck");
			}
		}
	}

	/**
	 * Runs BeanValidation over the card, it suit and it rank
	 * 
	 * @param card
	 * @return
	 * @throws UnrecognizedCardException
	 */
	private boolean checkCardDefinition(T card) throws UnrecognizedCardException {
		// There's no BeanValidation constraint for the suit name because can't
		// set different constraints to each extension of the abtract suit
		if (card.getSuit().validSuitName(card.getSuit().getName())) {

			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();

			Set<ConstraintViolation<T>> constraints = validator.validate(card);
			Set<ConstraintViolation<IRank>> constraintsRank = validator.validate(card.getRank());

			if (constraints.size() > 0 || constraintsRank.size() > 0) {
				StringBuilder errors = new StringBuilder();
				for (ConstraintViolation<T> constraint : constraints) {
					errors.append(constraint.getMessage() + "\n");
				}
				for (ConstraintViolation<IRank> constraint : constraintsRank) {
					errors.append(constraint.getMessage() + "\n");
				}
				throw new UnrecognizedCardException(errors.toString());
			} else {
				return true;
			}
		} else {
			throw new UnrecognizedCardException("Suit name '" + card.getSuit().getName() + "' is not valid");
		}
	}

	public T retrieveRandomCard(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			if (deck.size() == 1) {
				return deck.remove(0);
			} else {
				return deck.remove(ThreadLocalRandom.current().nextInt(0, deck.size() - 1));
			}
		} else {
			throw new NoMoreCardsException();
		}
	}

	public T retrieveCardOnTop(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			return deck.remove(0);
		} else {
			throw new NoMoreCardsException();
		}
	}

	public T retrieveCardOnBottom(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			return deck.remove(deck.size() - 1);
		} else {
			throw new NoMoreCardsException();
		}
	}

	public void shuffle(List<T> deck) throws NoMoreCardsException {
		if (deck.size() > 0) {
			Collections.shuffle(deck, ThreadLocalRandom.current());
		} else {
			throw new NoMoreCardsException();
		}
	}

	public void sort(List<T> deck, Comparator<T> criteria) throws NoMoreCardsException {
		if (deck.size() > 0) {
			Collections.sort(deck, criteria);
		} else {
			throw new NoMoreCardsException();
		}
	}

}
