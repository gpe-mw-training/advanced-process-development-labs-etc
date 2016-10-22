package org.acme.specialtripsagency.hotelservice;

import javax.xml.ws.WebFault;

/**
 * This Exception subclass provides Exception instantiation for the SOAP web
 * service failures.
 * 
 * @author dtorresf@redhat.com
 *
 */
@WebFault(name = "HotelBookingFault", targetNamespace = "urn:specialtripsagency.acme.org:hotelservice")
public class AcmeHotelServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private HotelBookingFault fault;

    /**
     * 
     */
    public AcmeHotelServiceException() {
        super();
    }

    /**
     * @param message
     */
    public AcmeHotelServiceException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public AcmeHotelServiceException(Throwable cause) {
        super(cause);
    }

    public AcmeHotelServiceException(HotelBookingFault fault) {
        super(fault.getFaultString());
        this.fault = fault;
    }

    /**
     * @param message
     * @param cause
     */
    public AcmeHotelServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public AcmeHotelServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public AcmeHotelServiceException(String message, HotelBookingFault fault) {
        super(message);
        this.fault = fault;
    }

    public AcmeHotelServiceException(String message, HotelBookingFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    /**
     * @return the fault
     */
    public HotelBookingFault getFaultInfo() {
        return fault;
    }

}
