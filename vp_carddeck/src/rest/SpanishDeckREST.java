/**
 * 
 */
package rest;

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
import vp_carddeck.business.SpanishDeckFactory;
import vp_carddeck.common.exceptions.NoDeckException;
import vp_carddeck.common.exceptions.NoMoreCardsException;
import vp_carddeck.entities.spanish.SpanishCard;

/**
 * @author maureyes
 *
 */
@Stateless
@Path("/spanishDeck")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SpanishDeckREST {

	@EJB
	DeckServices<SpanishCard> spanishDeckServices;

	private static final int HTTP_SUCCESS_200 = 200;
	private static final int HTTP_ERROR_400 = 400;

	private Response buildResponse(Object obj, int status) {
		return Response.status(status).entity(obj).build();

	}

	@POST
	@Path("/start")
	@Produces("application/json" + ";charset=utf-8")
	public Response startNewDeck() {
		spanishDeckServices.createDeck(new SpanishDeckFactory());
		return buildResponse("Deck started", HTTP_SUCCESS_200);
	}

	@DELETE
	@Path("/destroy")
	@Produces("application/json" + ";charset=utf-8")
	public Response destroyDeck() {
		spanishDeckServices.deleteDeck();
		return buildResponse("Deck destroyed", HTTP_SUCCESS_200);
	}

	@GET
	@Path("/card/top")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCardOnTop() {
		SpanishCard card;
		try {
			card = (SpanishCard) spanishDeckServices.getCardOnTop();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@GET
	@Path("/card/any")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCard() {
		SpanishCard card;
		try {
			card = (SpanishCard) spanishDeckServices.getRandomCard();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}
	
	@GET
	@Path("/card/bottom")
	@Produces("application/json" + ";charset=utf-8")
	public Response retrieveCardOnBottom() {
		SpanishCard card;
		try {
			card = (SpanishCard) spanishDeckServices.getCardOnBottom();
			return buildResponse(card, HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

	@PUT
	@Path("/card/top")
	@Produces("application/json" + ";charset=utf-8")
	public Response putCardOnTop(SpanishCard card) {
		// FIXME: Have to correct deserialization. @See
		// https://github.com/FasterXML/jackson-docs/wiki/JacksonPolymorphicDeserialization
		// return buildResponse(frenchDeckServices.putCardOnTop(card),
		// HTTP_SUCCESS_200);
		return buildResponse("Not available yet", HTTP_ERROR_400);
	}

	@PUT
	@Path("/card/bottom")
	@Produces("application/json" + ";charset=utf-8")
	public Response putCardOnBottom(SpanishCard card) {
		// FIXME: Have to correct deserialization. @See
		// https://github.com/FasterXML/jackson-docs/wiki/JacksonPolymorphicDeserialization
		// return buildResponse(frenchDeckServices.putCardOnBottom(card),
		// HTTP_SUCCESS_200);
		return buildResponse("Not available yet", HTTP_ERROR_400);
	}

	@PUT
	@Path("/shuffle")
	@Produces("application/json" + ";charset=utf-8")
	public Response shuffle() {
		try {
			spanishDeckServices.shuffle();
			return buildResponse("Deck shuffled", HTTP_SUCCESS_200);
		} catch (NoDeckException | NoMoreCardsException e) {
			return buildResponse(e.getLocalizedMessage(), HTTP_ERROR_400);
		}
	}

}
