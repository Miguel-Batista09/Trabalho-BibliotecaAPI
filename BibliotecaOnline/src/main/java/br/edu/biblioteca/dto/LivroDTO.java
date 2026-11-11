package br.edu.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    // Getters e Setters escritos manualmente (sem Lombok), exatamente como
    // previsto no roteiro da aula — evita erro de compilação no Eclipse/VS Code
    // quando o processador de anotações do Lombok não está habilitado.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
