package com.hoaqt.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@PropertySource("classpath:application-test.properties")
public class H2JpaConfig {
}
