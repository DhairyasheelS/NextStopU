package org.example.Repository;

import org.example.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepo extends JpaRepository<Bus,Long>
{
    List<Bus> findByDriverName(String driverName);

    Bus findByBusNumber(String busNumber);
}
