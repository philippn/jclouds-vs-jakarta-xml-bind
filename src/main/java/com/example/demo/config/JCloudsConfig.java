package com.example.demo.config;

import com.example.demo.DemoProperties;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStoreContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

@Configuration
public class JCloudsConfig {

    @Bean
    public BlobStoreContext blobStoreContext(DemoProperties properties) {
        Properties overrides = new Properties();
        if (properties.getOverrides() != null) {
            properties.getOverrides().forEach(overrides::setProperty);
        }
        ContextBuilder builder = ContextBuilder.newBuilder(properties.getProviderName())
                .overrides(overrides);
        String endpoint = properties.getEndpoint();
        checkArgument(endpoint.startsWith("http://") ||
                endpoint.startsWith("https://"), "BlobStore endpoint must specify scheme");
        builder.endpoint(endpoint);
        if (!isNullOrEmpty(properties.getIdentity()) && !isNullOrEmpty(properties.getCredential())) {
            builder.credentials(properties.getIdentity(), properties.getCredential());
        }
        return builder.buildView(BlobStoreContext.class);
    }
}
