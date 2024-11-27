package org.example.Repository;

import org.example.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepo extends JpaRepository<Route , Long>
{
    List<Route> findByBusId(Long busId);

    List<Route> findByStartPoint(String startPoint);
}
