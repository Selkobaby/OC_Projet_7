package com.p7.zuul.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Sleuth {

    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
