package com.microserviceambulance.Ambulance.exception;

public class AmbulanceException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AmbulanceException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "ambulance with "+id+" not found!";
    }

    public static String AmbulanceAlreadyExists() {
        return "ambulance with given name already exists";
    }
}