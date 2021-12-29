package com.spring.bookstore.dtos;

import com.spring.bookstore.domain.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    @NotBlank(message = "Campo título está em branco")
    @NotEmpty(message = "Insira um texto")
    @Length(min = 2,max = 9999999, message = "Inserir de 2 a 9.999.999 caracteres")
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
