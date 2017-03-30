package vp_carddeck.entities;

public class Card implements ICard {

	private ISuit suit;
	private IRank rank;
	
	public Card(ISuit suit, IRank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public int compareTo(ICard card) {
		int comparison = this.rank.compareTo(card.getRank());
		if(comparison == 0) {
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

}
