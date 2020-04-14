package com.test.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class HelloGreeting implements TestingProfile {
    @Override
    public String greeting() {
        return "Hello!";
    }
}
