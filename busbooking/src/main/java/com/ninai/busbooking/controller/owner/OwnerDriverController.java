package com.ninai.busbooking.controller.owner;

import com.ninai.busbooking.entity.Owner.Driver;
import com.ninai.busbooking.service.owner.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner/drivers")
public class OwnerDriverController {

    @Autowired
    private DriverService driverService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.addDriver(driver));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    // Read by Owner
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Driver>> getDriversByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(driverService.getDriversByOwner(ownerId));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.updateDriver(id, driver));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok("Driver deleted successfully");
    }
}