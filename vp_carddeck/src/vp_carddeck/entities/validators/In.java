package vp_carddeck.entities.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validator for list of characters as seen on http://stackoverflow.com/questions/4922655/javax-validation-to-validate-list-of-values/5179047
 * @author maureyes
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InConstraintValidator.class)
public @interface In {
	String message() default "The value is not one of the expected";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
    char[] values();
    
}