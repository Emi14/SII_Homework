package org.siit.homework.week11.repository;

import org.siit.homework.week11.entity.RoomFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomFareRepository extends JpaRepository<RoomFare, Long> {

    List<RoomFare> findBySeason(String season);
    List<RoomFare> findByValueGreaterThan(double value);
}
