package org.example.Service;

import org.example.Repository.BusRepo;
import org.example.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService
{
    private final BusRepo busRepo;

    @Autowired
    public BusService(BusRepo busRepo)
    {
        this.busRepo = busRepo;
    }

    // Add new Bus
    public Bus addBus(Bus bus)
    {
        return busRepo.save(bus);
    }

    // Retrieve all buses
    public List<Bus> getAllBuses()
    {
        return busRepo.findAll();
    }

    // Find a bus by id
    public Optional<Bus> getBusById(Long busId)
    {
        return busRepo.findById(busId);
    }

    // Find a bus by its number
    public Bus getBusByBusNumber(String busNumber)
    {
        return busRepo.findByBusNumber(busNumber);
    }

    // Delete a bus by ID
    public void deleteBus(Long busId)
    {
        busRepo.deleteById(busId);
    }
}
