package com.example.backend.presentation.util;

import com.example.backend.business.domain.abstractFactory.PlatformFactoryManager;
import com.example.backend.business.domain.model.BaseProduct;
import com.example.backend.business.domain.strategy.IEcommercePlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StrategyContext {

    private final PlatformFactoryManager platformFactoryManager;

    @Autowired
    public StrategyContext(PlatformFactoryManager platformFactoryManager) {
        this.platformFactoryManager = platformFactoryManager;
    }
}
