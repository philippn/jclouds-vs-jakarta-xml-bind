package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties("demo")
public class DemoProperties {
    private String providerName = "s3";
    private String containerName = "bucket";
    private String identity = "demo";
    private String credential = "demo123!";
    private String endpoint = "http://localhost:9000";
    private Map<String, String> overrides;
}
