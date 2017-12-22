package com.iqmsoft.sb.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.iqmsoft.sb.jersey.controller.MainController;


@Configuration
public class JerseyAppConfig extends ResourceConfig {
    public JerseyAppConfig() {
    
        register(MainController.class);
    }
}
