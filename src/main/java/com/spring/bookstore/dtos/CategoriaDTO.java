package com.spring.bookstore.dtos;

import com.spring.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Long id;

    @NotEmpty(message = "Insira o nome do livro")
    @Length(min = 2,max = 100, message = "Inserir de 2 a 100 caracteres")
    private String nome;

    @NotEmpty(message = "Insira uma descrição")
    @Length(min = 2,max = 200, message = "Inserir de 2 a 200 caracteres")
    private String descricao;



    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
