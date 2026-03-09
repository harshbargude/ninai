package com.ninai.busbooking.repository.owner;

import com.ninai.busbooking.entity.Owner.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    // Find all conductors belonging to a specific owner
    List<Conductor> findByOwnerId(Long ownerId);
}
