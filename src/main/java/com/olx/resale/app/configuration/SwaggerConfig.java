package com.olx.resale.app.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", createAPIKeyScheme())
                        .addParameters("X-Role-Guest", new Parameter()
                                .in("header")
                                .name("X-Role-Guest")
                                .required(true)
                                .description("Guest role header")
                                .schema(new io.swagger.v3.oas.models.media.StringSchema())))
                .info(new Info().title("OLX Resale App API")
                        .description("API documentation for the OLX Resale App")
                        .version("1.0"))
                
               
                ;
    }
}