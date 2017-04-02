/**
 * 
 */
package vp_carddeck.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import vp_carddeck.business.DeckServices;
import vp_carddeck.business.FrenchDeckFactory;
import vp_carddeck.common.exceptions.CardRepeatedException;
import vp_carddeck.common.exceptions.NoDeckException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.common.exceptions.UnrecognizedCardException;
import vp_carddeck.entities.french.FrenchCard;
import vp_carddeck.entities.french.FrenchDeck;
import vp_carddeck.rest.serialization.DTOFrenchCard;

/**
 * REST API to test {@link FrenchDeck} functions 
 * @author maureyes
 *
 */
@Stateless
@Path("/frenchDeck")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class FrenchDeckREST {

	@EJB
	DeckServices<FrenchCard> frenchDeckServices;

	private static final int HTTP_SUCCESS_200 = 200;
	private static final int HTTP_ERROR_400 = 400;

	private Response buildResponse(Object obj, int status) {
		return Response.status(status).entity(obj).build();
	}

	@POST
	@Path("/start")
	@Produces("application/json" + ";charset=utf-8")
	public Response startNewDeck() {
		frenchDeckServices.createDeck(new FrenchDeckFactory());
		return buildResponse("Deck started", HTTP_SUCCESS_200);
	}

	@DELETE
	@Path("/destroy")
	@Produces("application/json" + ";charset=utf-8")
	public Response destroyDeck() {
		frenchDeckServices.deleteDeck();
		return buildResponse("Deck destroyed", HTTP_SUCCESS_200);
	}

	@GET
	@Path("/card/top")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCardOnTop() {
		FrenchCard card;
		try {
			card = (FrenchCard) frenchDeckServices.getCardOnTop();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@GET
	@Path("/card/any")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCard() {
		FrenchCard card;
		try {
			card = (FrenchCard) frenchDeckServices.getRandomCard();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}
	
	@GET
	@Path("/card/bottom")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCardOnBottom() {
		FrenchCard card;
		try {
			card = (FrenchCard) frenchDeckServices.getCardOnBottom();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@PUT
	@Path("/card/top")
	@Produces("application/json" + ";charset=utf-8")
	public Response putCardOnTop(DTOFrenchCard card) {
		try {
			frenchDeckServices.putCardOnTop(DTOFrenchCard.convert(card));
			return buildResponse("Card added", HTTP_SUCCESS_200);
		} catch (NoDeckException | CardRepeatedException | UnrecognizedCardException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@PUT
	@Path("/card/bottom")
	@Produces("application/json" + ";charset=utf-8")
	public Response putCardOnBottom(DTOFrenchCard card) {
		try {
			frenchDeckServices.putCardOnBottom(DTOFrenchCard.convert(card));
			return buildResponse("Card added", HTTP_SUCCESS_200);
		} catch (NoDeckException | CardRepeatedException | UnrecognizedCardException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@PUT
	@Path("/shuffle")
	@Produces("application/json" + ";charset=utf-8")
	public Response shuffle() {
		try {
			frenchDeckServices.shuffle();
			return buildResponse("Deck shuffled", HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}
	
	@PUT
	@Path("/sort/rank")
	@Produces("application/json" + ";charset=utf-8")
	public Response sortByRank() {
		try {
			frenchDeckServices.sortByRank();
			return buildResponse("Deck sorted by rank", HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@PUT
	@Path("/sort/suit")
	@Produces("application/json" + ";charset=utf-8")
	public Response sortBySuit() {
		try {
			frenchDeckServices.sortBySuit();
			return buildResponse("Deck sorted by suit", HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

}
