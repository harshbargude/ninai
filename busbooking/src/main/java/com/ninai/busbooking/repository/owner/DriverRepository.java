package com.ninai.busbooking.repository.owner;

import com.ninai.busbooking.entity.Owner.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Retrieve all drivers associated with a specific owner
    List<Driver> findByOwnerId(Long ownerId);

    // Optional: Find driver by license number for validation
    Driver findByLicenseNumber(String licenseNumber);
}
