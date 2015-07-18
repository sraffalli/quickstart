package org.quickstart.api;

import org.quickstart.api.properties.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * Created by sraffalli on 18/07/15.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableConfigurationProperties
public class Application {

    private static final Logger  LOGGER = LoggerFactory.getLogger(Application.class);
    @Autowired
    private Properties properties;

    @PostConstruct
    public void setup() {
        LOGGER.error(properties.getUsername());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
