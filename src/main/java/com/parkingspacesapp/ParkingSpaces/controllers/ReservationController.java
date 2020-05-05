package com.parkingspacesapp.ParkingSpaces.controllers;

import com.parkingspacesapp.ParkingSpaces.common.dto.ReservationDto;
import com.parkingspacesapp.ParkingSpaces.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public Collection<ReservationDto> getReservations() {
        return reservationService.findAllReservations();
    }

    @RequestMapping(path = "/findByUser", method = RequestMethod.GET)
    public Set<ReservationDto> getReservationByUser(@RequestParam Long id) {
        return reservationService.findAllReservationsByUser(id);
    }

    @RequestMapping(path = "/findByParkingSpace", method = RequestMethod.GET)
    public Set<ReservationDto> getReservationByParkingSpace(@RequestParam Long id) {
        return reservationService.findAllReservationsByParkingSpace(id);
    }

    @RequestMapping(path = "/findById", method = RequestMethod.GET)
    public ReservationDto getReservationById(@RequestParam Long id) {
        return reservationService.findReservationById(id);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto saveReservation(@Valid @RequestBody ReservationDto reservationDto) {
        return this.reservationService.saveReservation(reservationDto);
    }

}
