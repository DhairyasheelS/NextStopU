package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.Service.LocationService;
import org.example.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationController
{

    @Autowired
    private final LocationService locationService;

    // Save a new Location
    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        Location newLocation = locationService.saveLocation(location);
        return ResponseEntity.ok(newLocation);
    }

    // Get latest location for a bus
    @GetMapping("/bus/{busId}/latest")
    public ResponseEntity<Optional<Location>> getLatestLocation(@PathVariable Long busId) {
        Optional<Location> latestLocation = locationService.getLatestLocation(busId);

        // Check if the location exists, otherwise return 204 No Content
        if (latestLocation.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(latestLocation);
    }

    // Get Location history for a bus within a specific time range
    @GetMapping("/bus/{busId}/history")
    public ResponseEntity<List<Location>> getLocationHistory(
            @PathVariable Long busId,
            @RequestParam("start") LocalDateTime startTime,
            @RequestParam("end") LocalDateTime endTime) {
        List<Location> locationHistory = locationService.getLocationHistory(busId, startTime, endTime);

        // Check if any locations are found, otherwise return 204 No Content
        if (locationHistory.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(locationHistory);
    }
}
