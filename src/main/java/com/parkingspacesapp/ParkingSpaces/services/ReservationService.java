package com.parkingspacesapp.ParkingSpaces.services;

import com.parkingspacesapp.ParkingSpaces.common.dto.ReservationDto;
import com.parkingspacesapp.ParkingSpaces.common.exceptions.ParkingSpaceNotFoundException;
import com.parkingspacesapp.ParkingSpaces.common.exceptions.UserNotFoundException;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ParkingSpaceEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ReservationEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.UserEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.ParkingSpaceRepository;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.ReservationRepository;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private ModelMapper modelMapper;

    public ReservationService(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    public Set<ReservationDto> findAllReservations() {
        List<ReservationEntity> reservations = StreamSupport
                .stream(reservationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return reservations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public Set<ReservationDto> findAllReservationsByParkingSpace(Long id) {
        ParkingSpaceEntity parkingSpace = parkingSpaceRepository.findById(id).orElseThrow(() -> new ParkingSpaceNotFoundException(id));
        return reservationRepository.findAllByParkingSpaceEntity(modelMapper.map(parkingSpace, ParkingSpaceEntity.class)).stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public Set<ReservationDto> findAllReservationsByUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return reservationRepository.findAllByUserEntity(modelMapper.map(user, UserEntity.class)).stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public ReservationDto saveReservation(ReservationDto reservationDto) {
        return convertToDto(reservationRepository.save(convertToEntity(reservationDto)));
    }

    public ReservationDto findReservationById(Long id) {
        return null;
    }

    private ReservationDto convertToDto(ReservationEntity reservationEntity) {
        return modelMapper.map(reservationEntity, ReservationDto.class);
    }

    private ReservationEntity convertToEntity(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, ReservationEntity.class);
    }
}
