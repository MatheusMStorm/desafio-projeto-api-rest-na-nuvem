package com.storm.desafio_projeto_api_rest_na_nuvem.doc;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
    @Value("${storm.openapi.dev-url}")
    private String devUrl;

    @Value("${storm.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Ambiente do desenvolvedor");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Ambiente de produção");

        Contact contact = new Contact();
        contact.setEmail("mouracostacosta93@gmail.com");
        contact.setName("Matheus Moura");
        contact.setUrl("https://matheus-linktree.vercel.app/");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
          .title("Desafio de Projeto: Criando uma API REST completa")
          .version("1.0")
          .contact(contact)
          .description("Projeto de criação de API REST na nuvem pela DIO").termsOfService("https://www.bancoinnovation.com/terms")
          .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
