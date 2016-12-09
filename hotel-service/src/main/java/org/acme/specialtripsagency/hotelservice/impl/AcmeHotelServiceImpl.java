package org.acme.specialtripsagency.hotelservice.impl;

import javax.jws.WebService;

import org.acme.specialtripsagency.hotelservice.AcmeHotelServiceException;
import org.acme.specialtripsagency.hotelservice.AcmeHotelServiceInterface;
import org.acme.specialtripsagency.hotelservice.BookingCancellation;
import org.acme.specialtripsagency.hotelservice.BookingCancellationResponse;
import org.acme.specialtripsagency.hotelservice.Hotel;
import org.acme.specialtripsagency.hotelservice.HotelBooking;
import org.acme.specialtripsagency.hotelservice.HotelBookingFault;
import org.acme.specialtripsagency.hotelservice.HotelBookingResponse;
import org.acme.specialtripsagency.hotelservice.HotelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(serviceName = "AcmeHotelService", endpointInterface = "org.acme.specialtripsagency.hotelservice.AcmeHotelServiceInterface", targetNamespace = "urn:specialtripsagency.acme.org:hotelservice")
public class AcmeHotelServiceImpl implements AcmeHotelServiceInterface {

	public static final IdGenerator generator = new IdGenerator();

	public static final Logger log = LoggerFactory.getLogger("AcmeHotelService");

	@Override
	public Hotel getAvailableHotels(HotelRequest parameters) {
		Hotel hotel = new Hotel();

		String hotelCity = parameters.getTargetCity();

		hotel.setHotelId(395);
		hotel.setHotelName("Holiday Inn");
		hotel.setRatePerPerson(200);
		hotel.setHotelCity(hotelCity);
		hotel.setAvailableFrom(parameters.getStartDate());
		hotel.setAvailableTo(parameters.getEndDate());

    @Override
    public HotelBookingResponse bookHotel(HotelBooking parameters) throws AcmeHotelServiceException {
        if ("INVALID".equals(parameters.getHotelID())) {
            HotelBookingFault fault = new HotelBookingFault();
            String message = "Not a valid hotel id";
            fault.setFaultCode("HOTEL_ID");
            fault.setFaultString(message);
            throw new AcmeHotelServiceException(message, fault);
        }
        HotelBookingResponse response = new HotelBookingResponse();
        if ("PREBOOKING".equals(parameters.getType())) {
            response.setStatus("PREBOOKED");
        } else {
            response.setStatus("BOOKED");
        }
        if (parameters.getBooking() == null || parameters.getBooking().isEmpty()) {
            response.setBooking(parameters.getHotelID()+ generator.nextId());
        } else {
            response.setBooking(parameters.getBooking());
        }
        log.info("Hotel Booked : BookingId {}, Status {}", response.getBooking(), response.getStatus());
        return response;
    }

}
