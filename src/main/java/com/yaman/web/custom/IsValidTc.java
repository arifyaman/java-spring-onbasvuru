package com.yaman.web.custom;

/**
 * @author Arif
 *
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.yaman.web.custom.validators.TcValidator;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=TcValidator.class)
public @interface IsValidTc {
	String message() default "Girdiğiniz TC kimlik numarasına sahip biri yok. Geçerli bir TC giriniz :)";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
		
}
