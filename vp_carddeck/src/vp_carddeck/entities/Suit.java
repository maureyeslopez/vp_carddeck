package vp_carddeck.entities;

import vp_carddeck.common.exceptions.UnrecognizedCardException;

/**
 * Abstract implementation of a suit
 * 
 * @author maureyes
 *
 */
public abstract class Suit implements ISuit {

	private String name;
	
	public Suit() {
		super();
	}
	
	public Suit(String name) throws UnrecognizedCardException {
		super();
		if(!validSuitName(name)) {
			throw new UnrecognizedCardException("Invalid suit name");
		} else {
			this.name = name;
		}
	}

	/**
	 * Name suit comparison
	 */
	@Override
	public int compareTo(ISuit suit) {
		return this.getName().compareTo(suit.getName());
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Suit other = (Suit) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
