package com.example.clinique.Exception;

public class CliniqueException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CliniqueException(String message) {
        super(message);
    }

    public static String NotFoundException(Long id) {
        return "clinique with "+id+" not found!";
    }

    public static String CliniqueAlreadyExists() {
        return "clinique with given name already exists";
    }
}
