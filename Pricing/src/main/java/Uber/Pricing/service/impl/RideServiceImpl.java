package Uber.Pricing.service.impl;

import Uber.Pricing.model.Pricing;
import Uber.Pricing.model.Ride;
import Uber.Pricing.repository.PricingRepository;
import Uber.Pricing.repository.RideRepository;
import Uber.Pricing.service.PricingService;
import Uber.Pricing.service.RideService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;



    @Autowired
    private PricingService pricingService;

    @Autowired
    private PricingRepository pricingRepository;


    @Override
    public Ride createRide(Ride ride){
        Ride newRide =new Ride();
        double price = calculatePrice(ride);
        ride.setPrice(price);
        Ride savedRide=rideRepository.save(ride);
        return savedRide;
    }
    public double calculatePrice(Ride ride) {
        try {
            Optional<Pricing> pricingOpt = pricingRepository.findByIsActiveTrue();
            if (pricingOpt.isPresent()) {
                Pricing pricing = pricingOpt.get();


                double distanceCharge = ride.getDistanceKm() <= 3 ? pricing.getBasePrice()
                        : pricing.getBasePrice() + (ride.getDistanceKm() - 3) * pricing.getAdditionalPricePerKm();
                double timeCharge = ride.getTimeHours() * pricing.getTimeMultiplier();
                double waitingCharge = (ride.getWaitingMinutes() / 3) * pricing.getWaitingChargePerMinute();

                return distanceCharge + timeCharge + waitingCharge;
            } else {
                throw new RuntimeException("No active pricing configuration found.");
            }
        } catch (Exception e) {
            System.out.println("Error calculating price: ");
            throw e;  // Re-throw the exception to be caught by the controller
        }
    }





}
