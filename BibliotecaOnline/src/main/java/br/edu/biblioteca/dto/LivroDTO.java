package br.edu.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data Transfer Object (DTO) baseado na classe Livro do domínio.
 *
 * Nesta integração NÃO usamos @Entity/@Id nem banco de dados: os dados
 * vêm da API externa (jsonplaceholder). O campo "id" chega preenchido
 * pela própria API fake.
 *
 * A API externa responde com os campos "userId", "id", "title" e "body".
 * Para que esses nomes sejam convertidos automaticamente para o nosso
 * domínio de Livro, usamos @JsonProperty em titulo/descricao e
 * @JsonIgnoreProperties para ignorar o "userId" (que não faz parte do
 * domínio) sem quebrar a desserialização do JSON.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {

    private Long id;

    /** No JSON externo corresponde ao campo "title" (e aceita "titulo" como alias). */
    @JsonProperty(value = "title", required = false)
    @JsonAlias("titulo")
    private String titulo;

    private String autor;

    private String categoria;

    private Integer anoPublicacao;

    /** No JSON externo corresponde ao campo "body" (e aceita "descricao" como alias). */
    @JsonProperty(value = "body", required = false)
    @JsonAlias("descricao")
    private String descricao;
}
