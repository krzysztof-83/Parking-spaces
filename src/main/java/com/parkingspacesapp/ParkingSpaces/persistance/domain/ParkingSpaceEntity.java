package com.parkingspacesapp.ParkingSpaces.persistance.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "parking_space")
public class ParkingSpaceEntity extends AbstractEntity {

    private int spaceNumber;
    private int floor;
    private boolean isActive;
    @OneToMany(mappedBy = "parkingSpaceEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReservationEntity> reservationEntity;

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<ReservationEntity> getReservationEntity() {
        return reservationEntity;
    }

    public void setReservationEntity(Set<ReservationEntity> reservationEntity) {
        this.reservationEntity = reservationEntity;
    }
}
