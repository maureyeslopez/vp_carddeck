package vp_carddeck.rest.serialization;

import vp_carddeck.entities.IRank;
import vp_carddeck.entities.french.FrenchFaceCard;
import vp_carddeck.entities.french.FrenchPip;

/**
 * DTO that represents {@link FrenchPip} and {@link FrenchFaceCard}.
 * @author maureyes
 *
 */
public class DTOFrenchRank {

	private char value;

	public DTOFrenchRank() {
		super();
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * 
	 * @param dtoRank
	 * @return An instance of {@link FrenchPip} or {@link FrenchFaceCard} depending on the value of the dtoRank
	 */
	public static IRank convert(DTOFrenchRank dtoRank) {
		IRank rank = null;
		
		char theValue = dtoRank.getValue();
		// If parses as an int, return a pip, otherwise a face
		if(Character.isDigit(theValue)) {
			Integer pip = Integer.parseInt(String.valueOf(theValue));
			rank = new FrenchPip(pip);
		} else {
			rank = new FrenchFaceCard(theValue);
		}
		
		return rank;
	}
}