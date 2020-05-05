package com.parkingspacesapp.ParkingSpaces.persistance.repository;

import com.parkingspacesapp.ParkingSpaces.persistance.domain.ParkingSpaceEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.ReservationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingSpaceRepository extends CrudRepository<ParkingSpaceEntity, Long> {

    @Query("select p from ParkingSpaceEntity p left join p.reservationEntity r where p.isActive = true " +
            "and r.reservationStart > ?2 and r.reservationEnd < ?1")
    List<ParkingSpaceEntity> findAvailableParkingSpacesByGivenDateTimes(LocalDateTime from, LocalDateTime to);

}
