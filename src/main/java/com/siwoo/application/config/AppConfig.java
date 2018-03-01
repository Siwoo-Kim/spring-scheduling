package com.siwoo.application.config;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(value = "com.siwoo.application",excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Configuration.class))
@Import(DataConfig.class)
/*@ImportResource(locations = "classpath:/META-INF/config/task-namespace-app-context.xml")*/
@EnableScheduling
public class AppConfig {}
