package org.acme.specialtripsagency.flightservice;

import javax.xml.ws.WebFault;

/**
 * This Exception subclass provides Exception instantiation for the SOAP web
 * service failures.
 * 
 * @author dtorresf@redhat.com
 *
 */
@WebFault(name="FlightBookingFault", targetNamespace="urn:specialtripsagency.acme.org:flightservice")
public class AcmeFlightServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private FlightBookingFault fault;
	
    /**
     * 
     */
    public AcmeFlightServiceException() {
        super();
    }

    /**
     * @param message
     */
    public AcmeFlightServiceException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public AcmeFlightServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public AcmeFlightServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public AcmeFlightServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public AcmeFlightServiceException(FlightBookingFault fault) {
        super(fault.getFaultString());
        this.fault = fault;
    }
    
    public AcmeFlightServiceException(String message, FlightBookingFault fault) {
        super(message);
        this.fault = fault;
    }
    
    public AcmeFlightServiceException(String message, FlightBookingFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

	/**
	 * 
	 * @return
	 */
	public FlightBookingFault getFaultInfo() {
		return fault;
	}



}
