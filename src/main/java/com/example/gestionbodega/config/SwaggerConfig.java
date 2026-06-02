package com.example.gestionbodega.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API deGestión de Bodega")
                        .version("1.0")
                        .description("API para la gestión de bodega, incluyendo productos, proveedores y órdenes de compra."));
    }
}
