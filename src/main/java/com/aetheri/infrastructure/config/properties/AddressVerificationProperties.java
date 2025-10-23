package com.aetheri.infrastructure.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "address-verification")
public record AddressVerificationProperties(
        String key,
        String url,
        int connectTimeoutMillis,
        int responseTimeoutSeconds,
        int timeOutSeconds
) {
}
