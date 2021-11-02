package co.edu.uniandes.dse.treeking.exceptions;

public class ErrorMessage {
	public static final String QUOTATION_NOT_FOUND = "The quotation with the given id was not found";

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}
