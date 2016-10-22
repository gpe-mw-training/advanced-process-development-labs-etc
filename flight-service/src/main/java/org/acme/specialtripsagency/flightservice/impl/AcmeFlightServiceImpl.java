package org.acme.specialtripsagency.flightservice.impl;

import java.math.BigDecimal;

import javax.jws.WebService;

import org.acme.specialtripsagency.flightservice.AcmeFlightServiceException;
import org.acme.specialtripsagency.flightservice.AcmeFlightServiceInterface;
import org.acme.specialtripsagency.flightservice.Booking;
import org.acme.specialtripsagency.flightservice.BookingCancellation;
import org.acme.specialtripsagency.flightservice.BookingCancellationResponse;
import org.acme.specialtripsagency.flightservice.BookingResponse;
import org.acme.specialtripsagency.flightservice.Flight;
import org.acme.specialtripsagency.flightservice.FlightBookingFault;
import org.acme.specialtripsagency.flightservice.FlightRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(serviceName = "AcmeFlightService", 
            endpointInterface = "org.acme.specialtripsagency.flightservice.AcmeFlightServiceInterface", 
            targetNamespace = "urn:specialtripsagency.acme.org:flightservice")
public class AcmeFlightServiceImpl implements AcmeFlightServiceInterface {
    
    public static final IdGenerator generator = new IdGenerator();
    
    public static final Logger log = LoggerFactory.getLogger("AcmeFlightService");

    @Override
    public BookingCancellationResponse cancelBooking(BookingCancellation parameters) {
        BookingCancellationResponse response = new BookingCancellationResponse();
        response.setStatus("CANCELLED");
        response.setCharge(0);
        response.setBooking(parameters.getBooking());
        log.info("Flight Cancelled : BookingId {}, Status {}", response.getBooking(), response.getStatus());
        return response;
    }

    @Override
    public BookingResponse bookFlight(Booking parameters) throws AcmeFlightServiceException {
        if ("INVALID".equals(parameters.getCarrier())) {
            FlightBookingFault fault = new FlightBookingFault();
            String message = "Not a valid carrier";
            fault.setFaultCode("CARRIER");
            fault.setFaultString(message);
            throw new AcmeFlightServiceException(message, fault);
        }
        BookingResponse response = new BookingResponse();
        if ("PREBOOKING".equals(parameters.getType())) {
            response.setStatus("PREBOOKED");
        } else {
            response.setStatus("BOOKED");
        }
        if (parameters.getBooking() == null || parameters.getBooking().isEmpty()) {
            response.setBooking(parameters.getCarrier()+ generator.nextId());
        } else {
            response.setBooking(parameters.getBooking());
        }
        log.info("Flight Booked : BookingId {}, Status {}", response.getBooking(), response.getStatus());
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
