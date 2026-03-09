package com.ninai.busbooking.service.owner;

import com.ninai.busbooking.entity.Owner.Conductor;

import java.util.List;

public interface ConductorService {
    Conductor addConductor(Conductor conductor);
    Conductor updateConductor(Long id, Conductor conductorDetails);
    void deleteConductor(Long id);
    Conductor getConductorById(Long id);
    List<Conductor> getAllConductors();
    List<Conductor> getConductorsByOwner(Long ownerId);
}