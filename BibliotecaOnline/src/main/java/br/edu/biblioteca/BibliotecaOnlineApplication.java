package br.edu.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Classe principal da aplicação Spring Boot (BibliotecaOnline).
 *
 * Estende SpringBootServletInitializer para que o projeto também possa ser
 * empacotado como WAR e implantado em um servidor externo (Tomcat), mantendo
 * a compatibilidade com o formato antigo do projeto. Para executar
 * diretamente, basta rodar o método main abaixo (Run as Java Application)
 * e acessar http://localhost:8080.
 */
@SpringBootApplication
public class BibliotecaOnlineApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaOnlineApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BibliotecaOnlineApplication.class);
    }
}
