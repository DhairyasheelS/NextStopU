package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.Service.RouteService;
import org.example.entity.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController
{
    private final RouteService routeService;

    // Add multiple routes
    @PostMapping
    public ResponseEntity<List<Route>> addRoutes(@RequestBody List<Route> routes) {
        List<Route> newRoutes = routeService.addRoutes(routes);  // Batch saving
        return ResponseEntity.ok(newRoutes);
    }

    // Get routes by bus ID
    @GetMapping("/bus/{busId}")
    public ResponseEntity<List<Route>> getRoutesByBusId(@PathVariable Long busId) {
        List<Route> routes = routeService.getRoutesByBusId(busId);

        // Return a 204 No Content response if no routes found
        if (routes == null || routes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(routes);
    }

    // Delete a route by ID
    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long routeId) {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }
}
