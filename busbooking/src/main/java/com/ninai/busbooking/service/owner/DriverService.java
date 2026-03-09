package com.ninai.busbooking.service.owner;

import com.ninai.busbooking.entity.Owner.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    Driver updateDriver(Long id, Driver driverDetails);
    void deleteDriver(Long id);
    Driver getDriverById(Long id);
    List<Driver> getAllDrivers();
    List<Driver> getDriversByOwner(Long ownerId);
}
