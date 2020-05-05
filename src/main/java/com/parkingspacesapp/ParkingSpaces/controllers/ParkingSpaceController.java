package com.parkingspacesapp.ParkingSpaces.controllers;

import com.parkingspacesapp.ParkingSpaces.common.dto.ParkingSpaceDto;
import com.parkingspacesapp.ParkingSpaces.common.dto.ReservationDto;
import com.parkingspacesapp.ParkingSpaces.services.ParkingSpaceService;
import com.parkingspacesapp.ParkingSpaces.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/parking-space")
public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @RequestMapping(path = "/findAvailableInDates", method = RequestMethod.GET)
    public Set<ParkingSpaceDto> getParkingspacesByGivenDates(@RequestParam String from,
                                                             @RequestParam String to) {
        return parkingSpaceService.findAvailableParkingSpacesByGivenDateTimes(LocalDateTime.parse(from), LocalDateTime.parse(to));
    }

}
