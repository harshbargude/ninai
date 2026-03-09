package com.ninai.busbooking.service.owner.Impl;

import com.ninai.busbooking.entity.Owner.Driver;
import com.ninai.busbooking.repository.owner.DriverRepository;
import com.ninai.busbooking.service.owner.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver details) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));

        // Mapping fields from Driver entity
        driver.setName(details.getName());
        driver.setLicenseNumber(details.getLicenseNumber());
        driver.setPhone(details.getPhone());
        driver.setLicenseExpiry(details.getLicenseExpiry());
        driver.setOwner(details.getOwner());

        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        driverRepository.delete(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<Driver> getDriversByOwner(Long ownerId) {
        return driverRepository.findByOwnerId(ownerId);
    }
}
