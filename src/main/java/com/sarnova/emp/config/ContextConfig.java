package com.sarnova.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("file:./src/main/resources/application.properties")
@ComponentScan(basePackages = {"com.sarnova"})
public class ContextConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer   propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
