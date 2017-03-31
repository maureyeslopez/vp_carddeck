package vp_carddeck.entities;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import vp_carddeck.entities.french.FrenchSuit;

/**
 * Suit definition
 * 
 * @author maureyes
 *
 */
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = FrenchSuit.class, name = "french"),
})
public interface ISuit extends Comparable<ISuit> {

	public String getName();
	
}
