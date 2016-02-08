
package org.acme.specialtripsagency.flightservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.acme.specialtripsagency.flightservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.acme.specialtripsagency.flightservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookingCancellationResponse }
     * 
     */
    public BookingCancellationResponse createBookingCancellationResponse() {
        return new BookingCancellationResponse();
    }

    /**
     * Create an instance of {@link FlightRequest }
     * 
     */
    public FlightRequest createFlightRequest() {
        return new FlightRequest();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link BookingCancellation }
     * 
     */
    public BookingCancellation createBookingCancellation() {
        return new BookingCancellation();
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
    }

    /**
     * Create an instance of {@link BookingResponse }
     * 
     */
    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

}
