package co.edu.uniandes.dse.treeking.exceptions;

public final class ErrorMessage {
    public static final String LOCATION_NOT_FOUND = "The location with the given id was not found";
    public static final String ROUTE_NOT_FOUND = "The route with the given id was not found";
    public static final String CALENDAR_NOT_FOUND = "The calendar with the given name was not found";

    private ErrorMessage() {
        throw new IllegalStateException("Utility class");
    }
}