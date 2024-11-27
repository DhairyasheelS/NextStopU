package org.example.controller;

import org.example.Service.BusService;
import org.example.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buses")
public class BusController
{
    private final BusService busService;

    @Autowired
    public BusController(BusService busService)
    {
        this.busService = busService;
    }

    // Add a new bus
    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus)
    {
        Bus newBus = busService.addBus(bus);
        return ResponseEntity.ok(newBus);
    }

    // Get all buses
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses()
    {
        List<Bus> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    // Get Bus by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id)
    {
        Optional<Bus> bus = busService.getBusById(id);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a bus by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id)
    {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }
}
