package Uber.Pricing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ride_id")
    private Long id;

    @Column(name = "distance_Km")
    private double distanceKm;
    @Column(name = "time_Hours")
    private double timeHours;
    @Column(name = "waiting_Minutes")
    private double waitingMinutes;
    @Column(name = "calculated_Price")
    private double calculatedPrice;
    @Column(name = "ride_Time")
    private LocalDateTime rideTime;

}
