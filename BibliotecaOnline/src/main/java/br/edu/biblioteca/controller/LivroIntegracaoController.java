package br.edu.biblioteca.controller;

import br.edu.biblioteca.dto.LivroDTO;
import br.edu.biblioteca.service.LivroIntegrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller local que expõe a integração com a API externa.
 *
 * Endpoints:
 *   GET  http://localhost:8080/api/integracao/livros  -> lista os "livros" do servidor externo
 *   POST http://localhost:8080/api/integracao/livros  -> cria um "livro" no servidor externo (201)
 */
@RestController
@RequestMapping("/api/integracao/livros")
public class LivroIntegracaoController {

    private final LivroIntegrationService integrationService;

    // Injeção de dependência via construtor
    public LivroIntegracaoController(LivroIntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarDoServidorExterno() {
        List<LivroDTO> lista = integrationService.buscarLivrosExternos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> criarNoServidorExterno(@RequestBody LivroDTO livroDTO) {
        LivroDTO resposta = integrationService.enviarLivroExterno(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
