package br.edu.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuração do RestTemplate como Bean da aplicação (Spring Web).
 *
 * Com isso o RestTemplate pode ser injetado via construtor nos Services,
 * seguindo as boas práticas do Spring Boot (em vez de criar um
 * "new RestTemplate()" dentro de cada método).
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
