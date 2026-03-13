package com.hibuz.account.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringdocConfig implements WebMvcConfigurer {
    private static final String SCHEME_KEY = "Login";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
    }

    @Bean
    public OpenAPI swaggerApi(@Value("#{servletContext.contextPath}") String contextPath) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SCHEME_KEY, new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_KEY))
                .addServersItem(new Server().url(contextPath));
    }
}
