package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(value = "imdb", ignoreUnknownFields = false)
public record ImdbProperties(URI dataDir) {
}
