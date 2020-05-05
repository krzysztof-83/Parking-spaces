package com.parkingspacesapp.ParkingSpaces.persistance.repository;

import com.parkingspacesapp.ParkingSpaces.persistance.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByName(String username);
}
