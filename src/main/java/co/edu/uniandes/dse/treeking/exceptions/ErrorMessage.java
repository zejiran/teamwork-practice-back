package co.edu.uniandes.dse.treeking.exceptions;

public final class ErrorMessage {
	public static final String POST_NOT_FOUND = "The post with the given ID was not found";

	public static final String ENTERPRISE_NOT_FOUND = "The enterprise with the given ID was not found";

	public static final String TRANSACTION_NOT_FOUND = "The transaction with the given ID was not found";

	public static final String QUOTATION_NOT_FOUND = "The quotation with the given ID was not found";

	public static final String INSURANCE_NOT_FOUND = "The insurance with the given ID was not found";

	public static final String OUTING_NOT_FOUND = "The outing with the given ID was not found";

	public static final String CLIENT_NOT_FOUND = "The client with the given ID was not found";
	
	public static final String ACTIVITY_NOT_FOUND = "The activity with the given ID was not found";

	public static final String COMPLEMENTARYINFORMATION_NOT_FOUND = "The complementary information with the given ID was not found";
	
	public static final String GUIDE_NOT_FOUND = "The guide with the given ID was not found";
	
	public static final String ITINERARY_NOT_FOUND = "The itinerary with the given ID was not found";

	public static final String MULTIMEDIA_NOT_FOUND = "The multimedia with the given ID was not found";

	public static final String NATURAL_PERSON_NOT_FOUND = "The natural person with the given ID was not found";

	public static final String PERSON_NOT_FOUND = "The person with the given ID was not found";

	public static final String USER_NOT_FOUND = "The user with the given ID was not found";

	public static final String ADMIN_NOT_FOUND = "The admin with the given ID was not found";

	public static final String COMMENT_NOT_FOUND = "The comment with the given ID was not found";

	public static final String BLOG_NOT_FOUND = "The blog with the given ID was not found";

	public static final String REVIEW_NOT_FOUND = "The review with the given ID was not found";
  
  public static final String LOCATION_NOT_FOUND = "The location with the given ID was not found";
  
  public static final String ROUTE_NOT_FOUND = "The route with the given ID was not found";
  
  public static final String CALENDAR_NOT_FOUND = "The calendar with the given name was not found";

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}  
