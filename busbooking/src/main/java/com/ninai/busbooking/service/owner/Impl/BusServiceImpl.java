package com.ninai.busbooking.service.owner.Impl;

import com.ninai.busbooking.entity.JourneyDetails.Bus;
import com.ninai.busbooking.repository.owner.BusRepository;
import com.ninai.busbooking.service.owner.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(Long id, Bus busDetails) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));

        bus.setBusName(busDetails.getBusName());
        bus.setBusNumber(busDetails.getBusNumber());
        bus.setTotalSeats(busDetails.getTotalSeats());

        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));
        busRepository.delete(bus);
    }

    @Override
    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
