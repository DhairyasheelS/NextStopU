package org.example.Repository;

import org.example.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long>
{
    //Latest Location of Bus
    Optional<Location> findFirstByBusIdOrderByLocalDateTimeDesc(Long busId);

    // Find all location updates for specific bus b/w two timestamps
    List<Location> findByBusIdAndLocalDateTimeBetween(Long busId, LocalDateTime startTime, LocalDateTime endTime);

}