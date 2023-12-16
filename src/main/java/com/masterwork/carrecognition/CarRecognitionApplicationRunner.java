package com.masterwork.carrecognition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
@Slf4j
public class CarRecognitionApplicationRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Run Project");
    }
}
