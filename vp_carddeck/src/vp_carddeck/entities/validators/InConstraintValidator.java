package vp_carddeck.entities.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.ArrayUtils;

public class InConstraintValidator implements ConstraintValidator<In, Character> {

	private char[] values;

	public final void initialize(final In annotation) {
		values = annotation.values();
	}

	public final boolean isValid(final Character value, final ConstraintValidatorContext context) {
		return ArrayUtils.contains(values, value);
	}

}