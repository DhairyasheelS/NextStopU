package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bus
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busNumber;
    private String driverName;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    @JsonManagedReference  // This is the parent side
    private List<Route> routes;

    @ElementCollection
    private List<String> stops;
}