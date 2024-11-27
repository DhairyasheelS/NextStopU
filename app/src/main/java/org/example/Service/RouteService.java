package org.example.Service;

import org.example.Repository.RouteRepo;
import org.example.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService
{
    private final RouteRepo routeRepo;

    @Autowired
    public RouteService(RouteRepo routeRepo)
    {
        this.routeRepo = routeRepo;
    }

    // Add new route
    public List<Route> addRoutes(List<Route> routes) {
        return routeRepo.saveAll(routes);  // Save multiple routes
    }

    //Get all routes for specific bus
    public List<Route> getRoutesByBusId(Long busId)
    {
        return routeRepo.findByBusId(busId);
    }

    // Get all routes starting from a specific point
    public List<Route> getRoutesByStartPoint(String startPoint)
    {
        return routeRepo.findByStartPoint(startPoint);
    }

    // Delete a route
    public void deleteRoute(Long routeId)
    {
        routeRepo.deleteById(routeId);
    }
}
