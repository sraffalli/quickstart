package org.quickstart.authorization.server;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

/**
 * Created by sraffalli on 24/07/15.
 */
public abstract class OAuthProperties {

    @Getter
    @Setter
    private String clientId;

    @Getter
    @Setter
    private String clientSecret;

    @Getter
    @Setter
    private URL tokenUri;

    @Getter
    @Setter
    private URL authUri;

    @Getter
    @Setter
    private String[] redirectUris;

    @Getter
    @Setter
    private int accessTokenValiditySeconds;

    @Getter
    @Setter
    private boolean autoApprove;

}
