package com.parkingspacesapp.ParkingSpaces.services;

import com.parkingspacesapp.ParkingSpaces.common.dto.ParkingSpaceDto;
import com.parkingspacesapp.ParkingSpaces.common.dto.ReservationDto;
import com.parkingspacesapp.ParkingSpaces.common.exceptions.ReservationNotFoundException;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ParkingSpaceEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ReservationEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.ParkingSpaceRepository;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParkingSpaceService {

    private ParkingSpaceRepository parkingSpaceRepository;
    private ModelMapper modelMapper;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, ModelMapper modelMapper) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.modelMapper = modelMapper;
    }

    public Set<ParkingSpaceDto> findAvailableParkingSpacesByGivenDateTimes(LocalDateTime from, LocalDateTime to) {
        return StreamSupport
                .stream(parkingSpaceRepository.findAvailableParkingSpacesByGivenDateTimes(from, to).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    private ParkingSpaceDto convertToDto(ParkingSpaceEntity parkingSpaceEntity) {
        return modelMapper.map(parkingSpaceEntity, ParkingSpaceDto.class);
    }
}
