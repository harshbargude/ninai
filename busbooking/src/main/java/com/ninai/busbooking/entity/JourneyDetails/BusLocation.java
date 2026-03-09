package com.ninai.busbooking.entity.JourneyDetails;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long busId;

    private Double latitude;

    private Double longitude;


    private LocalDateTime lastUpdated;
    
}
