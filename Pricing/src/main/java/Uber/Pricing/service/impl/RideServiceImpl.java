package Uber.Pricing.service.impl;

import Uber.Pricing.model.Ride;
import Uber.Pricing.repository.RideRepository;
import Uber.Pricing.service.PricingService;
import Uber.Pricing.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;



    private PricingService pricingService;


    @Override
    public Ride createRide(Ride ride){
        Ride newRide =new Ride();
        Ride savedRide=rideRepository.save(ride);
        return savedRide;
    }


}
