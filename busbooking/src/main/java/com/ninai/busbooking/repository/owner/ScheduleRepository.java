package com.ninai.busbooking.repository.owner;

import com.ninai.busbooking.entity.JourneyDetails.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // Custom query to find schedules by a specific date
    List<Schedule> findByTravelDate(LocalDate travelDate);

    // Custom query to find schedules for a specific bus
    List<Schedule> findByBusId(Long busId);
}