package com.ninai.busbooking.entity.JourneyDetails;

<<<<<<< HEAD:busbooking/busbooking/src/main/java/com/ninai/busbooking/entity/Schedule.java
=======
import com.ninai.busbooking.entity.Owner.Conductor;
import com.ninai.busbooking.entity.Owner.Driver;

>>>>>>> 98bc638387339bc2b221e618667383648d666d3d:busbooking/busbooking/src/main/java/com/ninai/busbooking/entity/JourneyDetails/Schedule.java
import com.ninai.busbooking.entity.User_folder.User;
import com.ninai.busbooking.enums.Direction;
import com.ninai.busbooking.enums.ScheduleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    private LocalDate travelDate;
    private LocalTime departureTime;

    private BigDecimal baseFare;


    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    private Double rate;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    @ManyToOne
    private User createdBy;

    private LocalDateTime publishedAt;

}
