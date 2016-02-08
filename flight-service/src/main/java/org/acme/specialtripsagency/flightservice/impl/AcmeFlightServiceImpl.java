package org.acme.specialtripsagency.flightservice.impl;

import java.math.BigDecimal;

import javax.jws.WebService;

import org.acme.specialtripsagency.flightservice.AcmeFlightServiceInterface;
import org.acme.specialtripsagency.flightservice.Booking;
import org.acme.specialtripsagency.flightservice.BookingCancellation;
import org.acme.specialtripsagency.flightservice.BookingCancellationResponse;
import org.acme.specialtripsagency.flightservice.BookingResponse;
import org.acme.specialtripsagency.flightservice.Flight;
import org.acme.specialtripsagency.flightservice.FlightRequest;

@WebService(serviceName = "AcmeFlightService", 
            endpointInterface = "org.acme.specialtripsagency.flightservice.AcmeFlightServiceInterface", 
            targetNamespace = "urn:specialtripsagency.acme.org:flightservice")
public class AcmeFlightServiceImpl implements AcmeFlightServiceInterface {
    
    public static final IdGenerator generator = new IdGenerator();

    @Override
    public BookingCancellationResponse cancelBooking(BookingCancellation parameters) {
        BookingCancellationResponse response = new BookingCancellationResponse();
        response.setStatus("CANCELLED");
        response.setCharge(0);
        return response;
    }

    @Override
    public BookingResponse bookFlight(Booking parameters) {
        BookingResponse response = new BookingResponse();
        if ("PREBOOKING".equals(parameters.getType())) {
            response.setStatus("PREBOOKED");
        } else {
            response.setStatus("BOOKED");
        }
        response.setBooking(parameters.getCarrier()+ generator.nextId());
        return response;
    }

    @Override
    public Flight listAvailablePlanes(FlightRequest parameters) {
        String startCity = parameters.getStartCity();
        String endCity = parameters.getEndCity();
        BigDecimal outboundBD = new BigDecimal(525);  
        
        Flight outbound = new Flight();
        outbound.setCarrier("EasyJet");
        outbound.setFlight(12345);
        outbound.setRatePerPerson(outboundBD);
        outbound.setStartCity(startCity);
        outbound.setTargetCity(endCity);
        outbound.setTravelDate(parameters.getStartDate());
        
        return outbound; 
    }

}
