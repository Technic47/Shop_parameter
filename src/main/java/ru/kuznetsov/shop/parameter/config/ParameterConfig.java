package ru.kuznetsov.shop.parameter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableCaching
@ComponentScan("ru.kuznetsov.shop.parameter")
@EnableJpaRepositories("ru.kuznetsov.shop.parameter.repository")
@EntityScan("ru.kuznetsov.shop.parameter.model")
public class ParameterConfig {
}
