package Uber.Pricing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Pricing")
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_id")
    private Long id;

    @Column(name = "day_of_Week")
    private String dayOfWeek;
    @Column(name = "base_Price")
    private Double basePrice;
    @Column(name = "additional_Price_Per_Km")
    private Double additionalPricePerKm;
    @Column(name = "time_Multiplier")
    private Double timeMultiplier;
    @Column(name = "waiting_Charge_Per_Minute")
    private Double waitingChargePerMinute;
    @Column(name = "is_active")
    private boolean isActive;

}
