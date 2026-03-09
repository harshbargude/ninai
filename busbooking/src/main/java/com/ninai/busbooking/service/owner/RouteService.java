package com.ninai.busbooking.service.owner;

import com.ninai.busbooking.entity.JourneyDetails.Route;

import java.util.List;

public interface RouteService {
    Route addRoute(Route route);
    Route updateRoute(Long id, Route routeDetails);
    void deleteRoute(Long id);
    Route getRouteById(Long id);
    List<Route> getAllRoutes();
}
