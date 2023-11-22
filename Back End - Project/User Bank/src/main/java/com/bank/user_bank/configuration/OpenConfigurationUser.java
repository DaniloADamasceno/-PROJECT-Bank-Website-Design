package com.bank.user_bank.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

public class OpenConfigurationUser {

    @Bean
    public OpenAPI customOpenAPI() { // link para acessar o SWAGGER: http://localhost:8080/swagger-ui.html
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Bank Website Design - USER | USUÁRIO")
                                .version("1.0.0")
                                .description("Microsserviço de Usuário")
                );
    }
}
