package org.acme.specialtripsagency.flightservice;

/**
 * This class models the failure information to be notified to the SOAP WS
 * client.
 * 
 * @author dtorresf@redhat.com
 *
 */
public class AcmeFlightServiceFault {

	private String faultCode;
	private String faultString;

	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * @param faultCode
	 *            the faultCode to set
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * @return the faultString
	 */
	public String getFaultString() {
		return faultString;
	}

	/**
	 * @param faultString
	 *            the faultString to set
	 */
	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}
}
