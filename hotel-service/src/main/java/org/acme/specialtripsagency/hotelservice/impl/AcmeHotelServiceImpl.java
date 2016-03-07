package org.acme.specialtripsagency.hotelservice.impl;

import javax.jws.WebService;

import org.acme.specialtripsagency.hotelservice.AcmeHotelServiceInterface;
import org.acme.specialtripsagency.hotelservice.BookingCancellation;
import org.acme.specialtripsagency.hotelservice.BookingCancellationResponse;
import org.acme.specialtripsagency.hotelservice.Hotel;
import org.acme.specialtripsagency.hotelservice.HotelBooking;
import org.acme.specialtripsagency.hotelservice.HotelBookingResponse;
import org.acme.specialtripsagency.hotelservice.HotelRequest;

@WebService(serviceName = "AcmeHotelService", 
            endpointInterface = "org.acme.specialtripsagency.hotelservice.AcmeHotelServiceInterface", 
            targetNamespace = "urn:specialtripsagency.acme.org:hotelservice")
public class AcmeHotelServiceImpl implements AcmeHotelServiceInterface {
    
    public static final IdGenerator generator = new IdGenerator();

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

        return hotel;
    }

    @Override
    public BookingCancellationResponse cancelBooking(BookingCancellation parameters) {
        BookingCancellationResponse response = new BookingCancellationResponse();
        response.setStatus("CANCELLED");
        response.setCharge(0);
        response.setBooking(parameters.getBooking());
        return response;
    }

    @Override
    public HotelBookingResponse bookHotel(HotelBooking parameters) {
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
        return response;
    }

}
