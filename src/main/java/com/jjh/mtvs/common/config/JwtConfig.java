package com.jjh.mtvs.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    // Getters and Setters
    private String secret;
    private long expiration;
    private RefreshToken refreshToken = new RefreshToken();

    @Setter
    @Getter
    public static class RefreshToken {
        private long expiration;

    }
}
