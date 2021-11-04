package co.edu.uniandes.dse.treeking.exceptions;

public class ErrorMessage {
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

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}
