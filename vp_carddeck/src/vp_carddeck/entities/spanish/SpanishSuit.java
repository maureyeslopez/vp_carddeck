package vp_carddeck.entities.spanish;

import vp_carddeck.entities.Suit;

public class SpanishSuit extends Suit {

	public final static String BASTO = "Basto";
	public final static String ORO = "Oro";
	public final static String COPA = "Copa";
	public final static String ESPADA = "Espada";
	
	public final static String[] SPANISH_SUITS = new String[]{ BASTO, ORO, COPA, ESPADA };
	
	public SpanishSuit(String name) {
		super(name);
	}

}
