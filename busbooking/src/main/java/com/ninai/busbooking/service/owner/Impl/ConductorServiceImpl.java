package com.ninai.busbooking.service.owner.Impl;

import com.ninai.busbooking.entity.Owner.Conductor;
import com.ninai.busbooking.repository.owner.ConductorRepository;
import com.ninai.busbooking.service.owner.ConductorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public Conductor addConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    @Transactional
    public Conductor updateConductor(Long id, Conductor details) {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor not found: " + id));

        conductor.setName(details.getName());
        conductor.setPhone(details.getPhone());
        conductor.setOwner(details.getOwner());

        return conductorRepository.save(conductor);
    }

    @Override
    public void deleteConductor(Long id) {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor not found"));
        conductorRepository.delete(conductor);
    }

    @Override
    public Conductor getConductorById(Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor not found"));
    }

    @Override
    public List<Conductor> getAllConductors() {
        return conductorRepository.findAll();
    }

    @Override
    public List<Conductor> getConductorsByOwner(Long ownerId) {
        return conductorRepository.findByOwnerId(ownerId);
    }
}
