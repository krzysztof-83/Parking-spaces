package com.parkingspacesapp.ParkingSpaces.common.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not found user: " + id);
    }
    public UserNotFoundException(String userName) {
        super("Could not found user: " + userName);
    }
}
