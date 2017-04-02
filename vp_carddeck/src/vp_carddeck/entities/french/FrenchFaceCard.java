package vp_carddeck.entities.french;

import org.apache.commons.lang3.ArrayUtils;

import vp_carddeck.entities.IFace;
import vp_carddeck.entities.IPip;
import vp_carddeck.entities.IRank;
import vp_carddeck.entities.validators.In;

public class FrenchFaceCard implements IFace {

	public static final char JACK = 'J';
	public static final char QUEEN = 'Q';
	public static final char KING = 'K';
	public static final char ACE = 'A';

	public static final char[] FRENCH_FACES = new char[] { JACK, QUEEN, KING, ACE };

	@In(values = { JACK, QUEEN, KING, ACE })
	private char letter;

	public FrenchFaceCard() {
		super();
	}

	public FrenchFaceCard(char letter) {
		super();
		this.letter = letter;
	}

	@Override
	public int compareTo(IRank rank) {
		if (rank instanceof IPip) {
			return 1;
		} else if (rank instanceof IFace) {
			int thisFacePosition = ArrayUtils.indexOf(FRENCH_FACES, this.getLetter());
			int comparedFacePosition = ArrayUtils.indexOf(FRENCH_FACES, ((IFace) rank).getLetter());
			return Integer.compare(thisFacePosition, comparedFacePosition);
		} else {
			return 0;
		}
	}

	@Override
	public char getLetter() {
		return this.letter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + letter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrenchFaceCard other = (FrenchFaceCard) obj;
		if (letter != other.letter)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(letter);
	}

}
