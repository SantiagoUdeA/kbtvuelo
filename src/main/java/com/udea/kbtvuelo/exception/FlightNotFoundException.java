package com.udea.kbtvuelo.exception;

public class FlightNotFoundException extends ModelNotFoundException{
    public FlightNotFoundException(String message) {
        super(message);
    }
}
