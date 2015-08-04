package org.quickstart.authorization.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.security.Principal;

@SpringBootApplication
@RestController
@EnableResourceServer
public class AuthorizationServerApplication extends WebMvcConfigurerAdapter {


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;
  /*      @Autowired
        private DataSource datasource;
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private GoogleOAuthProperties googleOAuthProperties;
*/
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            //clients.jdbc().dataSource(datasource).passwordEncoder(passwordEncoder)
            clients.inMemory()
                    /*.withClient("google").secret(googleOAuthProperties.getClientSecret())
                    .redirectUris(googleOAuthProperties.getRedirectUris())
                    .accessTokenValiditySeconds(googleOAuthProperties.getAccessTokenValiditySeconds())
                    .autoApprove(googleOAuthProperties.isAutoApprove()).authorizedGrantTypes().and()
*/
                        .withClient("acme")
                    .secret("acmesecret")
                    .authorizedGrantTypes("authorization_code", "refresh_token",
                            "password").scopes("openid");
        }

    }
}
