package com.jjh.mtvs.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("MTVS API Documentation")
                .version("v1.0.0")
                .description("MTVS 프로젝트의 API 문서");

        Server server = new Server();
        server.setUrl("http://125.132.216.190:9100");
        server.setDescription("MTVS Server");

        return new OpenAPI()
                .info(info)
                .addServersItem(server);
    }
}