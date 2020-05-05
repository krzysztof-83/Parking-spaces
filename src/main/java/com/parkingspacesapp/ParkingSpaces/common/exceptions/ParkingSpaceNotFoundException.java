package com.parkingspacesapp.ParkingSpaces.common.exceptions;

public class ParkingSpaceNotFoundException extends RuntimeException {

    public ParkingSpaceNotFoundException(Long id) {
        super("Could not found parking space: " + id);
    }
}
