package Uber.Pricing.repository;

import Uber.Pricing.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {

}
