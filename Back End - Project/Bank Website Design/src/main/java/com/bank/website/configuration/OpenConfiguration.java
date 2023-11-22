package com.bank.website.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

public class OpenConfiguration {


    @Bean
    public OpenAPI customOpenAPI() { // link para acessar o SWAGGER: http://localhost:8080/swagger-ui.html
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Bank Website Design")
                                .version("1.0.0")
                                .description("Site de Banco na linguagem Java com Spring Boot e Angular")
                );
    }
}
