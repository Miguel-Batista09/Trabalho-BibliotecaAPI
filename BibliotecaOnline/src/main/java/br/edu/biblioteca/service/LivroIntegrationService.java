package br.edu.biblioteca.service;

import br.edu.biblioteca.dto.LivroDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Service de integração com a API externa pública (jsonplaceholder),
 * consumida via RestTemplate (Spring Web).
 *
 * A API de posts é usada conceitualmente como um catálogo de livros:
 *   - "title"  -> titulo do LivroDTO
 *   - "body"   -> descricao do LivroDTO
 */
@Service
public class LivroIntegrationService {

    private final RestTemplate restTemplate;

    /** URL da API externa, configurável em application.properties. */
    @Value("${biblioteca.api.url:https://jsonplaceholder.typicode.com/posts}")
    private String apiUrl;

    // Injeção de dependência via construtor (boa prática Spring Boot)
    public LivroIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Método 1: Consumir GET externo.
     * Faz um GET na API e converte o JSON recebido em um Array de LivroDTO.
     */
    public List<LivroDTO> buscarLivrosExternos() {
        LivroDTO[] livrosArray = restTemplate.getForObject(apiUrl, LivroDTO[].class);
        return Arrays.asList(livrosArray);
    }

    /**
     * Método 2: Consumir POST externo.
     * Envia um POST com o objeto novoLivro no corpo (Body) para a API fake.
     */
    public LivroDTO enviarLivroExterno(LivroDTO novoLivro) {
        return restTemplate.postForObject(apiUrl, novoLivro, LivroDTO.class);
    }
}
