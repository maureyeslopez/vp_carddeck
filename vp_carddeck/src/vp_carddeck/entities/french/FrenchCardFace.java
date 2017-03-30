package vp_carddeck.entities.french;

import org.apache.commons.lang3.ArrayUtils;

import vp_carddeck.entities.IFace;
import vp_carddeck.entities.IPip;
import vp_carddeck.entities.IRank;

public class FrenchCardFace implements IFace {

	public static final char[] FRENCH_FACES = new char[]{ 'J', 'Q', 'K', 'A' };
	
	private char letter;
	
	public FrenchCardFace(char letter) {
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

}
