package com.udea.kbtvuelo.controller;

import com.udea.kbtvuelo.exception.InvalidRatingException;
import com.udea.kbtvuelo.model.Flight;
import com.udea.kbtvuelo.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flight")
@CrossOrigin("*")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public Flight save(@RequestBody Flight flight) throws InvalidRatingException {
        if(flight.getRating() < 0 || flight.getRating() > 5)
            throw new InvalidRatingException("Invalid rating");
        return flightService.save(flight);
    }

    @DeleteMapping
    public String delete(@RequestBody Flight flight) {
        return flightService.delete(flight);
    }

    @PatchMapping
    public Flight update(@RequestBody Flight flight) {
        return flightService.update(flight);
    }

    @RequestMapping(value = "/viewBestFlight", method = RequestMethod.GET)
    public Iterable<Flight> viewBestFlight() {
        return flightService.viewBestFlight();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Flight findById(@PathVariable Long id){
        return flightService.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    @GetMapping
    public Iterable<Flight> findAll(){
        System.out.println("Request received");
        return flightService.findAll();
    }

}
