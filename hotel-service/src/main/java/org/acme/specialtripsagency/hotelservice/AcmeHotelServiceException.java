package org.acme.specialtripsagency.hotelservice;

import javax.xml.ws.WebFault;

/**
 * This Exception subclass provides Exception instantiation for the SOAP web
 * service failures.
 * 
 * @author dtorresf@redhat.com
 *
 */
@WebFault(name="AcmeHotelServiceFault", targetNamespace="urn:specialtripsagency.acme.org:hotelservice")
public class AcmeHotelServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private AcmeHotelServiceFault fault;

	/**
	 * @return the fault
	 */
	public AcmeHotelServiceFault getFaultInfo() {
		return fault;
	}

	protected AcmeHotelServiceException(AcmeHotelServiceFault fault) {
		super(fault.getFaultString());
		this.fault = fault;
	}

	public AcmeHotelServiceException(String message, AcmeHotelServiceFault fault) {
		super(message);
		this.fault = fault;
	}

	public AcmeHotelServiceException(String message, AcmeHotelServiceFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}

	/**
	 * 
	 */
	public AcmeHotelServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AcmeHotelServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AcmeHotelServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AcmeHotelServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AcmeHotelServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
