package com.ninai.busbooking.service.owner.Impl;

import com.ninai.busbooking.entity.JourneyDetails.Schedule;
import com.ninai.busbooking.enums.ScheduleStatus;
import com.ninai.busbooking.repository.owner.ScheduleRepository;
import com.ninai.busbooking.service.owner.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        schedule.setStatus(ScheduleStatus.PUBLISHED);
        schedule.setPublishedAt(LocalDateTime.now());
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Schedule existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));

        // Updating fields based on the Schedule entity
        existingSchedule.setBus(scheduleDetails.getBus());
        existingSchedule.setTravelDate(scheduleDetails.getTravelDate());
        existingSchedule.setDepartureTime(scheduleDetails.getDepartureTime());
        existingSchedule.setBaseFare(scheduleDetails.getBaseFare());
        existingSchedule.setStatus(scheduleDetails.getStatus());
        existingSchedule.setRoute(scheduleDetails.getRoute());
        existingSchedule.setDriver(scheduleDetails.getDriver());
        existingSchedule.setConductor(scheduleDetails.getConductor());
        existingSchedule.setRate(scheduleDetails.getRate());
        existingSchedule.setDirection(scheduleDetails.getDirection());
        existingSchedule.setCreatedBy(scheduleDetails.getCreatedBy());
        existingSchedule.setPublishedAt(scheduleDetails.getPublishedAt());

        return scheduleRepository.save(existingSchedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
        scheduleRepository.delete(schedule);
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
}
