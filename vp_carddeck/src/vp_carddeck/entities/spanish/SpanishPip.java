package vp_carddeck.entities.spanish;

import vp_carddeck.entities.IFace;
import vp_carddeck.entities.IPip;
import vp_carddeck.entities.IRank;

public class SpanishPip implements IPip {

	public static final String SOTA = "Sota";
	public static final String CABALLO = "Caballo";
	public static final String REY = "Rey";
	public static final String ESPADILLA = "Espadilla";

	private int number;

	public SpanishPip(int number) {
		super();
		this.number = number;
	}

	@Override
	public int compareTo(IRank rank) {
		if (rank instanceof IPip) {
			int comparedRankNumber = ((SpanishPip) rank).getNumber();
			return Integer.compare(this.getNumber(), comparedRankNumber);
		} else if (rank instanceof IFace) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	/**
	 * From 10 to 12 have names
	 * 
	 * @return
	 */
	public String getName() {
		String name = null;
		if (Integer.compare(number, 10) == 0) {
			name = SOTA;
		} else if (Integer.compare(number, 11) == 0) {
			name = CABALLO;
		} else if (Integer.compare(number, 12) == 0) {
			name = REY;
		}

		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		SpanishPip other = (SpanishPip) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

}
