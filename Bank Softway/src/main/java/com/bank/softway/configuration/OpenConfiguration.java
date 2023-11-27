package com.bank.softway.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

public class OpenConfiguration {

    @Bean
    public OpenAPI customOpenAPI() { // link para acessar o SWAGGER: http://localhost:8080/swagger-ui.html
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Bank SoftWay ")
                                .version("1.0.0")
                                .description("Application for Bank SoftWay")
                );
    }
}
