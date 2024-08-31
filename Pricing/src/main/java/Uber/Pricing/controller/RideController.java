package Uber.Pricing.controller;

import Uber.Pricing.model.Ride;
import Uber.Pricing.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ride")
public class RideController {


    @Autowired
    private RideService rideService;


    @PostMapping("/add")
    public ResponseEntity<?> createRide(@Validated @RequestBody Ride ride) {
        try {
            Ride createdRide = rideService.createRide(ride);
            return new ResponseEntity<>(createdRide, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
