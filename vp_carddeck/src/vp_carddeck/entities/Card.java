package vp_carddeck.entities;

/**
 * Generic implementation of a Card
 * 
 * @author maureyes
 *
 */
public class Card implements ICard {

	private ISuit suit;
	private IRank rank;
	
	public Card(ISuit suit, IRank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * Compares card rank, if ranks are equal compares suits
	 */
	@Override
	public int compareTo(ICard card) {
		int comparison = this.rank.compareTo(card.getRank());
		if (comparison == 0) {
			comparison = this.suit.compareTo(card.getSuit());
		}
		
		return comparison;
	}

	@Override
	public ISuit getSuit() {
		return this.suit;
	}

	@Override
	public IRank getRank() {
		return this.rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return rank.toString() + " " + suit.toString();
	}
	
}
