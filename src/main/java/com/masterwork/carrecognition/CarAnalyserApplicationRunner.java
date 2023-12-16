package com.masterwork.carrecognition;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class CarAnalyserApplicationRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
