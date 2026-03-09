package com.ninai.busbooking.service.owner;

import com.ninai.busbooking.entity.JourneyDetails.Bus;

import java.util.List;

public interface BusService {
    Bus addBus(Bus bus);
    Bus updateBus(Long id, Bus busDetails);
    void deleteBus(Long id);
    Bus getBusById(Long id);
    List<Bus> getAllBuses();
}
