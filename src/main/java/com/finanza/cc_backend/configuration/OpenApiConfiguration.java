package com.finanza.cc_backend.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "crediComparaOpenApi")
    public OpenAPI crediComparaOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Credi Compara Application API")
                        .description("Credi Compara API implemented with Sprint Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));
    }
}