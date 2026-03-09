package com.ninai.busbooking.service.owner.Impl;

import com.ninai.busbooking.entity.JourneyDetails.Route;
import com.ninai.busbooking.repository.owner.RouteRepository;
import com.ninai.busbooking.service.owner.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Long id, Route details) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));

        route.setOrigin(details.getOrigin());
        route.setDestination(details.getDestination());

        return routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
        routeRepository.delete(route);
    }

    @Override
    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
