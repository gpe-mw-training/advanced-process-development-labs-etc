package org.acme.specialtripsagency.flightservice;

import javax.xml.ws.WebFault;

/**
 * This Exception subclass provides Exception instantiation for the SOAP web
 * service failures.
 * 
 * @author dtorresf@redhat.com
 *
 */
@WebFault(name="AcmeFlightServiceFault", targetNamespace="urn:specialtripsagency.acme.org:flightservice")
public class AcmeFlightServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private AcmeFlightServiceFault fault;

	/**
	 * 
	 * @return
	 */
	public AcmeFlightServiceFault getFaultInfo() {
		return fault;
	}

	protected AcmeFlightServiceException(AcmeFlightServiceFault fault) {
		super(fault.getFaultString());
		this.fault = fault;
	}

	public AcmeFlightServiceException(String message, AcmeFlightServiceFault fault) {
		super(message);
		this.fault = fault;
	}

	public AcmeFlightServiceException(String message, AcmeFlightServiceFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}

	/**
	 * 
	 */
	public AcmeFlightServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AcmeFlightServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AcmeFlightServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AcmeFlightServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated constructor stub
	}

}
