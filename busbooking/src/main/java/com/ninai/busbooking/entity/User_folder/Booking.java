package com.ninai.busbooking.entity.User_folder;

import com.ninai.busbooking.entity.JourneyDetails.Schedule;
import com.ninai.busbooking.enums.BookedBy;
import com.ninai.busbooking.enums.BookingStatus;
import com.ninai.busbooking.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
                @UniqueConstraint(columnNames = { "schedule_id", "seat_number" })
})
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "schedule_id")
        private Schedule schedule;

        @Column(name = "seat_number")
        private int seatNumber;

        private String passengerName;

        private String passengerPhone;

        private Double amount;

        private String pickupLocation;

        private String drop_location;

        @Enumerated(EnumType.STRING)
        private BookedBy bookedBy;

        @Enumerated(EnumType.STRING)
        private PaymentMode paymentMode;

        @Enumerated(EnumType.STRING)
        private BookingStatus status;

        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "booking")
        private List<Payment_details> payment_details;

}


