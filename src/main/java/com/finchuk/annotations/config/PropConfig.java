package com.finchuk.annotations.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by olexandr on 09.05.17.
 */
@Configuration
@PropertySource(value = "classpath:test5/client.properties",ignoreResourceNotFound = true)
public class PropConfig {
}
