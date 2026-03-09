package com.ninai.busbooking.repository.owner;

import com.ninai.busbooking.entity.JourneyDetails.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Optional<Bus> findBusByBusNumber(String BusNumber);
}
