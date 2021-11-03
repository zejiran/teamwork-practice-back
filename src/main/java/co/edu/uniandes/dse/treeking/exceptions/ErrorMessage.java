package co.edu.uniandes.dse.treeking.exceptions;

public final class ErrorMessage {
	public static final String POST_NOT_FOUND = "The post with the given id was not found";


	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}  