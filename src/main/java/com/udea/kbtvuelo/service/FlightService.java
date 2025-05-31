package com.udea.kbtvuelo.service;

import com.udea.kbtvuelo.dao.IFlightDao;
import com.udea.kbtvuelo.exception.FlightNotFoundException;
import com.udea.kbtvuelo.exception.ModelNotFoundException;
import com.udea.kbtvuelo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    private final IFlightDao flightDao;

    @Autowired
    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public Flight save(Flight flight) {
        return flightDao.save(flight);
    }

    public String delete(Flight flight) {
        flightDao.delete(flight);
        return "Flight deleted successfully";
    }

    public Iterable<Flight> findAll(){
        return flightDao.findAll();
    }

    public Optional<Flight> findById(Long id){
        return flightDao.findById(id);
    }

    public Flight update(Flight flight){
        var exists = flightDao
                .findById(flight.getId())
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with id: " + flight.getId()));
        exists.setName(flight.getName());
        exists.setCapacity(flight.getCapacity());
        exists.setRating(flight.getRating());
        exists.setCapacity(flight.getCapacity());
        exists.setCompleted(flight.getCompleted());
        exists.setFlightNumber(flight.getFlightNumber());
        exists.setOrigin(flight.getOrigin());
        exists.setDestination(flight.getDestination());
        return flightDao.save(exists);
    }

    public Iterable<Flight> viewBestFlight() throws ModelNotFoundException {
        var bestFlights = flightDao.viewBestFlight();
        if(!bestFlights.isEmpty())
            return bestFlights;
        throw new ModelNotFoundException("Could not find flights with a review >= 4");
    }
}
