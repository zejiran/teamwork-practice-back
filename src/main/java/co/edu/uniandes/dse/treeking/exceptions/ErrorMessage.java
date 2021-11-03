package co.edu.uniandes.dse.treeking.exceptions;

public class ErrorMessage {
	public static final String QUOTATION_NOT_FOUND = "The quotation with the given id was not found";

	public static final String INSURANCE_NOT_FOUND = "The insurance with the given id was not found";

	public static final String OUTING_NOT_FOUND = "The outing with the given id was not found";

	public static final String CLIENT_NOT_FOUND = "The client with the given id was not found";

	public static final String ADMIN_NOT_FOUND = "The admin whit the given id was not found";

	public static final String COMMENT_NOT_FOUND = "The comment whit the given id was not found";

	public static final String BLOG_NOT_FOUND = "The blog whit the given id was not found";

	public static final String REVIEW_NOT_FOUND = "The review whit the given id was not found";

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}
