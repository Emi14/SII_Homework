package org.siit.homework.week11.repository;

import org.siit.homework.week11.entity.Accommodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    List<Accommodation> findByType(String type);
    List<Accommodation> findByBedType(String bedType);
    List<Accommodation> findByMaxGuestsGreaterThanEqual(int numGuests);
}
