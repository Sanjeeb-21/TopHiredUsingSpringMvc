package com.tophire.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.tophire.service"})
/*
 * @ComponentScan(basePackages = { "com.tophire.service" }, excludeFilters =
 * { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
 */
@EnableTransactionManagement
public class ServiceConfig {

}
