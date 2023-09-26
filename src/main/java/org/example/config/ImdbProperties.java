package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties(value = "imdb", ignoreUnknownFields = false)
public record ImdbProperties(Path datasetsDir, boolean fillDb) {
}
