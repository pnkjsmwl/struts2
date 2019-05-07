package com.test.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.test"}) // equivalent to <tx:annotation-config />
/*<!-- support spring annotation -->
	<context:annotation-config />
<!-- support annotation transaction -->
	<tx:annotation-driven />*/
public class AppConfig {

}
