package org.example.Service;

import org.example.Repository.LocationRepo;
import org.example.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService
{
    private final LocationRepo locationRepo;

    @Autowired
    public LocationService(LocationRepo locationRepo)
    {
        this.locationRepo = locationRepo;
    }

    // Save the current location of bus
    public Location saveLocation(Location location)
    {
        return locationRepo.save(location);
    }

    // Get the latest location of bus
    public Optional<Location> getLatestLocation(Long busID)
    {
        return locationRepo.findFirstByBusIdOrderByLocalDateTimeDesc(busID);
    }

    // Get location history within a time range
    public List<Location> getLocationHistory(Long busId, LocalDateTime startTime, LocalDateTime endTime)
    {
        return locationRepo.findByBusIdAndLocalDateTimeBetween(busId, startTime, endTime);
    }
}