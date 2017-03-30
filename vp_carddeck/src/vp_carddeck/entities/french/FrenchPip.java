package vp_carddeck.entities.french;

import vp_carddeck.entities.IFace;
import vp_carddeck.entities.IPip;
import vp_carddeck.entities.IRank;

public class FrenchPip implements IPip {

	private int number;
	
	public FrenchPip(int number) {
		super();
		this.number = number;
	}
	
	@Override
	public int compareTo(IRank rank) {
		if (rank instanceof IPip) {
			int comparedRankNumber = ((FrenchPip) rank).getNumber(); 
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

}
