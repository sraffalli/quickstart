package org.quickstart.resource.server;

import org.quickstart.resource.server.properties.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by sraffalli on 18/07/15.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
//@EnableConfigurationProperties
@EnableOAuth2Resource
@RestController
public class ResourceServerApplication {

    private static final Logger  LOGGER = LoggerFactory.getLogger(ResourceServerApplication.class);

  //  @Autowired
   // private Properties properties;

    @RequestMapping("/")
    public String home() {
        return "{id: "+UUID.randomUUID().toString()+", content: 'Hello World'}";
    }

   // @PostConstruct
  //  public void setup() {
  //      LOGGER.error(properties.getUsername());
  //  }

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }

}
