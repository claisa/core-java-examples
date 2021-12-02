package customannotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface Size {

	/**
	 * Minimum length of the String field
	 */
	public int min() default -1;

	/**
	 * Maximum length of the String field
	 */
	public int max() default -1;
	
}

