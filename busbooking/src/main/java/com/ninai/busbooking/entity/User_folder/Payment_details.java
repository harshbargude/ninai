package com.ninai.busbooking.entity.User_folder;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;

    private Double amount;

    private String paymentMode;

    private String status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}
