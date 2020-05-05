package com.parkingspacesapp.ParkingSpaces.common.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException() {
        super("Could not found reservation: ");
    }
}
