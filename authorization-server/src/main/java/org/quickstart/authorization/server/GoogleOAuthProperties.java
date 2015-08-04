package org.quickstart.authorization.server;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sraffalli on 24/07/15.
 */
@ConfigurationProperties(prefix = "oauth.google")
public class GoogleOAuthProperties  extends OAuthProperties {
}
