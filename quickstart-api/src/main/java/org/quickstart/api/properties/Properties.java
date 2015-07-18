package org.quickstart.api.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * Created by sraffalli on 18/07/15.
 */
@Component
@ConfigurationProperties(prefix="connection")
public class Properties {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private InetAddress remoteAddress;

}
