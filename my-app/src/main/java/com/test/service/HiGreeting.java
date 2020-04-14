package com.test.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class HiGreeting implements TestingProfile {
    @Override
    public String greeting() {
        return "Hi";
    }
}
