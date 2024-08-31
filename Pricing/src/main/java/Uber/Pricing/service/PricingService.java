package Uber.Pricing.service;

import Uber.Pricing.model.Pricing;
import org.springframework.stereotype.Service;

@Service
public interface PricingService {


    Pricing createPricing(Pricing pricing);


    

}
