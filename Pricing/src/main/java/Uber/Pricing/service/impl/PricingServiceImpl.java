package Uber.Pricing.service.impl;

import Uber.Pricing.model.Pricing;
import Uber.Pricing.repository.PricingRepository;
import Uber.Pricing.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
@Service
public class PricingServiceImpl implements PricingService {


    @Autowired
    private PricingRepository pricingRepository;

    public Pricing createPricing(Pricing pricing){
        Pricing newPricing = new Pricing();
        Pricing savedPricing=pricingRepository.save(pricing);
        return savedPricing;
    }

}
