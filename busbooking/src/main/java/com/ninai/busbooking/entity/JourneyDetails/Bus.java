package com.ninai.busbooking.entity.JourneyDetails;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String busName;

    private String busNumber;

    private int totalSeats;

    @OneToMany(mappedBy = "bus")
    private List<Schedule> schedules;

}
