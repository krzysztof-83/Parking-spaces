package com.parkingspacesapp.ParkingSpaces.persistance.repository;

import com.parkingspacesapp.ParkingSpaces.persistance.domain.ParkingSpaceEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ReservationEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

  List<ReservationEntity> findAllByUserEntity(UserEntity userEntity);
  List<ReservationEntity> findAllByParkingSpaceEntity(ParkingSpaceEntity parkingSpaceEntity);

}
