package customannotations;

/**
 * Exception for the failure of Size criteria
 * (Size Annotation)
 */
public class SizeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SizeException(String message) {
		super(message);
	}
}
