package co.edu.uniandes.dse.treeking.exceptions;

public final class ErrorMessage {
	public static final String ENTERPRISE_NOT_FOUND = "The enterprise with the given id was not found";


	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}