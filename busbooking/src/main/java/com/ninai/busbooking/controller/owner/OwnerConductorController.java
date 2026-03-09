package com.ninai.busbooking.controller.owner;

import com.ninai.busbooking.service.owner.ConductorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninai.busbooking.entity.Owner.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner/conductors")
public class OwnerConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping("/add")
    public ResponseEntity<Conductor> addConductor(@RequestBody Conductor conductor) {
        return ResponseEntity.ok(conductorService.addConductor(conductor));
    }

    @GetMapping
    public ResponseEntity<List<Conductor>> getAll() {
        return ResponseEntity.ok(conductorService.getAllConductors());
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Conductor>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(conductorService.getConductorsByOwner(ownerId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Conductor> update(@PathVariable Long id, @RequestBody Conductor conductor) {
        return ResponseEntity.ok(conductorService.updateConductor(id, conductor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        conductorService.deleteConductor(id);
        return ResponseEntity.ok("Conductor removed successfully");
    }
}