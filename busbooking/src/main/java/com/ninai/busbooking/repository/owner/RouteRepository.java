package com.ninai.busbooking.repository.owner;

import com.ninai.busbooking.entity.JourneyDetails.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Find routes by origin
    List<Route> findByOrigin(String origin);

    // Find routes by destination
    List<Route> findByDestination(String destination);
}
