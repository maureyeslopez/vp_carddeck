package vp_carddeck.entities;

public class Suit implements ISuit {

	private String name;
	
	public Suit(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(ISuit suit) {
		return this.getName().compareTo(suit.getName());
	}

	@Override
	public String getName() {
		return this.name;
	}


}
