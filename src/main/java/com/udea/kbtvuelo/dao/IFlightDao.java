package com.udea.kbtvuelo.dao;

import com.udea.kbtvuelo.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFlightDao extends CrudRepository<Flight, Long> {

    @Query("from Flight f where f.rating >= 4 AND f.completed=true")
    public List<Flight> viewBestFlight();
}
