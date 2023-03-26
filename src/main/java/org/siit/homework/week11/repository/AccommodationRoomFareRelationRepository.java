package org.siit.homework.week11.repository;

import org.siit.homework.week11.entity.AccommodationRoomFareRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRoomFareRelationRepository extends JpaRepository<AccommodationRoomFareRelation, Long> {

    List<AccommodationRoomFareRelation> findByAccommodationId(Long accommodationId);
    List<AccommodationRoomFareRelation> findByRoomFareId(Long roomFareId);
}
