package com.example.backend.business.domain.abstractFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlatformFactoryManager {

    @Autowired
    private HepsiburadaPlatformFactory hepsiburadaPlatformFactory;
    @Autowired
    private TrendyolPlatformFactory trendyolPlatformFactory;

    public EcommercePlatformFactory getFactory(String platformName) {
        switch (platformName.toLowerCase()) {
            case "hepsiburada":
                return hepsiburadaPlatformFactory;
            case "trendyol":
                return trendyolPlatformFactory;
            default:
                return null;
        }
    }
}
