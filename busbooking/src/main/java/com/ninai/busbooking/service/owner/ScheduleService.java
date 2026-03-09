package com.ninai.busbooking.service.owner;


import com.ninai.busbooking.entity.JourneyDetails.Schedule;
import java.util.List;

public interface ScheduleService {
    Schedule addSchedule(Schedule schedule);
    Schedule updateSchedule(Long id, Schedule scheduleDetails);
    void deleteSchedule(Long id);
    Schedule getScheduleById(Long id);
    List<Schedule> getAllSchedules();
}
