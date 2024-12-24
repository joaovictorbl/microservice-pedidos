package br.com.joaolourenco.pedidos.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpriogDoc {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pedidos API")
                        .description("API de pedidos")
                        .contact(new Contact()
                                .name("João Victor Barreto Lourenço")
                                .email("joaovictor_bl@outlook.com")
                        ));
    }
}
